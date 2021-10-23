/**
 * 
 */
package com.fundtransfer.hcl.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Admin
 *
 */
@Entity
@Table(name="CUSTOMER")
public class Customer  {
	
	@Id
	@Column(name="CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "", joinColumns = {
					@JoinColumn(name = "MAPPING_USER_ID", referencedColumnName = "CUSTOMER_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "MAPPING_ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID") })
	@JsonManagedReference
	private Set<Account> Accounts;

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
	public Set<Account> getAccounts() {
		return Accounts;
	}
	public void setAccounts(Set<Account> accounts) {
		Accounts = accounts;
	}
}