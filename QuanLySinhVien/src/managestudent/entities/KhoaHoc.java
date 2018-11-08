
package managestudent.entities;

public class KhoaHoc {
	private int khoaHocId;
	private String tenKhoaHoc;

	public KhoaHoc() {
		khoaHocId = -1;
		tenKhoaHoc = "";
	}

	public KhoaHoc(int khoaHocId, String tenKhoaHoc) {
		this.khoaHocId = khoaHocId;
		this.tenKhoaHoc = tenKhoaHoc;
	}

	public KhoaHoc(String tenKhoaHoc) {
		this.khoaHocId = -1;
		this.tenKhoaHoc = tenKhoaHoc;
	}

	public int getKhoaHocId() {
		return khoaHocId;
	}

	public void setKhoaHocId(int khoaHocId) {
		this.khoaHocId = khoaHocId;
	}

	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}
}
