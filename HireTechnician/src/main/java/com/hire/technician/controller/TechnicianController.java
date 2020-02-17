package com.hire.technician.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hire.technician.entity.Technician;
import com.hire.technician.service.TechnicianService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TechnicianController {

	@Autowired
	TechnicianService technicianService;

	// adding a new technician
	@PostMapping(path = "/technician/new")
	@ResponseBody
	public void newTechnician(@RequestBody Technician data) {
		technicianService.newTechnician(data);
	}

	// admin use
	// getting all the technician
	@GetMapping(path = "/technician")
	@ResponseBody
	public Iterable<Technician> getAllTechnician() {
		return technicianService.getAllTechnician();
	}

	// admin use
	// getting all the available technician
	@GetMapping(path = "/technician/{available}")
	@ResponseBody
	public Iterable<Technician> availableTechnicians(@PathVariable("available") String available) {
		return technicianService.availableTechnicians(available);
	}

	// updating contact number for technician
	@PutMapping(path = "/technician/{technicianId}/updateContactNumber")
	@ResponseBody
	public void updateContactNumber(@RequestBody String contact,@PathVariable("technicianId") Integer technicianId) {
		technicianService.updateContactNumber(contact,technicianId);
	}

	// checking his availability status
	@GetMapping(path = "/technician/availability/{technicianId}")
	@ResponseBody
	public boolean technicianAvailability(@PathVariable("technicianId") Integer technicianId) {
		return technicianService.technicianAvailability(technicianId);
	}

	// making himself unAvailable (soft delete)
	@PutMapping(path = "/technician/unavailable/{technicianId}")
	@ResponseBody
	public boolean makeTechnicianUnAvailable(@PathVariable("technicianId") Integer technicianId) {
		technicianService.makeTechnicianUnAvailable(technicianId);
		return false;
	}

	// making himself available for service
	@PutMapping(path = "/technician/available/{technicianId}")
	@ResponseBody
	public boolean makingAvailable(@PathVariable("technicianId") Integer technicianId) {
		technicianService.makeTechnicianAvailable(technicianId);
		return true;
	}

}
