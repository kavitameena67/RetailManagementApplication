package com.userapp.repository;

import com.userapp.model.Price;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * This repository performs CRUD operations on Mongo DB
 * @author kavitameena67
 */
@Repository
public interface IPriceRepository extends MongoRepository<Price, String> {

}
