/**
 * 
 */
package com.fundtransfer.hcl.app.service;

import java.util.Optional;

import com.fundtransfer.hcl.app.model.Transaction;

/**
 * @author Admin
 *
 */
public interface TransferService {
	public Optional<Transaction> displayTransactionDetails(Long id);
	public Transaction saveTransactionDetails(Transaction transaction);
}
