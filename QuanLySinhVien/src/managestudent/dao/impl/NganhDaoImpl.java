
package managestudent.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import managestudent.dao.NganhDao;
import managestudent.entities.Nganh;

public class NganhDaoImpl extends BaseDaoImpl implements NganhDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.NganhDao#addNganh(managestudent.entities.Nganh)
	 */
	@Override
	public boolean addNganh(Nganh nganh) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO nganh ");
				sqlCommand.append("(manganh, tennganh, ghichu) ");
				sqlCommand.append("VALUES ");
				sqlCommand.append("(?, ?, ?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, nganh.getMaNganh());
				preparedStatement.setString(2, nganh.getTenNganh());
				preparedStatement.setString(3, nganh.getGhiChu());
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
	 * @see managestudent.dao.NganhDao#deleteNganhByMaNganh(java.lang.String)
	 */
	@Override
	public boolean deleteNganhByMaNganh(String maNganh) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM nganh ");
				sqlCommand.append("WHERE manganh = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, maNganh);
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
	 * @see managestudent.dao.NganhDao#getAllNganh()
	 */
	@Override
	public List<Nganh> getAllNganh(Nganh nganh, int offset, int limit, int sortColumn, String sortType) {
		List<Nganh> lsNganh = new ArrayList<Nganh>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT nganh_id, manganh, tennganh, ghichu ");
				sqlCommand.append("FROM nganh ");

				if(nganh.getMaNganh().trim() != null && nganh.getMaNganh().trim().length() > 0 &&
						nganh.getTenNganh().trim() != null && nganh.getTenNganh().trim().length() > 0) {

					sqlCommand.append("WHERE manganh LIKE ? ");
					sqlCommand.append("AND tennganh LIKE ? ");
				} else if (nganh.getMaNganh().trim() != null && nganh.getMaNganh().trim().length() > 0) {
					sqlCommand.append("WHERE manganh LIKE ? ");
				} else if (nganh.getTenNganh().trim() != null && nganh.getTenNganh().trim().length() > 0) {
					sqlCommand.append("WHERE tennganh LIKE ? ");
				}

				if(sortColumn == 1) {
					sqlCommand.append("ORDER BY manganh ");
					sqlCommand.append(sortType + " ");
				} else if(sortColumn == 2) {
					sqlCommand.append("ORDER BY tennganh ");
					sqlCommand.append(sortType + " ");
				} else {
					sqlCommand.append("ORDER BY manganh ASC ");
				}

				sqlCommand.append("LIMIT " + offset + ", " + limit);

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				int paramCount = preparedStatement.getParameterMetaData().getParameterCount();
				if(paramCount == 2) {
					preparedStatement.setString(1, "%" + nganh.getMaNganh() + "%");
					preparedStatement.setString(2, "%" + nganh.getTenNganh() + "%");
				} else if(paramCount == 1) {
					if(sqlCommand.indexOf("WHERE manganh") > 0) {
						preparedStatement.setString(1, "%" + nganh.getMaNganh() + "%");
					} else {
						preparedStatement.setString(1, "%" + nganh.getTenNganh() + "%");
					}
				}
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						Nganh objNganh = new Nganh(rs.getInt("nganh_id"), rs.getString("manganh"), rs.getString("tennganh"), rs.getString("ghichu"));

						lsNganh.add(objNganh);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsNganh = null;
			}
			closeConnect();
		}

		return lsNganh;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.NganhDao#getNganhByMaNganh(java.lang.String)
	 */
	@Override
	public Nganh getNganhByMaNganh(String maNganh) {
		Nganh nganh = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT nganh_id, manganh, tennganh, ghichu ");
				sqlCommand.append("FROM nganh ");
				sqlCommand.append("WHERE manganh = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, maNganh);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						nganh = new Nganh(rs.getInt("nganh_id"), rs.getString("manganh"), rs.getString("tennganh"), rs.getString("ghichu"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				nganh = null;
			}
			closeConnect();
		}

		return nganh;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.NganhDao#updateNganhByMaNganh(java.lang.String, managestudent.entities.Nganh)
	 */
	@Override
	public boolean updateNganhByMaNganh(String maNganh, Nganh nganh) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE nganh ");
				sqlCommand.append("SET manganh = ?, tennganh = ?, ghichu = ? ");
				sqlCommand.append("WHERE manganh = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, nganh.getMaNganh());
				preparedStatement.setString(2, nganh.getTenNganh());
				preparedStatement.setString(3, nganh.getGhiChu());
				preparedStatement.setString(4, maNganh);
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
	 * @see managestudent.dao.NganhDao#getTotalRecords(managestudent.entities.Nganh, int, int, int, java.lang.String)
	 */
	@Override
	public int getTotalRecords(Nganh nganh) {
		int total = 0;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT COUNT(*) count ");
				sqlCommand.append("FROM nganh ");

				if(nganh.getMaNganh().trim() != null && nganh.getMaNganh().trim().length() > 0 &&
						nganh.getTenNganh().trim() != null && nganh.getTenNganh().trim().length() > 0) {

					sqlCommand.append("WHERE manganh LIKE ? ");
					sqlCommand.append("AND tennganh LIKE ? ");
				} else if (nganh.getMaNganh().trim() != null && nganh.getMaNganh().trim().length() > 0) {
					sqlCommand.append("WHERE manganh LIKE ? ");
				} else if (nganh.getTenNganh().trim() != null && nganh.getTenNganh().trim().length() > 0) {
					sqlCommand.append("WHERE tennganh LIKE ? ");
				}

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				int paramCount = preparedStatement.getParameterMetaData().getParameterCount();
				if(paramCount == 2) {
					preparedStatement.setString(1, "%" + nganh.getMaNganh() + "%");
					preparedStatement.setString(2, "%" + nganh.getTenNganh() + "%");
				} else if(paramCount == 1) {
					if(sqlCommand.indexOf("WHERE manganh") > 0) {
						preparedStatement.setString(1, "%" + nganh.getMaNganh() + "%");
					} else {
						preparedStatement.setString(1, "%" + nganh.getTenNganh() + "%");
					}
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

	/* (non-Javadoc)
	 * @see managestudent.dao.NganhDao#updateNganhByID(int, managestudent.entities.Nganh)
	 */
	@Override
	public boolean updateNganhByID(int nganhId, Nganh nganh) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE nganh ");
				sqlCommand.append("SET manganh = ?, tennganh = ?, ghichu = ? ");
				sqlCommand.append("WHERE nganh_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, nganh.getMaNganh());
				preparedStatement.setString(2, nganh.getTenNganh());
				preparedStatement.setString(3, nganh.getGhiChu());
				preparedStatement.setInt(4, nganhId);
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
	 * @see managestudent.dao.NganhDao#getNganhById(int)
	 */
	@Override
	public Nganh getNganhById(int nganhId) {
		Nganh nganh = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT nganh_id, manganh, tennganh, ghichu ");
				sqlCommand.append("FROM nganh ");
				sqlCommand.append("WHERE nganh_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, nganhId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						nganh = new Nganh(rs.getInt("nganh_id"), rs.getString("manganh"), rs.getString("tennganh"), rs.getString("ghichu"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				nganh = null;
			}
			closeConnect();
		}

		return nganh;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.NganhDao#deleteNganhById(int)
	 */
	@Override
	public boolean deleteNganhById(int idNganh) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM nganh ");
				sqlCommand.append("WHERE nganh_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, idNganh);
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

}
