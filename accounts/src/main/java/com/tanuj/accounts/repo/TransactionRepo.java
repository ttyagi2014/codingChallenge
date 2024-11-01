package com.tanuj.accounts.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tanuj.accounts.entity.Transaction;
public interface TransactionRepo extends JpaRepository<Transaction,Long> {
	
	 @Query(nativeQuery = true,value = "select * from transaction where gamid=:accntno ") 
	 public List<Transaction> findTransactionByAccountNo(Long accntno);

}
