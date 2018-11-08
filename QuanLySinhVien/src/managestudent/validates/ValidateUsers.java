
package managestudent.validates;

import java.util.ArrayList;
import java.util.List;

import managestudent.logics.impl.UserLogicsImpl;
import managestudent.utils.MessageErrorProperties;

public class ValidateUsers {

	public static List<String> validateLogin(String loginId, String password) {
		List<String> lsErrorMess = new ArrayList<String>();

		if (loginId.trim().length() == 0) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_001_user"));
		}

		if (password.length() == 0) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_001_pass"));
		}

		UserLogicsImpl userLogic = new UserLogicsImpl();
		if (loginId.trim().length() != 0 && password.length() != 0) {
			if (!userLogic.existsAccount(loginId, password)) {
				lsErrorMess.add(MessageErrorProperties.getMessage("error_016"));
			}
		}

		return lsErrorMess;
	}
}
