/**
 * Copyright(C) K16SE 2014
 *
 * TonGiao.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.entities;

/**
 *
 * @author HaVH
 *
 */
public class TonGiao {
	private int tonGiaoId;
	private String tenTonGiao;

	/**
	 * Constructor không tham số
	 *
	 *
	 */
	public TonGiao() {
		this.tonGiaoId = -1;
		this.tenTonGiao = "";
	}

	/**
	 * Constructor đầy đủ tham số
	 *
	 * @param tonGiaoId int tôn giáo id
	 * @param tenTonGiao String tên tôn giáo
	 */
	public TonGiao(int tonGiaoId, String tenTonGiao) {
		this.tonGiaoId = tonGiaoId;
		this.tenTonGiao = tenTonGiao;
	}

	/**
	 * Constructor không có tôn giáo id
	 *
	 * @param tenTonGiao String tên tôn giáo
	 */
	public TonGiao(String tenTonGiao) {
		this.tonGiaoId = -1;
		this.tenTonGiao = tenTonGiao;
	}

	/**
	 * @return the tonGIaoId
	 */
	public int getTonGiaoId() {
		return tonGiaoId;
	}
	/**
	 * @param tonGIaoId the tonGIaoId to set
	 */
	public void setTonGiaoId(int tonGiaoId) {
		this.tonGiaoId = tonGiaoId;
	}
	/**
	 * @return the tenTonGiao
	 */
	public String getTenTonGiao() {
		return tenTonGiao;
	}
	/**
	 * @param tenTonGiao the tenTonGiao to set
	 */
	public void setTenTonGiao(String tenTonGiao) {
		this.tenTonGiao = tenTonGiao;
	}
}
