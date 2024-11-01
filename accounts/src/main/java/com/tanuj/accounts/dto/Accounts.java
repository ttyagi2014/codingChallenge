package com.tanuj.accounts.dto;

import java.math.BigDecimal;

import com.tanuj.accounts.enums.AccountType;
import com.tanuj.accounts.enums.Currency;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Accounts {
	private Long accountNumber;
	private String accountName;

	AccountType accountType;

	private String balancedDate;

	private Currency currency;

	private BigDecimal balance;

}
