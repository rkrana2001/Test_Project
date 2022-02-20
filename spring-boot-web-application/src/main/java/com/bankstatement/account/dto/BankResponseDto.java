package com.bankstatement.account.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@JsonInclude(Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonTypeName(value = "bankResponse")
public class BankResponseDto {
	
	@JsonProperty("successStatus")
	protected boolean successStatus;
	
	@JsonProperty("errorMessage")
	protected ErrorDto errorMessage;
	
	@JsonProperty("ID")
	private BigDecimal ID;
	
	@JsonProperty("accountId")
	private Integer accountId;
	
	@JsonProperty("dateField")
	private String dateField;
	
	@JsonProperty("amount")
	private String amount;

	public boolean isSuccessStatus() {
		return successStatus;
	}

	public void setSuccessStatus(boolean successStatus) {
		this.successStatus = successStatus;
	}

	public BigDecimal getID() {
		return ID;
	}

	public void setID(BigDecimal bigDecimal) {
		ID = bigDecimal;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getDateField() {
		return dateField;
	}

	public void setDateField(String dateField) {
		this.dateField = dateField;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public ErrorDto getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorDto errorMessage) {
		this.errorMessage = errorMessage;
	}
	

}
