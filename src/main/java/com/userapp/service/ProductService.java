package com.userapp.service;

import com.userapp.exception.ErrorCodes;
import com.userapp.exception.model.InvalidInputException;
import com.userapp.exception.model.ProductDoesntExistsException;
import com.userapp.model.*;
import com.userapp.repository.IPriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * This service layer is composition service for product details and price details
 * @author kavitameena67
 */
@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    IPriceRepository priceRepository;

    /** This method will return Product Details based on Product ID
     * @param productId
     * @return
     * @throws Exception
     */
    public ProductPriceDetails getProductById(String productId)
            throws InvalidInputException, ProductDoesntExistsException {

        if (productId == null) {
            logger.error("getProductById - " + ErrorCodes.INVALID_INPUT);
            throw new InvalidInputException(ErrorCodes.INVALID_INPUT);
        }

        Product product = findProductById(productId);

        String title = "";
        if (product == null) {
            throw new ProductDoesntExistsException(ErrorCodes.PRODUCT_NOT_EXISTS);
        } else {
            Item item = product.getItem();
            if (item != null) {
                ProductDescription productDescription = item.getProductDescription();
                if (productDescription != null) {
                    title = productDescription.getTitle();
                }
            }
        }
        Price price = null;
        Optional<Price> priceInRecord = priceRepository.findById(productId);
        if (priceInRecord.isPresent()) {
            price = priceInRecord.get();
        }
        ProductPriceDetails productPriceDetails = new ProductPriceDetails(productId, title, price);
        return productPriceDetails;
    }

    /**
     * This method will update current price for the given product
     * @param productId
     * @param productPriceDetails
     * @return
     * @throws Exception
     */
    public ProductPriceDetails updatePriceForProduct(String productId, ProductPriceDetails productPriceDetails)
            throws InvalidInputException, ProductDoesntExistsException {

        if ((productId == null) || (productPriceDetails == null) || (productPriceDetails.getCurrentPrice() == null)) {
            logger.error("UpdateUser - " + ErrorCodes.INVALID_INPUT);
            throw new InvalidInputException(ErrorCodes.INVALID_INPUT);
        }

        Product product = findProductById(productId);
        if (product == null) {
            throw new ProductDoesntExistsException(ErrorCodes.PRODUCT_NOT_EXISTS);
        }

        Price price = productPriceDetails.getCurrentPrice();

        Price currentPrice = new Price();
        currentPrice.setProductId(productId);
        currentPrice.setValue(price.getValue());
        currentPrice.setCurrentCode(price.getCurrentCode());

        Price savedPrice = priceRepository.save(price);
        if (savedPrice != null) {
            logger.debug("ProductService - UpdatePriceForProduct - Success");
            productPriceDetails.setId(productId);
            productPriceDetails.setCurrentPrice(price);
        }

        return productPriceDetails;
    }

    // PRIVATE METHODS

    private Product findProductById(String productId) throws ProductDoesntExistsException {
        final String uri = "https://redsky.target.com/v2/pdp/tcin/{id}?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", productId);

        RestTemplate restTemplate = new RestTemplate();

        Product product = null;
        try {
            ProductDetails productDetails = restTemplate.getForObject(uri, ProductDetails.class, params);

            if (productDetails != null) {
                product = productDetails.getProduct();
            }
        } catch (Exception e) {
            throw new ProductDoesntExistsException(ErrorCodes.PRODUCT_NOT_EXISTS);
        }

        return product;
    }

}
