package com.fundtransfer.hcl.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT")
public class Account {

	@Id
	@Column(name="ACCOUNT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
