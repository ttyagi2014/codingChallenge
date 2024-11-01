package com.tanuj.accounts.dto;

import java.math.BigDecimal;

import com.tanuj.accounts.enums.Currency;
import com.tanuj.accounts.enums.TransactionType;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TransactionDto {

	

	private String accountName;

	String valueDate;

	Currency currency;

	BigDecimal debitAmount;

	BigDecimal creditAmount;

	TransactionType type;

	String transactionNarrative;
}
