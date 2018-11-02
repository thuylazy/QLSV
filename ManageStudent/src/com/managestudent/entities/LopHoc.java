/**
 * Copyright(C) K16SE 2014
 *
 * LopHoc.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.entities;

/**
 *
 * @author HaVH
 *
 */
public class LopHoc {
	private int lopHocId;
	private String tenLopHoc;

	/**
	 * Constructor khÃ´ng tham sá»‘
	 *
	 *
	 */
	public LopHoc() {
		lopHocId = -1;
		tenLopHoc = "";
	}

	/**
	 * Constructor Ä‘áº§y Ä‘á»§ tham sá»‘
	 *
	 * @param lopHocId int lá»›p há»�c id
	 * @param tenLopHoc String tÃªn lá»›p há»�c
	 */
	public LopHoc(int lopHocId, String tenLopHoc) {
		this.lopHocId = lopHocId;
		this.tenLopHoc = tenLopHoc;
	}

	/**
	 * Constructor khÃ´ng cÃ³ lá»›p há»�c id
	 *
	 * @param tenLopHoc String tÃªn lá»›p há»�c
	 */
	public LopHoc(String tenLopHoc) {
		this.lopHocId = -1;
		this.tenLopHoc = tenLopHoc;
	}

	/**
	 * @return the lopHocId
	 */
	public int getLopHocId() {
		return lopHocId;
	}
	/**
	 * @param lopHocId the lopHocId to set
	 */
	public void setLopHocId(int lopHocId) {
		this.lopHocId = lopHocId;
	}
	/**
	 * @return the tenLopHoc
	 */
	public String getTenLopHoc() {
		return tenLopHoc;
	}
	/**
	 * @param tenLopHoc the tenLopHoc to set
	 */
	public void setTenLopHoc(String tenLopHoc) {
		this.tenLopHoc = tenLopHoc;
	}
}
