/**
 * Copyright(C) K16SE 2014
 *
 * NganhLogics.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.logics;

import java.util.List;

import managestudent.entities.Nganh;

/**
 *
 * @author HaVH
 *
 */
public interface NganhLogics {
	/**
	 * Lấy danh sách tất cả ngành
	 *
	 * @return List<Nganh> Danh sách đối tượng ngành
	 */
	List<Nganh> getAllNganh(Nganh nganh, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Lấy thông tin ngành bằng mã ngành
	 *
	 * @param maNganh String mã ngành
	 * @return Nganh đối tượng ngành
	 */
	Nganh getNganhByMaNganh(String maNganh);

	/**
	 * Lấy thông tin ngành bằng id ngành
	 *
	 * @param nganhId int id ngành
	 * @return Nganh đối tượng ngành
	 */
	Nganh getNganhById(int nganhId);

	/**
	 * Thêm mới ngành
	 *
	 * @param nganh Nganh đối tượng ngành
	 * @return true: thành công / false: thất bại
	 */
	boolean addNganh(Nganh nganh);

	/**
	 * Cập nhật thông tin ngành bằng mã ngành
	 *
	 * @param maNganh String mã ngành
	 * @param nganh Nganh đối tượng ngành
	 * @return true: thành công / false: thất bại
	 */
	boolean updateNganhByMaNganh(String maNganh, Nganh nganh);

	/**
	 * Xóa thông tin ngành bằng mã ngành
	 *
	 * @param maNganh String mã ngành
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteNganhByMaNganh(String maNganh);

	/**
	 * Xóa thông tin ngành bằng id ngành
	 *
	 * @param idNganh int id ngành
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteNganhById(int idNganh);

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
	int getTotalRecords(Nganh nganh);

	/**
	 * Cập nhật thông tin ngành bằng ngành id
	 *
	 * @param nganhId int ngành id
	 * @param nganh Nganh đối tượng ngành
	 * @return true: thành công / false: thất bại
	 */
	boolean updateNganhByID(int nganhId, Nganh nganh);
}
