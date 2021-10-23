package com.fundtransfer.hcl.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fundtransfer.hcl.app.model.Transaction;
import com.fundtransfer.hcl.app.repository.TransactionRepository;

@Component
public class TransferServiceImpl implements TransferService{

	
	@Autowired
	TransactionRepository transactionRepository;
	@Override
	public Optional<Transaction> displayTransactionDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction saveTransactionDetails(Transaction transaction) {
		return transactionRepository.saveAndFlush(transaction);
	}

}
