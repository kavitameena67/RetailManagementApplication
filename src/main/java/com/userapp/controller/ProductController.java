package com.userapp.controller;

import com.userapp.model.ProductPriceDetails;
import com.userapp.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author kavitameena67
 */
@RestController
@Api(value = "myRetail.com System", description = "Operations related to myRetail.com System")
@RequestMapping("/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Product based on Id", response = ResponseEntity.class)
    public ResponseEntity<Object> getProductById(@PathVariable String id)
            throws Exception {

        logger.info("Get Product based on Id");
        ProductPriceDetails productPriceDetails = productService.getProductById(id);
        if (productPriceDetails != null) {
            logger.debug("Get Product based on Id - Success");
            return ResponseEntity.ok(productPriceDetails);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Current Price for Product", response = ResponseEntity.class)
    public ResponseEntity<Object> updatePriceForProduct(@PathVariable String id, @RequestBody ProductPriceDetails productPriceDetails)
            throws Exception {

        logger.info("Update Current Price for Product");
        ProductPriceDetails savedProductPriceDetails = productService.updatePriceForProduct(id, productPriceDetails);
        if (savedProductPriceDetails != null) {
            logger.debug("Update Current Price for Product - Success");
            return ResponseEntity.ok(savedProductPriceDetails);
        }
        return ResponseEntity.noContent().build();
    }
}
