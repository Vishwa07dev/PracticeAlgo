package com.rider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rider.model.Rider;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long>{

}