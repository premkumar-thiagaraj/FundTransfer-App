/**
 * 
 */
package com.fundtransfer.hcl.app.service;

import java.util.List;
import java.util.Optional;

import org.eclipse.jdt.core.compiler.InvalidInputException;

import com.fundtransfer.hcl.app.exception.TransferException;
import com.fundtransfer.hcl.app.model.Transaction;

/**
 * @author Admin
 *
 */
public interface TransferService {
	public List<Transaction> displayTransactionDetails(Long id);
	public Transaction saveTransactionDetails(Transaction transaction) throws TransferException;
}
