
package managestudent.entities;

public class TonGiao {
	private int tonGiaoId;
	private String tenTonGiao;

	public TonGiao() {
		this.tonGiaoId = -1;
		this.tenTonGiao = "";
	}

	public TonGiao(int tonGiaoId, String tenTonGiao) {
		this.tonGiaoId = tonGiaoId;
		this.tenTonGiao = tenTonGiao;
	}

	public TonGiao(String tenTonGiao) {
		this.tonGiaoId = -1;
		this.tenTonGiao = tenTonGiao;
	}

	public int getTonGiaoId() {
		return tonGiaoId;
	}

	public void setTonGiaoId(int tonGiaoId) {
		this.tonGiaoId = tonGiaoId;
	}

	public String getTenTonGiao() {
		return tenTonGiao;
	}

	public void setTenTonGiao(String tenTonGiao) {
		this.tenTonGiao = tenTonGiao;
	}
}
