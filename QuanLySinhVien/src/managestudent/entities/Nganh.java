
package managestudent.entities;

public class Nganh {
	private int nganhId;
	private String maNganh;
	private String tenNganh;
	private String ghiChu;

	public Nganh() {
		nganhId = -1;
		maNganh = "";
		tenNganh = "";
		ghiChu = "";
	}


	public Nganh(int nganhId, String maNganh, String tenNganh, String ghiChu) {
		this.nganhId = nganhId;
		this.maNganh = maNganh;
		this.tenNganh = tenNganh;
		this.ghiChu = ghiChu;
	}

	public Nganh(String maNganh, String tenNganh, String ghiChu) {
		this.nganhId = -1;
		this.maNganh = maNganh;
		this.tenNganh = tenNganh;
		this.ghiChu = ghiChu;
	}

	public int getNganhId() {
		return nganhId;
	}

	public void setNganhId(int nganhId) {
		this.nganhId = nganhId;
	}

	public String getMaNganh() {
		return maNganh;
	}

	public void setMaNganh(String maNganh) {
		this.maNganh = maNganh;
	}

	public String getTenNganh() {
		return tenNganh;
	}

	public void setTenNganh(String tenNganh) {
		this.tenNganh = tenNganh;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
}
