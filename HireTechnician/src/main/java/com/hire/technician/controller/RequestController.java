package com.hire.technician.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hire.technician.entity.Request;
import com.hire.technician.service.RequestService;

@RestController
public class RequestController {

	@Autowired
	RequestService requestService;

	@PostMapping(path = "/request/new/customer/{customerId}/address/{addressId}")
	@ResponseBody
	public String newRequest(@RequestBody Request request, @PathVariable("customerId") Integer customerId,
			@PathVariable("addressId") Integer addressId) {
		return requestService.newRequest(request, addressId);
	}

	@GetMapping(path = "/request/pending")
	@ResponseBody
	public List<Request> getAllPenedingRequest() {
		return requestService.getAllPendingRequest();
	}

}
