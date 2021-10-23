/**
 * 
 */
package com.fundtransfer.hcl.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fundtransfer.hcl.app.model.Account;
import com.fundtransfer.hcl.app.model.AccountBalDto;
import com.fundtransfer.hcl.app.model.Customer;
import com.fundtransfer.hcl.app.model.CustomerDto;
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
	public CustomerDto displayCustomerBalanceDetails(Long id) {	
		Optional<Customer> customerOptional = customerRepository.findById(id);
		
		CustomerDto customerdto = new CustomerDto();
		if(customerOptional.isPresent()) {
			
			Customer customer = customerOptional.get();
			
			List<AccountBalDto> accountBalDtList = new ArrayList<>();
			customerdto.setCustomerId(customer.getId());
			customerdto.setName(customer.getName());
			for(Account account : customer.getAccounts()) {
				AccountBalDto dto = new AccountBalDto();
				dto.setAccountNo(account.getAccountNo());
				dto.setBalance(account.getBalance());
				dto.setAccountType(account.getAccountType());
				accountBalDtList.add(dto);
			}
			customerdto.setAcountBalances(accountBalDtList);
		} else {
			return new CustomerDto();
		}
		return customerdto;
	}

	
	
}
