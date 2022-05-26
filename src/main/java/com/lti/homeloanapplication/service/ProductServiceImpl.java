package com.lti.homeloanapplication.service;

import com.lti.homeloanapplication.entity.EmiOffer;
import com.lti.homeloanapplication.entity.Product;
import com.lti.homeloanapplication.exception.ProductAlReadyExistedException;
import com.lti.homeloanapplication.exception.ProductNotFoundException;
import com.lti.homeloanapplication.repository.EmiOfferRepository;
import com.lti.homeloanapplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

    public List<Product> getAllProducts(){
        List<Product> list = productRepository.findAll();
       /* for (Product product: list) {
            EmiOffer emiOffer=emiOfferRepository.findById(product.getProductId()).get();
            product.setEmiOffer(emiOffer);
        }*/
        return list;
    }

    public Product addProduct(Product product){
       if(productRepository.existsById(product.getProductId())){
           throw new ProductAlReadyExistedException();
       }
       Product addProduct = productRepository.save(product);
        return addProduct;
    }

    @Override
    public Product getProductByType(String productType)throws ProductNotFoundException {
        Product product;

        if(null!=productType && !productType.isEmpty() && null!=productRepository.findByProductType(productType)){
             product = productRepository.findByProductType(productType);
            List<EmiOffer> emiOffers=emiOfferRepository.findAll().stream().filter(emiOffer -> emiOffer.getEmiType()
                    .equalsIgnoreCase(product.getEmiType())).collect(Collectors.toList());
            product.setEmiOffers(emiOffers);
        }else {
            throw new ProductNotFoundException();

        }
        return product;
    }


}