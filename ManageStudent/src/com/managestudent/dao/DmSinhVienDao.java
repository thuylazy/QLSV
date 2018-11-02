/**
 * Copyright(C) K16SE 2014
 *
 * DmSinhVienDao.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.dao;

import java.util.List;

import managestudent.entities.DmSinhVien;

/**
 *
 * @author HaVH
 *
 */
public interface DmSinhVienDao extends BaseDao {
	/**
	 * Láº¥y danh sÃ¡ch táº¥t cáº£ sinh viÃªn
	 *
	 * @return List<DmSinhVien> Danh sÃ¡ch Ä‘á»‘i tÆ°á»£ng DmSinhVien
	 */
	List<DmSinhVien> getAllSinhVien(DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Láº¥y danh sÃ¡ch thÃ´ng tin chi tiáº¿t táº¥t cáº£ sinh viÃªn
	 *
	 * @return List<DmSinhVien> Danh sÃ¡ch Ä‘á»‘i tÆ°á»£ng DmSinhVien
	 */
	List<DmSinhVien> getAllSinhVienDetail(DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Láº¥y danh sÃ¡ch sinh viÃªn trong há»‡ Ä‘Ã o táº¡o
	 *
	 * @param heDaoTaoId int há»‡ Ä‘Ã o táº¡o id
	 * @return List<DmSinhVien> Danh sÃ¡ch Ä‘á»‘i tÆ°á»£ng DmSinhVien
	 */
	List<DmSinhVien> getListSinhVienByHeDaoTaoId(int heDaoTaoId, DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Láº¥y danh sÃ¡ch sinh viÃªn trong lá»›p
	 *
	 * @param lopId int lá»›p id
	 * @return List<DmSinhVien> Danh sÃ¡ch Ä‘á»‘i tÆ°á»£ng DmSinhVien
	 */
	List<DmSinhVien> getListSinhVienByLopId(int lopId, DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Láº¥y danh sÃ¡ch sinh viÃªn trong khÃ³a há»�c
	 *
	 * @param khoaHocId int khÃ³a há»�c id
	 * @return List<DmSinhVien> Danh sÃ¡ch Ä‘á»‘i tÆ°á»£ng DmSinhVien
	 */
	List<DmSinhVien> getListSinhVienByKhoaHocId(int khoaHocId, DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Láº¥y sinh viÃªn theo mÃ£ sinh viÃªn
	 *
	 * @param maSinhVien String mÃ£ sinh viÃªn
	 * @return DmSinhVien Ä‘á»‘i tÆ°á»£ng DmSinhVien
	 */
	DmSinhVien getSinhVienByMaSinhVien(String maSinhVien);

	/**
	 * Láº¥y sinh viÃªn theo id sinh viÃªn
	 *
	 * @param sinhVienId int id sinh viÃªn
	 * @return DmSinhVien Ä‘á»‘i tÆ°á»£ng DmSinhVien
	 */
	DmSinhVien getSinhVienById(int sinhVienId);

	/**
	 * ThÃªm sinh viÃªn
	 *
	 * @param sinhVien DmSinhVien Ä‘á»‘i tÆ°á»£ng DmSinhVien
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean addSinhVien(DmSinhVien sinhVien);

	/**
	 * Cáº­p nháº­t thÃ´ng tin sinh viÃªn
	 *
	 * @param maSinhVien String mÃ£ sinh viÃªn
	 * @param sinhVien DmSinhVien Ä‘á»‘i tÆ°á»£ng DmSinhVien
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean updateSinhVienByMaSinhVien(String maSinhVien, DmSinhVien sinhVien);

	/**
	 * Cáº­p nháº­t thÃ´ng tin sinh viÃªn báº±ng id
	 *
	 * @param idSinhVien id sinh viÃªn
	 * @param sinhVien DmSinhVien Ä‘á»‘i tÆ°á»£ng DmSinhVien
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean updateSinhVienById(int idSinhVien, DmSinhVien sinhVien);

	/**
	 * XÃ³a thÃ´ng tin sinh viÃªn
	 *
	 * @param maSinhVien String mÃ£ sinh viÃªn
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean deleteSinhVienByMaSinhVien(String maSinhVien);

	/**
	 * XÃ³a thÃ´ng tin sinh viÃªn
	 *
	 * @param idSinhVien int id sinh viÃªn
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean deleteSinhVienById(int idSinhVien);

	/**
	 * Láº¥y tá»•ng sá»‘ táº¥t cáº£ báº£n ghi thá»�a mÃ£n Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m
	 *
	 * @param sinhVien DmSinhVien Ä‘á»‘i tÆ°á»£ng sinh viÃªn (chá»©a thÃ´ng tin Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m)
	 * @return int tá»•ng sá»‘ táº¥t cáº£ báº£n ghi thá»�a mÃ£n Ä‘iá»�u kiá»‡n tÃ¬m kiáº¿m
	 */
	int getTotalRecords(DmSinhVien sinhVien);

	/**
	 * Cáº­p nháº­t chuyÃªn ngÃ nh cho sinh viÃªn
	 * @param chuyenNganhId chuyÃªn ngÃ nh id
	 * @param sinhVienId sinh viÃªn id
	 * @return true: update success / false: update fail
	 */
	boolean updateChuyenNganhSinhVien(int sinhVienId, int chuyenNganhId);
}
