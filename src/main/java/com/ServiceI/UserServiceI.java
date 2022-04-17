package com.ServiceI;

import java.util.List;

import com.model.User;

public interface UserServiceI {

	int saveuser(User u);

	List<User> getuser(String username, String password);

	List<User> getusers();

	User editdata(int id);

	int deletedata(int id);

	int updatedata(User u);

}
