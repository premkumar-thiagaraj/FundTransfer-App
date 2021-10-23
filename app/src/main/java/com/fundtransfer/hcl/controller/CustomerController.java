package com.fundtransfer.hcl.controller;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	protected Logger logger = Logger.getLogger(CustomerController.class.getName());

	@RequestMapping("/loginValidation")
	public String loginValidation(@RequestParam Integer customerId, @RequestParam String password) {

		return null;

		// return "{\"addend1\":\"" + addend1 + "\", \"addend2\":\"" + addend2 + "\",
		// \"sum\": \"" + sum + "\"}";
	}

	@RequestMapping("/detailAccount")
	public String detailAccount(@RequestParam String accNo) {

		return null;
	}

	@RequestMapping("/displayCustomerDetails")
	public String displayCustomerDetails(@RequestParam String customerId) {

		return null;
	}

	@RequestMapping("/fundTransfer")
	public String fundTransfer(@RequestParam String accNoSrc, @RequestParam String accNoDst,
			@RequestParam Double amount, @RequestParam String Comment) {

		return null;
	}

}
