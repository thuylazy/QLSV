/**
 * Copyright(C) K16SE 2014
 *
 * KhoaHocLogics.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.logics;

import java.util.List;

import managestudent.entities.KhoaHoc;

/**
 *
 * @author HaVH
 *
 */
public interface KhoaHocLogics {
	/**
	 * Láº¥y danh sÃ¡ch táº¥t cáº£ khÃ³a há»�c
	 *
	 * @return List<KhoaHoc> Danh sÃ¡ch Ä‘á»‘i tÆ°á»£ng khÃ³a há»�c
	 */
	List<KhoaHoc> getAllKhoaHoc(KhoaHoc khoaHoc, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Láº¥y thÃ´ng tin khÃ³a há»�c báº±ng khÃ³a há»�c id
	 *
	 * @param khoaHocId int khÃ³a há»�c id
	 * @return KhoaHoc Ä‘á»‘i tÆ°á»£ng khÃ³a há»�c
	 */
	KhoaHoc getKhoaHocById(int khoaHocId);

	/**
	 * ThÃªm khÃ³a há»�c
	 *
	 * @param khoaHoc KhoaHoc Ä‘á»‘i tÆ°á»£ng khÃ³a há»�c
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean addKhoaHoc(KhoaHoc khoaHoc);

	/**
	 * Cáº­p nháº­t thÃ´ng tin khÃ³a há»�c
	 *
	 * @param khoaHocId int khÃ³a há»�c id
	 * @param khoaHoc KhoaHoc Ä‘á»‘i tÆ°á»£ng khÃ³a há»�c
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean updateKhoaHocById(int khoaHocId, KhoaHoc khoaHoc);

	/**
	 * XÃ³a thÃ´ng tin khÃ³a há»�c
	 *
	 * @param khoaHocId int khÃ³a há»�c id
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean deleteKhoaHocById(int khoaHocId);

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
	int getTotalRecords(KhoaHoc khoaHoc);
}
