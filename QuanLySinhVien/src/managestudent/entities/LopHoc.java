
package managestudent.entities;

public class LopHoc {
	private int lopHocId;
	private String tenLopHoc;

	public LopHoc() {
		lopHocId = -1;
		tenLopHoc = "";
	}

	public LopHoc(int lopHocId, String tenLopHoc) {
		this.lopHocId = lopHocId;
		this.tenLopHoc = tenLopHoc;
	}

	public LopHoc(String tenLopHoc) {
		this.lopHocId = -1;
		this.tenLopHoc = tenLopHoc;
	}

	public int getLopHocId() {
		return lopHocId;
	}

	public void setLopHocId(int lopHocId) {
		this.lopHocId = lopHocId;
	}

	public String getTenLopHoc() {
		return tenLopHoc;
	}

	public void setTenLopHoc(String tenLopHoc) {
		this.tenLopHoc = tenLopHoc;
	}
}
