package com.hire.technician.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hire.technician.entity.Request;

@Repository
public interface RequestRepository extends CrudRepository<Request, Integer> {

	@Query("from Request where completed = ?1")
	public List<Request> getAllPendingRequest(boolean data);

}
