package com.hire.technician.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hire.technician.entity.Address;
import com.hire.technician.entity.Customer;
import com.hire.technician.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AddressService addressService;

	public List<Customer> customersList() {
		return customerRepository.getAllCustomers();
	}

	public void newCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public void updateContactNumber(int id, String newContactDetail) {
		Optional<Customer> data = customerRepository.findById(id);
		Customer temproryCustomer =null;
		if(data.isPresent()) {
		temproryCustomer = data.get();
		temproryCustomer.setContactNumber(newContactDetail);
		customerRepository.save(temproryCustomer);
		}
	}

	public Customer getCustomerWithId(int customerId) {
		Optional<Customer> data = customerRepository.findById(customerId);
		Customer customer = null;
		if(data.isPresent()) {
		customer = data.get();
		}
		return customer;
	}

	public List<Address> customersAddressList(int customerId) {
		return addressService.customersAddressList(customerId);
	}

}
