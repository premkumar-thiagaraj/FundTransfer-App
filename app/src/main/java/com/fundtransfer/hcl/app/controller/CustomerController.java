package com.fundtransfer.hcl.app.controller;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fundtransfer.hcl.app.model.Customer;
import com.fundtransfer.hcl.app.model.Transaction;
import com.fundtransfer.hcl.app.service.BalanceInquiryService;
import com.fundtransfer.hcl.app.service.TransferService;

@Controller
public class CustomerController {
	
	
	@Autowired
	BalanceInquiryService balanceInquiryService;

	@Autowired
	TransferService transferService;
	
	protected Logger logger = Logger.getLogger(CustomerController.class.getName());

	@RequestMapping("/loginValidation")
	public String loginValidation(@RequestParam Integer customerId, @RequestParam String password) {

		return null;
	}

	@GetMapping(path = "/displayBalance/{customerId}")
	public String displayCustomerDetails(@PathVariable Long customerId, Model model) {
		
		Optional<Customer> customerOptional = balanceInquiryService.displayCustomerBalanceDetails(customerId);
		if(customerOptional.isPresent()) {
			model.addAttribute("customer", customerOptional.get());
			//return new ResponseEntity<Customer>(balanceInquiryService.displayCustomerDetails(customerId).get(), HttpStatus.OK);
		} else {
			model.addAttribute("customer", customerOptional.orElse(new Customer()));
		}
		return "index";
		
	}

	@PostMapping("/fundTransfer")
	public String fundTransfer(@ModelAttribute("transaction") Transaction transaction , @RequestParam String accNoSrc, @RequestParam String accNoDst,
			@RequestParam Double amount, @RequestParam String Comment) {
		
		if(null != transferService.saveTransactionDetails(transaction))
			return HttpStatus.OK.name();
		return HttpStatus.NOT_MODIFIED.name();
	}
	
	@GetMapping(path = "/a")
	public String welcome() {
		return "index";
	}

}
