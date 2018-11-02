/**
 * Copyright(C) K16SE 2014
 *
 * NganhDao.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.dao;

import java.util.List;

import managestudent.entities.Nganh;

/**
 *
 * @author HaVH
 *
 */
public interface NganhDao extends BaseDao {
	/**
	 * Láº¥y danh sÃ¡ch táº¥t cáº£ ngÃ nh
	 *
	 * @param nganh Nganh Ä‘á»‘i tÆ°á»£ng ngÃ nh (chá»©a Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m)
	 * @param offset int vá»‹ trÃ­ báº£n ghi Ä‘áº§u tiÃªn
	 * @param limit int sá»‘ báº£n ghi tá»‘i Ä‘a cáº§n láº¥y
	 * @param sortColumn int vá»‹ trÃ­ cá»™t cáº§n sáº¯p xáº¿p
	 * @param sortType String kiá»ƒu sáº¯p xáº¿p (ASC / DESC)
	 * @return List<Nganh> Danh sÃ¡ch Ä‘á»‘i tÆ°á»£ng ngÃ nh
	 */
	List<Nganh> getAllNganh(Nganh nganh, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Láº¥y thÃ´ng tin ngÃ nh báº±ng mÃ£ ngÃ nh
	 *
	 * @param maNganh String mÃ£ ngÃ nh
	 * @return Nganh Ä‘á»‘i tÆ°á»£ng ngÃ nh
	 */
	Nganh getNganhByMaNganh(String maNganh);

	/**
	 * Láº¥y thÃ´ng tin ngÃ nh báº±ng id ngÃ nh
	 *
	 * @param nganhId int id ngÃ nh
	 * @return Nganh Ä‘á»‘i tÆ°á»£ng ngÃ nh
	 */
	Nganh getNganhById(int nganhId);

	/**
	 * ThÃªm má»›i ngÃ nh
	 *
	 * @param nganh Nganh Ä‘á»‘i tÆ°á»£ng ngÃ nh
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean addNganh(Nganh nganh);

	/**
	 * Cáº­p nháº­t thÃ´ng tin ngÃ nh báº±ng mÃ£ ngÃ nh
	 *
	 * @param maNganh String mÃ£ ngÃ nh
	 * @param nganh Nganh Ä‘á»‘i tÆ°á»£ng ngÃ nh
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean updateNganhByMaNganh(String maNganh, Nganh nganh);

	/**
	 * Cáº­p nháº­t thÃ´ng tin ngÃ nh báº±ng ngÃ nh id
	 *
	 * @param nganhId int ngÃ nh id
	 * @param nganh Nganh Ä‘á»‘i tÆ°á»£ng ngÃ nh
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean updateNganhByID(int nganhId, Nganh nganh);

	/**
	 * XÃ³a thÃ´ng tin ngÃ nh báº±ng mÃ£ ngÃ nh
	 *
	 * @param maNganh String mÃ£ ngÃ nh
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean deleteNganhByMaNganh(String maNganh);

	/**
	 * XÃ³a thÃ´ng tin ngÃ nh báº±ng id ngÃ nh
	 *
	 * @param idNganh int id ngÃ nh
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean deleteNganhById(int idNganh);

	/**
	 * Láº¥y tá»•ng sá»‘ báº£n ghi thá»�a mÃ£n Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m
	 *
	 * @param nganh Nganh Ä‘á»‘i tÆ°á»£ng ngÃ nh (chá»©a Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m)
	 * @return int tá»•ng sá»‘ báº£n ghi thá»�a mÃ£n Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m
	 */
	int getTotalRecords(Nganh nganh);
}
