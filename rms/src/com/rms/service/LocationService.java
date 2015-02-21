package com.rms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rms.dao.LocationDAO;

/**
 * 
 * @author hegde_a
 *
 */
public class LocationService {

	private final Logger logger = LoggerFactory.getLogger(BillingService.class);
	
	public double getTaxForLocation(int locationId) {
		logger.info("service to retrieve tax percentage for location");
		
		LocationDAO locationDAO = new LocationDAO();
		double tax = locationDAO.getTaxForLocation(locationId);
		return tax;
	}
}
