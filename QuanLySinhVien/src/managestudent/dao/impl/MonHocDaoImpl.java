
package managestudent.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import managestudent.dao.MonHocDao;
import managestudent.entities.MonHoc;

public class MonHocDaoImpl extends BaseDaoImpl implements MonHocDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.MonHocDao#addMonHoc(managestudent.entities.MonHoc)
	 */
	@Override
	public boolean addMonHoc(MonHoc monHoc) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO monhoc ");
				sqlCommand.append("(tenmonhoc, sotrinh, hesochuyencan, hesogiuaky, hesohocky, chuyennganh_id) ");
				sqlCommand.append("VALUES ");
				sqlCommand.append("(?, ?, ?, ?, ?, ?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, monHoc.getTenMonHoc());
				preparedStatement.setString(2, monHoc.getSoTrinh());
				preparedStatement.setFloat(3, monHoc.getHeSoChuyenCan());
				preparedStatement.setFloat(4, monHoc.getHeSoGiuaKy());
				preparedStatement.setFloat(5, monHoc.getHeSoHocKy());
				preparedStatement.setInt(6, monHoc.getChuyenNganhId());
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
	 * @see managestudent.dao.MonHocDao#deleteMonHocById(int)
	 */
	@Override
	public boolean deleteMonHocById(int monHocId) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM monhoc ");
				sqlCommand.append("WHERE monhoc_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, monHocId);
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
	 * @see managestudent.dao.MonHocDao#getAllMonHoc()
	 */
	@Override
	public List<MonHoc> getAllMonHoc(MonHoc monHoc, int offset, int limit, int sortColumn, String sortType) {
		List<MonHoc> lsMonHoc = new ArrayList<MonHoc>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				int conCount = 0;
				int pos = -1;
				int countChar = 0;
				String tmp = "";

				sqlCommand.append("SELECT mh.monhoc_id, mh.tenmonhoc, ");
				sqlCommand.append("mh.chuyennganh_id, cn.ten_cn ");
				sqlCommand.append("FROM monhoc mh ");
				sqlCommand.append("INNER JOIN chuyennganh cn ");
				sqlCommand.append("ON mh.chuyennganh_id = cn.chuyennganh_id ");

				if(monHoc.getMonHocId() > 0) {
					sqlCommand.append("WHERE mh.monhoc_id = ? ");
					conCount++;
				}
				if(monHoc.getTenMonHoc().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("mh.tenmonhoc LIKE ? ");
					conCount++;
				}
				if(monHoc.getChuyenNganhId() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("mh.chuyennganh_id = ? ");
					conCount++;
				}
				if(monHoc.getTenChuyenNganh().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("cn.ten_cn LIKE ? ");
					conCount++;
				}

				sqlCommand.append("ORDER BY ");
				if(sortColumn == 2) {
					sqlCommand.append("mh.tenmonhoc ");
				} else if(sortColumn == 3) {
					sqlCommand.append("cn.ten_cn ");
				} else {
					sqlCommand.append("mh.monhoc_id ");
				}
				sqlCommand.append(sortType + " ");

				sqlCommand.append("LIMIT " + offset + ", " + limit);

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(sqlCommand.indexOf("mh.monhoc_id = ?") > 0) {
					preparedStatement.setInt(1, monHoc.getMonHocId());
				}
				if((pos = sqlCommand.indexOf("mh.tenmonhoc LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + monHoc.getTenMonHoc() + "%");
				}
				if((pos = sqlCommand.indexOf("mh.chuyennganh_id = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, monHoc.getChuyenNganhId());
				}
				if((pos = sqlCommand.indexOf("cn.ten_cn LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + monHoc.getTenChuyenNganh() + "%");
				}

				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						MonHoc objMonHoc = new MonHoc(rs.getInt("monhoc_id"), rs.getString("tenmonhoc"), rs.getInt("chuyennganh_id"),
								rs.getString("ten_cn"));

						lsMonHoc.add(objMonHoc);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsMonHoc = null;
			}
			closeConnect();
		}

		return lsMonHoc;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.MonHocDao#getMonHocByChuyenNganh(int)
	 */
	@Override
	public List<MonHoc> getMonHocByChuyenNganh(int chuyenNganhId, MonHoc monHoc, int offset, int limit, int sortColumn, String sortType) {
		List<MonHoc> lsMonHoc = new ArrayList<MonHoc>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				int conCount = 0;
				int pos = -1;
				int countChar = 0;
				String tmp = "";

				sqlCommand.append("SELECT mh.monhoc_id, mh.tenmonhoc, ");
				sqlCommand.append("mh.chuyennganh_id, cn.ten_cn ");
				sqlCommand.append("FROM monhoc mh ");
				sqlCommand.append("INNER JOIN chuyennganh cn ");
				sqlCommand.append("ON mh.chuyennganh_id = cn.chuyennganh_id ");

				sqlCommand.append("WHERE mh.chuyennganh_id = ? ");
				conCount++;
				if(monHoc.getMonHocId() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("mh.monhoc_id = ? ");
					conCount++;
				}
				if(monHoc.getTenMonHoc().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("mh.tenmonhoc LIKE ? ");
					conCount++;
				}
				if(monHoc.getTenChuyenNganh().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("cn.ten_cn LIKE ? ");
					conCount++;
				}

				sqlCommand.append("ORDER BY ");
				if(sortColumn == 2) {
					sqlCommand.append("mh.tenmonhoc ");
				} else if(sortColumn == 3) {
					sqlCommand.append("cn.ten_cn ");
				} else {
					sqlCommand.append("mh.monhoc_id ");
				}
				sqlCommand.append(sortType + " ");

				sqlCommand.append("LIMIT " + offset + ", " + limit);

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				preparedStatement.setInt(1, chuyenNganhId);
				if(sqlCommand.indexOf("mh.monhoc_id = ?") > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, monHoc.getMonHocId());
				}
				if((pos = sqlCommand.indexOf("mh.tenmonhoc LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + monHoc.getTenMonHoc() + "%");
				}
				if((pos = sqlCommand.indexOf("cn.ten_cn LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + monHoc.getTenChuyenNganh() + "%");
				}

				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						MonHoc objMonHoc = new MonHoc(rs.getInt("monhoc_id"), rs.getString("tenmonhoc"), rs.getInt("chuyennganh_id"),
								rs.getString("ten_cn"));

						lsMonHoc.add(objMonHoc);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsMonHoc = null;
			}
			closeConnect();
		}

		return lsMonHoc;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.MonHocDao#getMonHocById(int)
	 */
	@Override
	public MonHoc getMonHocById(int monHocId) {
		MonHoc monHoc = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT monhoc_id, tenmonhoc, sotrinh, hesochuyencan, hesogiuaky, hesohocky, chuyennganh_id ");
				sqlCommand.append("FROM monhoc ");
				sqlCommand.append("WHERE monhoc_id = ? ");
				sqlCommand.append("ORDER BY monhoc_id ASC");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, monHocId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						monHoc = new MonHoc(rs.getInt("monhoc_id"), rs.getString("tenmonhoc"), rs.getString("sotrinh"), rs.getFloat("hesochuyencan"),
								rs.getFloat("hesogiuaky"), rs.getFloat("hesohocky"), rs.getInt("chuyennganh_id"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				monHoc = null;
			}
			closeConnect();
		}

		return monHoc;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.MonHocDao#updateMonJHocById(int, managestudent.entities.MonHoc)
	 */
	@Override
	public boolean updateMonHocById(int monHocId, MonHoc monHoc) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE monhoc ");
				sqlCommand.append("SET tenmonhoc = ?, sotrinh = ?, hesochuyencan = ?, hesogiuaky = ?, hesohocky = ?, chuyennganh_id = ? ");
				sqlCommand.append("WHERE monhoc_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, monHoc.getTenMonHoc());
				preparedStatement.setString(2, monHoc.getSoTrinh());
				preparedStatement.setFloat(3, monHoc.getHeSoChuyenCan());
				preparedStatement.setFloat(4, monHoc.getHeSoGiuaKy());
				preparedStatement.setFloat(5, monHoc.getHeSoHocKy());
				preparedStatement.setInt(6, monHoc.getChuyenNganhId());
				preparedStatement.setInt(7, monHoc.getMonHocId());
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
	 * @see managestudent.dao.MonHocDao#getTotalRecords(managestudent.entities.MonHoc)
	 */
	@Override
	public int getTotalRecords(MonHoc monHoc) {
		int total = 0;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				int conCount = 0;
				int pos = -1;
				int countChar = 0;
				String tmp = "";

				sqlCommand.append("SELECT COUNT(*) count ");
				sqlCommand.append("FROM monhoc mh ");
				sqlCommand.append("INNER JOIN chuyennganh cn ");
				sqlCommand.append("ON mh.chuyennganh_id = cn.chuyennganh_id ");

				if(monHoc.getMonHocId() > 0) {
					sqlCommand.append("WHERE mh.monhoc_id = ? ");
					conCount++;
				}
				if(monHoc.getTenMonHoc().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("mh.tenmonhoc LIKE ? ");
					conCount++;
				}
				if(monHoc.getChuyenNganhId() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("mh.chuyennganh_id = ? ");
					conCount++;
				}
				if(monHoc.getTenChuyenNganh().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("cn.ten_cn LIKE ? ");
					conCount++;
				}

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(sqlCommand.indexOf("mh.monhoc_id = ?") > 0) {
					preparedStatement.setInt(1, monHoc.getMonHocId());
				}
				if((pos = sqlCommand.indexOf("mh.tenmonhoc LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + monHoc.getTenMonHoc() + "%");
				}
				if((pos = sqlCommand.indexOf("mh.chuyennganh_id = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, monHoc.getChuyenNganhId());
				}
				if((pos = sqlCommand.indexOf("cn.ten_cn LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + monHoc.getTenChuyenNganh() + "%");
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
