/**
 * 
 */
package com.fundtransfer.hcl.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fundtransfer.hcl.app.model.Customer;
import com.fundtransfer.hcl.app.repository.CustomerRepository;

/**
 * @author Admin
 *
 */
@Component
public class BalanceInquiryServiceImpl implements BalanceInquiryService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Optional<Customer> displayCustomerDetails(Long id) {	
		
		return customerRepository.findById(id);
	}

	
	
}
