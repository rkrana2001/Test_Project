package com.bankstatement.account.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@JsonInclude(Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonTypeName(value = "bankRequest")
public class BankRequestDto {
	
	@JsonProperty("accountId")
	protected String accountId;
	
	@JsonProperty("fromDate")
	protected String fromDate;
	
	@JsonProperty("toDate")
	protected String toDate;
	
	@JsonProperty("fromAmount")
	protected String fromAmount;
	
	@JsonProperty("toAmount")
	protected String toAmount;

	
	
	public String getAccountId() {
		return accountId;
	}



	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}



	public String getFromDate() {
		return fromDate;
	}



	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}



	public String getToDate() {
		return toDate;
	}



	public void setToDate(String toDate) {
		this.toDate = toDate;
	}



	public String getFromAmount() {
		return fromAmount;
	}



	public void setFromAmount(String fromAmount) {
		this.fromAmount = fromAmount;
	}



	public String getToAmount() {
		return toAmount;
	}



	public void setToAmount(String toAmount) {
		this.toAmount = toAmount;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(" BankRequestDto [accountId=");
		builder.append(accountId);
		builder.append(", fromDate=");
		builder.append(fromDate);
		builder.append(", toDate=");
		builder.append(toDate);
		builder.append(", fromAmount=");
		builder.append(fromAmount);
		builder.append(", toAmount=");
		builder.append(toAmount);
		builder.append("]");
		return builder.toString();
	}

}
