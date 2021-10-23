/**
 * 
 */
package com.fundtransfer.hcl.app.service;

import java.util.Optional;

import com.fundtransfer.hcl.app.model.Customer;

/**
 * @author Admin
 *
 */
public interface BalanceInquiryService {

	public Optional<Customer> displayCustomerDetails(Long id);
	
}
