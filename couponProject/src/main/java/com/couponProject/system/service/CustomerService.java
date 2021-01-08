package com.couponProject.system.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couponProject.system.core.Coupon;
import com.couponProject.system.core.Customer;
import com.couponProject.system.repostory.CouponRepostory;
import com.couponProject.system.repostory.CustomerRepostory;

@Service
public class CustomerService extends ClientService {


	private int customerID;

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public CustomerService() {
		super();
		this.customerID = 0;
	}

	@Override
	public boolean login(String email, String password)  {
		try {
			if (customerRepostory.isCustomerExists(email, password)) {
				return true;
			}
		} catch (ProjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Coupon getOneCoupon(int couponId) throws ProjectException {
		return couponRepostory.getOne(couponId);
	}

	public void purchaseCoupon(Coupon coupon) throws ProjectException {

		boolean flag = true;
		List<Coupon> couponsOfCustomer = customerRepostory.historyOfPurchase(customerID);
		for (Coupon customerCoupon : couponsOfCustomer) {
			if (customerCoupon.equals(coupon) || (coupon.getAmount() == 0)
					|| (LocalDate.now().isAfter(coupon.getEndDate()))) {
				flag = false;
				break;
			}
		}
		if (flag) {
			couponRepostory.addCouponPurchase(customerID, coupon.getId());
			coupon.setAmount(coupon.getAmount() - 1);
		}

	}

	public void removeCouponPurchase(Coupon coupon) throws ProjectException {
		if (!couponRepostory.isCouponsExists(coupon.getId())) {
			throw new ProjectException("This coupon does not exist");
		}
		couponRepostory.deleteCouponPurchase(customerID, coupon.getId());
	}

	public List<Coupon> returnAllCustomerCoupon() throws ProjectException {
		try {
			return customerRepostory.historyOfPurchase(customerID);
		} catch (Exception e) {
			throw new ProjectException(e.getMessage(), e);
		}
	}

	public List<Coupon> returnAllCustomerCoupon(String category) throws ProjectException {
		List<Coupon> couponsWithTheSameCategory = new ArrayList<>();
		List<Coupon> allCoupons = customerRepostory.historyOfPurchase(customerID);
		for (int i = 0; i < allCoupons.size(); i++) {
			if (allCoupons.get(i).getCategory().equals(allCoupons)) {
				couponsWithTheSameCategory.add(allCoupons.get(i));
			}
		}
		return couponsWithTheSameCategory;

	}

	public ArrayList<Coupon> returnAllCustomerCoupon(double price) throws ProjectException {
		ArrayList<Coupon> couponsUnderThePrice = new ArrayList<>();
		List<Coupon> allCoupons = customerRepostory.historyOfPurchase(customerID);
		for (int i = 0; i < allCoupons.size(); i++) {
			if (allCoupons.get(i).getPrice() <= price) {
				couponsUnderThePrice.add(allCoupons.get(i));
			}
		}
		return couponsUnderThePrice;

	}

	public Customer getCustomerDetails() throws ProjectException {
		return customerRepostory.getOne(customerID);
	}

	public List<Coupon> getHistoryPurchase(int customerId) throws ProjectException {
		return customerRepostory.historyOfPurchase(customerId);
	}

}
