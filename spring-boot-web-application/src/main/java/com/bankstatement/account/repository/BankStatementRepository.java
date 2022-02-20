package com.bankstatement.account.repository;

import com.bankstatement.account.dto.BankRequestDto;
import com.bankstatement.account.entities.BankStatementEntity;

public interface BankStatementRepository {

	BankStatementEntity getBankStatement(BankRequestDto bankRequestDto);
}
