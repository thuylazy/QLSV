/**
 * Copyright(C) K16SE 2014
 *
 * User.java, Sep 5, 2014 HaVH
 *
 */
package com.managestudent.entities;

import java.util.Date;

/**
 *
 * @author HaVH
 *
 */
public class User {
	private int userId;
	private String username;
	private String password;
	private String hoVaTen;
	private String diaChi;
	private String soDienThoai;
	private Date ngaySinh;
	private String soCmt;

	/**
	 * Constructor khÃ´ng tham sá»‘
	 *
	 *
	 */
	public User() {
		userId = -1;
		username = "";
		password = "";
		hoVaTen = "";
		diaChi = "";
		soDienThoai = "";
		ngaySinh = new Date();
		soCmt = "";
	}

	/**
	 * Constructor Ä‘áº§y Ä‘á»§ tham sá»‘
	 *
	 * @param userId int user id
	 * @param username String username
	 * @param password String password
	 * @param hoVaTen String há»� vÃ  tÃªn
	 * @param diaChi String Ä‘á»‹a chá»‰
	 * @param soDienThoai String sá»‘ Ä‘iá»‡n thoáº¡i
	 * @param ngaySinh Date ngÃ y sinh
	 * @param soCmt String sá»‘ cmtnd
	 */
	public User(int userId, String username, String password, String hoVaTen, String diaChi, String soDienThoai, Date ngaySinh, String soCmt) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.hoVaTen = hoVaTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.soCmt = soCmt;
	}

	/**
	 * Constructor khÃ´ng cÃ³ user id
	 *
	 * @param username String username
	 * @param password String password
	 * @param hoVaTen String há»� vÃ  tÃªn
	 * @param diaChi String Ä‘á»‹a chá»‰
	 * @param soDienThoai String sá»‘ Ä‘iá»‡n thoáº¡i
	 * @param ngaySinh Date ngÃ y sinh
	 * @param soCmt String sá»‘ cmtnd
	 */
	public User(String username, String password, String hoVaTen, String diaChi, String soDienThoai, Date ngaySinh, String soCmt) {
		this.userId = -1;
		this.username = username;
		this.password = password;
		this.hoVaTen = hoVaTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.soCmt = soCmt;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the hoVaTen
	 */
	public String getHoVaTen() {
		return hoVaTen;
	}
	/**
	 * @param hoVaTen the hoVaTen to set
	 */
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	/**
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return diaChi;
	}
	/**
	 * @param diaChi the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	/**
	 * @return the soDienThoai
	 */
	public String getSoDienThoai() {
		return soDienThoai;
	}
	/**
	 * @param soDienThoai the soDienThoai to set
	 */
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	/**
	 * @return the ngaySinh
	 */
	public Date getNgaySinh() {
		return ngaySinh;
	}
	/**
	 * @param ngaySinh the ngaySinh to set
	 */
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	/**
	 * @return the soCmt
	 */
	public String getSoCmt() {
		return soCmt;
	}
	/**
	 * @param soCmt the soCmt to set
	 */
	public void setSoCmt(String soCmt) {
		this.soCmt = soCmt;
	}
}
