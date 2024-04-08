package com.simpleWebApp.model;

public class Employee {
	
	private int id;
	private String name;
	private String domain;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", domain=" + domain + "]";
	}
}
