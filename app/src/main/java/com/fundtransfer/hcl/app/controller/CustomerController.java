package com.fundtransfer.hcl.app.controller;

import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fundtransfer.hcl.app.exception.TransferException;
import com.fundtransfer.hcl.app.model.Account;
import com.fundtransfer.hcl.app.model.CustomerDto;
import com.fundtransfer.hcl.app.model.Transaction;
import com.fundtransfer.hcl.app.repository.AccountRepository;
import com.fundtransfer.hcl.app.service.BalanceInquiryService;
import com.fundtransfer.hcl.app.service.TransferService;

@RestController
public class CustomerController {
	
	
	@Autowired
	BalanceInquiryService balanceInquiryService;

	@Autowired
	TransferService transferService;
	
	@Autowired
	AccountRepository accountRepository;
	
	protected Logger logger = Logger.getLogger(CustomerController.class.getName());

	/** Api that displays the customer account and respective balances for the chosen customer
	 * @param customerId
	 * @return
	 */
	@GetMapping(path = "/displayCustomerDetails/{customerId}")
	public ResponseEntity<CustomerDto> displayCustomerDetails(@PathVariable Long customerId) {
		CustomerDto customerDto = null;
		try{
		  customerDto = balanceInquiryService.displayCustomerBalanceDetails(customerId);
		} catch(Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage()); 
		}
		return new ResponseEntity<CustomerDto>(customerDto, HttpStatus.OK);
		
	}

	/**
	 * Api that performs the fund transfer and updates the balances accordingly 
	 * @param transaction
	 * @return
	 */
	@PostMapping("/fundtransfer")
	public ResponseEntity<CustomerDto> fundTransfer(@RequestBody Transaction transaction) {
		  
		try{
			if(null != transferService.saveTransactionDetails(transaction)) {
				Optional<Account> accountOptional = accountRepository.findById(transaction.getSrcAccountNo());
				if(accountOptional.isPresent()) {
					Long customerId = accountOptional.get().getCustomer().getId();
					CustomerDto customerDto = balanceInquiryService.displayCustomerBalanceDetails(customerId);
					return new ResponseEntity<CustomerDto>(customerDto, HttpStatus.CREATED);
				}
			} else {
				throw new TransferException("Transfer failed");
			}
		} catch(Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage()); 
		}
		return new ResponseEntity<CustomerDto>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(path = "/a")
	public String welcome() {
		return "index";
	}

}
