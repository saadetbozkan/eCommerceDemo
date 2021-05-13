package eCommerceDemo.business.concretes;

import eCommerceDemo.business.abstracts.ValidatorService;
import eCommerceDemo.core.abstracts.AuthService;
import eCommerceDemo.business.abstracts.UserCheckService;
import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class UserManager implements UserService {
	private UserDao userDao;
	private ValidatorService validatorService;
	private UserCheckService userCheckService;
	private AuthService authService;

	public UserManager(UserDao userDao, ValidatorService validatorService, UserCheckService userCheckService,
			AuthService authService) {
		super();
		this.userDao = userDao;
		this.validatorService = validatorService;
		this.userCheckService = userCheckService;
		this.authService = authService;
	}

	@Override
	public void add(User user) {

		if (userCheckService.userPasswordCheck(user) && userCheckService.usereMailCheck(user)
				&& userCheckService.userFirstNameCheck(user) && userCheckService.userLastNameCheck(user)
				&& userCheckService.usereMailContainCheck(user, userDao.getAll())) {
			validatorService.send(user.geteMail() + " adersini sistemimize kayýt etmek icin onaylayýnýz.");
			if (validatorService.receive()) {
				userDao.add(user);
			}
		}

	}

	@Override
	public void addWithAuth(String eMail) {
		authService.add(eMail);
	}

	@Override
	public void singIn(String eMail, String password) {
		if (userDao.getUser(eMail, password) == null) {
			System.out.println("mail ya da parola hatalý.Lutfen tekrar deneyiniz");
			return;
		}
		System.out.println("Hos geldiniz.");

	}

}
