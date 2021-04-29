package com.hire.technician.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hire.technician.entity.Technician;

@Repository
public interface TechnicianRepository extends CrudRepository<Technician, Integer> {

	@Query("from Technician where available = ?1")
	Iterable<Technician> getAllAvailableTechnician(boolean avialable);

	@Query("from Technician where address_id=?1 and available=?2")
	public Technician getAllAvailableTechnicianAtCustomerZip(int addressid, boolean check);

}
