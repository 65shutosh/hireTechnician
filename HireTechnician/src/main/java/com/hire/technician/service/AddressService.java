package com.hire.technician.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hire.technician.entity.Address;
import com.hire.technician.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public List<Address> getAllAvailableTechnicianAddressATCustomerZip(int customerZip) {
		return addressRepository.getAllAvailableTechnicianAddressATCustomerZip(customerZip);
	}

	public Address getAddressDetailById(Integer addressId) {
		Optional<Address> data = addressRepository.findById(addressId);
		Address address = data.get();
		return address;
	}

}
