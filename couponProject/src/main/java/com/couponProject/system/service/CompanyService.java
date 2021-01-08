package com.couponProject.system.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couponProject.system.core.Company;
import com.couponProject.system.core.Coupon;
import com.couponProject.system.repostory.CompaniesRepostory;
import com.couponProject.system.repostory.CouponRepostory;

import jdk.jfr.Category;

@Service
public class CompanyService extends ClientService {

	private int companyId;

	public CompanyService() {
		super();
		this.companyId = 0;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Override
	public boolean login(String email, String password) {
		try {
			if (companiesRepostory.isCompanyExists(email, password)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public void addCoupon(Coupon coupon) throws ProjectException {
		if (!couponRepostory.isCouponsExists(coupon.getId())) {
			couponRepostory.save(coupon);
		}
	}

	public void updateCoupon(Coupon coupon) throws ProjectException {
		couponRepostory.save(coupon);
	}

	public void deleteThisCoupon(int couponId) throws ProjectException {
		couponRepostory.deleteById(couponId);
	}

	public List<Coupon> AllCoupons() throws ProjectException {
		return couponRepostory.findAllByCompanyId(companyId);
	}

	public Coupon getThisCoupon(int couponId) throws ProjectException {
		return couponRepostory.getOne(couponId);
	}

	public List<Coupon> returnAllCouponFromSameCategory(String category) throws ProjectException {
		return couponRepostory.couponSameCategorySameCompany(category, companyId);
	}

	public List<Coupon> returnAllCouponByPrice(double price) throws ProjectException {
		return couponRepostory.maxPriceforComapny(price);
	}

	public Company getCompanyDetails() throws ProjectException {
		return companiesRepostory.findById(companyId);
	}

	public void updateDetails(Company company) throws ProjectException {
		companiesRepostory.save(company);
	}

}
