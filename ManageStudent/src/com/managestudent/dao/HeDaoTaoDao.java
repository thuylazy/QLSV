/**
 * Copyright(C) K16SE 2014
 *
 * HeDaoTaoDao.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.dao;

import java.util.List;

import managestudent.entities.HeDaoTao;

/**
 *
 * @author HaVH
 *
 */
public interface HeDaoTaoDao extends BaseDao {
	/**
	 * Láº¥y danh sÃ¡ch táº¥t cáº£ há»‡ Ä‘Ã o táº¡o
	 *
	 * @return List<HeDaoTao> Danh sÃ¡ch Ä‘á»‘i tÆ°á»£ng há»‡ Ä‘Ã o táº¡o
	 */
	List<HeDaoTao> getAllHeDaoTao(HeDaoTao hdt, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Láº¥y há»‡ Ä‘Ã o táº¡o báº±ng mÃ£ há»‡
	 *
	 * @param maHeDaoTao String mÃ£ há»‡ Ä‘Ã o táº¡o
	 * @return HeDaoTao Ä‘á»‘i tÆ°á»£ng há»‡ Ä‘Ã o táº¡o
	 */
	HeDaoTao getHeDaoTaoByMaHe(String maHeDaoTao);

	/**
	 * Láº¥y há»‡ Ä‘Ã o táº¡o báº±ng id há»‡
	 *
	 * @param hdtId int id há»‡ Ä‘Ã o táº¡o
	 * @return HeDaoTao Ä‘á»‘i tÆ°á»£ng há»‡ Ä‘Ã o táº¡o
	 */
	HeDaoTao getHeDaoTaoById(int hdtId);

	/**
	 * ThÃªm há»‡ Ä‘Ã o táº¡o
	 *
	 * @param hdt HeDaoTao Ä‘á»‘i tÆ°á»£ng há»‡ Ä‘Ã o táº¡o
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean addHeDaoTao(HeDaoTao hdt);

	/**
	 * Cáº­p nháº­t há»‡ Ä‘Ã o táº¡o báº±ng mÃ£ há»‡
	 *
	 * @param maHeDaoTao String mÃ£ há»‡ Ä‘Ã o táº¡o
	 * @param hdt HeDaoTao Ä‘á»‘i tÆ°á»£ng há»‡ Ä‘Ã o táº¡o
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean updateHeDaoTaoByMaHe(String maHeDaoTao, HeDaoTao hdt);

	/**
	 * Cáº­p nháº­t há»‡ Ä‘Ã o táº¡o báº±ng id há»‡ Ä‘Ã o táº¡o
	 *
	 * @param hdtId id há»‡ Ä‘Ã o táº¡o
	 * @param hdt HeDaoTao Ä‘á»‘i tÆ°á»£ng há»‡ Ä‘Ã o táº¡o
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean updateHeDaoTaoById(int hdtId, HeDaoTao hdt);

	/**
	 * XÃ³a thÃ´ng tin há»‡ Ä‘Ã o táº¡o
	 *
	 * @param maHeDaoTao String mÃ£ há»‡ Ä‘Ã o táº¡o
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean deleteHeDaoTaoByMaHe(String maHeDaoTao);

	/**
	 * XÃ³a thÃ´ng tin há»‡ Ä‘Ã o táº¡o
	 *
	 * @param maHeDaoTao int id há»‡ Ä‘Ã o táº¡o
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean deleteHeDaoTaoById(int idHeDaoTao);

	/**
	 * Láº¥y tá»•ng sá»‘ báº£n ghi thá»�a mÃ£n Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m
	 *
	 * @param hdt HeDaoTao Ä‘á»‘i tÆ°á»£ng há»‡ Ä‘Ã o táº¡o (chá»©a thÃ´ng tin Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m)
	 * @return int tá»•ng sá»‘ báº£n ghi thá»�a mÃ£n Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m
	 */
	int getTotalRecords(HeDaoTao hdt);
}
