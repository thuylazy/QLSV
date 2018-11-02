/**
 * Copyright(C) K16SE 2014
 *
 * DanTocDao.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.dao;

import java.util.List;

import managestudent.entities.DanToc;

/**
 *
 * @author HaVH
 *
 */
public interface DanTocDao extends BaseDao {
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
	 * Láº¥y tá»•ng sá»‘ báº£n ghi thá»�a mÃ£n Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m
	 *
	 * @param danToc DanToc Ä‘á»‘i tÆ°á»£ng dÃ¢n tá»™c (chÆ°a thÃ´ng tin Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m)
	 * @return int tá»•ng sá»‘ báº£n ghi thá»�a mÃ£n Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m
	 */
	int getTotalRecords(DanToc danToc);
}
