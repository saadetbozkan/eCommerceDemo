package eCommerceDemo.business.concretes;

import eCommerceDemo.business.abstracts.ValidatorService;

public class EmailUserValidatorManager implements ValidatorService {

	@Override
	public void send(String message) {
		System.out.println("eMail Yollandý.");
	}

	@Override
	public boolean receive() {
		System.out.println("eMail onaylandý.");
		return true;
	}

}
