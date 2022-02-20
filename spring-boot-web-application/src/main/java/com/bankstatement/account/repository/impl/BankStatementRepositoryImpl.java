package com.bankstatement.account.repository.impl;

import static com.bankstatement.account.bankconstants.BankStatementConstants.BANK_STATEMENT;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bankstatement.account.dto.BankRequestDto;
import com.bankstatement.account.entities.BankStatementEntity;
import com.bankstatement.account.repository.BankStatementRepository;
@Repository
public class BankStatementRepositoryImpl implements BankStatementRepository{

	private final Logger log = LoggerFactory.getLogger(BankStatementRepositoryImpl.class);
	
	
	@Override
	public BankStatementEntity getBankStatement(BankRequestDto bankRequestDto) {
		log.info("BankStatementRepositoryImpl.getBankStatement method invoked {}");
		Connection con = getConnection();
		BankStatementEntity bankStatementEntity = new BankStatementEntity();
		try {
			EntityManager entityManager = null;
			Statement s = (Statement) con.createStatement();
			@SuppressWarnings("null")
			Query query =   entityManager.createNamedQuery(BANK_STATEMENT);
			query.setParameter("accountNumber", bankRequestDto.getAccountId());
			query.setParameter("dateField", bankRequestDto.getFromDate());
			query.setParameter("amount", bankRequestDto.getFromAmount());
			bankStatementEntity = (BankStatementEntity) query.getSingleResult();
		}catch(Exception e) {
			log.info("Data not found : ", e);
		}
		
		return bankStatementEntity;
	}
	
	
	private Connection getConnection() {
		
		Connection connection = null;
		try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
            connection= DriverManager.getConnection("jdbc:ucanaccess://192.168.1.122\\C:\\Users\\lavan\\Documents\\accountsdb.accdb");//Establishing Connection
            log.info("Connected Successfully");

        }catch(Exception e){
            System.out.println("Error in connection");

        }
		
		return connection;
	}

}
