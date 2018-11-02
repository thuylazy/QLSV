/**
 * Copyright(C) K16SE 2014
 *
 * KhoaHocDao.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.dao;

import java.util.List;

import managestudent.entities.KhoaHoc;

/**
 *
 * @author HaVH
 *
 */
public interface KhoaHocDao extends BaseDao {
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
	 * Láº¥y tá»•ng sá»‘ báº£n ghi thá»�a mÃ£n Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m
	 *
	 * @param khoaHoc KhoaHoc Ä‘á»‘i tÆ°á»£ng khÃ³a há»�c (chá»©a thÃ´ng tin Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m)
	 * @return int tá»•ng sá»‘ báº£n ghi thá»�a mÃ£n Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m
	 */
	int getTotalRecords(KhoaHoc khoaHoc);
}
