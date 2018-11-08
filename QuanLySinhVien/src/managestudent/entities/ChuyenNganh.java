
package managestudent.entities;

public class ChuyenNganh {
	private int chuyenNganhId;
	private String maChuyenNganh;
	private String tenChuyenNganh;
	private int nganhId;
	private String tenNganh;

	public ChuyenNganh(int chuyenNganhId, String maChuyenNganh, String tenChuyenNganh, int nganhId, String tenNganh) {
		super();
		this.chuyenNganhId = chuyenNganhId;
		this.maChuyenNganh = maChuyenNganh;
		this.tenChuyenNganh = tenChuyenNganh;
		this.nganhId = nganhId;
		this.tenNganh = tenNganh;
	}

	public ChuyenNganh(int chuyenNganhId, String maChuyenNganh, String tenChuyenNganh, int nganhId) {
		this.chuyenNganhId = chuyenNganhId;
		this.maChuyenNganh = maChuyenNganh;
		this.tenChuyenNganh = tenChuyenNganh;
		this.nganhId = nganhId;
		this.tenNganh = "";
	}

	public ChuyenNganh(String maChuyenNganh, String tenChuyenNganh, int nganhId) {
		this.chuyenNganhId = -1;
		this.maChuyenNganh = maChuyenNganh;
		this.tenChuyenNganh = tenChuyenNganh;
		this.nganhId = nganhId;
		this.tenNganh = "";
	}

	public ChuyenNganh() {
		this.chuyenNganhId = -1;
		this.maChuyenNganh = "";
		this.tenChuyenNganh = "";
		this.nganhId = -1;
		this.tenNganh = "";
	}

	public int getChuyenNganhId() {
		return chuyenNganhId;
	}

	public void setChuyenNganhId(int chuyenNganhId) {
		this.chuyenNganhId = chuyenNganhId;
	}

	public String getMaChuyenNganh() {
		return maChuyenNganh;
	}

	public void setMaChuyenNganh(String maChuyenNganh) {
		this.maChuyenNganh = maChuyenNganh;
	}

	public String getTenChuyenNganh() {
		return tenChuyenNganh;
	}

	public void setTenChuyenNganh(String tenChuyenNganh) {
		this.tenChuyenNganh = tenChuyenNganh;
	}

	public int getNganhId() {
		return nganhId;
	}

	public void setNganhId(int nganhId) {
		this.nganhId = nganhId;
	}

	public String getTenNganh() {
		return tenNganh;
	}

	public void setTenNganh(String tenNganh) {
		this.tenNganh = tenNganh;
	}
}
