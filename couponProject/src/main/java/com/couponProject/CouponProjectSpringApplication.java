package com.couponProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.couponProject.system.Job.CouponExpirationDailyJob;
import com.couponProject.system.core.Company;
import com.couponProject.system.repostory.*;
import com.couponProject.system.service.*;


@SpringBootApplication
public class CouponProjectSpringApplication {

	public static void main(String[] args) {
     ConfigurableApplicationContext ctx=  SpringApplication.run(CouponProjectSpringApplication.class, args);
     System.out.println("AAAAAAAAAAAAAAAAAAAAAAA");
     ctx.close();
//		Company company=new Company();
//		company.setEmail("ilove@gmail.com");
//		company.setName("i love");
//		company.setPassword("1234qwer");
//
//		CompaniesRepostory companiesRepostory=ctx.getBean(CompaniesRepostory.class);
//		companiesRepostory.save(company);
//		System.out.println(companiesRepostory.findById(company.getId()));		
		//not working cant accept couponRepostory
//		try {
////			CouponExpirationDailyJob couponExpirationDailyJob = new CouponExpirationDailyJob(CouponRepostory);
//		}catch (Exception e) {
//			e.getMessage();
//		}
//		
//		try {
//			CompanyService companyService=new CompanyService();
//			companyService.AllCoupons();
//		}catch (Exception e) {
//			e.getMessage();
//		}
	}

}
 