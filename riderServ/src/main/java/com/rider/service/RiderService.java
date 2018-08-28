package com.rider.service;

import java.util.List;

import com.rider.model.Rider;

public interface RiderService {

	Rider createRider(Rider rider);
	
	List<Rider> findAllRiders();
}
