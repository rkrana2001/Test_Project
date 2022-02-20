package com.bankstatement.account.service;

import com.bankstatement.account.dto.BankRequestDto;
import com.bankstatement.account.dto.BankResponseDto;

public interface BankStatementService {

	BankResponseDto getBankStatement(BankRequestDto bankRequestDto);
	
}
