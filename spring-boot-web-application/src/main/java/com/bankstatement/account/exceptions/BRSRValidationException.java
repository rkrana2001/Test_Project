package com.bankstatement.account.exceptions;

import java.util.HashMap;
import java.util.Map;

public class BRSRValidationException extends BRSRBaseException{
	
	protected String errorDesc;
	
	protected Map<String, String> errorList = null;
	
	public BRSRValidationException() {
		super();
		errorList = new HashMap<>();
	}
	
	public BRSRValidationException(String message, Throwable throwable) {
		super(message, throwable);
		errorList = new HashMap<>();
	}
	
	public BRSRValidationException(String message) {
		super(message);
		errorList = new HashMap<>();
	}
	
	public BRSRValidationException(Throwable throwable, String errorCode, int severityLevel) {
		super(throwable,errorCode, severityLevel);
		errorList = new HashMap<>();
	}
	
	public BRSRValidationException(Throwable throwable) {
		super(throwable);
		errorList = new HashMap<>();
	}
	
	public BRSRValidationException(Map<String, String> errorList) {
		super();
		this.errorList = errorList;
	}
	
	public void addError(String errorCode, String errorDescription) {
		errorList.put(errorCode,errorDescription);
	}
	
	public Map<String, String> gerErrorList(){
		return errorList;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	
	

}
