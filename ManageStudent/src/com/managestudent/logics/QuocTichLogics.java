/**
 * Copyright(C) K16SE 2014
 *
 * QuocTichLogics.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.logics;

import java.util.List;

import managestudent.entities.QuocTich;

/**
 *
 * @author HaVH
 *
 */
public interface QuocTichLogics {
	/**
	 * Lấy danh sách tất cả quốc tịch
	 *
	 * @return List<QuocTich> Danh sách đối tượng quốc tịch
	 */
	List<QuocTich> getAllQuocTich(QuocTich quocTich, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Lấy thông tin quốc tịch bằng id
	 *
	 * @param quocTichId int quốc tịch id
	 * @return QuocTich đối tượng quốc tịch
	 */
	QuocTich getQuocTichById(int quocTichId);

	/**
	 * Thêm thông tin quốc tịch
	 *
	 * @param quocTich QuocTich đối tượng quốc tịch
	 * @return true: thành công / false: thất bại
	 */
	boolean addQuocTich(QuocTich quocTich);

	/**
	 * Cập nhật thông tin quốc tịch
	 *
	 * @param quocTichId int quốc tịch id
	 * @param quocTich QuocTich đối tượng quốc tịch
	 * @return true: thành công / false: thất bại
	 */
	boolean updateQuocTichById(int quocTichId, QuocTich quocTich);

	/**
	 * Xóa thông tin quốc tịch
	 *
	 * @param quocTichId int quốc tịch id
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteQuocTichById(int quocTichId);

	/**
	 * Lấy danh sách tên các column có trong table
	 *
	 * @return List<String> Danh sách tên các column có trong table
	 */
	List<String> getAllColumnName();

	/**
	 * Lấy toàn bộ số bản ghi trong bảng
	 *
	 * @return int tổng số bản ghi
	 */
	int getTotalRecords(QuocTich quocTich);
}
