/**
 * Copyright(C) K16SE 2014
 *
 * QuocTich.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.entities;

/**
 *
 * @author HaVH
 *
 */
public class QuocTich {
	private int quocTichId;
	private String tenQuocTich;

	/**
	 * Constructor không tham số
	 *
	 *
	 */
	public QuocTich() {
		quocTichId = -1;
		tenQuocTich = "";
	}

	/**
	 * Constructor đầy đủ tham số
	 *
	 * @param quocTichId int quốc tịch id
	 * @param tenQuocTich String tên quốc tịch
	 */
	public QuocTich(int quocTichId, String tenQuocTich) {
		this.quocTichId = quocTichId;
		this.tenQuocTich = tenQuocTich;
	}

	/**
	 * Constructor không có quốc tịch id
	 *
	 * @param tenQuocTich String tên quốc tịch
	 */
	public QuocTich(String tenQuocTich) {
		this.quocTichId = -1;
		this.tenQuocTich = tenQuocTich;
	}

	/**
	 * @return the quocTichId
	 */
	public int getQuocTichId() {
		return quocTichId;
	}
	/**
	 * @param quocTichId the quocTichId to set
	 */
	public void setQuocTichId(int quocTichId) {
		this.quocTichId = quocTichId;
	}
	/**
	 * @return the tenQuocTich
	 */
	public String getTenQuocTich() {
		return tenQuocTich;
	}
	/**
	 * @param tenQuocTich the tenQuocTich to set
	 */
	public void setTenQuocTich(String tenQuocTich) {
		this.tenQuocTich = tenQuocTich;
	}
}
