/**
 * Copyright(C) K16SE 2014
 *
 * HocKy.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.entities;

/**
 *
 * @author HaVH
 *
 */
public class HocKy {
	private int hocKyId;
	private String tenHocKy;

	/**
	 * Constructor khÃ´ng tham sá»‘
	 *
	 *
	 */
	public HocKy() {
		hocKyId = -1;
		tenHocKy = "";
	}

	/**
	 * Constructor Ä‘áº§y Ä‘á»§ tham sá»‘
	 *
	 * @param hocKyId int há»�c ká»³ id
	 * @param tenHocKy String tÃªn há»�c ká»³
	 */
	public HocKy(int hocKyId, String tenHocKy) {
		this.hocKyId = hocKyId;
		this.tenHocKy = tenHocKy;
	}

	/**
	 * Constructor khÃ´ng cÃ³ há»�c ká»³ id
	 *
	 * @param tenHocKy String tÃªn há»�c ká»³
	 */
	public HocKy(String tenHocKy) {
		this.hocKyId = -1;
		this.tenHocKy = tenHocKy;
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
	/**
	 * @return the tenHocKy
	 */
	public String getTenHocKy() {
		return tenHocKy;
	}
	/**
	 * @param tenHocKy the tenHocKy to set
	 */
	public void setTenHocKy(String tenHocKy) {
		this.tenHocKy = tenHocKy;
	}
}
