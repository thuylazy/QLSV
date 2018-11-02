/**
 * Copyright(C) K16SE 2014
 *
 * HocKyLogics.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.logics;

import java.util.List;

import managestudent.entities.HocKy;

/**
 *
 * @author HaVH
 *
 */
public interface HocKyLogics {
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
	int getTotalRecords(HocKy hocKy);
}
