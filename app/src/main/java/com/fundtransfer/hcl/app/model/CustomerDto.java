package com.fundtransfer.hcl.app.model;

import java.util.List;

public class CustomerDto {
	
	private Long customerId;
	
	private String name;
	
	private String password;
	
	private List<AccountBalDto> acountBalances;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AccountBalDto> getAcountBalances() {
		return acountBalances;
	}

	public void setAcountBalances(List<AccountBalDto> acountBalances) {
		this.acountBalances = acountBalances;
	}
	
}
