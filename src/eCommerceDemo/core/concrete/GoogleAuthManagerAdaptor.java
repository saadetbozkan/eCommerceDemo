package eCommerceDemo.core.concrete;

import eCommerceDemo.core.abstracts.AuthService;
import eCommerceDemo.googleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdaptor implements AuthService {

	@Override
	public void add(String eMail) {
		GoogleAuthManager authManager = new GoogleAuthManager();
		authManager.add(eMail);
	}

}
