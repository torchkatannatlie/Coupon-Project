package com.couponProject.system.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.couponProject.system.core.Coupon;
import com.couponProject.system.service.ProjectException;

@Repository
public interface CouponRepostory extends JpaRepository<Coupon,Integer> {
	@Query(value = "select  * from coupons where id = :couponId",nativeQuery = true)
	boolean isCouponsExists(int couponId)throws ProjectException;
	
//	@Query("insert into coupons(COMPANY_ID,CATEGORY_ID,TITLE,DESCRIPTION,START_DATE,END_DATE,AMOUNT,PRICE,IMAGE) values ( ? , ? , ? ,? , ? , ? , ? , ? , ?)")
//	void addCoupon(Coupon coupon)throws ProjectException;
			
//	//getAllCoupons
//	List<Coupon>findAll()throws ProjectException;
	
	//getAllCompanyCoupons
	@Query(value = "select * from coupons where COMPANY_ID = :companyId",nativeQuery = true)
	List<Coupon>findAllByCompanyId(int companyId)throws ProjectException;
	
	//getOneCoupon
	@Query(value = "select * from coupons where id= :couponId",nativeQuery = true)
	Coupon findByCouponId(int couponId)throws ProjectException;
	
	@Query(value = "INSERT INTO customers_coupons (customer_id, coupon_id) VALUES (:customerID, :couponID)",nativeQuery = true)
	void addCouponPurchase(int customerID, int couponID)throws ProjectException;
	
	@Query(value = "DELETE FROM customers_coupons WHERE (coupon_id = :couponID) and (customer_id = :customerID)",nativeQuery = true)
	void deleteCouponPurchase(int couponID, int customerID)throws ProjectException;
	
	//deleteAllCoupons
	void deleteAllByCompanyId(int companyId)throws ProjectException;
	
	//deleteAllCouponHistory
	@Query(value = "DELETE FROM couponproject.customers_coupons WHERE coupon_id = :companyId",nativeQuery = true)
	void deleteAllCouponHistory(int companyId)throws ProjectException;
	
	@Query(value = "select form coupons where CATEGORY= :category AND COMPANY_ID= :companyId ",nativeQuery = true)
	List<Coupon>couponSameCategorySameCompany(String category,int companyId)throws ProjectException;
	
	@Query(value = "select from coupons where price<= :price",nativeQuery = true)
	List<Coupon>maxPriceforComapny(double price)throws ProjectException;
	
	@Query(value = "DELETE FROM couponproject.customers_coupons WHERE coupon_id = ?",nativeQuery = true)
	void deleteCouponPurchase(int couponID)throws ProjectException;
	
}
