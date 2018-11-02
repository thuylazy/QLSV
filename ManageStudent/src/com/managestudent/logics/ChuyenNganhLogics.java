/**
 * Copyright(C) K16SE 2014
 *
 * ChuyenNganhLogics.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.logics;

import java.util.List;

import managestudent.entities.ChuyenNganh;

/**
 *
 * @author HaVH
 *
 */
public interface ChuyenNganhLogics {
	/**
	 * Láº¥y danh sÃ¡ch táº¥t cáº£ chuyÃªn ngÃ nh trong database
	 * @return List<ChuyenNganh> Danh sÃ¡ch cÃ¡c chuyÃªn ngÃ nh
	 */
	List<ChuyenNganh> getAllChuyenNganh(ChuyenNganh chuyenNganh, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Láº¥y 1 chuyÃªn ngÃ nh báº±ng mÃ£ chuyÃªn ngÃ nh
	 * @param maChuyenNganh String mÃ£ chuyÃªn ngÃ nh
	 * @return ChuyenNganh Ä‘á»‘i tÆ°á»£ng chuyÃªn ngÃ nh
	 */
	ChuyenNganh getChuyenNganhByMaCN(String maChuyenNganh);

	/**
	 * Láº¥y ra danh sÃ¡ch cÃ¡c chuyÃªn ngÃ nh dá»±a trÃªn mÃ£ ngÃ nh
	 * @param nganhId int Id ngÃ nh
	 * @return List<ChuyenNganh> Danh sÃ¡ch cÃ¡c chuyÃªn ngÃ nh thuá»™c ngÃ nh id
	 */
	List<ChuyenNganh> getChuyenNganhByNganhId(int nganhId, ChuyenNganh chuyenNganh, int offset, int limit, int sortColumn, String sortType);

	/**
	 * ThÃªm chuyÃªn ngÃ nh
	 *
	 * @param cn ChuyenNganh Ä‘á»‘i tÆ°á»£ng chuyÃªn ngÃ nh (chuyenNganhId = -1)
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean addChuyenNganh(ChuyenNganh cn);

	/**
	 * Cáº­p nháº­t chuyÃªn ngÃ nh báº±ng mÃ£ chuyÃªn ngÃ nh
	 *
	 * @param cn ChuyenNganh Ä‘á»‘i tÆ°á»£ng chuyÃªn ngÃ nh (maChuyenNganh: Ä‘iá»�u kiá»‡n update)
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean updateChuyenNganhByMaChuyenNganh(ChuyenNganh cn);

	/**
	 * Cáº­p nháº­t chuyÃªn ngÃ nh báº±ng id chuyÃªn ngÃ nh
	 *
	 * @param cn ChuyenNganh Ä‘á»‘i tÆ°á»£ng chuyÃªn ngÃ nh (maChuyenNganh: Ä‘iá»�u kiá»‡n update)
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean updateChuyenNganhById(int chuyenNganhId, ChuyenNganh cn);

	/**
	 * XÃ³a chuyÃªn ngÃ nh báº±ng mÃ£ chuyÃªn ngÃ nh
	 *
	 * @param maChuyenNganh String mÃ£ chuyÃªn ngÃ nh
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean deleteChuyenNganhByMaChuyenNganh(String maChuyenNganh);

	/**
	 * XÃ³a chuyÃªn ngÃ nh báº±ng id chuyÃªn ngÃ nh
	 *
	 * @param idChuyenNganh int id chuyÃªn ngÃ nh
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean deleteChuyenNganhById(int idChuyenNganh);

	/**
	 * Láº¥y danh sÃ¡ch tÃªn cÃ¡c column cÃ³ trong table
	 *
	 * @return List<String> Danh sÃ¡ch tÃªn cÃ¡c column cÃ³ trong table
	 */
	List<String> getAllColumnName();

	/**
	 * Láº¥y thÃ´ng tin chuyÃªn ngÃ nh báº±ng id chuyÃªn ngÃ nh
	 *
	 * @param chuyenNganhId int chuyÃªn ngÃ nh id
	 * @return ChuyenNganh Ä‘á»‘i tÆ°á»£ng chuyÃªn ngÃ nh
	 */
	ChuyenNganh getChuyenNganhById(int chuyenNganhId);

	/**
	 * Láº¥y toÃ n bá»™ sá»‘ báº£n ghi trong báº£ng
	 *
	 * @return int tá»•ng sá»‘ báº£n ghi
	 */
	int getTotalRecords(ChuyenNganh chuyenNganh);
}
