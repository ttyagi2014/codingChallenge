package com.tanuj.accounts;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.tanuj.accounts.dto.Accounts;
import com.tanuj.accounts.entity.GeneralAcountMaster;
import com.tanuj.accounts.entity.Transaction;
import com.tanuj.accounts.entity.User;
import com.tanuj.accounts.enums.AccountType;
import com.tanuj.accounts.enums.Currency;
import com.tanuj.accounts.enums.TransactionType;
import com.tanuj.accounts.repo.AccountRepo;
import com.tanuj.accounts.repo.TransactionRepo;
import com.tanuj.accounts.repo.UserRepo;
import com.tanuj.accounts.security.dto.UserInfo;
import com.tanuj.accounts.security.repo.UserRepository;

@Configuration
public class SpringRunnerApplication implements CommandLineRunner {
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	UserRepository repo;

	@Autowired
	AccountRepo accntRepo;

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	TransactionRepo tx;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		UserInfo userInfo1 = new UserInfo();

		userInfo1.setUsername("sgSavings123Aus");
		userInfo1.setPassword(encoder.encode("123"));
		userInfo1.setRoles("ADMIN");
		repo.save(userInfo1);

		User user = new User();
		user.setAddress("AUSTRALIA");
		user.setMailId("xyz@gmail.com");
		user.setUsername("sgSavings123Aus");
		
		GeneralAcountMaster obj1 = new GeneralAcountMaster();
		obj1.setAccountName("SGSAVINGS23");
		obj1.setAccountType(AccountType.Savings);
		BigDecimal bg1 = new BigDecimal(12345.6);
		obj1.setBalance(bg1);
		obj1.setUserinfo(user);
		obj1.setCurrency(Currency.SGD);
		obj1.setBalancedDate(LocalDateTime.of(2024, 8, 11, 10, 0, 0));
		
		Transaction tx1=new Transaction();
		tx1.setAccountName("SGSAVINGS23");
		tx1.setCreditAmount(new BigDecimal(224.5));
		tx1.setCurrency(Currency.SGD);
		tx1.setDebitAmount(null);
		tx1.setTransactionNarrative("Transferred from hjj");
		tx1.setType(TransactionType.Credit);
		tx1.setValueDate(LocalDateTime.of(2024, 7, 11, 10, 0, 0));
		tx1.setGamid(obj1);
		
		Transaction tx2=new Transaction();
		tx2.setAccountName("SGSAVINGS23");
		tx2.setCreditAmount(new BigDecimal(12224.5));
		tx2.setCurrency(Currency.SGD);
		tx2.setDebitAmount(null);
		tx2.setTransactionNarrative("CREDITED FROM XYZ");
		tx2.setType(TransactionType.Credit);
		tx2.setValueDate(LocalDateTime.of(2024, 9, 11, 10,20, 0));
		tx2.setGamid(obj1);
		
		Transaction tx3=new Transaction();
		tx3.setAccountName("SGSAVINGS23");
		tx3.setCreditAmount(new BigDecimal(1224.5));
		tx3.setCurrency(Currency.SGD);
		tx3.setDebitAmount(null);
		tx3.setTransactionNarrative("TRANSFERT TO KFC");
		tx3.setType(TransactionType.Credit);
		tx3.setValueDate(LocalDateTime.of(2024, 9, 23, 11, 20, 10));
		tx3.setGamid(obj1);
		
		//obj1.setListTransaction(Arrays.asList(tx1,tx2,tx3));
		accntRepo.save(obj1);
		
		
		
		GeneralAcountMaster obj2 = new GeneralAcountMaster();
		obj2.setAccountName("AUDCURRENT23");
		obj2.setAccountType(AccountType.Current);
		BigDecimal bg2 = new BigDecimal(212345.6);
		obj2.setBalance(bg2);
		obj2.setUserinfo(user);
		obj2.setCurrency(Currency.AUD);
		obj2.setBalancedDate(LocalDateTime.of(2024, 7, 11, 10, 0, 0));
		
		Transaction tx4=new Transaction();
		tx4.setAccountName("AUDCURRENT23");
		tx4.setCreditAmount(new BigDecimal(1224.5));
		tx4.setDebitAmount(null);
		tx4.setTransactionNarrative("TRANSFERRED FROM STOCK");
		tx4.setType(TransactionType.Credit);
		tx4.setCurrency(Currency.AUD);
		tx4.setValueDate(LocalDateTime.of(2024, 11, 5, 12, 0, 0));
		tx4.setGamid(obj2);
		
		tx.save(tx1);
		tx.save(tx2);
		tx.save(tx3);
		tx.save(tx4);
		
		//obj2.setListTransaction(Arrays.asList(tx4));
		accntRepo.save(obj2);

	}

}
