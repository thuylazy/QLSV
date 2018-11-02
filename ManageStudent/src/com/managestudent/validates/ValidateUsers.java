/**
 * Copyright(C) K16SE 2014
 *
 * ValidateUsers.java, Sep 9, 2014 HaVH
 *
 */
package com.managestudent.validates;

import java.util.ArrayList;
import java.util.List;

import managestudent.logics.impl.UserLogicsImpl;
import managestudent.utils.MessageErrorProperties;

/**
 *
 * @author HaVH
 *
 */
public class ValidateUsers {
	/**
	 * validateLogin
	 *
	 * @param loginId
	 *            String loginId
	 * @param password
	 *            String password
	 * @return List<String> danh sách lỗi
	 */
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
