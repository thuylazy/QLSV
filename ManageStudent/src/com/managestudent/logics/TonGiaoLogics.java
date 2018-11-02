/**
 * Copyright(C) K16SE 2014
 *
 * TonGiaoLogics.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.logics;

import java.util.List;

import managestudent.entities.TonGiao;

/**
 *
 * @author HaVH
 *
 */
public interface TonGiaoLogics {
	/**
	 * Lấy danh sách tất cả tôn giáo
	 *
	 * @return List<TonGiao> Danh sách đối tượng tôn giáo
	 */
	List<TonGiao> getAllTonGiao(TonGiao tonGiao, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Lấy thông tin tôn giáo bằng id tôn giáo
	 *
	 * @param tonGiaoId int tôn giáo id
	 * @return TonGiao đối tượng tôn giáo
	 */
	TonGiao getTonGiaoById(int tonGiaoId);

	/**
	 * Thêm tôn giáo
	 *
	 * @param tonGiao TonGiao đối tượng tôn giáo
	 * @return true: thành công / false: thất bại
	 */
	boolean addTonGiao(TonGiao tonGiao);

	/**
	 * Cập nhật thông tin tôn giáo
	 *
	 * @param tonGiaoId int tôn giáo id
	 * @param tonGiao TonGiao đối tượng tôn giáo
	 * @return true: thành công / false: thất bại
	 */
	boolean updateTonGiaoById(int tonGiaoId, TonGiao tonGiao);

	/**
	 * Xóa thông tin tôn giáo bằng tôn giáo id
	 *
	 * @param tonGiaoId int id tôn giáo
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteTonGiaoById(int tonGiaoId);

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
	int getTotalRecords(TonGiao tonGiao);
}
