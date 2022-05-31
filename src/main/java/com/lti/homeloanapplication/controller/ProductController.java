package com.lti.homeloanapplication.controller;

import com.lti.homeloanapplication.entity.Product;
import com.lti.homeloanapplication.exception.ProductAlReadyExistedException;
import com.lti.homeloanapplication.exception.ProductNotFoundException;
import com.lti.homeloanapplication.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
@RequestMapping("/api")
@Slf4j
public class ProductController {
    @Autowired
    ProductService productService;

    /**
     * Method to add product to database
     *
     * @param product: Product details to add in database
     * @return ResponseEntity with proper status code
     * @throws ProductAlReadyExistedException
     */
    @ApiOperation(value = "Add Product Details ", tags = "addProduct")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Product Added"),
            @ApiResponse(code = 409, message = "Products Already Existed Exception")})
    @PostMapping("/productDetails")
    @ResponseBody
    public ResponseEntity saveProductDetails(@RequestBody  @Valid Product product) throws SQLException, ProductAlReadyExistedException {
        LOGGER.info("Inside saveProductDetails of ProductController");
        Product addProduct = productService.saveProductDetails(product);
        return new ResponseEntity<>(addProduct, HttpStatus.CREATED);
    }
    
    /**
     * Method to show list of available product to  customer from database
     *
     * @return Response Entity with proper status code
     * @throws ProductNotFoundException
     */
    @ApiOperation(value = "View all products ", tags = "getAllProducts")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 409, message = "Course Not Found")})
    @GetMapping("/products")
    public ResponseEntity<List> viewAllProducts()  {
        List<Product> productList = productService.viewAllProducts();

        if (productList.size() == 0 && productList.isEmpty()) {
                throw new ProductNotFoundException();
            }
            return ResponseEntity.of(Optional.of(productList));
    }


    /**
     * Method to show viewProductByType of Products from database
     *
     * @param productType: productType for which display the  product Details
     * @return ResponseEntity with proper status code
     * @throws ProductNotFoundException
     */
    @ApiOperation(value = " View Registered ProductType under Product ", tags = "viewProductByType")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 404, message = "No registered product found  ..! ")})

    @GetMapping("/products_type/{type}")
    public ResponseEntity viewProductByType(@PathVariable("type") String productType) {
        LOGGER.info("Inside viewProductByType List of ProductController");
        return new ResponseEntity(productService.viewProductByType(productType), HttpStatus.OK);
    }


}
