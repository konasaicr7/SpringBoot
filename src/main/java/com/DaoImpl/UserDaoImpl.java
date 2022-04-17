package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.DaoI.UserDaoI;
import com.model.User;
@Repository
public class UserDaoImpl implements UserDaoI {
	@Autowired
SessionFactory sf;
	
	public int saveuser(User u) {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		int id=(Integer) s.save(u);
		return id;
		
		
	}
	public List<User> getuser(String username, String password) {
		// TODO Auto-generated method stub
		
		Session s=sf.openSession();
		Query<User> q=s.createQuery("from User u  where u.username=:u and u.password=:p");
		q.setParameter("u", username);
		q.setParameter("p", password);
		List<User>slis=q.getResultList();
		return slis;
		
		
	}
	public List<User> getusers() {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		Query<User> q=s.createQuery("from User");
		
		List<User>slist1=q.getResultList();
		return slist1;
	}
	public User editdata(int id) {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		Query<User> q=s.createQuery("from User u where u.id=:u");
		q.setParameter("u",id);
		User use=q.getSingleResult();
		return use;
		
	}
	public int deletedata(int id) {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query<User>q=s.createQuery("delete from User u where u.id=:us");
		q.setParameter("us", id);
		int i=q.executeUpdate();
		tx.commit();
		s.close();
		return i;
	}
	public int updatedata(User u) {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query<User>q=s.createQuery("update User u set u.uname=:u1,u.username=:u2,u.password=:u3 ,u.mobile=:u5 where u.id=:u4");
		q.setParameter("u1",u.getUname());
		q.setParameter("u2",u.getUsername());
		q.setParameter("u3",u.getPassword());
		q.setParameter("u5",u.getMobile());
		q.setParameter("u4",u.getId());
		int i=q.executeUpdate();
		tx.commit();
		s.clear();
		s.close();
		return i;
	}
	


}
