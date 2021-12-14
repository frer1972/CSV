package com.Homework.demo.model;

public class Enrollment {
	
	private Integer userId;
	private String firstName;
	private String lastName;
	private Integer version;
	private String insuranceCompany;
	
	public Enrollment() {
	}

	public Enrollment(Integer userId, String firstName, String lastName, Integer version, String insuranceCompany) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.version = version;
		this.insuranceCompany = insuranceCompany;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}
	
	public static String[] fields() {
		return new String[] {"userId","firstName","lastName","version","insuranceCompany"};
	}

	@Override
	public String toString() {
		return "Enrollment [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", version="
				+ version + ", insuranceCompany=" + insuranceCompany + "]";
	}
	
	

}
