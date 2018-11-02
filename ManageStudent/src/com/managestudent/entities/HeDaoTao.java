/**
 * Copyright(C) K16SE 2014
 *
 * HeDaoTao.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.entities;

/**
 *
 * @author HaVH
 *
 */
public class HeDaoTao {
	private int heDtId;
	private String maHeDt;
	private String tenHeDt;

	/**
	 * Constructor không có hệ đào tạo id
	 *
	 * @param maHeDt String mã hệ đào tạo
	 * @param tenHeDt String tên hệ đào tạo
	 */
	public HeDaoTao(String maHeDt, String tenHeDt) {
		this.heDtId = -1;
		this.maHeDt = maHeDt;
		this.tenHeDt = tenHeDt;
	}

	/**
	 * Constructor đầy đủ tham số
	 *
	 * @param heDtId int hệ đào tạo id
	 * @param maHeDt String mã hệ đào tạo
	 * @param tenHeDt String tên hệ đào tạo
	 */
	public HeDaoTao(int heDtId, String maHeDt, String tenHeDt) {
		this.heDtId = heDtId;
		this.maHeDt = maHeDt;
		this.tenHeDt = tenHeDt;
	}

	/**
	 * Constructor không tham số
	 *
	 *
	 */
	public HeDaoTao() {
		heDtId = -1;
		maHeDt = "";
		tenHeDt = "";
	}

	/**
	 * @return the heDtId
	 */
	public int getHeDtId() {
		return heDtId;
	}
	/**
	 * @param heDtId the heDtId to set
	 */
	public void setHeDtId(int heDtId) {
		this.heDtId = heDtId;
	}
	/**
	 * @return the maHeDt
	 */
	public String getMaHeDt() {
		return maHeDt;
	}
	/**
	 * @param maHeDt the maHeDt to set
	 */
	public void setMaHeDt(String maHeDt) {
		this.maHeDt = maHeDt;
	}
	/**
	 * @return the tenHeDt
	 */
	public String getTenHeDt() {
		return tenHeDt;
	}
	/**
	 * @param tenHeDt the tenHeDt to set
	 */
	public void setTenHeDt(String tenHeDt) {
		this.tenHeDt = tenHeDt;
	}
}
