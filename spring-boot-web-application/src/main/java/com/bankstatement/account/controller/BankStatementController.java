package com.bankstatement.account.controller;

import java.util.Map;
import java.util.Map.Entry;

import javax.validation.Valid;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankstatement.account.dto.BankRequestDto;
import com.bankstatement.account.dto.BankResponseDto;
import com.bankstatement.account.dto.ErrorDto;
import com.bankstatement.account.dto.ErrorRecordDto;
import com.bankstatement.account.enume.BankValidationErrEnum;
import com.bankstatement.account.exceptions.BRSRValidationException;
import com.bankstatement.account.service.BankStatementService;

@RestController
public class BankStatementController {
	private static final Logger log = LoggerFactory.getLogger(BankStatementController.class);

	@Autowired
	private BankStatementService bankStatementService;

	@PostMapping("/bank/statement")
	@ResponseBody
	public BankResponseDto retrieveCoursesForStudent(@Valid @RequestBody BankRequestDto bankRequestDto) {
		log.info("Entring The Controller getBankStatement {}", bankRequestDto);
		BankResponseDto bankResponseDto = new BankResponseDto();
try {
			
			if (null != bankRequestDto) {
				ErrorDto errorDto = validateBankRequest(bankRequestDto.getAccountId(), bankRequestDto.getFromDate(),
						bankRequestDto.getToDate(), bankRequestDto.getFromAmount(), bankRequestDto.getToAmount());
				if(CollectionUtils.isNotEmpty(errorDto.getErrorRecord())) {
					return populateErrorResponse(errorDto);
				}
				bankResponseDto = bankStatementService.getBankStatement(bankRequestDto);
			}
			
		}catch(Exception e){
			log.error("Exception in BankStatementController.getBankStatement", e);
			bankResponseDto = populateErrorResponse(e);
		}
		return bankResponseDto;
	}
	private BankResponseDto populateErrorResponse(Exception e) {
		log.debug("getBankStatement populateErrorResponse method invoked: exception related to BankValidationException");
		BankResponseDto bankResponseDto = new BankResponseDto();
		ErrorDto errorTypeDto = null;
		if(e instanceof BRSRValidationException) {
			BRSRValidationException brsrValidationException = (BRSRValidationException) e;
			Map<String, String> errorMap = brsrValidationException.getErrorList();
			errorTypeDto = getErrorDto(errorMap);
		} 
			bankResponseDto.setSuccessStatus(false);
			bankResponseDto.setErrorMessage(errorTypeDto);
		
		return bankResponseDto;
	}

	private ErrorDto getErrorDto(Map<String, String> errorMap) {
		
		String errorCode = BankValidationErrEnum.SYSTEM_ERROR_CODE_CJ0020.getValue();
		String errorDescriptio = BankValidationErrEnum.ERROR_MSG_PLEASE_TRY_AGAIN_SOME_TIME.getValue();
		if(null != errorMap && CollectionUtils.isNotEmpty(errorMap.keySet())) {
			for(Entry<String,String> errorEntry : errorMap.entrySet()) {
				errorCode = errorEntry.getKey();
				errorDescriptio = errorEntry.getValue();
			}
		}
		return populateErrorDto(errorCode, errorDescriptio);
	}

	private ErrorDto populateErrorDto(String errorCode, String errorDescriptio) {
		log.debug("populateErrorResponse methos invoked {} : {}", errorCode, errorDescriptio);
		ErrorRecordDto errorRecordType = new ErrorRecordDto();
		errorRecordType.setErrorCode(errorCode);
		errorRecordType.setErrorDescription(errorDescriptio);
		ErrorDto errorType = new ErrorDto();
		errorType.getErrorRecord().add(errorRecordType);
		return errorType;
	}

	private ErrorDto validateBankRequest(String accountId, String fromDate, String toDate, String fromAmount,
			String toAmount) {
		
		ErrorDto errorDto = null;
		
		return errorDto;
	}

	private BankResponseDto populateErrorResponse(ErrorDto errorDto) {
		
		log.debug("getBankStatement populateErrorResponse method invoked: errorDto{}", errorDto);
		BankResponseDto bankResponseDto = new BankResponseDto();
		bankResponseDto.setSuccessStatus(false);
		bankResponseDto.setErrorMessage(errorDto);
		return bankResponseDto;
	}
}
