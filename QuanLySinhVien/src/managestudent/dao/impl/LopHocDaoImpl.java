
package managestudent.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import managestudent.dao.LopHocDao;
import managestudent.entities.LopHoc;

public class LopHocDaoImpl extends BaseDaoImpl implements LopHocDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.LopHocDao#addLopHoc(managestudent.entities.LopHoc)
	 */
	@Override
	public boolean addLopHoc(LopHoc lopHoc) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO lophoc ");
				sqlCommand.append("(tenlop) ");
				sqlCommand.append("VALUES ");
				sqlCommand.append("(?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, lopHoc.getTenLopHoc());
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
	 * @see managestudent.dao.LopHocDao#deleteLopHocById(int)
	 */
	@Override
	public boolean deleteLopHocById(int lopHocId) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM lophoc ");
				sqlCommand.append("WHERE lop_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, lopHocId);
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
	 * @see managestudent.dao.LopHocDao#getAllLopHoc()
	 */
	@Override
	public List<LopHoc> getAllLopHoc(LopHoc lopHoc, int offset, int limit, int sortColumn, String sortType) {
		List<LopHoc> lsLop = new ArrayList<LopHoc>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				int conCount = 0;
				int pos = -1;
				int countChar = 0;
				String tmp = "";

				sqlCommand.append("SELECT lop_id, tenlop ");
				sqlCommand.append("FROM lophoc ");

				if(lopHoc.getLopHocId() > 0) {
					sqlCommand.append("WHERE lop_id = ? ");
					conCount++;
				}
				if(lopHoc.getTenLopHoc().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("tenlop LIKE ? ");
					conCount++;
				}

				sqlCommand.append("ORDER BY ");
				if(sortColumn == 2) {
					sqlCommand.append("tenlop ");
				} else {
					sqlCommand.append("lop_id ");
				}
				sqlCommand.append(sortType + " ");

				sqlCommand.append("LIMIT " + offset + ", " + limit);

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(sqlCommand.indexOf("lop_id = ?") > 0) {
					preparedStatement.setInt(1, lopHoc.getLopHocId());
				}
				if((pos = sqlCommand.indexOf("tenlop LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + lopHoc.getTenLopHoc() + "%");
				}

				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						LopHoc lop = new LopHoc(rs.getInt("lop_id"), rs.getString("tenlop"));

						lsLop.add(lop);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsLop = null;
			}
			closeConnect();
		}

		return lsLop;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.LopHocDao#getLopHocById(int)
	 */
	@Override
	public LopHoc getLopHocById(int lopHocId) {
		LopHoc lop = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT lop_id, tenlop ");
				sqlCommand.append("FROM lophoc ");
				sqlCommand.append("WHERE lop_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, lopHocId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						lop = new LopHoc(rs.getInt("lop_id"), rs.getString("tenlop"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lop = null;
			}
			closeConnect();
		}

		return lop;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.LopHocDao#updateLopHocById(int, managestudent.entities.LopHoc)
	 */
	@Override
	public boolean updateLopHocById(int lopHocId, LopHoc lopHoc) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE lophoc ");
				sqlCommand.append("SET tenlop = ? ");
				sqlCommand.append("WHERE lop_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, lopHoc.getTenLopHoc());
				preparedStatement.setInt(2, lopHocId);
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
	 * @see managestudent.dao.LopHocDao#getTotalRecords(managestudent.entities.LopHoc)
	 */
	@Override
	public int getTotalRecords(LopHoc lopHoc) {
		int total = 0;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				int conCount = 0;
				int pos = -1;
				int countChar = 0;
				String tmp = "";

				sqlCommand.append("SELECT COUNT(*) count ");
				sqlCommand.append("FROM lophoc ");

				if(lopHoc.getLopHocId() > 0) {
					sqlCommand.append("WHERE lop_id = ? ");
					conCount++;
				}
				if(lopHoc.getTenLopHoc().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("tenlop LIKE ? ");
					conCount++;
				}

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(sqlCommand.indexOf("lop_id = ?") > 0) {
					preparedStatement.setInt(1, lopHoc.getLopHocId());
				}
				if((pos = sqlCommand.indexOf("tenlop LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + lopHoc.getTenLopHoc() + "%");
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
