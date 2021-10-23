package com.fundtransfer.hcl.app.controller;

import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fundtransfer.hcl.app.model.Transaction;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction transaction = new Transaction();
		transaction.setSrcAccountNo(111113L);
		transaction.setDstAccountNo(111111L);
		transaction.setComment("fund transfer online");
		transaction.setTransactionAmount(143d);
		transaction.setTransactionDate(new Date());
		
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(transaction);
            System.out.println("ResultingJSONstring = " + json);
            //System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
}
	}

}
