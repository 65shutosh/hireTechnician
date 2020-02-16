package com.hire.technician.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void updateContactNumber(Customer customer) {
		Optional<Customer> data = customerRepository.findById(customer.getId());
		Customer temproryCustomer = data.get();
		temproryCustomer.setContactNumber(customer.getContactNumber());
		customerRepository.save(temproryCustomer);
	}

	public Customer getCustomerWithId(int customerId) {
		Optional<Customer> data = customerRepository.findById(customerId);
		Customer customer = data.get();
		return customer;
	}

}
