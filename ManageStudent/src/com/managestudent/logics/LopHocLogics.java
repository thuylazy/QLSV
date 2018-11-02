/**
 * Copyright(C) K16SE 2014
 *
 * LopHocLogics.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.logics;

import java.util.List;

import managestudent.entities.LopHoc;

/**
 *
 * @author HaVH
 *
 */
public interface LopHocLogics {
	/**
	 * Láº¥y danh sÃ¡ch lá»›p há»�c
	 *
	 * @return List<LopHoc> Danh sÃ¡ch Ä‘á»‘i tÆ°á»£ng lá»›p há»�c
	 */
	List<LopHoc> getAllLopHoc(LopHoc lopHoc, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Láº¥y thÃ´ng tin lá»›p há»�c báº±ng lá»›p há»�c id
	 *
	 * @param lopHocId int lá»›p há»�c id
	 * @return LopHoc Ä‘á»‘i tÆ°á»£ng lá»›p há»�c
	 */
	LopHoc getLopHocById(int lopHocId);

	/**
	 * ThÃªm lá»›p há»�c
	 *
	 * @param lopHoc LopHoc Ä‘á»‘i tÆ°á»£ng lá»›p há»�c
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean addLopHoc(LopHoc lopHoc);

	/**
	 * Cáº­p nháº­t thÃ´ng tin lá»›p há»�c
	 *
	 * @param lopHocId int lá»›p há»�c id
	 * @param lopHoc LopHoc Ä‘á»‘i tÆ°á»£ng lá»›p há»�c
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean updateLopHocById(int lopHocId, LopHoc lopHoc);

	/**
	 * XÃ³a thÃ´ng tin lá»›p há»�c
	 *
	 * @param lopHocId int lá»›p há»�c id
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean deleteLopHocById(int lopHocId);

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
	int getTotalRecords(LopHoc lopHoc);
}
