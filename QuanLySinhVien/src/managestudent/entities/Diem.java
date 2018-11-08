
package managestudent.entities;

public class Diem {
	private int diemId;
	private int monHocId;
	private String lanThi;
	private float diemThi;
	private float diemChuyenCan;
	private float diemGiuaKy;
	private int hocKyId;
	private int sinhVienId;
	private MonHoc monHoc;

	public Diem() {
		diemId = -1;
		monHocId = -1;
		lanThi = "";
		diemThi = -1;
		diemChuyenCan = -1;
		diemGiuaKy = -1;
		hocKyId = -1;
		sinhVienId = -1;
		monHoc = null;
		hocKyId = -1;
	}

	public Diem(int diemId, int monHocId, String lanThi, float diemThi, float diemChuyenCan, float diemGiuaKy, int hocKyId, int sinhVienId) {
		this.diemId = diemId;
		this.monHocId = monHocId;
		this.lanThi = lanThi;
		this.diemThi = diemThi;
		this.diemChuyenCan = diemChuyenCan;
		this.diemGiuaKy = diemGiuaKy;
		this.hocKyId = hocKyId;
		this.sinhVienId = sinhVienId;
		this.monHoc = null;
	}

	public Diem(int monHocId, String lanThi, float diemThi, float diemChuyenCan, float diemGiuaKy, int hocKyId, int sinhVienId) {
		this.diemId = -1;
		this.monHocId = monHocId;
		this.lanThi = lanThi;
		this.diemThi = diemThi;
		this.diemChuyenCan = diemChuyenCan;
		this.diemGiuaKy = diemGiuaKy;
		this.hocKyId = hocKyId;
		this.sinhVienId = sinhVienId;
		this.monHoc = null;
	}


	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public int getSinhVienId() {
		return sinhVienId;
	}

	public void setSinhVienId(int sinhVienId) {
		this.sinhVienId = sinhVienId;
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
}
