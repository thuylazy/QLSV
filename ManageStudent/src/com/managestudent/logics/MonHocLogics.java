/**
 * Copyright(C) K16SE 2014
 *
 * MonHocLogics.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.logics;

import java.util.List;

import managestudent.entities.MonHoc;

/**
 *
 * @author HaVH
 *
 */
public interface MonHocLogics {
	/**
	 * Láº¥y danh sÃ¡ch táº¥t cáº£ mÃ´n há»�c
	 *
	 * @return List<MonHoc> danh sÃ¡ch Ä‘á»‘i tÆ°á»£ng mÃ´n há»�c
	 */
	List<MonHoc> getAllMonHoc(MonHoc monHoc, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Láº¥y thÃ´ng tin mÃ´n há»�c báº±ng id mÃ´n há»�c
	 *
	 * @param monHocId int mÃ´n há»�c id
	 * @return MonHoc Ä‘á»‘i tÆ°á»£ng mÃ´n há»�c
	 */
	MonHoc getMonHocById(int monHocId);

	/**
	 * Láº¥y thÃ´ng tin mÃ´n há»�c báº±ng chuyÃªn ngÃ nh id
	 *
	 * @param chuyenNganhId int chuyÃªn ngÃ nh id
	 * @return List<MonHoc> Danh sÃ¡ch Ä‘á»‘i tÆ°á»£ng mÃ´n há»�c
	 */
	List<MonHoc> getMonHocByChuyenNganh(int chuyenNganhId, MonHoc monHoc, int offset, int limit, int sortColumn, String sortType);

	/**
	 * ThÃªm mÃ´n há»�c
	 *
	 * @param monHoc MonHoc Ä‘á»‘i tÆ°á»£ng mÃ´n há»�c
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean addMonHoc(MonHoc monHoc);

	/**
	 * Cáº­p nháº­t thÃ´ng tin mÃ´n há»�c báº±ng id mÃ´n há»�c
	 *
	 * @param monHocId int id mÃ´n há»�c
	 * @param monHoc MonHoc Ä‘á»‘i tÆ°á»£ng mÃ´n há»�c
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean updateMonHocById(int monHocId, MonHoc monHoc);

	/**
	 * XÃ³a thÃ´ng tin mÃ´n há»�c
	 *
	 * @param monHocId int id mÃ´n há»�c
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean deleteMonHocById(int monHocId);

	/**
	 * Láº¥y danh sÃ¡ch tÃªn cÃ¡c column cÃ³ trong table
	 *
	 * @return List<String> Danh sÃ¡ch tÃªn cÃ¡c column cÃ³ trong table
	 */
	List<String> getAllColumnName();

	/**
	 * Láº¥y toÃ n bá»™ sá»‘ báº£n ghi trong báº£ng
	 *
	 * @return int tá»•ng sá»‘ báº£n ghi
	 */
	int getTotalRecords(MonHoc monHoc);
}
