package com.lti.homeloanapplication.controller;

import com.lti.homeloanapplication.entity.Product;
import com.lti.homeloanapplication.exception.ProductAlReadyExistedException;
import com.lti.homeloanapplication.exception.ProductNotFoundException;
import com.lti.homeloanapplication.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
@RequestMapping("/api")
@Slf4j
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/productDetails")
    @ResponseBody
    public ResponseEntity addProduct(@RequestBody Product product) throws SQLException, ProductAlReadyExistedException {
        LOGGER.info("Inside saveProductDetails of ProductController");
        Product addProduct = productService.addProduct(product);
        return new ResponseEntity<>(addProduct, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity <List> getAllProducts()throws ProductNotFoundException{
        LOGGER.info("Inside getAllProducts List of ProductController");
        return new ResponseEntity<List>((List) productService.getAllProducts(),HttpStatus.OK);
    }

    @GetMapping("/products_type/{type}")
    public ResponseEntity getProductByType(@PathVariable ("type") String productType)throws ProductNotFoundException {
        LOGGER.info("Inside getProductByType List of ProductController");
        return new ResponseEntity(productService.getProductByType(productType),HttpStatus.OK);
    }

}
