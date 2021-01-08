package com.couponProject.system.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.couponProject.system.core.Company;
import com.couponProject.system.service.ProjectException;
@Repository
public interface CompaniesRepostory extends JpaRepository<Company, Integer> {

	@Query(value = "select  from companies where id = :companyID",nativeQuery = true)
	boolean isCompanyExists(int companyID) throws ProjectException;

	@Query(value = "select  from companies where email = :email and password= :password",nativeQuery = true)
	boolean isCompanyExists(String email, String password)throws ProjectException;

	// save

	// set---
	// getAllCompanies
	List<Company> findAllCompanies()throws ProjectException;

	// getOneCompany
	Company findById(int comapnyId)throws ProjectException;
	
	//returnComapnyInfoByLogin
	Company findByEmail(String email)throws ProjectException;

}
