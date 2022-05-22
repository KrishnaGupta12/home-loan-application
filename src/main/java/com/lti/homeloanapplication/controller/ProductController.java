package com.lti.homeloanapplication.controller;

import com.lti.homeloanapplication.entity.EmiOffer;
import com.lti.homeloanapplication.entity.Product;
import com.lti.homeloanapplication.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
@RequestMapping("/api")
@Slf4j
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/productDetails")
    public Product addProduct(@RequestBody Product product){
        LOGGER.info("Inside saveProductDetails of ProductController");
       return productService.addProduct(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        LOGGER.info("Inside getAllProducts List of ProductController");
        return productService.getAllProducts();
    }

    @GetMapping("/products_type/{type}")
    public Product getProductByType(@PathVariable ("type") String productType){
        LOGGER.info("Inside getProductByType List of ProductController");
        return productService.getProductByType(productType);
    }

}
