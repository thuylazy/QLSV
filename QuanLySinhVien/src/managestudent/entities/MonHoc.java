
package managestudent.entities;

public class MonHoc {
	private int monHocId;
	private String tenMonHoc;
	private String soTrinh;
	private float heSoChuyenCan;
	private float heSoGiuaKy;
	private float heSoHocKy;
	private int chuyenNganhId;
	private String tenChuyenNganh;

	public MonHoc(int monHocId, String tenMonHoc, int chuyenNganhId, String tenChuyenNganh) {
		super();
		this.monHocId = monHocId;
		this.tenMonHoc = tenMonHoc;
		this.chuyenNganhId = chuyenNganhId;
		this.tenChuyenNganh = tenChuyenNganh;
	}

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

	public int getChuyenNganhId() {
		return chuyenNganhId;
	}

	public void setChuyenNganhId(int chuyenNganhId) {
		this.chuyenNganhId = chuyenNganhId;
	}

	public int getMonHocId() {
		return monHocId;
	}

	public void setMonHocId(int monHocId) {
		this.monHocId = monHocId;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public String getSoTrinh() {
		return soTrinh;
	}

	public void setSoTrinh(String soTrinh) {
		this.soTrinh = soTrinh;
	}

	public float getHeSoChuyenCan() {
		return heSoChuyenCan;
	}

	public void setHeSoChuyenCan(float heSoChuyenCan) {
		this.heSoChuyenCan = heSoChuyenCan;
	}

	public float getHeSoGiuaKy() {
		return heSoGiuaKy;
	}

	public void setHeSoGiuaKy(float heSoGiuaKy) {
		this.heSoGiuaKy = heSoGiuaKy;
	}

	public float getHeSoHocKy() {
		return heSoHocKy;
	}

	public void setHeSoHocKy(float heSoHocKy) {
		this.heSoHocKy = heSoHocKy;
	}

	public String getTenChuyenNganh() {
		return tenChuyenNganh;
	}

	public void setTenChuyenNganh(String tenChuyenNganh) {
		this.tenChuyenNganh = tenChuyenNganh;
	}
}
