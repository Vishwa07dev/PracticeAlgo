package com.interviewmiles.service;

import java.util.List;


import com.interviewmiles.model.User;
import com.interviewmiles.model.UserCreateForm;

public interface UserService {
	
	User getUserById(String id);
	
	User getUserByEmail(String email);
	
	List<User> getAllUsers() ;
	
	User create(UserCreateForm form);

}
