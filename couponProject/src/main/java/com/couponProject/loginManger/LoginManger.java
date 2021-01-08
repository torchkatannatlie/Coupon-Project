package com.couponProject.loginManger;

import org.springframework.stereotype.Component;

import com.couponProject.system.service.AdminService;
import com.couponProject.system.service.ClientService;
import com.couponProject.system.service.CompanyService;
import com.couponProject.system.service.CustomerService;
@Component
public class LoginManger {
//	private static LoginManger loginManger;
//
//	private LoginManger() {
//
//	}
//
//	public static LoginManger getInstance() {
//		if (loginManger == null) {
//			loginManger = new LoginManger();
//		}
//		return loginManger;
//	}

	public ClientService login(String email, String password, ClientType clientType) {
		switch (clientType) {
		case Company:
			ClientService companyFacade = new CompanyService();
			if (companyFacade.login(email, password)) {
				System.out.println("your login as company!");
				return companyFacade;
			} else {
				System.out.println("you try to login to worng type");
			}
			break;
		case Customer:
			ClientService customerFasade = new CustomerService();
			if (customerFasade.login(email, password)) {
				System.out.println("your login as customer!");
				return customerFasade;
			} else {
				System.out.println("you try to login to worng type");
			}
			break;
		case Administrator:
			ClientService adminFasade = new AdminService();
			if (adminFasade.login(email, password)) {
				System.out.println("your login as the big boss!!\n welocme back!");
				return adminFasade;
			} else {
				System.out.println("you try to login to worng type");
			}
			break;
		}
		return null;
	}

}
