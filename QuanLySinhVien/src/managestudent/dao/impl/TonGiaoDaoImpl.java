
package managestudent.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import managestudent.dao.TonGiaoDao;
import managestudent.entities.TonGiao;

public class TonGiaoDaoImpl extends BaseDaoImpl implements TonGiaoDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.TonGiaoDao#addTonGiao(managestudent.entities.TonGiao)
	 */
	@Override
	public boolean addTonGiao(TonGiao tonGiao) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO tongiao ");
				sqlCommand.append("(tentongiao) ");
				sqlCommand.append("VALUES ");
				sqlCommand.append("(?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, tonGiao.getTenTonGiao());
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
	 * @see managestudent.dao.TonGiaoDao#deleteTonGiaoById(int)
	 */
	@Override
	public boolean deleteTonGiaoById(int tonGiaoId) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM tongiao ");
				sqlCommand.append("WHERE tongiao_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, tonGiaoId);
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
	 * @see managestudent.dao.TonGiaoDao#getAllTonGiao()
	 */
	@Override
	public List<TonGiao> getAllTonGiao(TonGiao tonGiao, int offset, int limit, int sortColumn, String sortType) {
		List<TonGiao> lsTonGiao = new ArrayList<TonGiao>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				int conCount = 0;
				int pos = -1;
				int countChar = 0;
				String tmp = "";

				sqlCommand.append("SELECT tongiao_id, tentongiao ");
				sqlCommand.append("FROM tongiao ");

				if(tonGiao.getTonGiaoId() > 0) {
					sqlCommand.append("WHERE tongiao_id = ? ");
					conCount++;
				}
				if(tonGiao.getTenTonGiao().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("tentongiao LIKE ? ");
					conCount++;
				}

				sqlCommand.append("ORDER BY ");
				if(sortColumn == 2) {
					sqlCommand.append("tentongiao ");
				} else {
					sqlCommand.append("tongiao_id ");
				}
				sqlCommand.append(sortType + " ");

				sqlCommand.append("LIMIT " + offset + ", " + limit);

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(sqlCommand.indexOf("tongiao_id = ?") > 0) {
					preparedStatement.setInt(1, tonGiao.getTonGiaoId());
				}
				if((pos = sqlCommand.indexOf("tentongiao LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + tonGiao.getTenTonGiao() + "%");
				}

				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						TonGiao objTonGiao = new TonGiao(rs.getInt("tongiao_id"), rs.getString("tentongiao"));

						lsTonGiao.add(objTonGiao);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsTonGiao = null;
			}
			closeConnect();
		}

		return lsTonGiao;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.TonGiaoDao#getTonGiaoById(int)
	 */
	@Override
	public TonGiao getTonGiaoById(int tonGiaoId) {
		TonGiao tonGiao = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT tongiao_id, tentongiao ");
				sqlCommand.append("FROM tongiao ");
				sqlCommand.append("WHERE tongiao_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, tonGiaoId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						tonGiao = new TonGiao(rs.getInt("tongiao_id"), rs.getString("tentongiao"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				tonGiao = null;
			}
			closeConnect();
		}

		return tonGiao;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.TonGiaoDao#updateTonGiaoById(int, managestudent.entities.TonGiao)
	 */
	@Override
	public boolean updateTonGiaoById(int tonGiaoId, TonGiao tonGiao) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE tongiao ");
				sqlCommand.append("SET tentongiao = ? ");
				sqlCommand.append("WHERE tongiao_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, tonGiao.getTenTonGiao());
				preparedStatement.setInt(2, tonGiaoId);
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
	 * @see managestudent.dao.TonGiaoDao#getTotalRecords(managestudent.entities.TonGiao)
	 */
	@Override
	public int getTotalRecords(TonGiao tonGiao) {
		int total = 0;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				int conCount = 0;
				int pos = -1;
				int countChar = 0;
				String tmp = "";

				sqlCommand.append("SELECT COUNT(*) count ");
				sqlCommand.append("FROM tongiao ");

				if(tonGiao.getTonGiaoId() > 0) {
					sqlCommand.append("WHERE tongiao_id = ? ");
					conCount++;
				}
				if(tonGiao.getTenTonGiao().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("tentongiao LIKE ? ");
					conCount++;
				}

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(sqlCommand.indexOf("tongiao_id = ?") > 0) {
					preparedStatement.setInt(1, tonGiao.getTonGiaoId());
				}
				if((pos = sqlCommand.indexOf("tentongiao LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + tonGiao.getTenTonGiao() + "%");
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
