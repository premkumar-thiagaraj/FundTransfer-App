package com.fundtransfer.hcl.app.controller;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fundtransfer.hcl.app.model.Customer;
import com.fundtransfer.hcl.app.service.BalanceInquiryService;

@RestController
public class CustomerController {
	
	
	@Autowired
	BalanceInquiryService balanceInquiryService;
	 
	protected Logger logger = Logger.getLogger(CustomerController.class.getName());

	@RequestMapping("/loginValidation")
	public String loginValidation(@RequestParam Integer customerId, @RequestParam String password) {

		return null;
	}

	@GetMapping(path = "/detailAccount")
	public String detailAccount() {
		 System.out.println("Hellos");
		return "Hello";
	}

	@RequestMapping(path = "/displayBalance/{customerId}")
	public String displayCustomerDetails(@PathVariable Long customerId, Model model) {
		
		Optional<Customer> customerOptional = balanceInquiryService.displayCustomerDetails(customerId);
		if(customerOptional.isPresent()) {
			model.addAttribute("customer", customerOptional.get());
			//return new ResponseEntity<Customer>(balanceInquiryService.displayCustomerDetails(customerId).get(), HttpStatus.OK);
		} else {
			model.addAttribute("customer", customerOptional.orElse(new Customer()));
		}
		return "index";
		
	}

	@RequestMapping("/fundTransfer")
	public String fundTransfer(@RequestParam String accNoSrc, @RequestParam String accNoDst,
			@RequestParam Double amount, @RequestParam String Comment) {

		return null;
	}
	
	@GetMapping(path = "/")
	public String welcome() {
		return "index";
	}

}
