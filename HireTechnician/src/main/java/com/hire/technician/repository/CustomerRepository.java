package com.hire.technician.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hire.technician.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	@Query(value = "from Customer")
	public List<Customer> getAllCustomers();

}
