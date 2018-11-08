
package managestudent.entities;

public class DanToc {
	private int danTocId;
	private String tenDanToc;

	public DanToc(int danTocId, String tenDanToc) {
		this.danTocId = danTocId;
		this.tenDanToc = tenDanToc;
	}

	public DanToc(String tenDanToc) {
		this.danTocId = -1;
		this.tenDanToc = tenDanToc;
	}

	public DanToc() {
		this.danTocId = -1;
		this.tenDanToc = "";
	}

	public int getDanTocId() {
		return danTocId;
	}

	public void setDanTocId(int danTocId) {
		this.danTocId = danTocId;
	}

	public String getTenDanToc() {
		return tenDanToc;
	}

	public void setTenDanToc(String tenDanToc) {
		this.tenDanToc = tenDanToc;
	}
}
