package com.homeloan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.homeloan.model.Payment;
import com.homeloan.service.PaymentService;

@Controller
public class PaymentController {

	@Autowired
	PaymentService employeeService;

	@RequestMapping("/welcome")
	public ResponseEntity<?> firstPage() {
		return new ResponseEntity("welcome to home loan payment", HttpStatus.OK);
	}

	@RequestMapping(value = "/addNewPayment", method = RequestMethod.POST)
	public ResponseEntity<?> processRequest(@RequestBody Payment payment) {

		return new ResponseEntity("Payment Details added Successfully ", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseEntity<String> login(Model model, String error, String logout) {
		if (error != null)
		return new ResponseEntity("Your username and password are invalid.", HttpStatus.NOT_FOUND);

		if (logout != null)
		return new ResponseEntity("You have been logged out successfully.", HttpStatus.OK);

		return new ResponseEntity("You have been login successfully.", HttpStatus.OK);
	}

}
