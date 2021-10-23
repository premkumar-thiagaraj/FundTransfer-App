package com.fundtransfer.hcl.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundtransfer.hcl.app.model.Account;

	@Repository
	public interface AccountRepository extends JpaRepository<Account, Long> {


	}