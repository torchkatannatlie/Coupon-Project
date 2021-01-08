package com.couponProject.system.Job;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.couponProject.system.core.Coupon;
import com.couponProject.system.repostory.CouponRepostory;

@Component
public class CouponExpirationDailyJob implements Runnable {
	@Autowired
	private CouponRepostory couponDBDAO;
	private boolean quit = false;


	@PostConstruct
	@Override
	public void run() {
		try {
			while (!quit) {
				List<Coupon> allCoupons = couponDBDAO.findAll();
				for (int i = 0; i < allCoupons.size(); i++) {
					Coupon coupon = allCoupons.get(i);
					if (coupon.getEndDate().isBefore(LocalDate.now())) {
						couponDBDAO.deleteById(coupon.getId());
						;
					}
				}
//				System.out.println("We successfully deleted the expired coupons");
				for (int j = 0; j < 86400 && !quit; j++) {
					Thread.sleep(1000);
				}
//				Thread.sleep(86_400_000);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("finish");
	}

	@PreDestroy
	public void stop() {
		quit = true;
		System.out.println("you now quiting");
	}

}
