package com.hire.technician.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hire.technician.entity.Address;
import com.hire.technician.entity.Request;
import com.hire.technician.entity.Technician;
import com.hire.technician.repository.RequestRepository;

@Service
public class RequestService {

	@Autowired
	RequestRepository requestRepository;

	@Autowired
	TechnicianService technicianService;

	@Autowired
	AddressService addressService;

	public List<Request> getAllPendingRequest() {
		return requestRepository.getAllPendingRequest(true);
	}

	public String newRequest(Request request, Integer addressId) {
		Address address = addressService.getAddressDetailById(addressId);
		int customerZip = address.getZip();

		List<Technician> availableTechnicianATCustomerZip = technicianService
				.getAllAvailableTechnicianATCustomerZip(customerZip);
		if (availableTechnicianATCustomerZip.size() == 0)
			return "Sorry there is no available technician at your location";
		else {
			request.setTechnician(availableTechnicianATCustomerZip.get(0));
			requestRepository.save(request);
			technicianService.makeTechnicianUnAvailable(availableTechnicianATCustomerZip.get(0).getId());
			return "your request is taken care of we have assigned " + availableTechnicianATCustomerZip.get(0).getName()
					+ " contact Number: " + availableTechnicianATCustomerZip.get(0).getContactNumber()
					+ " for your service";
		}
	}
}
