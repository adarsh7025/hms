package com.rms.formentity;

/**
 * 
 * @author hegde_a
 *
 */

public class UserForm {

	private int id;
	private String userId;
	private String password;
	private String name;
	private String type;
	private int locationId;
	private int parent;
	private long phoneNo;

	public UserForm() {
		super();
	}

	public UserForm(int id, String userId, String password, String name, String type, int locationId, int parent,
			long phoneNo) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.type = type;
		this.locationId = locationId;
		this.parent = parent;
		this.phoneNo = phoneNo;
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

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "UserForm [id=" + id + ", userId=" + userId + ", password=" + password + ", name=" + name + ", type="
				+ type + ", locationId=" + locationId + ", parent=" + parent + ", phoneNo=" + phoneNo + "]";
	}

}
