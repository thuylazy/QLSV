/**
 * Copyright(C) K16SE 2014
 *
 * KhoaHoc.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.entities;

/**
 *
 * @author HaVH
 *
 */
public class KhoaHoc {
	private int khoaHocId;
	private String tenKhoaHoc;

	/**
	 * Constructor khÃ´ng tham sá»‘
	 *
	 *
	 */
	public KhoaHoc() {
		khoaHocId = -1;
		tenKhoaHoc = "";
	}

	/**
	 * Constructor Ä‘áº§y Ä‘á»§ tham sá»‘
	 *
	 * @param khoaHocId int khÃ³a há»�c id
	 * @param tenKhoaHoc String tÃªn khÃ³a há»�c
	 */
	public KhoaHoc(int khoaHocId, String tenKhoaHoc) {
		this.khoaHocId = khoaHocId;
		this.tenKhoaHoc = tenKhoaHoc;
	}

	/**
	 * Constructor khÃ´ng cÃ³ khÃ³a há»�c id
	 *
	 * @param tenKhoaHoc String tÃªn khÃ³a há»�c
	 */
	public KhoaHoc(String tenKhoaHoc) {
		this.khoaHocId = -1;
		this.tenKhoaHoc = tenKhoaHoc;
	}

	/**
	 * @return the khoaHocId
	 */
	public int getKhoaHocId() {
		return khoaHocId;
	}
	/**
	 * @param khoaHocId the khoaHocId to set
	 */
	public void setKhoaHocId(int khoaHocId) {
		this.khoaHocId = khoaHocId;
	}
	/**
	 * @return the tenKhoaHoc
	 */
	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}
	/**
	 * @param tenKhoaHoc the tenKhoaHoc to set
	 */
	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}
}
