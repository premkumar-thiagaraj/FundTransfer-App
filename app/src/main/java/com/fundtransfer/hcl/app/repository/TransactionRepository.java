package com.fundtransfer.hcl.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundtransfer.hcl.app.model.Transaction;

	@Repository
	public interface TransactionRepository extends JpaRepository<Transaction, Long> {

		Transaction getBySrcAccountNo(Long id);

		Transaction getByDestAccountNo(Long id);



	}