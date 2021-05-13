package eCommerceDemo;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.business.concretes.EmailUserValidatorManager;
import eCommerceDemo.business.concretes.UserCheckManager;
import eCommerceDemo.business.concretes.UserManager;
import eCommerceDemo.core.concrete.GoogleAuthManagerAdaptor;
import eCommerceDemo.dataAccess.concretes.ListUserDao;
import eCommerceDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new ListUserDao(), new EmailUserValidatorManager(),
				new UserCheckManager(), new GoogleAuthManagerAdaptor());

		userService.add(new User(1, "Saadet", "Bozkan", "saadet@aaww.com", "012300000000"));

		System.out.println("\n***********************************\n");

		userService.add(new User(2, "S", "Bozkan", "saadet1@aaww.com", "012300000000"));

		System.out.println("\n***********************************\n");

		userService.add(new User(3, "Saadet", "B", "saade2t@aaww.com", "012300000000"));

		System.out.println("\n***********************************\n");

		userService.add(new User(4, "Saadet", "Bozkan", "@aaww.com", "012300000000"));

		System.out.println("\n***********************************\n");

		userService.add(new User(5, "Saadet", "Bozkan", "saadet@aaww.com", "012300000000"));

		System.out.println("\n***********************************\n");

		userService.singIn("saadet@aaww.com", "012300000000");

		System.out.println("\n***********************************\n");

		userService.addWithAuth("saadet@aaww.com");

	}

}
