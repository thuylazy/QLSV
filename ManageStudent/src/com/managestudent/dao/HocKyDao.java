/**
 * Copyright(C) K16SE 2014
 *
 * HocKyDao.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.dao;

import java.util.List;

import managestudent.entities.HocKy;

/**
 *
 * @author HaVH
 *
 */
public interface HocKyDao extends BaseDao {
	/**
	 * Láº¥y danh sÃ¡ch táº¥t cáº£ há»�c ká»³
	 *
	 * @return List<HocKy> Danh sÃ¡ch Ä‘á»‘i tÆ°á»£ng há»�c ká»³
	 */
	List<HocKy> getAllHocKy(HocKy hocKy, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Láº¥y thÃ´ng tin 1 há»�c ká»³ báº±ng há»�c ká»³ id
	 *
	 * @param hocKyId int há»�c ká»³ id
	 * @return HocKy Ä‘á»‘i tÆ°á»£ng há»�c ká»³
	 */
	HocKy getHocKyById(int hocKyId);

	/**
	 * ThÃªm há»�c ká»³
	 *
	 * @param hocKy HocKy Ä‘á»‘i tÆ°á»£ng há»�c ká»³
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean addHocKy(HocKy hocKy);

	/**
	 * Cáº­p nháº­t thÃ´ng tin há»�c ká»³
	 *
	 * @param hocKyId int há»�c ká»³ id
	 * @param hocKy HocKy Ä‘á»‘i tÆ°á»£ng há»�c ká»³
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean updateHocKyById(int hocKyId, HocKy hocKy);

	/**
	 * XÃ³a thÃ´ng tin há»�c ká»³
	 *
	 * @param hocKyId int há»�c ká»³ id
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean deleteHocKyById(int hocKyId);

	/**
	 * Láº¥y tá»•ng sá»‘ báº£n ghi thá»�a mÃ£n Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m
	 *
	 * @param hocKy HocKy Ä‘á»‘i tÆ°á»£ng há»�c ká»³ (chá»©a thÃ´ng tin Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m)
	 * @return int tá»•ng sá»‘ báº£n ghi thá»�a mÃ£n Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m
	 */
	int getTotalRecords(HocKy hocKy);
}
