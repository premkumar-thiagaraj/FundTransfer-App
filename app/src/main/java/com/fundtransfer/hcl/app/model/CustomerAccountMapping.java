package com.fundtransfer.hcl.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_ACCOUNT_MAPPING")
public class CustomerAccountMapping {
	@Id
	@Column(name="MAPPING_CUSTOMER_ID")
	private Long customerId;
	
	@Column(name="MAPPING_ACCOUNT_ID")
	private Long accountNo;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	
	
	
}
