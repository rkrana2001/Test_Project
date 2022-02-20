package com.bankstatement.account.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statement")
public class BankStatementEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3572500103720797806L;

	@Id
	@Column(name = "ID")
	private BigDecimal id;
	
	@Column(name = "account_id")
	private Integer accountId;
	
	@Column(name = "datefield")
	private String dateField;
	
	@Column(name = "amount")
	private String amount;
	
	private List<BankStatementAccountEntity> account;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
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

	public List<BankStatementAccountEntity> getAccount() {
		return account;
	}

	public void setAccount(List<BankStatementAccountEntity> account) {
		this.account = account;
	}
	
}
