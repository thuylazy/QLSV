/**
 * Copyright(C) K16SE 2014
 *
 * DanTocDaoImpl.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import managestudent.dao.DanTocDao;
import managestudent.entities.DanToc;

/**
 *
 * @author HaVH
 *
 */
public class DanTocDaoImpl extends BaseDaoImpl implements DanTocDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.DanTocDao#getAllDanToc()
	 */
	@Override
	public List<DanToc> getAllDanToc(DanToc danToc, int offset, int limit, int sortColumn, String sortType) {
		List<DanToc> lsDanToc = new ArrayList<DanToc>();
		int conCount = 0;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT dantoc_id, tendantoc ");
				sqlCommand.append("FROM dantoc ");

				if(danToc.getDanTocId() > 0) {
					sqlCommand.append("WHERE dantoc_id = ? ");
					conCount++;
				}
				if(danToc.getTenDanToc().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("tendantoc LIKE ? ");
					conCount++;
				}

				sqlCommand.append("ORDER BY ");
				if(sortColumn == 2) {
					sqlCommand.append("tendantoc ");
				} else {
					sqlCommand.append("dantoc_id ");
				}
				sqlCommand.append(sortType + " ");

				sqlCommand.append("LIMIT " + offset + ", " + limit);

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(danToc.getDanTocId() > 0) {
					preparedStatement.setInt(1, danToc.getDanTocId());
				}
				if(danToc.getTenDanToc().length() > 0) {
					if(conCount > 1) {
						preparedStatement.setString(2, "%" + danToc.getTenDanToc() + "%");
					} else {
						preparedStatement.setString(1, "%" + danToc.getTenDanToc() + "%");
					}
				}

				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						DanToc dt = new DanToc(rs.getInt("dantoc_id"), rs.getString("tendantoc"));

						lsDanToc.add(dt);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				lsDanToc = null;
			}
			closeConnect();
		}

		return lsDanToc;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DanTocDao#getDanTocById(int)
	 */
	@Override
	public DanToc getDanTocById(int danTocId) {
		DanToc dt = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT dantoc_id, tendantoc ");
				sqlCommand.append("FROM dantoc ");
				sqlCommand.append("WHERE dantoc_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, danTocId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						dt = new DanToc();
						dt.setDanTocId(rs.getInt("dantoc_id"));
						dt.setTenDanToc(rs.getString("tendantoc"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				dt = null;
			}
			closeConnect();
		}

		return dt;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DanTocDao#addDanToc(managestudent.entities.DanToc)
	 */
	@Override
	public boolean addDanToc(DanToc dt) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO dantoc ");
				sqlCommand.append("(tendantoc) ");
				sqlCommand.append("VALUES ");
				sqlCommand.append("(?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, dt.getTenDanToc());
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

	/* (non-Javadoc)
	 * @see managestudent.dao.DanTocDao#deleteDanTocById(int)
	 */
	@Override
	public boolean deleteDanTocById(int danTocId) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM dantoc WHERE ");
				sqlCommand.append("dantoc_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, danTocId);
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

	/* (non-Javadoc)
	 * @see managestudent.dao.DanTocDao#updateDanTocById(managestudent.entities.DanToc)
	 */
	@Override
	public boolean updateDanTocById(int danTocId, DanToc dt) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE dantoc SET ");
				sqlCommand.append("tendantoc = ? ");
				sqlCommand.append("WHERE dantoc_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, dt.getTenDanToc());
				preparedStatement.setInt(2, danTocId);
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

	/* (non-Javadoc)
	 * @see managestudent.dao.DanTocDao#getTotalRecords(managestudent.entities.DanToc)
	 */
	@Override
	public int getTotalRecords(DanToc danToc) {
		int total = 0;
		int conCount = 0;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT COUNT(*) count ");
				sqlCommand.append("FROM dantoc ");

				if(danToc.getDanTocId() > 0) {
					sqlCommand.append("WHERE dantoc_id = ? ");
					conCount++;
				}
				if(danToc.getTenDanToc().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("tendantoc LIKE ? ");
					conCount++;
				}

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(danToc.getDanTocId() > 0) {
					preparedStatement.setInt(1, danToc.getDanTocId());
				}
				if(danToc.getTenDanToc().length() > 0) {
					if(conCount > 1) {
						preparedStatement.setString(2, "%" + danToc.getTenDanToc() + "%");
					} else {
						preparedStatement.setString(1, "%" + danToc.getTenDanToc() + "%");
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
				System.out.println("An exception occur: " + e.getMessage());
				total = 0;
			}
			closeConnect();
		}

		return total;
	}
}
