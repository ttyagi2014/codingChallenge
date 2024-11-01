package com.tanuj.accounts.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanuj.accounts.dto.Accounts;
import com.tanuj.accounts.dto.TransactionDto;
import com.tanuj.accounts.entity.GeneralAcountMaster;
import com.tanuj.accounts.entity.Transaction;
import com.tanuj.accounts.repo.AccountRepo;
import com.tanuj.accounts.repo.TransactionRepo;
import com.tanuj.accounts.repo.UserRepo;

@Service
public class AccountsService {
	@Autowired
	AccountRepo accntRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	TransactionRepo txrepo;

	public List<Accounts> getAccountDetails(String userName) {
		Integer id = userRepo.findUserIdByName(userName);
		List<GeneralAcountMaster> listGenAccntMaster = accntRepo.findByAccountUserId(id);

		return transformintoAccountsDto(listGenAccntMaster);
	}

	public List<Accounts> transformintoAccountsDto(List<GeneralAcountMaster> listSource) {
		List<Accounts> listTarget = new ArrayList<>();
		for (GeneralAcountMaster g : listSource) {
			Accounts accnt = Accounts.builder().accountName(g.getAccountName()).accountNumber(g.getAccountNumber())
					.accountType(g.getAccountType()).balance(g.getBalance())
					.balancedDate(g.getBalancedDate().format(DateTimeFormatter.ofPattern("YYYY-MM-dd")))
					.currency(g.getCurrency()).build();

			listTarget.add(accnt);
		}
		return listTarget;
	}

	public List<TransactionDto> getTransactionDetailsByAccountNo(String accntNo) {

		return transformintoTransactionDto(txrepo.findTransactionByAccountNo(Long.valueOf(accntNo)));

	}

	public List<TransactionDto> transformintoTransactionDto(List<Transaction> listSource) {
		List<TransactionDto> listTarget = new ArrayList<>();
		System.out.println(listSource);
		for (Transaction t : listSource) {
			TransactionDto tx = TransactionDto.builder().accountName(t.getAccountName())
					.creditAmount(t.getCreditAmount()).currency(t.getCurrency()).debitAmount(t.getDebitAmount())
					.transactionNarrative(t.getTransactionNarrative()).type(t.getType())
					.valueDate(t.getValueDate().format(DateTimeFormatter.ofPattern("YYYY-MM-dd"))).build();

			listTarget.add(tx);
		}
		return listTarget;
	}

}
