package com.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DaoI.UserDaoI;
import com.ServiceI.UserServiceI;
import com.model.User;
@Service
public class UserserviceImpl implements UserServiceI  {
	@Autowired
	UserDaoI us;
	public int saveuser(User u) {
		// TODO Auto-generated method stub
		return us.saveuser(u);
	}
	public List<User> getuser(String username, String password) {
		// TODO Auto-generated method stub
		return us.getuser(username,password);
	}
	public List<User> getusers() {
		// TODO Auto-generated method stub
		return us.getusers();
	}
	public User editdata(int id) {
		// TODO Auto-generated method stub
		return us.editdata(id);
	}
	public int deletedata(int id) {
		// TODO Auto-generated method stub
		return us.deletedata(id);
	}
	public int updatedata(User u) {
		// TODO Auto-generated method stub
		return us.updatedata(u);
	}

}
