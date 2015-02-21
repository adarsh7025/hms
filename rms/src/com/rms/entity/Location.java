package com.rms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author hegde_a
 *
 */
@Entity
@Table(name = "LOCATION")
public class Location {

	@Id
	@Column(name = "LOCATION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int locationId;

	@Column(name = "CITY")
	private String city;

	@Column(name = "PARENT")
	private String parent;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "TAX")
	private double tax;

	public Location() {
		super();
	}

	public Location(int locationId, String city, String parent, String type, double tax) {
		super();
		this.locationId = locationId;
		this.city = city;
		this.parent = parent;
		this.type = type;
		this.tax = tax;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", city=" + city + ", parent=" + parent + ", type=" + type
				+ ", tax=" + tax + "]";
	}

}
