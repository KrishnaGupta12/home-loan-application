package com.lti.homeloanapplication.repository;

import com.lti.homeloanapplication.entity.EmiOffer;
import com.lti.homeloanapplication.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByProductType(String productType);

    // Product save(Product productDetails, EmiOffer emiOffer);

   /* List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    Product getProductById(String productID);*/

//    Set<Product> getFilteredProducts(Map<String, List<String>> filterParams, String manufacturer);

}
