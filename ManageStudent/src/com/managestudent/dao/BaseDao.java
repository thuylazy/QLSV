
package com.managestudent.dao;

import java.util.List;

public interface BaseDao {
	public boolean connectToDB();

	public void closeConnect();

	List<String> getAllColumnName(String tableName);

	int getTotalRecords(String tableName);
}
