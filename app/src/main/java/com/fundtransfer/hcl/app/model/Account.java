package com.fundtransfer.hcl.app.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ACCOUNT")
public class Account {
	@Id
	@Column(name="ACCOUNT_NO",unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountNo;
	
	@Column(name="ACCOUNT_TYPE")
	private String accountType;
	
	@Column(name="CREATION_DATE")
	private Date creationDate;
	
	@Column(name="BALANCE")
	private Double balance;

	@JsonManagedReference
	@ManyToOne
	@JoinTable(name = "CUSTOMER_ACCOUNT_MAPPING", joinColumns = {
			@JoinColumn(name = "MAPPING_ACCOUNT_ID", referencedColumnName = "ACCOUNT_NO") }, inverseJoinColumns = {
					@JoinColumn(name = "MAPPING_CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID") })
    private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	

}
