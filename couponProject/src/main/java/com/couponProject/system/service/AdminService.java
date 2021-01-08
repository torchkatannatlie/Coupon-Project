package com.couponProject.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.couponProject.system.core.Company;
import com.couponProject.system.core.Customer;
@Service
public class AdminService extends ClientService {

	private String adminEmail = "admin@admin.com";
	private String adminPassword = "admin";

	@Override
	public boolean login(String email, String password) {
		if (email.equals(adminEmail) && password.equals(adminPassword)) {
			System.out.println("walcome back boss");
			return true;
		}
		return false;
	}

	// addcomapny
	public void addCompany(Company company) throws ProjectException {
		try {
			companiesRepostory.save(company);
		} catch (Exception e) {
			throw new ProjectException(e.getMessage());
		}
	}

	// updatecomapny
	public void updateComapny(Company company) throws ProjectException {
		try {
			companiesRepostory.save(company);
		} catch (Exception e) {
			throw new ProjectException(e.getMessage());
		}
	}

	// deletecomapny
	public void deleteThisCompany(Integer companyId) throws ProjectException {
		try {
			companiesRepostory.deleteById(companyId);
		} catch (Exception e) {
			throw new ProjectException(e.getMessage());
		}
	}

	// returnallcomapny
	public List<Company> AllCompany() throws ProjectException {
		try {
			return companiesRepostory.findAllCompanies();
		} catch (Exception e) {
			throw new ProjectException(e.getMessage());
		}
	}

	// returnonecompnay
	public Company getThisCompany(int companyId) throws ProjectException {
		return companiesRepostory.findById(companyId);
	}

	// addcustomer
	public void addCustomer(Customer customer) throws ProjectException {
		customerRepostory.save(customer);
	}// udateCustomer

	public void updateCustomer(Customer customer) throws ProjectException {
		customerRepostory.save(customer);
	}

//deleteCustomer
	public void deleteThisCustomer(int customerId) throws ProjectException {
		customerRepostory.deleteById(customerId);
	}

//returnallCustomer
	public List<Customer> AllCustomer() throws ProjectException {
		return customerRepostory.findAll();
	}

//returnoneCustomer
	public Customer getThisCustomer(int customerId) throws ProjectException {
		return customerRepostory.findById(customerId);
	}

}
