package com.fundtransfer.hcl.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.RequestParam;

@Entity
@Table(name="TRANSACTION")
public class Transaction {

	@Id
	@Column(name="TRANSACTION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "SRC_ACCT_NO")
	private Long accNoSrc;
	
	@Column(name = "DES_ACCT_NO")
	private Long accNoDst;

	@Column(name = "AMOUNT")
	private Long amount;

	@Column(name = "COMMENT")
	private String comment;
}
