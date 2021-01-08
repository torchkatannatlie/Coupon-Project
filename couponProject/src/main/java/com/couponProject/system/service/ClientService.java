package com.couponProject.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.couponProject.system.repostory.CompaniesRepostory;
import com.couponProject.system.repostory.CouponRepostory;
import com.couponProject.system.repostory.CustomerRepostory;
@Component
public abstract class ClientService {
	@Autowired
      protected CustomerRepostory customerRepostory;
	@Autowired
      protected CouponRepostory couponRepostory;
	@Autowired
      protected CompaniesRepostory companiesRepostory;

		public abstract boolean login(String email, String password) ;
}
