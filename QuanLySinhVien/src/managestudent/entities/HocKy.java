
package managestudent.entities;

public class HocKy {
	private int hocKyId;
	private String tenHocKy;

	public HocKy() {
		hocKyId = -1;
		tenHocKy = "";
	}

	public HocKy(int hocKyId, String tenHocKy) {
		this.hocKyId = hocKyId;
		this.tenHocKy = tenHocKy;
	}

	public HocKy(String tenHocKy) {
		this.hocKyId = -1;
		this.tenHocKy = tenHocKy;
	}

	public int getHocKyId() {
		return hocKyId;
	}

	public void setHocKyId(int hocKyId) {
		this.hocKyId = hocKyId;
	}

	public String getTenHocKy() {
		return tenHocKy;
	}

	public void setTenHocKy(String tenHocKy) {
		this.tenHocKy = tenHocKy;
	}
}
