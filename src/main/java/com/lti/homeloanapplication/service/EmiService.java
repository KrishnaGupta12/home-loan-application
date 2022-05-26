package com.lti.homeloanapplication.service;

import com.lti.homeloanapplication.entity.EmiOffer;
import com.lti.homeloanapplication.entity.Product;
import com.lti.homeloanapplication.exception.EmiOfferAlReadyExistedException;
import com.lti.homeloanapplication.exception.EmiOfferNotFoundException;

import java.util.List;

public interface EmiService {

   
  public EmiOffer addEmiOffer(EmiOffer emiOffer)throws EmiOfferAlReadyExistedException;

  List<EmiOffer> getAllEmiOffer()throws EmiOfferNotFoundException;

 public  EmiOffer getEmiById(Long id)throws EmiOfferNotFoundException;
}
