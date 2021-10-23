/**
 * 
 */
package com.fundtransfer.hcl.app.service;

import com.fundtransfer.hcl.app.model.CustomerDto;

/**
 * @author Admin
 *
 */
public interface BalanceInquiryService {

	public CustomerDto displayCustomerBalanceDetails(Long id);
	
}
