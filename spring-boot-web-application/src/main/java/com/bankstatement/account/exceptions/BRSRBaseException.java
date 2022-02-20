package com.bankstatement.account.exceptions;

import java.util.HashMap;
import java.util.Map;

public class BRSRBaseException extends BRSRExceptionStack{
	
	private static final long serialVersionUID = 1L;
	
	protected Object rootCause;
	protected String errorCode;
	protected int severityLevel;
	
	protected Map<String, String> errorList = null;
	
	protected BRSRBaseException() {
		errorList = new HashMap<>();
	}
	
	protected BRSRBaseException(String message) {
		super(message);
	}
	
	protected BRSRBaseException(String message, Throwable throwable) {
		super(message,throwable);
	}
	
	protected BRSRBaseException(Throwable throwable) {
		super(throwable);
	}
	
	protected BRSRBaseException(Throwable throwable, String errorCode, int severityLevel) {
		super(throwable);
		this.errorCode = errorCode;
		this.severityLevel = severityLevel;
	}

	public Object getRootCause() {
		return rootCause;
	}

	public void setRootCause(Object rootCause) {
		this.rootCause = rootCause;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public int getSeverityLevel() {
		return severityLevel;
	}

	public void setSeverityLevel(int severityLevel) {
		this.severityLevel = severityLevel;
	}

	public Map<String, String> getErrorList() {
		return errorList;
	}

	public void setErrorList(Map<String, String> errorList) {
		this.errorList = errorList;
	}
	
	

}
