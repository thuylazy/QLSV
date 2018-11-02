/**
 * Copyright(C) K16SE 2014
 *
 * QuocTichDaoImpl.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import managestudent.dao.QuocTichDao;
import managestudent.entities.QuocTich;

/**
 *
 * @author HaVH
 *
 */
public class QuocTichDaoImpl extends BaseDaoImpl implements QuocTichDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.QuocTichDao#addQuocTich(managestudent.entities.QuocTich)
	 */
	@Override
	public boolean addQuocTich(QuocTich quocTich) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO quoctich ");
				sqlCommand.append("(tenquoctich) ");
				sqlCommand.append("VALUES ");
				sqlCommand.append("(?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, quocTich.getTenQuocTich());
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
	 * @see managestudent.dao.QuocTichDao#deleteQuocTichById(int)
	 */
	@Override
	public boolean deleteQuocTichById(int quocTichId) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM quoctich ");
				sqlCommand.append("WHERE quoctich_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, quocTichId);
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
	 * @see managestudent.dao.QuocTichDao#getAllQuocTich()
	 */
	@Override
	public List<QuocTich> getAllQuocTich(QuocTich quocTich, int offset, int limit, int sortColumn, String sortType) {
		List<QuocTich> lsQuocTich = new ArrayList<QuocTich>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				int conCount = 0;
				int pos = -1;
				int countChar = 0;
				String tmp = "";

				sqlCommand.append("SELECT quoctich_id, tenquoctich ");
				sqlCommand.append("FROM quoctich ");

				if(quocTich.getQuocTichId() > 0) {
					sqlCommand.append("WHERE quoctich_id = ? ");
					conCount++;
				}
				if(quocTich.getTenQuocTich().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("tenquoctich LIKE ? ");
					conCount++;
				}

				sqlCommand.append("ORDER BY ");
				if(sortColumn == 2) {
					sqlCommand.append("tenquoctich ");
				} else {
					sqlCommand.append("quoctich_id ");
				}
				sqlCommand.append(sortType + " ");

				sqlCommand.append("LIMIT " + offset + ", " + limit);

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(sqlCommand.indexOf("quoctich_id = ?") > 0) {
					preparedStatement.setInt(1, quocTich.getQuocTichId());
				}
				if((pos = sqlCommand.indexOf("tenquoctich LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + quocTich.getTenQuocTich() + "%");
				}

				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						QuocTich objQuocTich = new QuocTich(rs.getInt("quoctich_id"), rs.getString("tenquoctich"));

						lsQuocTich.add(objQuocTich);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsQuocTich = null;
			}
			closeConnect();
		}

		return lsQuocTich;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.QuocTichDao#getQuocTichById(int)
	 */
	@Override
	public QuocTich getQuocTichById(int quocTichId) {
		QuocTich quocTich = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT quoctich_id, tenquoctich ");
				sqlCommand.append("FROM quoctich ");
				sqlCommand.append("WHERE quoctich_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, quocTichId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						quocTich = new QuocTich(rs.getInt("quoctich_id"), rs.getString("tenquoctich"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				quocTich = null;
			}
			closeConnect();
		}

		return quocTich;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.QuocTichDao#updateQuocTichById(int, managestudent.entities.QuocTich)
	 */
	@Override
	public boolean updateQuocTichById(int quocTichId, QuocTich quocTich) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE quoctich ");
				sqlCommand.append("SET tenquoctich = ? ");
				sqlCommand.append("WHERE quoctich_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, quocTich.getTenQuocTich());
				preparedStatement.setInt(2, quocTichId);
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
	 * @see managestudent.dao.QuocTichDao#getTotalRecords(managestudent.entities.QuocTich)
	 */
	@Override
	public int getTotalRecords(QuocTich quocTich) {
		int total = 0;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				int conCount = 0;
				int pos = -1;
				int countChar = 0;
				String tmp = "";

				sqlCommand.append("SELECT COUNT(*) count ");
				sqlCommand.append("FROM quoctich ");

				if(quocTich.getQuocTichId() > 0) {
					sqlCommand.append("WHERE quoctich_id = ? ");
					conCount++;
				}
				if(quocTich.getTenQuocTich().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("tenquoctich LIKE ? ");
					conCount++;
				}

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(sqlCommand.indexOf("quoctich_id = ?") > 0) {
					preparedStatement.setInt(1, quocTich.getQuocTichId());
				}
				if((pos = sqlCommand.indexOf("tenquoctich LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + quocTich.getTenQuocTich() + "%");
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
