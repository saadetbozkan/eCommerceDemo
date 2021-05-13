package eCommerceDemo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class ListUserDao implements UserDao {
	private List<User> listUser = new ArrayList<User>();

	@Override
	public void add(User user) {
		listUser.add(user);
		System.out.println("Kullanýcý eklendi:" + user.getFirstName());
	}

	@Override
	public List<User> getAll(){

		return listUser;
	}

	@Override
	public User getUser(String eMail, String password) {
		if(listUser.isEmpty()) {
			return null;
		}
		for(User user : listUser) {
			if(user.geteMail() == eMail && user.getPassword() == password) {
				return user;
			}
		}
		return null;
	}

}
