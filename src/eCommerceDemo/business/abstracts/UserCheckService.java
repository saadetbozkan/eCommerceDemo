package eCommerceDemo.business.abstracts;

import java.util.List;

import eCommerceDemo.entities.concretes.User;

public interface UserCheckService {
	boolean userFirstNameCheck(User user);
	boolean userLastNameCheck(User user);
	boolean usereMailCheck(User user);
	boolean userPasswordCheck(User user);
	boolean usereMailContainCheck(User user, List<User> userList);

	
}
