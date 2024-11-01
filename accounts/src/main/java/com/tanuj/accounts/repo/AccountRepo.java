package com.tanuj.accounts.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tanuj.accounts.entity.GeneralAcountMaster;

public interface AccountRepo extends JpaRepository<GeneralAcountMaster,Long> {
	
	@Query(nativeQuery = true,value="select *  from general_acount_master u where u.userid=:userId")
	List<GeneralAcountMaster> findByAccountUserId(@Param("userId") Integer userId);
	
}
