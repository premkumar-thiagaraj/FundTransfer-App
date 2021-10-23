package com.fundtransfer.hcl.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACTION")
public class Transaction {
	@Id
	@Column(name="TRANSACTION_ID",unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	
	@Column(name="TRANSACTION_DATE")
	private Date transactionDate;
	
	@Column(name="TRANSACTION_AMOUNT")
	private Double transactionAmount;
	
	@Column(name="COMMENT")
	private String comment;

	@Column(name="SRC_ACCOUNT_NO")
	private Long srcAccountNo;
	
	@Column(name="DST_ACCOUNT_NO")
	private Long dstAccountNo;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getSrcAccountNo() {
		return srcAccountNo;
	}

	public void setSrcAccountNo(Long srcAccountNo) {
		this.srcAccountNo = srcAccountNo;
	}

	public Long getDstAccountNo() {
		return dstAccountNo;
	}

	public void setDstAccountNo(Long dstAccountNo) {
		this.dstAccountNo = dstAccountNo;
	}

	
	
	
}
