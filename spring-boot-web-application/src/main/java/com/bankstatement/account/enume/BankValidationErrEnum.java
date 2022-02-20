package com.bankstatement.account.enume;

public enum BankValidationErrEnum {
	
	SYSTEM_ERROR_CODE_CJ0020("8253"),
	SYSTEM_ERROR_CODE_7611("7611"),
	ERROR_MSG_PLEASE_TRY_AGAIN_SOME_TIME("Unable to process your request. Please try again or contact service desk"),
	SERVICE_ERROR_CODE_8036("8036"),
	SERVICE_ERROR_MSG_8036("Mandatory data is missing. Check and re-enter");
	
	
	
	private String value;
	
	private BankValidationErrEnum(final String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
