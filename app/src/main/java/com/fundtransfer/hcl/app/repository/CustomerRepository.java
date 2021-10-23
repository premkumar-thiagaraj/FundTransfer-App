package com.fundtransfer.hcl.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundtransfer.hcl.app.model.Customer;

	@Repository
	public interface CustomerRepository extends JpaRepository<Customer, Long> {


	}