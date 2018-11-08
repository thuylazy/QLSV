
package managestudent.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import managestudent.dao.UserDao;
import managestudent.entities.User;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.UserDao#addUser(managestudent.entities.User)
	 */
	@Override
	public boolean addUser(User u) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO `user` ");
				sqlCommand.append("(`username`, `password`, hovaten, diachi, sodienthoai, ngaysinh, socmt) ");
				sqlCommand.append("VALUES(?, ?, ?, ?, ?, ?, ?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, u.getUsername());
				preparedStatement.setString(2, u.getPassword());
				preparedStatement.setString(3, u.getHoVaTen());
				preparedStatement.setString(4, u.getDiaChi());
				preparedStatement.setString(5, u.getSoDienThoai());
				preparedStatement.setDate(6, new Date(u.getNgaySinh().getTime()));
				preparedStatement.setString(7, u.getSoCmt());
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.UserDao#deleteUserById(int)
	 */
	@Override
	public boolean deleteUserById(int userId) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM `user` ");
				sqlCommand.append("WHERE user_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, userId);
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.UserDao#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() {
		List<User> lsUser = new ArrayList<User>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT user_id, `username`, `password`, hovaten, diachi, sodienthoai, ngaysinh, socmt ");
				sqlCommand.append("FROM `user` ");
				sqlCommand.append("ORDER by user_id ASC");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						User u = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"), rs.getString("hovaten"),
								rs.getString("diachi"), rs.getString("sodienthoai"), rs.getDate("ngaysinh"), rs.getString("socmt"));

						lsUser.add(u);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsUser = null;
			}
			closeConnect();
		}

		return lsUser;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.UserDao#getUserById(int)
	 */
	@Override
	public User getUserById(int userId) {
		User u = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT user_id, `username`, `password`, hovaten, diachi, sodienthoai, ngaysinh, socmt ");
				sqlCommand.append("FROM `user` ");
				sqlCommand.append("WHERE user_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, userId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						u = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"), rs.getString("hovaten"),
								rs.getString("diachi"), rs.getString("sodienthoai"), rs.getDate("ngaysinh"), rs.getString("socmt"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				u = null;
			}
			closeConnect();
		}

		return u;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.UserDao#updateUserById(int, managestudent.entities.User)
	 */
	@Override
	public boolean updateUserById(int userId, User u) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE `user` SET ");
				sqlCommand.append("`password` = ?, hovaten = ?, diachi = ?, sodienthoai = ?, ngaysinh = ?, socmt = ? ");
				sqlCommand.append("WHERE user_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, u.getPassword());
				preparedStatement.setString(2, u.getHoVaTen());
				preparedStatement.setString(3, u.getSoDienThoai());
				preparedStatement.setDate(4, new Date(u.getNgaySinh().getTime()));
				preparedStatement.setString(5, u.getSoCmt());
				preparedStatement.setInt(6, u.getUserId());
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.UserDao#existsAccount(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean existsAccount(String loginId, String password) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT COUNT(user_id) ");
				sqlCommand.append("FROM `user` ");
				sqlCommand.append("WHERE `username` = ? ");
				sqlCommand.append("AND `password` = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, loginId);
				preparedStatement.setString(2, password);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						int count = rs.getInt(1);
						if(count > 0) {
							result = true;
						} else {
							result = false;
						}
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

}
