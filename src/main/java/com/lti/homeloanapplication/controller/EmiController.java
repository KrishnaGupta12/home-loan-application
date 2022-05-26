package com.lti.homeloanapplication.controller;

import com.lti.homeloanapplication.entity.EmiOffer;
import com.lti.homeloanapplication.entity.Product;
import com.lti.homeloanapplication.service.EmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
@RequestMapping("/api")
public class EmiController {

    @Autowired
    private EmiService emiService;
    @PostMapping("/addEmiOffer")
    public EmiOffer addEmiOffer(@RequestBody EmiOffer emiOffer){
        return emiService.addEmiOffer(emiOffer);

    }
    @GetMapping("/emi")
    public List<EmiOffer> getAllEmiOffer(){

        return emiService.getAllEmiOffer();
    }

    @GetMapping("/emi/{id}")
    public EmiOffer getEmiById(@PathVariable ("id") Long id){
        return emiService.getEmiById(id);
    }



}
