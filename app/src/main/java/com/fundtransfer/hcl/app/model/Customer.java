/**
 * 
 */
package com.fundtransfer.hcl.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Admin
 *
 */
@Entity
@Table(name="CUSTOMER")
public class Customer  {

	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="NAME")
	private String name;
	@Column(name="ACCOUNT_NO")
	private int accountNumber;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
}