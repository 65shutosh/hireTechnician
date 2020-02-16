package com.hire.technician.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hire.technician.entity.Address;
import com.hire.technician.entity.Customer;
import com.hire.technician.repository.AddressRepository;
import com.hire.technician.service.CustomerService;

@RestController
public class AddressController {
	@Autowired
	AddressRepository addressRepository;

	@Autowired
	CustomerService CustomerService;

	// new Address for Customer
	@PostMapping(path = "/newAddress/{customerId}")
	@ResponseBody
	public Iterable<Address> newAddress(@RequestBody Address data, @PathVariable("customerId") Integer customerId) {

		Customer customer = CustomerService.getCustomerWithId(customerId);
		data.setCustomer(customer);
		addressRepository.save(data);
		return addressRepository.findAll();
	}

	// get Address
	@GetMapping(path = "/getAddresses")
	@ResponseBody
	public Iterable<Address> getAddresses() {
		return addressRepository.findAll();
	}

}
