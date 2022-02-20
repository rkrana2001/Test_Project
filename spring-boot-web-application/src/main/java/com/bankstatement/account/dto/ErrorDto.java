package com.bankstatement.account.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@JsonPropertyOrder({"errorRecord"})
@JsonInclude(Include.NON_NULL)

public class ErrorDto {
	
	@JsonProperty("errorRecord")
	protected List<ErrorRecordDto> errorRecord;

	public List<ErrorRecordDto> getErrorRecord() {
		return errorRecord;
	}

	public void setErrorRecord(List<ErrorRecordDto> errorRecord) {
		this.errorRecord = errorRecord;
	}
	
	

}
