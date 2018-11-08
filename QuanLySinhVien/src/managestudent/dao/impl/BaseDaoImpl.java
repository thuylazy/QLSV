
package managestudent.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import managestudent.utils.DatabaseProperties;
import managestudent.dao.BaseDao;

public class BaseDaoImpl implements BaseDao {
	protected Connection connection = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet rs = null;

	@Override
	public boolean connectToDB() {
		boolean result = true;

        try {
			// load mysql driver
			Class.forName(DatabaseProperties.getData("driver"));
			connection = DriverManager.getConnection(DatabaseProperties
					.getData("url"), DatabaseProperties.getData("user"),
					DatabaseProperties.getData("password"));
		} catch (Exception e) {
			System.out.println("an exception occur: " + e.getMessage());
			result = false;
		}
        return result;
	}

	@Override
	public void closeConnect() {
		if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("an exception occur: " + e.getMessage());
            }
            connection = null;
        }
	}

	@Override
	public List<String> getAllColumnName(String tableName) {
		List<String> lsColumn = new ArrayList<String>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT COLUMN_NAME ");
				sqlCommand.append("FROM INFORMATION_SCHEMA.COLUMNS ");
				sqlCommand.append("WHERE table_name = ? ");
				sqlCommand.append("ORDER BY COLUMN_NAME ASC");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, tableName);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						lsColumn.add(rs.getString("COLUMN_NAME"));
					}
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				lsColumn = null;
			}
			closeConnect();
		}

		return lsColumn;
	}

	@Override
	public int getTotalRecords(String tableName) {
		int total = -1;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT COUNT(*) count ");
				sqlCommand.append("FROM " + tableName);

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						total = rs.getInt("count");
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				total = -1;
			}
			closeConnect();
		}

		return total;
	}

}
