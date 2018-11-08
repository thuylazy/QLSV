
package managestudent.entities;

import java.util.Date;

public class LogDiem {
	private int logId;
	private int diemId;
	private int monHocId;
	private String lanThi;
	private float diemThi;
	private float diemChuyenCan;
	private float diemGiuaKy;
	private int hocKyId;
	private int sinhVienId;
	private String action;
	private Date time;

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}
	public int getDiemId() {
		return diemId;
	}

	public void setDiemId(int diemId) {
		this.diemId = diemId;
	}

	public int getMonHocId() {
		return monHocId;
	}

	public void setMonHocId(int monHocId) {
		this.monHocId = monHocId;
	}

	public String getLanThi() {
		return lanThi;
	}

	public void setLanThi(String lanThi) {
		this.lanThi = lanThi;
	}

	public float getDiemThi() {
		return diemThi;
	}

	public void setDiemThi(float diemThi) {
		this.diemThi = diemThi;
	}

	public float getDiemChuyenCan() {
		return diemChuyenCan;
	}

	public void setDiemChuyenCan(float diemChuyenCan) {
		this.diemChuyenCan = diemChuyenCan;
	}

	public float getDiemGiuaKy() {
		return diemGiuaKy;
	}

	public void setDiemGiuaKy(float diemGiuaKy) {
		this.diemGiuaKy = diemGiuaKy;
	}

	public int getHocKyId() {
		return hocKyId;
	}

	public void setHocKyId(int hocKyId) {
		this.hocKyId = hocKyId;
	}

	public int getSinhVienId() {
		return sinhVienId;
	}

	public void setSinhVienId(int sinhVienId) {
		this.sinhVienId = sinhVienId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
