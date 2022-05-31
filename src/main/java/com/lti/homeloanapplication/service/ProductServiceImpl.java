package com.lti.homeloanapplication.service;

import com.lti.homeloanapplication.entity.EmiOffer;
import com.lti.homeloanapplication.entity.Product;
import com.lti.homeloanapplication.exception.ProductNotFoundException;
import com.lti.homeloanapplication.repository.EmiOfferRepository;
import com.lti.homeloanapplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Product Business Layer implementing ProductService Interface.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Autowired
    ProductRepository productRepository;

    @Autowired
    private EmiOfferRepository emiOfferRepository;

    /**
     * show list of available products
     */
    public List<Product> viewAllProducts(){
        List<Product> list = productRepository.findAll();

        return list;
    }

    public Product saveProductDetails(Product product){
          return productRepository.save(product);
    }

    /**
     * get product by productType method
     */
    @Override
    public Product viewProductByType(String productType) {
        Product product;

        if(null!=productType && !productType.isEmpty() && null!=productRepository.findByProductType(productType)){
             product = productRepository.findByProductType(productType);
            List<EmiOffer> emiOffers=emiOfferRepository.findAll().stream().filter(emiOffer -> emiOffer.getEmiType()
                    .equalsIgnoreCase(product.getEmiType())).collect(Collectors.toList());
            product.setEmiOffer((EmiOffer) emiOffers);
        }else {
            throw new ProductNotFoundException();

        }
        return product;
    }


}