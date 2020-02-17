package com.hire.technician.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hire.technician.entity.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

	@Query("from Address where zip = ?1 and customer_id is null")
	List<Address> getAllAvailableTechnicianAddressATCustomerZip(int customerZip);

	@Query("from Address where customer_id =?1")
	List<Address> customersAddressList(Integer customerId);

}
