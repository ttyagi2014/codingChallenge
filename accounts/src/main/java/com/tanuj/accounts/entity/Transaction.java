package com.tanuj.accounts.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.tanuj.accounts.enums.Currency;
import com.tanuj.accounts.enums.TransactionType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	@Column
	private String accountName;
	@Column
	LocalDateTime valueDate;
	@Column
	@Enumerated(EnumType.STRING)
	Currency currency;
	@Column
	BigDecimal debitAmount;
	@Column
	BigDecimal creditAmount;
	@Column
	@Enumerated(EnumType.STRING)
	TransactionType type;
	@Column
	String transactionNarrative;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "gamid")
	private GeneralAcountMaster gamid;
	
}
