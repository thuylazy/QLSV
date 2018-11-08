
package managestudent.entities;

import java.util.Date;

public class User {
	private int userId;
	private String username;
	private String password;
	private String hoVaTen;
	private String diaChi;
	private String soDienThoai;
	private Date ngaySinh;
	private String soCmt;

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoCmt() {
		return soCmt;
	}

	public void setSoCmt(String soCmt) {
		this.soCmt = soCmt;
	}
}
