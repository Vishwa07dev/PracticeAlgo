package com.interviewmiles.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.interviewmiles.model.User;

public interface UserRepository extends Repository<User, String> {
	  User save(User user);
	  List<User> findAll();
	  Optional<User> findOne(String id);
	  void delete(User user);
	  Optional<User> findOneByEmail(String email); 
}
