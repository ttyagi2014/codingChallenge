package com.tanuj.accounts.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tanuj.accounts.dto.Accounts;
import com.tanuj.accounts.dto.TransactionDto;
import com.tanuj.accounts.entity.GeneralAcountMaster;
import com.tanuj.accounts.service.AccountsService;

@RestController
public class AccountInfo {
	
	@Autowired
	AccountsService accntService;
	@GetMapping("/accountInfo")
	public List<Accounts> getAccountList(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username=((UserDetails)principal).getUsername();
		return accntService.getAccountDetails(username);
	}
	
	
	  @GetMapping("/transaction/{accntno}") 
	  public List<TransactionDto> getTransactionDetailsByAccntNo(@PathVariable String accntno ){
		  System.out.println("account no:"+accntno);
		  List<TransactionDto> listTx=accntService.getTransactionDetailsByAccountNo(accntno);
		  System.out.println("**************");
		  System.out.println(listTx);
		  return listTx;
	  }
	 
	
	
	

}
