/**
 * Copyright(C) K16SE 2014
 *
 * DiemLogics.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.logics;

import java.util.List;

import managestudent.entities.Diem;

/**
 *
 * @author HaVH
 *
 */
public interface DiemLogics {
	/**
	 * Láº¥y danh sÃ¡ch Ä‘iá»ƒm dá»±a trÃªn sinh viÃªn id
	 *
	 * @param sinhVienId int sinh viÃªn id
	 * @param hocKyId int há»�c ká»³ id
	 * @return List<Diem> Danh sÃ¡ch Ä‘iá»ƒm
	 */
	List<Diem> getDiemBySinhVienId(int sinhVienId, int hocKyId);

	/**
	 * ThÃªm Ä‘iá»ƒm
	 *
	 * @param diem Diem Ä‘á»‘i tÆ°á»£ng Ä‘iá»ƒm
	 * @return > 0: success / < 0: fail
	 */
	int addDiem(Diem diem);

	/**
	 * Cáº­p nháº­t thÃ´ng tin Ä‘iá»ƒm báº±ng Ä‘iá»ƒm id
	 *
	 * @param diemId int Ä‘iá»ƒm id
	 * @param diem Diem Ä‘á»‘i tÆ°á»£ng Ä‘iá»ƒm
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean updateDiemById(int diemId, Diem diem);

	/**
	 * XÃ³a thÃ´ng tin Ä‘iá»ƒm
	 *
	 * @param diemId int Ä‘iá»ƒm id
	 * @return true: thÃ nh cÃ´ng / false: tháº¥t báº¡i
	 */
	boolean deleteDiemById(int diemId);

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
	int getTotalRecords();
}
