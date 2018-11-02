/**
 * Copyright(C) K16SE 2014
 *
 * MonHoc.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.entities;

/**
 *
 * @author HaVH
 *
 */
public class MonHoc {
	private int monHocId;
	private String tenMonHoc;
	private String soTrinh;
	private float heSoChuyenCan;
	private float heSoGiuaKy;
	private float heSoHocKy;
	private int chuyenNganhId;
	private String tenChuyenNganh;

	/**
	 * Constructor thÃ´ng tin tá»•ng quÃ¡t cá»§a mÃ´n há»�c
	 *
	 * @param monHocId id mÃ´n há»�c
	 * @param tenMonHoc String tÃªn mÃ´n há»�c
	 * @param chuyenNganhId int id chuyÃªn ngÃ nh cá»§a mÃ´n há»�c
	 * @param tenChuyenNganh String tÃªn chuyÃªn ngÃ nh cá»§a mÃ´n há»�c
	 */
	public MonHoc(int monHocId, String tenMonHoc, int chuyenNganhId, String tenChuyenNganh) {
		super();
		this.monHocId = monHocId;
		this.tenMonHoc = tenMonHoc;
		this.chuyenNganhId = chuyenNganhId;
		this.tenChuyenNganh = tenChuyenNganh;
	}

	/**
	 * Constructor khÃ´ng tham sá»‘
	 *
	 *
	 */
	public MonHoc() {
		monHocId = -1;
		tenMonHoc = "";
		soTrinh = "";
		heSoChuyenCan = -1;
		heSoGiuaKy = -1;
		heSoHocKy = -1;
		chuyenNganhId = -1;
		tenChuyenNganh = "";
	}

	/**
	 * Constructor Ä‘áº§y Ä‘á»§ tham sá»‘
	 *
	 * @param monHocId int mÃ´n há»�c id
	 * @param tenMonHoc String tÃªn mÃ´n há»�c
	 * @param soTrinh String sá»‘ trÃ¬nh
	 * @param heSoChuyenCan float há»‡ sá»‘ chuyÃªn cáº§n
	 * @param heSoGiuaKy float há»‡ sá»‘ giá»¯a ká»³
	 * @param heSoHocKy float há»‡ sá»‘ há»�c ká»³
	 * @param chuyenNganhId int chuyÃªn ngÃ nh id
	 * @param soNgayNghi int sá»‘ ngÃ y nghá»‰
	 */
	public MonHoc(int monHocId, String tenMonHoc, String soTrinh, float heSoChuyenCan, float heSoGiuaKy, float heSoHocKy, int chuyenNganhId) {
		this.monHocId = monHocId;
		this.tenMonHoc = tenMonHoc;
		this.soTrinh = soTrinh;
		this.heSoChuyenCan = heSoChuyenCan;
		this.heSoGiuaKy = heSoGiuaKy;
		this.heSoHocKy = heSoHocKy;
		this.chuyenNganhId = chuyenNganhId;
		tenChuyenNganh = "";
	}

	/**
	 * Constructor khÃ´ng cÃ³ id mÃ´n há»�c
	 *
	 * @param tenMonHoc String tÃªn mÃ´n há»�c
	 * @param soTrinh String sá»‘ trÃ¬nh
	 * @param heSoChuyenCan float há»‡ sá»‘ chuyÃªn cáº§n
	 * @param heSoGiuaKy float há»‡ sá»‘ giá»¯a ká»³
	 * @param heSoHocKy float há»‡ sá»‘ há»�c ká»³
	 * @param chuyenNganhId int chuyÃªn ngÃ nh id
	 * @param soNgayNghi int sá»‘ ngÃ y nghá»‰
	 */
	public MonHoc(String tenMonHoc, String soTrinh, float heSoChuyenCan, float heSoGiuaKy, float heSoHocKy, int chuyenNganhId, int soNgayNghi) {
		this.monHocId = -1;
		this.tenMonHoc = tenMonHoc;
		this.soTrinh = soTrinh;
		this.heSoChuyenCan = heSoChuyenCan;
		this.heSoGiuaKy = heSoGiuaKy;
		this.heSoHocKy = heSoHocKy;
		this.chuyenNganhId = chuyenNganhId;
		tenChuyenNganh = "";
	}

	/**
	 * @return the chuyenNganhId
	 */
	public int getChuyenNganhId() {
		return chuyenNganhId;
	}
	/**
	 * @param chuyenNganhId the chuyenNganhId to set
	 */
	public void setChuyenNganhId(int chuyenNganhId) {
		this.chuyenNganhId = chuyenNganhId;
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
	 * @return the tenMonHoc
	 */
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	/**
	 * @param tenMonHoc the tenMonHoc to set
	 */
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	/**
	 * @return the soTrinh
	 */
	public String getSoTrinh() {
		return soTrinh;
	}
	/**
	 * @param soTrinh the soTrinh to set
	 */
	public void setSoTrinh(String soTrinh) {
		this.soTrinh = soTrinh;
	}
	/**
	 * @return the heSoChuyenCan
	 */
	public float getHeSoChuyenCan() {
		return heSoChuyenCan;
	}
	/**
	 * @param heSoChuyenCan the heSoChuyenCan to set
	 */
	public void setHeSoChuyenCan(float heSoChuyenCan) {
		this.heSoChuyenCan = heSoChuyenCan;
	}
	/**
	 * @return the heSoGiuaKy
	 */
	public float getHeSoGiuaKy() {
		return heSoGiuaKy;
	}
	/**
	 * @param heSoGiuaKy the heSoGiuaKy to set
	 */
	public void setHeSoGiuaKy(float heSoGiuaKy) {
		this.heSoGiuaKy = heSoGiuaKy;
	}
	/**
	 * @return the heSoHocKy
	 */
	public float getHeSoHocKy() {
		return heSoHocKy;
	}
	/**
	 * @param heSoHocKy the heSoHocKy to set
	 */
	public void setHeSoHocKy(float heSoHocKy) {
		this.heSoHocKy = heSoHocKy;
	}

	/**
	 * @return the tenChuyenNganh
	 */
	public String getTenChuyenNganh() {
		return tenChuyenNganh;
	}

	/**
	 * @param tenChuyenNganh the tenChuyenNganh to set
	 */
	public void setTenChuyenNganh(String tenChuyenNganh) {
		this.tenChuyenNganh = tenChuyenNganh;
	}
}
