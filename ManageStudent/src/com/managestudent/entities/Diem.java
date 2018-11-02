/**
 * Copyright(C) K16SE 2014
 *
 * Diem.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.entities;

/**
 *
 * @author HaVH
 *
 */
public class Diem {
	private int diemId;
	private int monHocId;
	private String lanThi;
	private float diemThi;
	private float diemChuyenCan;
	private float diemGiuaKy;
	private int hocKyId;
	private int sinhVienId;
	private MonHoc monHoc;

	public Diem() {
		diemId = -1;
		monHocId = -1;
		lanThi = "";
		diemThi = -1;
		diemChuyenCan = -1;
		diemGiuaKy = -1;
		hocKyId = -1;
		sinhVienId = -1;
		monHoc = null;
		hocKyId = -1;
	}

	/**
	 * Constructor Ä‘áº§y Ä‘á»§ tham sá»‘
	 *
	 * @param diemId int Ä‘iá»ƒm id
	 * @param monHocId int mÃ´n há»�c id
	 * @param lanThi String láº§n thi
	 * @param diemThi float Ä‘iá»ƒm thi
	 * @param diemChuyenCan float Ä‘iá»ƒm chuyÃªn cáº§n
	 * @param diemGiuaKy float Ä‘iá»ƒm giá»¯a ká»³
	 * @param hocKyId int há»�c ká»³ id
	 * @param sinhVienId int sinh viÃªn id
	 */
	public Diem(int diemId, int monHocId, String lanThi, float diemThi, float diemChuyenCan, float diemGiuaKy, int hocKyId, int sinhVienId) {
		this.diemId = diemId;
		this.monHocId = monHocId;
		this.lanThi = lanThi;
		this.diemThi = diemThi;
		this.diemChuyenCan = diemChuyenCan;
		this.diemGiuaKy = diemGiuaKy;
		this.hocKyId = hocKyId;
		this.sinhVienId = sinhVienId;
		this.monHoc = null;
	}

	/**
	 * Constructor khÃ´ng cÃ³ Ä‘iá»ƒm id
	 *
	 * @param monHocId int mÃ´n há»�c id
	 * @param lanThi String láº§n thi
	 * @param diemThi float Ä‘iá»ƒm thi
	 * @param diemChuyenCan float Ä‘iá»ƒm chuyÃªn cáº§n
	 * @param diemGiuaKy float Ä‘iá»ƒm giá»¯a ká»³
	 * @param hocKyId int há»�c ká»³ id
	 * @param sinhVienId int sinh viÃªn id
	 */
	public Diem(int monHocId, String lanThi, float diemThi, float diemChuyenCan, float diemGiuaKy, int hocKyId, int sinhVienId) {
		this.diemId = -1;
		this.monHocId = monHocId;
		this.lanThi = lanThi;
		this.diemThi = diemThi;
		this.diemChuyenCan = diemChuyenCan;
		this.diemGiuaKy = diemGiuaKy;
		this.hocKyId = hocKyId;
		this.sinhVienId = sinhVienId;
		this.monHoc = null;
	}

	/**
	 * @return the monHoc
	 */
	public MonHoc getMonHoc() {
		return monHoc;
	}

	/**
	 * @param monHoc the monHoc to set
	 */
	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	/**
	 * Constructor khÃ´ng tham sá»‘
	 *
	 */

	/**
	 * @return the sinhVienId
	 */
	public int getSinhVienId() {
		return sinhVienId;
	}
	/**
	 * @param sinhVienId the sinhVienId to set
	 */
	public void setSinhVienId(int sinhVienId) {
		this.sinhVienId = sinhVienId;
	}
	/**
	 * @return the diemId
	 */
	public int getDiemId() {
		return diemId;
	}
	/**
	 * @param diemId the diemId to set
	 */
	public void setDiemId(int diemId) {
		this.diemId = diemId;
	}
	/**
	 * @return the monHocId
	 */
	public int getMonHocId() {
		return monHocId;
	}
	/**
	 * @param monHocId the monHocId to set
	 */
	public void setMonHocId(int monHocId) {
		this.monHocId = monHocId;
	}
	/**
	 * @return the lanThi
	 */
	public String getLanThi() {
		return lanThi;
	}
	/**
	 * @param lanThi the lanThi to set
	 */
	public void setLanThi(String lanThi) {
		this.lanThi = lanThi;
	}
	/**
	 * @return the diemThi
	 */
	public float getDiemThi() {
		return diemThi;
	}
	/**
	 * @param diemThi the diemThi to set
	 */
	public void setDiemThi(float diemThi) {
		this.diemThi = diemThi;
	}
	/**
	 * @return the diemChuyenCan
	 */
	public float getDiemChuyenCan() {
		return diemChuyenCan;
	}
	/**
	 * @param diemChuyenCan the diemChuyenCan to set
	 */
	public void setDiemChuyenCan(float diemChuyenCan) {
		this.diemChuyenCan = diemChuyenCan;
	}
	/**
	 * @return the diemGiuaKy
	 */
	public float getDiemGiuaKy() {
		return diemGiuaKy;
	}
	/**
	 * @param diemGiuaKy the diemGiuaKy to set
	 */
	public void setDiemGiuaKy(float diemGiuaKy) {
		this.diemGiuaKy = diemGiuaKy;
	}
	/**
	 * @return the hocKyId
	 */
	public int getHocKyId() {
		return hocKyId;
	}
	/**
	 * @param hocKyId the hocKyId to set
	 */
	public void setHocKyId(int hocKyId) {
		this.hocKyId = hocKyId;
	}
}
