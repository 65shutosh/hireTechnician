package com.hire.technician.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.hire.technician.entity.Address;
import com.hire.technician.repository.AddressRepository;

class AddressServiceTest {

	@InjectMocks
	AddressService addressService;

	@Mock
	AddressRepository addressRepository = Mockito.mock(AddressRepository.class);

//	@BeforeEach
//	public static void initiate() {
//
//	}

	@Test
	@DisplayName("Get all available technician addresses at customers Zip")
	public void testGetAllAvailableTechnicianAddressATCustomerZip() {
		MockitoAnnotations.initMocks(this);
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(new Address(1, "HSR Layout", "Bangalore", 96950, "near Agara Lake"));
		addresses.add(new Address(2, "HSR Layout 2", "Bangalore", 96950, "near Agara Lake 2"));
		Mockito.when(addressRepository.getAllAvailableTechnicianAddressATCustomerZip(96950)).thenReturn(addresses);
		List<Address> data = addressService.getAllAvailableTechnicianAddressATCustomerZip(96950);
		assertEquals(2, data.size(), "If it checks with function answer should be 2");
		Mockito.verify(addressRepository).getAllAvailableTechnicianAddressATCustomerZip(96950);
	}

//	@Test
//	public void testGetAddressDetailById() {
//		Address address = new Address(1, "HSR Layout", "Bangalore", 96950, "near Agara Lake");
//
//	}

}
