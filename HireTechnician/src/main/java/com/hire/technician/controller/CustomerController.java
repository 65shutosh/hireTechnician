package com.hire.technician.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hire.technician.entity.Address;
import com.hire.technician.entity.Customer;
import com.hire.technician.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	// get all the address of a customer
	@GetMapping(path = "/customer/{customerId}/addresses")
	@ResponseBody
	public List<Address> customersAddressList(@PathVariable("customerId") Integer customerId) {
		return customerService.customersAddressList(customerId);
	}

	// new customer to add
	@PostMapping(path = "/customer/newCustomer")
	@ResponseBody
	public void newCustomer(@RequestBody Customer customer) {
		customerService.newCustomer(customer);
	}

	// updating contact number
	@PutMapping(path = "/customer/{customerId}/updateContactNumber")
	@ResponseBody
	public void updateContactNumber(@RequestBody String customerNewContact,@PathVariable("customerId") Integer customerId) {
		customerService.updateContactNumber(customerId,customerNewContact);
	}

}
