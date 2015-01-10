package com.rms.entity;

public class User {
	
	private int id;
	
	private String userId;
	
	private String password;
	
	private String name;
	
	private String type;
	
	private String locationId;
	
	private String parent;
	
	private String phoneNo;
	
	private char active;
	
	public User() {
		super();
	}

	public User(int id, String userId, String password, String name, String type, String locationId, String parent,
			String phoneNo, char active) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.type = type;
		this.locationId = locationId;
		this.parent = parent;
		this.phoneNo = phoneNo;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public char getActive() {
		return active;
	}

	public void setActive(char active) {
		this.active = active;
	}

}
