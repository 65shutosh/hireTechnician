package com.hire.technician.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hire.technician.entity.Customer;
import com.hire.technician.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	// get all the customers
	@GetMapping(path = "/allCustomer")
	@ResponseBody
	public List<Customer> customersList() {
		return customerService.customersList();
	}

	// new customer to add
	@PostMapping(path = "/newCustomer")
	@ResponseBody
	public void newCustomer(@RequestBody Customer customer) {
		customerService.newCustomer(customer);
	}

	// updating contact number
	@PutMapping(path = "/updateContactNumber")
	@ResponseBody
	public void updateContactNumber(@RequestBody Customer customer) {
		customerService.updateContactNumber(customer);
	}

}
