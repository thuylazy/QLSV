/**
 * Copyright(C) K16SE 2014
 *
 * HeDaoTaoDaoImpl.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import managestudent.dao.HeDaoTaoDao;
import managestudent.entities.HeDaoTao;

/**
 *
 * @author HaVH
 *
 */
public class HeDaoTaoDaoImpl extends BaseDaoImpl implements HeDaoTaoDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.HeDaoTaoDao#addHeDaoTao(managestudent.entities.HeDaoTao)
	 */
	@Override
	public boolean addHeDaoTao(HeDaoTao hdt) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO hedaotao ");
				sqlCommand.append("(mahedt, ten_hedt) ");
				sqlCommand.append("VALUES ");
				sqlCommand.append("(?, ?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, hdt.getMaHeDt());
				preparedStatement.setString(2, hdt.getTenHeDt());
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
	 * @see managestudent.dao.HeDaoTaoDao#deleteHeDaoTaoByMaHe(java.lang.String)
	 */
	@Override
	public boolean deleteHeDaoTaoByMaHe(String maHeDaoTao) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM hedaotao ");
				sqlCommand.append("WHERE mahedt = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, maHeDaoTao);
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
	 * @see managestudent.dao.HeDaoTaoDao#getAllHeDaoTao()
	 */
	@Override
	public List<HeDaoTao> getAllHeDaoTao(HeDaoTao hdt, int offset, int limit, int sortColumn, String sortType) {
		List<HeDaoTao> lsHdt = new ArrayList<HeDaoTao>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				int conCount = 0;
				int pos = -1;
				int countChar = 0;
				String tmp = "";

				sqlCommand.append("SELECT hedt_id, mahedt, ten_hedt ");
				sqlCommand.append("FROM hedaotao ");

				if(hdt.getMaHeDt().length() > 0) {
					sqlCommand.append("WHERE mahedt LIKE ? ");
					conCount++;
				}
				if(hdt.getTenHeDt().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("ten_hedt LIKE ? ");
					conCount++;
				}

				sqlCommand.append("ORDER BY ");

				if(sortColumn == 2) {
					sqlCommand.append("ten_hdt ");
				} else {
					sqlCommand.append("mahedt ");
				}
				sqlCommand.append(sortType + " ");

				sqlCommand.append("LIMIT " + offset + ", " + limit);

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(sqlCommand.indexOf("mahedt LIKE ?") > 0) {
					preparedStatement.setString(1, "%" + hdt.getMaHeDt() + "%");
				}
				if((pos = sqlCommand.indexOf("ten_hedt LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + hdt.getTenHeDt() + "%");
				}

				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						HeDaoTao objHdt = new HeDaoTao(rs.getInt("hedt_id"), rs.getString("mahedt"), rs.getString("ten_hedt"));

						lsHdt.add(objHdt);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsHdt = null;
			}
			closeConnect();
		}

		return lsHdt;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.HeDaoTaoDao#getHeDaoTaoByMaHe(java.lang.String)
	 */
	@Override
	public HeDaoTao getHeDaoTaoByMaHe(String maHeDaoTao) {
		HeDaoTao hdt = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT hedt_id, mahedt, ten_hedt ");
				sqlCommand.append("FROM hedaotao ");
				sqlCommand.append("WHERE mahedt = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, maHeDaoTao);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						hdt = new HeDaoTao(rs.getInt("hedt_id"), rs.getString("mahedt"), rs.getString("ten_hedt"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				hdt = null;
			}
			closeConnect();
		}

		return hdt;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.HeDaoTaoDao#updateHeDaoTaoByMaHe(java.lang.String, managestudent.entities.HeDaoTao)
	 */
	@Override
	public boolean updateHeDaoTaoByMaHe(String maHeDaoTao, HeDaoTao hdt) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE hedaotao ");
				sqlCommand.append("SET mahedt = ?, ten_hedt = ? ");
				sqlCommand.append("WHERE mahedt = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, hdt.getMaHeDt());
				preparedStatement.setString(2, hdt.getTenHeDt());
				preparedStatement.setString(3, maHeDaoTao);
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
	 * @see managestudent.dao.HeDaoTaoDao#getTotalRecords(managestudent.entities.HeDaoTao)
	 */
	@Override
	public int getTotalRecords(HeDaoTao hdt) {
		int total = 0;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				int conCount = 0;
				int pos = -1;
				int countChar = 0;
				String tmp = "";

				sqlCommand.append("SELECT COUNT(*) count ");
				sqlCommand.append("FROM hedaotao ");

				if(hdt.getMaHeDt().length() > 0) {
					sqlCommand.append("WHERE mahedt LIKE ? ");
					conCount++;
				}
				if(hdt.getTenHeDt().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("ten_hedt LIKE ? ");
					conCount++;
				}

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(sqlCommand.indexOf("mahedt LIKE ?") > 0) {
					preparedStatement.setString(1, "%" + hdt.getMaHeDt() + "%");
				}
				if((pos = sqlCommand.indexOf("ten_hedt LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + hdt.getTenHeDt() + "%");
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
	 * @see managestudent.dao.HeDaoTaoDao#updateHeDaoTaoById(int, managestudent.entities.HeDaoTao)
	 */
	@Override
	public boolean updateHeDaoTaoById(int hdtId, HeDaoTao hdt) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE hedaotao ");
				sqlCommand.append("SET mahedt = ?, ten_hedt = ? ");
				sqlCommand.append("WHERE hedt_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, hdt.getMaHeDt());
				preparedStatement.setString(2, hdt.getTenHeDt());
				preparedStatement.setInt(3, hdtId);
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
	 * @see managestudent.dao.HeDaoTaoDao#getHeDaoTaoById(int)
	 */
	@Override
	public HeDaoTao getHeDaoTaoById(int hdtId) {
		HeDaoTao hdt = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT hedt_id, mahedt, ten_hedt ");
				sqlCommand.append("FROM hedaotao ");
				sqlCommand.append("WHERE hedt_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, hdtId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						hdt = new HeDaoTao(rs.getInt("hedt_id"), rs.getString("mahedt"), rs.getString("ten_hedt"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				hdt = null;
			}
			closeConnect();
		}

		return hdt;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.HeDaoTaoDao#deleteHeDaoTaoById(int)
	 */
	@Override
	public boolean deleteHeDaoTaoById(int idHeDaoTao) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM hedaotao ");
				sqlCommand.append("WHERE hedt_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, idHeDaoTao);
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
