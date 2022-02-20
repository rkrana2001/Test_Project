package com.bankstatement.account.query;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries(value = {
		
		@NamedQuery(name = "bank.statement",  query ="select a.accountType, a.accountNumber "
				+ " b.accountId, b.dateField, b.amount from BankStatementAccountEntity a, BankStatementEntity b "
				+ " where a.id = b.id and a.accountNumber = :accountNumber and b.dateField = :dateField and b.amount = :amount "),
})

@Entity
public class NamedQueryHolder {
	
	@Id
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
