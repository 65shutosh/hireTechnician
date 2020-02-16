package com.hire.technician.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "technician")
public class Technician {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String Name;
	@NotNull
	private String contactNumber;
	private String email;
	@NotNull
	private String govID;
	private boolean available = true;
	@Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false)
	private Calendar workingSince;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToMany
	@JoinColumn(name = "technician_id")
	private List<Request> service;

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGovID() {
		return govID;
	}

	public void setGovID(String govID) {
		this.govID = govID;
	}

	public Calendar getWorkingSince() {
		return workingSince;
	}

	public void setWorkingSince(Calendar workingSince) {
		this.workingSince = workingSince;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Request> getService() {
		return service;
	}

	public void setService(List<Request> service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "Technician [id=" + id + ", Name=" + Name + ", contactNumber=" + contactNumber + ", email=" + email
				+ ", govID=" + govID + ", available=" + available + ", workingSince=" + workingSince + ", address_id="
				+ address.getId() + ", service=" + service + "]";
	}

}
