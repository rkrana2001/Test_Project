package com.bankstatement.account.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bankstatement.account.dto.BankRequestDto;
import com.bankstatement.account.dto.BankResponseDto;
import com.bankstatement.account.entities.BankStatementEntity;
import com.bankstatement.account.repository.BankStatementRepository;
import com.bankstatement.account.service.BankStatementService;

@Component
public class BankStatementServiceImpl implements BankStatementService{
	private final Logger log = LoggerFactory.getLogger(BankStatementServiceImpl.class);
	
	@Autowired 
	BankStatementRepository bankStatementRepository;

	@Override
	public BankResponseDto getBankStatement(BankRequestDto bankRequestDto) {
		BankResponseDto bankResponseDto = new BankResponseDto();
		BankStatementEntity bankStatementEntity = bankStatementRepository.getBankStatement(bankRequestDto);
		if (null != bankStatementEntity) {
			bankResponseDto.setAccountId(bankStatementEntity.getAccountId());
			bankResponseDto.setAmount(bankStatementEntity.getAmount());
			bankResponseDto.setDateField(bankStatementEntity.getDateField());
			bankResponseDto.setID(bankStatementEntity.getId());
		}
		return bankResponseDto;
	}


}
