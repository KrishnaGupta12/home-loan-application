package com.lti.homeloanapplication.service;

import com.lti.homeloanapplication.entity.Product;
import com.lti.homeloanapplication.exception.ProductAlReadyExistedException;
import com.lti.homeloanapplication.exception.ProductNotFoundException;

import java.sql.SQLException;
import java.util.List;


public interface ProductService {
    List<Product> viewAllProducts()throws ProductNotFoundException;

    public Product saveProductDetails(Product product)throws ProductAlReadyExistedException, SQLException;

    Product viewProductByType(String productType)throws ProductNotFoundException;
}
