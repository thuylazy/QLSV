/**
 * Copyright(C) K16SE 2014
 *
 * DanTocLogics.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.logics;

import java.util.List;

import managestudent.entities.DanToc;

/**
 *
 * @author HaVH
 *
 */
public interface DanTocLogics {
	/**
	 * Láº¥y danh sÃ¡ch táº¥t cáº£ cÃ¡c dÃ¢n tá»™c trong database
	 * @return List<DanToc> Danh sÃ¡ch cÃ¡c dÃ¢n tá»™c
	 */
	List<DanToc> getAllDanToc(DanToc danToc, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Láº¥y 1 dÃ¢n tá»™c báº±ng id dÃ¢n tá»™c
	 * @param danTocId int id dÃ¢n tá»™c
	 * @return DanToc Ä‘á»‘i tÆ°á»£ng dÃ¢n tá»™c
	 */
	DanToc getDanTocById(int danTocId);

	/**
	 * ThÃªm dÃ¢n tá»™c
	 *
	 * @param dt DanToc Ä‘á»‘i tÆ°á»£ng dÃ¢n tá»™c
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean addDanToc(DanToc dt);

	/**
	 * Cáº­p nháº­t thÃ´ng tin dÃ¢n tá»™c
	 *
	 * @param dt DanToc Ä‘á»‘i tÆ°á»£ng dÃ¢n tá»™c (danTocId = Ä‘iá»�u kiá»‡n update)
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean updateDanTocById(int danTocId, DanToc dt);

	/**
	 * XÃ³a dÃ¢n tá»™c
	 *
	 * @param danTocId int dÃ¢n tá»™c id
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean deleteDanTocById(int danTocId);

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
	int getTotalRecords(DanToc danToc);
}
