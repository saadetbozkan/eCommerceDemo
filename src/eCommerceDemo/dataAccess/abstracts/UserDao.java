package eCommerceDemo.dataAccess.abstracts;

import java.util.List;

import eCommerceDemo.entities.concretes.User;

public interface UserDao {
	void add(User user);
	
	User getUser(String eMail, String password);
	
	List<User> getAll();
}
