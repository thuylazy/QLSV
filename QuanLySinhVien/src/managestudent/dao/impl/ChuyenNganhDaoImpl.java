
package managestudent.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import managestudent.dao.ChuyenNganhDao;
import managestudent.entities.ChuyenNganh;

public class ChuyenNganhDaoImpl extends BaseDaoImpl implements ChuyenNganhDao {

	@Override
	public List<ChuyenNganh> getAllChuyenNganh(ChuyenNganh chuyenNganh, int offset, int limit, int sortColumn, String sortType) {
		List<ChuyenNganh> lsChuyenNganh = new ArrayList<ChuyenNganh>();

		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				int conCount = 0;
				int pos = -1;
				int countChar = 0;
				String tmp = "";

				sqlCommand.append("SELECT cn.chuyennganh_id, cn.ma_cn, cn.ten_cn, cn.nganh_id, n.tennganh ");
				sqlCommand.append("FROM chuyennganh cn ");
				sqlCommand.append("INNER JOIN nganh n ");
				sqlCommand.append("ON cn.nganh_id = n.nganh_id ");

				if(chuyenNganh.getMaChuyenNganh().length() > 0) {
					sqlCommand.append("WHERE cn.ma_cn LIKE ? ");
					conCount++;
				}
				if(chuyenNganh.getTenChuyenNganh().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("cn.ten_cn LIKE ? ");
					conCount++;
				}
				if(chuyenNganh.getNganhId() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("cn.nganh_id = ? ");
					conCount++;
				}
				if(chuyenNganh.getTenNganh().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("n.tennganh LIKE ? ");
					conCount++;
				}

				sqlCommand.append("ORDER BY ");

				if (sortColumn == 2) {
					sqlCommand.append("cn.ten_cn ");
				} else if (sortColumn == 3) {
					sqlCommand.append("n.tennganh ");
				} else {
					sqlCommand.append("cn.ma_cn ");
				}
				sqlCommand.append(sortType + " ");

				sqlCommand.append("LIMIT " + offset + ", " + limit);

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(sqlCommand.indexOf("cn.ma_cn LIKE ?") > 0) {
					preparedStatement.setString(1, "%" + chuyenNganh.getMaChuyenNganh() + "%");
				}
				if((pos = sqlCommand.indexOf("cn.ten_cn LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + chuyenNganh.getTenChuyenNganh() + "%");
				}
				if((pos = sqlCommand.indexOf("cn.nganh_id = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, chuyenNganh.getNganhId());
				}
				if((pos = sqlCommand.indexOf("n.tennganh LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + chuyenNganh.getTenNganh() + "%");
				}

				rs = preparedStatement.executeQuery();

				if (rs != null) {
					while (rs.next()) {
						ChuyenNganh cn = new ChuyenNganh(rs.getInt("chuyennganh_id"), rs.getString("ma_cn"),
								rs.getString("ten_cn"), rs.getInt("nganh_id"), rs.getString("tennganh"));

						lsChuyenNganh.add(cn);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				lsChuyenNganh = null;
			}
			closeConnect();
		}

		return lsChuyenNganh;
	}

	@Override
	public ChuyenNganh getChuyenNganhByMaCN(String maChuyenNganh) {
		ChuyenNganh cn = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT chuyennganh_id, ma_cn, ten_cn, nganh_id ");
				sqlCommand.append("FROM chuyennganh ");
				sqlCommand.append("WHERE ma_cn = ? ");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, maChuyenNganh);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						cn = new ChuyenNganh();
						cn.setChuyenNganhId(rs.getInt("chuyennganh_id"));
						cn.setMaChuyenNganh(rs.getString("ma_cn"));
						cn.setTenChuyenNganh(rs.getString("ten_cn"));
						cn.setNganhId(rs.getInt("nganh_id"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				cn = null;
			}
			closeConnect();
		}

		return cn;
	}

	@Override
	public List<ChuyenNganh> getChuyenNganhByNganhId(int nganhId, ChuyenNganh chuyenNganh, int offset, int limit, int sortColumn, String sortType) {
		List<ChuyenNganh> lsChuyenNganh = new ArrayList<ChuyenNganh>();
		int conCount = 0;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT cn.chuyennganh_id, cn.ma_cn, cn.ten_cn, cn.nganh_id, n.tennganh ");
				sqlCommand.append("FROM chuyennganh cn ");
				sqlCommand.append("INNER JOIN nganh n ");
				sqlCommand.append("ON cn.nganh_id = n.nganh_id ");

				if(chuyenNganh.getMaChuyenNganh().length() > 0) {
					sqlCommand.append("WHERE cn.ma_cn LIKE ? ");
					conCount++;
				}
				if(chuyenNganh.getTenChuyenNganh().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("cn.ten_cn LIKE ? ");
				}
				if(conCount > 0) {
					sqlCommand.append("AND ");
				} else {
					sqlCommand.append("WHERE ");
				}
				sqlCommand.append("n.nganh_id = ? ");

				sqlCommand.append("ORDER BY ");

				if (sortColumn == 2) {
					sqlCommand.append("cn.ten_cn ");
				} else {
					sqlCommand.append("cn.ma_cn ");
				}
				sqlCommand.append(sortType + " ");

				sqlCommand.append("LIMIT " + offset + ", " + limit);

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(sqlCommand.indexOf("cn.ma_cn LIKE ") > 0) {
					preparedStatement.setString(1, chuyenNganh.getMaChuyenNganh());
				}
				if(sqlCommand.indexOf("cn.ten_cn LIKE ") > 0) {
					if(conCount > 1) {
						preparedStatement.setString(2, chuyenNganh.getTenChuyenNganh());
					} else {
						preparedStatement.setString(1, chuyenNganh.getTenChuyenNganh());
					}
				}
				if(sqlCommand.indexOf("n.tennganh LIKE ") > 0) {
					if(conCount == 2) {
						preparedStatement.setString(2, chuyenNganh.getTenNganh());
					} else if(conCount == 3) {
						preparedStatement.setString(3, chuyenNganh.getTenNganh());
					} else {
						preparedStatement.setString(1, chuyenNganh.getTenNganh());
					}
				}

				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						ChuyenNganh cn = new ChuyenNganh(
								rs.getInt("chuyennganh_id"),
								rs.getString("ma_cn"),
								rs.getString("ten_cn"),
								rs.getInt("nganh_id"));

						lsChuyenNganh.add(cn);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				lsChuyenNganh = null;
			}
			closeConnect();
		}

		return lsChuyenNganh;
	}


	@Override
	public boolean addChuyenNganh(ChuyenNganh cn) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO chuyennganh ");
				sqlCommand.append("(ma_cn, ten_cn, nganh_id) VALUES ");
				sqlCommand.append("(?, ?, ?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, cn.getMaChuyenNganh());
				preparedStatement.setString(2, cn.getTenChuyenNganh());
				preparedStatement.setInt(3, cn.getNganhId());
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

	@Override
	public boolean deleteChuyenNganhByMaChuyenNganh(String maChuyenNganh) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM chuyennganh ");
				sqlCommand.append("WHERE ma_cn = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, maChuyenNganh);
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

	@Override
	public boolean updateChuyenNganhByMaChuyenNganh(ChuyenNganh cn) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE chuyennganh SET ");
				sqlCommand.append("ten_cn = ?, nganh_id = ? ");
				sqlCommand.append("WHERE ma_cn = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, cn.getTenChuyenNganh());
				preparedStatement.setInt(2, cn.getNganhId());
				preparedStatement.setString(3, cn.getMaChuyenNganh());
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

	@Override
	public ChuyenNganh getChuyenNganhById(int chuyenNganhId) {
		ChuyenNganh cn = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT chuyennganh_id, ma_cn, ten_cn, nganh_id ");
				sqlCommand.append("FROM chuyennganh ");
				sqlCommand.append("WHERE chuyennganh_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, chuyenNganhId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						cn = new ChuyenNganh(rs.getInt("chuyennganh_id"), rs.getString("ma_cn"), rs.getString("ten_cn"), rs.getInt("nganh_id"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				cn = null;
			}
			closeConnect();
		}

		return cn;
	}

	@Override
	public int getTotalRecords(ChuyenNganh chuyenNganh) {
		int total = 0;

		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				int conCount = 0;
				int pos = -1;
				int countChar = 0;
				String tmp = "";

				sqlCommand.append("SELECT COUNT(*) count ");
				sqlCommand.append("FROM chuyennganh cn ");
				sqlCommand.append("INNER JOIN nganh n ");
				sqlCommand.append("ON cn.nganh_id = n.nganh_id ");

				if(chuyenNganh.getMaChuyenNganh().length() > 0) {
					sqlCommand.append("WHERE cn.ma_cn LIKE ? ");
					conCount++;
				}
				if(chuyenNganh.getTenChuyenNganh().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("cn.ten_cn LIKE ? ");
					conCount++;
				}
				if(chuyenNganh.getNganhId() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("cn.nganh_id = ? ");
					conCount++;
				}
				if(chuyenNganh.getTenNganh().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("n.tennganh LIKE ? ");
					conCount++;
				}

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(sqlCommand.indexOf("cn.ma_cn LIKE ?") > 0) {
					preparedStatement.setString(1, "%" + chuyenNganh.getMaChuyenNganh() + "%");
				}
				if((pos = sqlCommand.indexOf("cn.ten_cn LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + chuyenNganh.getTenChuyenNganh() + "%");
				}
				if((pos = sqlCommand.indexOf("cn.nganh_id = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, chuyenNganh.getNganhId());
				}
				if((pos = sqlCommand.indexOf("n.tennganh LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + chuyenNganh.getTenNganh() + "%");
				}

				rs = preparedStatement.executeQuery();

				if (rs != null) {
					while (rs.next()) {
						total = rs.getInt("count");
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				total = 0;
			}
			closeConnect();
		}

		return total;
	}

	@Override
	public boolean updateChuyenNganhById(int chuyenNganhId, ChuyenNganh cn) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE chuyennganh SET ");
				sqlCommand.append("ma_cn = ?, ten_cn = ?, nganh_id = ? ");
				sqlCommand.append("WHERE chuyennganh_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, cn.getMaChuyenNganh());
				preparedStatement.setString(2, cn.getTenChuyenNganh());
				preparedStatement.setInt(3, cn.getNganhId());
				preparedStatement.setInt(4, chuyenNganhId);
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

	@Override
	public boolean deleteChuyenNganhById(int idChuyenNganh) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM chuyennganh ");
				sqlCommand.append("WHERE chuyennganh_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, idChuyenNganh);
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}
}
