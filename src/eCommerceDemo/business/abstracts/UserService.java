package eCommerceDemo.business.abstracts;

import eCommerceDemo.entities.concretes.User;

public interface UserService {
	void add(User user);
	void addWithAuth(String eMail);
	void singIn(String eMail, String password);

}
