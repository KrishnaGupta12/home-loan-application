package com.lti.homeloanapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.homeloanapplication.entiti.Owner;
import com.lti.homeloanapplication.exception.MyException;
import com.lti.homeloanapplication.exception.OwnerAddException;
import com.lti.homeloanapplication.service.HomeLoanService;

@RestController
public class HomeLoneController {
	@Autowired
	private HomeLoanService homeLoanService;
//This is for saving owner's details in DB
	@PostMapping("/owner")
	public Owner addOwner(@Validated @RequestBody Owner owner) throws OwnerAddException {
		return this.homeLoanService.addOwner(owner);

	}
	//This is for getting owner's details from DB
	@GetMapping("/owner")
	public List<Owner> getOwner() {

		return this.homeLoanService.getOwner();
	}

	@GetMapping("/owner/{ownerId}")
	public Owner getOneOwner(@PathVariable String ownerId) {

		return this.homeLoanService.getOneOwner(Long.parseLong(ownerId));
	}

}
