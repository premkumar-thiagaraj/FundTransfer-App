package com.fundtransfer.hcl.app.exception;

public class TransferException extends RuntimeException {

	
	int errCode;
	
	String message;

	public TransferException(String message) {
		this.message= message;
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
