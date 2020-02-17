package com.hire.technician.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.hire.technician.entity.Address;
import com.hire.technician.entity.Technician;
import com.hire.technician.repository.TechnicianRepository;

@Service
public class TechnicianService {
	@Autowired
	TechnicianRepository technicianRepository;

	@Autowired
	AddressService addressService;

	public void newTechnician(@RequestBody Technician data) {
		technicianRepository.save(data);
	}

	public Iterable<Technician> getAllTechnician() {
		return technicianRepository.findAll();
	}

	public Iterable<Technician> availableTechnicians(String avaialable) {
		if (avaialable.equals("available"))
			return technicianRepository.getAllAvailableTechnician(true);
		return null;
	}

	public void updateContactNumber(String contact, int technicianId) {
		Optional<Technician> data = technicianRepository.findById(technicianId);
		// throws no such element Exception
		Technician temproryTechnician = null;
		if (data.isPresent()) {
			temproryTechnician = data.get();
			temproryTechnician.setContactNumber(contact);
			technicianRepository.save(temproryTechnician);
		}
	}

	public List<Technician> getAllAvailableTechnicianATCustomerZip(int customerZip) {

		List<Address> technicianIdListAtCustomerZip = addressService
				.getAllAvailableTechnicianAddressATCustomerZip(customerZip);
		List<Technician> allTechnicianDetailsForTechnicianIdTakenFromAddressObject = new ArrayList<>();
		for (Iterator<Address> iterator = technicianIdListAtCustomerZip.iterator(); iterator.hasNext();) {
			Address address = iterator.next();
			int addressId = address.getId();
			Technician temproryTechnician = technicianRepository.getAllAvailableTechnicianAtCustomerZip(addressId,
					true);
			if (temproryTechnician != null)
				allTechnicianDetailsForTechnicianIdTakenFromAddressObject.add(temproryTechnician);
		}
		return allTechnicianDetailsForTechnicianIdTakenFromAddressObject;
	}

	public void makeTechnicianUnAvailable(int id) {
		Optional<Technician> data = technicianRepository.findById(id);
		Technician temproryTechnician = null;
		if (data.isPresent()) {
			temproryTechnician = data.get();
			temproryTechnician.setAvailable(false);
			technicianRepository.save(temproryTechnician);
		}
	}

	public boolean technicianAvailability(int technicianId) {
		Optional<Technician> data = technicianRepository.findById(technicianId);
		Technician technician = null;
		if (data.isPresent()) {
			technician = data.get();
			return technician.isAvailable();
		}
		return false;
	}

	public void makeTechnicianAvailable(int technicianId) {
		Optional<Technician> data = technicianRepository.findById(technicianId);
		Technician technician = null;
		if (data.isPresent()) {
			technician = data.get();
			technician.setAvailable(true);
			technicianRepository.save(technician);
		}
	}

}
