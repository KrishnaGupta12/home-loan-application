package com.lti.homeloanapplication.service;

import com.lti.homeloanapplication.entity.EmiOffer;
import com.lti.homeloanapplication.repository.EmiOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author EmiOffer Implementation with EmiService interface
 */
@Service
public class EmiServiceImpl implements EmiService{

    @Autowired
    EmiOfferRepository emiOfferRepository;

    public EmiOffer addEmiOffer(EmiOffer emiOffer) {
        return emiOfferRepository.save(emiOffer);
    }
    public List<EmiOffer> getAllEmiOffer() {
        return emiOfferRepository.findAll();
    }

    @Override
    public EmiOffer getEmiById(Long id) {
        return emiOfferRepository.findById(id).get();
    }


}
