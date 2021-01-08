package com.couponProject.system.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.couponProject.system.core.Coupon;
import com.couponProject.system.core.Customer;
import com.couponProject.system.service.ProjectException;

@Repository
public interface CustomerRepostory extends JpaRepository<Customer, Integer> {

	@Query(value = "select  from customer where email = :email and password= :password",nativeQuery = true)
	boolean isCustomerExists(String email, String password) throws ProjectException;

//	@Query("select  from customer where email= :email")
	boolean findByEmail(String email) throws ProjectException;

	// add
//	Customer save(Customer customer);


//	List<Customer>findAll()throws ProjectException;

	Customer findById(int customerId) throws ProjectException;

	@Query(value="select coupun_id from customers_coupons where customer_id= :customerId",nativeQuery = true)
	List<Coupon> historyOfPurchase(int customerId) throws ProjectException;

}
