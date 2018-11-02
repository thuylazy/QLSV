/**
 * Copyright(C) K16SE 2014
 *
 * TonGiaoDao.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.dao;

import java.util.List;

import managestudent.entities.TonGiao;

/**
 *
 * @author HaVH
 *
 */
public interface TonGiaoDao extends BaseDao {
	/**
	 * Láº¥y danh sÃ¡ch táº¥t cáº£ tÃ´n giÃ¡o
	 *
	 * @return List<TonGiao> Danh sÃ¡ch Ä‘á»‘i tÆ°á»£ng tÃ´n giÃ¡o
	 */
	List<TonGiao> getAllTonGiao(TonGiao tonGiao, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Láº¥y thÃ´ng tin tÃ´n giÃ¡o báº±ng id tÃ´n giÃ¡o
	 *
	 * @param tonGiaoId int tÃ´n giÃ¡o id
	 * @return TonGiao Ä‘á»‘i tÆ°á»£ng tÃ´n giÃ¡o
	 */
	TonGiao getTonGiaoById(int tonGiaoId);

	/**
	 * ThÃªm tÃ´n giÃ¡o
	 *
	 * @param tonGiao TonGiao Ä‘á»‘i tÆ°á»£ng tÃ´n giÃ¡o
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean addTonGiao(TonGiao tonGiao);

	/**
	 * Cáº­p nháº­t thÃ´ng tin tÃ´n giÃ¡o
	 *
	 * @param tonGiaoId int tÃ´n giÃ¡o id
	 * @param tonGiao TonGiao Ä‘á»‘i tÆ°á»£ng tÃ´n giÃ¡o
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean updateTonGiaoById(int tonGiaoId, TonGiao tonGiao);

	/**
	 * XÃ³a thÃ´ng tin tÃ´n giÃ¡o báº±ng tÃ´n giÃ¡o id
	 *
	 * @param tonGiaoId int id tÃ´n giÃ¡o
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean deleteTonGiaoById(int tonGiaoId);

	/**
	 * Láº¥y tá»•ng sá»‘ báº£n ghi thá»�a mÃ£n Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m
	 *
	 * @param tonGiao TonGiao Ä‘á»‘i tÆ°á»£ng tÃ´n giÃ¡o (chá»©a thÃ´ng tin Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m)
	 * @return int tá»•ng sá»‘ báº£n ghi thá»�a mÃ£n Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m
	 */
	int getTotalRecords(TonGiao tonGiao);
}
