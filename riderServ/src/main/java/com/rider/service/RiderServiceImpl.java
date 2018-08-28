package com.rider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rider.model.Rider;
import com.rider.repository.RiderRepository;

@Service
public class RiderServiceImpl implements RiderService{

	private final RiderRepository riderRepository ;
	
	@Autowired
	public RiderServiceImpl(RiderRepository riderRepository){
		this.riderRepository = riderRepository ;
	}
	
	public Rider createRider(Rider rider) {
		Rider createdRider = riderRepository.save(rider);
		return createdRider;
	}

	public List<Rider> findAllRiders() {
		return riderRepository.findAll();
	}

}
