package eCommerceDemo.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceDemo.business.abstracts.UserCheckService;
import eCommerceDemo.entities.concretes.User;

public class UserCheckManager implements UserCheckService {

	private String regex;
	private Pattern pattern;
	private Matcher matcher;

	@Override
	public boolean userFirstNameCheck(User user) {

		regex = "[a-zA-Z]{2,7}";

		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(user.getFirstName());

		if (!matcher.matches()) {
			System.out.println("Ad en az 2 karakteden oluþmalý!");
			return false;
		}

		return true;
	}

	@Override
	public boolean userLastNameCheck(User user) {
		regex = "[a-zA-Z]{2,7}";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(user.getLastName());

		if (!matcher.matches()) {
			System.out.println("Soyad en az 2 karakteden oluþmalý!");
			return false;
		}
		return true;
	}

	@Override
	public boolean usereMailCheck(User user) {
		regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(user.geteMail());

		if (!matcher.matches()) {
			System.out.println("Gecersiz eMail!");
			return false;
		}
		
		return true;
	}

	@Override
	public boolean userPasswordCheck(User user) {
		if (user.getPassword().length() < 6) {
			System.out.println("Parola en az 7 haneli olmalýdýr!");
			return false;
		}
		return true;
	}

	@Override
	public boolean usereMailContainCheck(User user, List<User> userList) {

		if (userList == null) {

			return true;
		}
		for (User oneOfUsers : userList) {
			if (user.geteMail() == oneOfUsers.geteMail()) {
				System.out.println("Bu mail adresi alýnmýstýr.Lütfen baska bir mail adresi deneyin!");
				return false;
			}

		}

		return true;
	}

}
