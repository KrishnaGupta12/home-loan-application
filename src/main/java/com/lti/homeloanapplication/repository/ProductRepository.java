package com.lti.homeloanapplication.repository;

import com.lti.homeloanapplication.entity.EmiOffer;
import com.lti.homeloanapplication.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByProductType(String productType);

}
