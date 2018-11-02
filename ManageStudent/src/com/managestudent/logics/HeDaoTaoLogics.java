/**
 * Copyright(C) K16SE 2014
 *
 * HeDaoTaoLogics.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.logics;

import java.util.List;

import managestudent.entities.HeDaoTao;

/**
 *
 * @author HaVH
 *
 */
public interface HeDaoTaoLogics {
	/**
	 * Lấy danh sách tất cả hệ đào tạo
	 *
	 * @return List<HeDaoTao> Danh sách đối tượng hệ đào tạo
	 */
	List<HeDaoTao> getAllHeDaoTao(HeDaoTao hdt, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Lấy hệ đào tạo bằng mã hệ
	 *
	 * @param maHeDaoTao String mã hệ đào tạo
	 * @return HeDaoTao đối tượng hệ đào tạo
	 */
	HeDaoTao getHeDaoTaoByMaHe(String maHeDaoTao);

	/**
	 * Lấy hệ đào tạo bằng id hệ
	 *
	 * @param hdtId int id hệ đào tạo
	 * @return HeDaoTao đối tượng hệ đào tạo
	 */
	HeDaoTao getHeDaoTaoById(int hdtId);

	/**
	 * Thêm hệ đào tạo
	 *
	 * @param hdt HeDaoTao đối tượng hệ đào tạo
	 * @return true: thành công / false: thất bại
	 */
	boolean addHeDaoTao(HeDaoTao hdt);

	/**
	 * Cập nhật hệ đào tạo bằng mã hệ
	 *
	 * @param maHeDaoTao String mã hệ đào tạo
	 * @param hdt HeDaoTao đối tượng hệ đào tạo
	 * @return true: thành công / false: thất bại
	 */
	boolean updateHeDaoTaoByMaHe(String maHeDaoTao, HeDaoTao hdt);

	/**
	 * Cập nhật hệ đào tạo bằng id hệ đào tạo
	 *
	 * @param hdtId id hệ đào tạo
	 * @param hdt HeDaoTao đối tượng hệ đào tạo
	 * @return true: thành công / false: thất bại
	 */
	boolean updateHeDaoTaoById(int hdtId, HeDaoTao hdt);

	/**
	 * Xóa thông tin hệ đào tạo
	 *
	 * @param maHeDaoTao String mã hệ đào tạo
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteHeDaoTaoByMaHe(String maHeDaoTao);

	/**
	 * Xóa thông tin hệ đào tạo
	 *
	 * @param maHeDaoTao int id hệ đào tạo
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteHeDaoTaoById(int idHeDaoTao);

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
	int getTotalRecords(HeDaoTao hdt);
}
