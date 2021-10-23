package com.fundtransfer.hcl.app.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fundtransfer.hcl.app.exception.TransferException;
import com.fundtransfer.hcl.app.model.Account;
import com.fundtransfer.hcl.app.model.Transaction;
import com.fundtransfer.hcl.app.repository.AccountRepository;
import com.fundtransfer.hcl.app.repository.TransactionRepository;


@Component
public class TransferServiceImpl implements TransferService{
	
	protected Logger logger = Logger.getLogger(TransferServiceImpl.class.getName());

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public Transaction saveTransactionDetails(Transaction transaction) throws TransferException {
		
		if(null != transaction.getSrcAccountNo() && null!=transaction.getDstAccountNo()) {
			
			Account sourceAccount = accountRepository.getById(transaction.getSrcAccountNo());
			Account destinationAccount = accountRepository.getById(transaction.getDstAccountNo());
			
			if(null != sourceAccount && null != destinationAccount) {
				if(sourceAccount.getBalance() > 0) {
					
					if(sourceAccount.getBalance() - transaction.getTransactionAmount() >= 0) {
						
						sourceAccount.setBalance(sourceAccount.getBalance() - transaction.getTransactionAmount());
						destinationAccount.setBalance(sourceAccount.getBalance() + transaction.getTransactionAmount());
						
						transaction = transactionRepository.saveAndFlush(transaction);
						accountRepository.saveAll(List.of(sourceAccount,destinationAccount));
					} else {
						throw new TransferException("Insufficient Balance");
					}
					
				}
				
			} else {
				logger.log(Level.WARNING, "Source or destination Account Not found");
				
				throw new TransferException("No Account found for given Source or Destination account Number");
			}
			
		} else {
			
			throw new TransferException("Source or Destination Account No invalid");
		}
		return transaction;
	}
	
	@Override
	public List<Transaction> displayTransactionDetails(Long id) {
		Transaction debit= transactionRepository.getBySrcAccountNo(id);
		Transaction credit= transactionRepository.getByDestAccountNo(id);
		return List.of(debit,credit);
	}


}
