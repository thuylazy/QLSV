/**
 * Copyright(C) K16SE 2014
 *
 * UserLogics.java, Sep 5, 2014 HaVH
 *
 */
package com.managestudent.logics;

import java.util.List;

import managestudent.entities.User;

/**
 *
 * @author HaVH
 *
 */
public interface UserLogics {
	/**
	 * Lấy danh sách tất cả user
	 *
	 * @return List<User> Danh sách đối tượng user
	 */
	List<User> getAllUsers();

	/**
	 * Lấy thông tin user bằng user id
	 *
	 * @param userId int user id
	 * @return User đối tượng user
	 */
	User getUserById(int userId);

	/**
	 * Thêm user
	 *
	 * @param u User đối tượng user
	 * @return true: thành công / false: thất bại
	 */
	boolean addUser(User u);

	/**
	 * Cập nhật thông tin user
	 *
	 * @param userId int user id
	 * @param u User đối tượng user
	 * @return true: thành công / false: thất bại
	 */
	boolean updateUserById(int userId, User u);

	/**
	 * Xóa thông tin user
	 *
	 * @param userId int user id
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteUserById(int userId);

	/**
	 * Kiểm tra account có tồn tại trong database không
	 *
	 * @param loginId String username
	 * @param password String password
	 * @return true: account tồn tại trong db, false: account không tồn tại
	 */
	boolean existsAccount(String loginId, String password);
}
