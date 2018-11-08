
package managestudent.logics;

import java.util.List;

import managestudent.entities.User;

public interface UserLogics {

	List<User> getAllUsers();

	User getUserById(int userId);

	boolean addUser(User u);

	boolean updateUserById(int userId, User u);

	boolean deleteUserById(int userId);

	boolean existsAccount(String loginId, String password);
}
