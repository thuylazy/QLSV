/**
 * Copyright(C) K16SE 2014
 *
 * QuocTichDao.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.dao;

import java.util.List;

import managestudent.entities.QuocTich;

/**
 *
 * @author HaVH
 *
 */
public interface QuocTichDao extends BaseDao {
	/**
	 * Láº¥y danh sÃ¡ch táº¥t cáº£ quá»‘c tá»‹ch
	 *
	 * @return List<QuocTich> Danh sÃ¡ch Ä‘á»‘i tÆ°á»£ng quá»‘c tá»‹ch
	 */
	List<QuocTich> getAllQuocTich(QuocTich quocTich, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Láº¥y thÃ´ng tin quá»‘c tá»‹ch báº±ng id
	 *
	 * @param quocTichId int quá»‘c tá»‹ch id
	 * @return QuocTich Ä‘á»‘i tÆ°á»£ng quá»‘c tá»‹ch
	 */
	QuocTich getQuocTichById(int quocTichId);

	/**
	 * ThÃªm thÃ´ng tin quá»‘c tá»‹ch
	 *
	 * @param quocTich QuocTich Ä‘á»‘i tÆ°á»£ng quá»‘c tá»‹ch
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean addQuocTich(QuocTich quocTich);

	/**
	 * Cáº­p nháº­t thÃ´ng tin quá»‘c tá»‹ch
	 *
	 * @param quocTichId int quá»‘c tá»‹ch id
	 * @param quocTich QuocTich Ä‘á»‘i tÆ°á»£ng quá»‘c tá»‹ch
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean updateQuocTichById(int quocTichId, QuocTich quocTich);

	/**
	 * XÃ³a thÃ´ng tin quá»‘c tá»‹ch
	 *
	 * @param quocTichId int quá»‘c tá»‹ch id
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean deleteQuocTichById(int quocTichId);

	/**
	 * Láº¥y tá»•ng sá»‘ báº£n ghi thá»�a mÃ£n Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m
	 *
	 * @param quocTich QuocTich Ä‘á»‘i tÆ°á»£ng quá»‘c tá»‹ch (chá»©a thÃ´ng tin Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m)
	 * @return int tá»•ng sá»‘ báº£n ghi thá»�a mÃ£n Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m
	 */
	int getTotalRecords(QuocTich quocTich);
}
