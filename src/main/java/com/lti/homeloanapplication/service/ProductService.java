package com.lti.homeloanapplication.service;

import com.lti.homeloanapplication.entity.Product;
import com.lti.homeloanapplication.exception.ProductAlReadyExistedException;
import com.lti.homeloanapplication.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface ProductService {
    List<Product> getAllProducts()throws ProductNotFoundException;

    public Product addProduct(Product product)throws ProductAlReadyExistedException;

    Product getProductByType(String productType)throws ProductNotFoundException;
}
