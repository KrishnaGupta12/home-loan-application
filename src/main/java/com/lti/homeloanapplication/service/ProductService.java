package com.lti.homeloanapplication.service;

import com.lti.homeloanapplication.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface ProductService {
    List<Product> getAllProducts();

    public Product addProduct(Product product);

    Product getProductByType(String productType);
}
