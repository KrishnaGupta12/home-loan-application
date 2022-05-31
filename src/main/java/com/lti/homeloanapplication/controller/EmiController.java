package com.lti.homeloanapplication.controller;

import com.lti.homeloanapplication.entity.EmiOffer;

import com.lti.homeloanapplication.service.EmiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
@Slf4j
@RequestMapping("/api")
public class EmiController {

    @Autowired
    private EmiService emiService;
    @PostMapping("/addEmiOffer")
    public EmiOffer addEmiOffer(@RequestBody EmiOffer emiOffer){
        LOGGER.info("Inside addEmiOffer of EmiController");
        return emiService.addEmiOffer(emiOffer);

    }
    @GetMapping("/emi")
    public List<EmiOffer> getAllEmiOffer(){
        LOGGER.info("Inside getAllEmiOffer List of EmiController");

        return emiService.getAllEmiOffer();
    }

    @GetMapping("/emi/{id}")
    public EmiOffer getEmiById(@PathVariable ("id") Long id){
        LOGGER.info("Inside getEmiById List of EmiController");

        return emiService.getEmiById(id);
    }



}
