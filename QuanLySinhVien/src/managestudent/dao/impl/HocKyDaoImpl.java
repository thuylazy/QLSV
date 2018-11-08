
package managestudent.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import managestudent.dao.HocKyDao;
import managestudent.entities.HocKy;

public class HocKyDaoImpl extends BaseDaoImpl implements HocKyDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.HocKyDao#addHocKy(managestudent.entities.HocKy)
	 */
	@Override
	public boolean addHocKy(HocKy hocKy) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO hocky ");
				sqlCommand.append("(tenhocky) ");
				sqlCommand.append("VALUES ");
				sqlCommand.append("(?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, hocKy.getTenHocKy());
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
	 * @see managestudent.dao.HocKyDao#deleteHocKyById(int)
	 */
	@Override
	public boolean deleteHocKyById(int hocKyId) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM hocky ");
				sqlCommand.append("WHERE hocky_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, hocKyId);
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
	 * @see managestudent.dao.HocKyDao#getAllHocKy()
	 */
	@Override
	public List<HocKy> getAllHocKy(HocKy hocKy, int offset, int limit, int sortColumn, String sortType) {
		List<HocKy> lsHocKy = new ArrayList<HocKy>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				int conCount = 0;
				int pos = -1;
				int countChar = 0;
				String tmp = "";

				sqlCommand.append("SELECT hocky_id, tenhocky ");
				sqlCommand.append("FROM hocky ");

				if(hocKy.getHocKyId() > 0) {
					sqlCommand.append("WHERE hocky_id = ? ");
					conCount++;
				}
				if(hocKy.getTenHocKy().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("tenhocky LIKE ? ");
					conCount++;
				}

				sqlCommand.append("ORDER BY ");
				if(sortColumn == 2) {
					sqlCommand.append("tenhocky ");
				} else {
					sqlCommand.append("hocky_id ");
				}
				sqlCommand.append(sortType + " ");

				sqlCommand.append("LIMIT " + offset + ", " + limit);

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(sqlCommand.indexOf("hocky_id = ?") > 0) {
					preparedStatement.setInt(1, hocKy.getHocKyId());
				}
				if((pos = sqlCommand.indexOf("tenhocky LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + hocKy.getTenHocKy() + "%");
				}

				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						HocKy objHocKy = new HocKy(rs.getInt("hocky_id"), rs.getString("tenhocky"));

						lsHocKy.add(objHocKy);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsHocKy = null;
			}
			closeConnect();
		}

		return lsHocKy;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.HocKyDao#getHocKyById(int)
	 */
	@Override
	public HocKy getHocKyById(int hocKyId) {
		HocKy hocKy = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT hocky_id, tenhocky ");
				sqlCommand.append("FROM hocky ");
				sqlCommand.append("WHERE hocky_id = ? ");
				sqlCommand.append("ORDER BY hocky_id");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, hocKyId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						hocKy = new HocKy(rs.getInt("hocKy_id"), rs.getString("tenhocky"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				hocKy = null;
			}
			closeConnect();
		}

		return hocKy;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.HocKyDao#updateHocKyById(int, managestudent.entities.HocKy)
	 */
	@Override
	public boolean updateHocKyById(int hocKyId, HocKy hocKy) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE hocky ");
				sqlCommand.append("SET tenhocky = ? ");
				sqlCommand.append("WHERE hocky_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, hocKy.getTenHocKy());
				preparedStatement.setInt(2, hocKyId);
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
	 * @see managestudent.dao.HocKyDao#getTotalRecords(managestudent.entities.HocKy)
	 */
	@Override
	public int getTotalRecords(HocKy hocKy) {
		int total = 0;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				int conCount = 0;
				int pos = -1;
				int countChar = 0;
				String tmp = "";

				sqlCommand.append("SELECT COUNT(*) count ");
				sqlCommand.append("FROM hocky ");

				if(hocKy.getHocKyId() > 0) {
					sqlCommand.append("WHERE hocky_id = ? ");
					conCount++;
				}
				if(hocKy.getTenHocKy().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("tenhocky LIKE ? ");
					conCount++;
				}

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(sqlCommand.indexOf("hocky_id = ?") > 0) {
					preparedStatement.setInt(1, hocKy.getHocKyId());
				}
				if((pos = sqlCommand.indexOf("tenhocky LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + hocKy.getTenHocKy() + "%");
				}

				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						total = rs.getInt("count");
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				total = 0;
			}
			closeConnect();
		}

		return total;
	}

}
