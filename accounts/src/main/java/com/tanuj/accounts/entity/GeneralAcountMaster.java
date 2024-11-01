package com.tanuj.accounts.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import com.tanuj.accounts.enums.AccountType;
import com.tanuj.accounts.enums.Currency;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class GeneralAcountMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountNumber;
	private String accountName;
	@Enumerated(EnumType.STRING)
	AccountType accountType;

	private LocalDateTime balancedDate;

	@Enumerated(EnumType.STRING)
	private Currency currency;

	private BigDecimal balance;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private User userinfo;

}
