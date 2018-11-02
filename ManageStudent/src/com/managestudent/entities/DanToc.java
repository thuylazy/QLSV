/**
 * Copyright(C) K16SE 2014
 *
 * DanToc.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.entities;

/**
 *
 * @author HaVH
 *
 */
public class DanToc {
	private int danTocId;
	private String tenDanToc;

	/**
	 * Constructor đầy đủ tham số
	 *
	 * @param danTocId int id dân tộc
	 * @param tenDanToc String tên dân tộc
	 */
	public DanToc(int danTocId, String tenDanToc) {
		this.danTocId = danTocId;
		this.tenDanToc = tenDanToc;
	}

	/**
	 * Constructor không có dân tộc id
	 *
	 * @param tenDanToc String tên dân tộc
	 */
	public DanToc(String tenDanToc) {
		this.danTocId = -1;
		this.tenDanToc = tenDanToc;
	}

	/**
	 * Constructor không tham số
	 *
	 */
	public DanToc() {
		this.danTocId = -1;
		this.tenDanToc = "";
	}

	/**
	 * @return the danTocId
	 */
	public int getDanTocId() {
		return danTocId;
	}
	/**
	 * @param danTocId the danTocId to set
	 */
	public void setDanTocId(int danTocId) {
		this.danTocId = danTocId;
	}
	/**
	 * @return the tenDanToc
	 */
	public String getTenDanToc() {
		return tenDanToc;
	}
	/**
	 * @param tenDanToc the tenDanToc to set
	 */
	public void setTenDanToc(String tenDanToc) {
		this.tenDanToc = tenDanToc;
	}
}
