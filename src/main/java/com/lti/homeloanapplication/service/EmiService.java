package com.lti.homeloanapplication.service;

import com.lti.homeloanapplication.entity.EmiOffer;
import com.lti.homeloanapplication.entity.Product;

import java.util.List;

public interface EmiService {
   
  public EmiOffer addEmiOffer(EmiOffer emiOffer);

  List<EmiOffer> getAllEmiOffer();

 public  EmiOffer getEmiById(Long id);
}
