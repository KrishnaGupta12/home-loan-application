package com.lti.homeloanapplication.repository;

import com.lti.homeloanapplication.entity.EmiOffer;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Registered
public interface EmiOfferRepository extends JpaRepository<EmiOffer,Long> {



    @Query(value = "select * from EmiOffer where emi_Type = ?1",nativeQuery = true)
    List<EmiOffer> findbyEmiType(String emiType);
}
