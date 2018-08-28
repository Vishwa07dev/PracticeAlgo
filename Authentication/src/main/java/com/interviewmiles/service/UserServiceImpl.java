package com.interviewmiles.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.interviewmiles.exception.UserNotFoundExceptionByEmail;
import com.interviewmiles.exception.UserNotFoundExceptionByID;
import com.interviewmiles.model.User;
import com.interviewmiles.model.UserCreateForm;
import com.interviewmiles.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	final private UserRepository userRepository ;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepositor){
		this.userRepository = userRepositor ;
	}
	public User getUserById(String id) {
		Optional<User> user =  userRepository.findOne(id);
		return user.orElseThrow(() -> new UserNotFoundExceptionByID(id));
	}

	public User getUserByEmail(String email) {
		Optional<User> user =  userRepository.findOneByEmail(email);
		return user.orElseThrow(() -> new UserNotFoundExceptionByEmail(email));
	}

	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

	public User create(UserCreateForm form) {
		User user = new User();
		user.setEmail(form.getEmail());
		user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
		return userRepository.save(user);
	}

}
