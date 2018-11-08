
package managestudent.entities;

import java.util.Date;


public class DmSinhVien {
	private int sinhVienId;
	private String maSinhVien;
	private String hoDem;
	private String ten;
	private Date ngaySinh;
	private int gioiTinh; //1: Nam / 0: Nu / -1: Khong chon
	private String cmtnd;
	private String soDienThoai;
	private String noiSinh;
	private String queQuan;
	private String hoKhauThuongTru;
	private String noiOHienTai;
	private String cheDoUuDai;
	private int danTocId;
	private int tonGiaoId;
	private String hoTenBo;
	private String ngheNghiepBo;
	private String hoTenMe;
	private String ngheNghiepMe;
	private int lopId;
	private int khoaHocId;
	private Date ngayNhapHoc;
	private float diemDauVao1;
	private float diemDauVao2;
	private float diemDauVao3;
	private String anhSinhVien;
	private String tenLopHoc;
	private String tenKhoaHoc;
	private int chuyenNganhId;

	public DmSinhVien(int sinhVienId, String maSinhVien, String hoDem, String ten, Date ngaySinh, int gioiTinh, int lopId, int khoaHocId) {
		super();
		this.sinhVienId = sinhVienId;
		this.maSinhVien = maSinhVien;
		this.hoDem = hoDem;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.lopId = lopId;
		this.khoaHocId = khoaHocId;
	}

	public DmSinhVien() {
		sinhVienId = -1;
		maSinhVien = "";
		hoDem = "";
		ten = "";
		ngaySinh = new Date();
		gioiTinh = -1;
		cmtnd = "";
		soDienThoai = "";
		noiSinh = "";
		queQuan = "";
		hoKhauThuongTru = "";
		noiOHienTai = "";
		cheDoUuDai = "";
		danTocId = -1;
		tonGiaoId = -1;
		hoTenBo = "";
		ngheNghiepBo = "";
		hoTenMe = "";
		ngheNghiepMe = "";
		lopId = -1;
		khoaHocId = -1;
		ngayNhapHoc = new Date();
		diemDauVao1 = -1;
		diemDauVao2 = -1;
		diemDauVao3 = -1;
		anhSinhVien = "";
		tenKhoaHoc = "";
		tenLopHoc = "";
		chuyenNganhId = -1;
	}


	public DmSinhVien(int sinhVienId, String maSinhVien, String hoDem, String ten, Date ngaySinh, int gioiTinh, String cmtnd, String soDienThoai,
			String noiSinh, String queQuan, String hoKhauThuongTru, String noiOHienTai, String cheDoUuDai, int danTocId, int tonGiaoId,
			String hoTenBo, String ngheNghiepBo, String hoTenMe, String ngheNghiepMe, int lopId, int khoaHocId, Date ngayNhapHoc,
			float diemDauVao1, float diemDauVao2, float diemDauVao3, String anhSinhVien) {
		this.sinhVienId = sinhVienId;
		this.maSinhVien = maSinhVien;
		this.hoDem = hoDem;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.cmtnd = cmtnd;
		this.soDienThoai = soDienThoai;
		this.noiSinh = noiSinh;
		this.queQuan = queQuan;
		this.hoKhauThuongTru = hoKhauThuongTru;
		this.noiOHienTai = noiOHienTai;
		this.cheDoUuDai = cheDoUuDai;
		this.danTocId = danTocId;
		this.tonGiaoId = tonGiaoId;
		this.hoTenBo = hoTenBo;
		this.ngheNghiepBo = ngheNghiepBo;
		this.hoTenMe = hoTenMe;
		this.ngheNghiepMe = ngheNghiepMe;
		this.lopId = lopId;
		this.khoaHocId = khoaHocId;
		this.ngayNhapHoc = ngayNhapHoc;
		this.diemDauVao1 = diemDauVao1;
		this.diemDauVao2 = diemDauVao2;
		this.diemDauVao3 = diemDauVao3;
		this.anhSinhVien = anhSinhVien;
		this.tenKhoaHoc = "";
		this.tenLopHoc = "";
		this.chuyenNganhId = -1;
	}


	public int getChuyenNganhId() {
		return chuyenNganhId;
	}

	public void setChuyenNganhId(int chuyenNganhId) {
		this.chuyenNganhId = chuyenNganhId;
	}

	public String getAnhSinhVien() {
		return anhSinhVien;
	}

	public void setAnhSinhVien(String anhSinhVien) {
		this.anhSinhVien = anhSinhVien;
	}

	public int getSinhVienId() {
		return sinhVienId;
	}

	public void setSinhVienId(int sinhVienId) {
		this.sinhVienId = sinhVienId;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getCmtnd() {
		return cmtnd;
	}

	public void setCmtnd(String cmtnd) {
		this.cmtnd = cmtnd;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getNoiSinh() {
		return noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public String getHoKhauThuongTru() {
		return hoKhauThuongTru;
	}

	public void setHoKhauThuongTru(String hoKhauThuongTru) {
		this.hoKhauThuongTru = hoKhauThuongTru;
	}

	public String getNoiOHienTai() {
		return noiOHienTai;
	}

	public void setNoiOHienTai(String noiOHienTai) {
		this.noiOHienTai = noiOHienTai;
	}

	public String getCheDoUuDai() {
		return cheDoUuDai;
	}

	public void setCheDoUuDai(String cheDoUuDai) {
		this.cheDoUuDai = cheDoUuDai;
	}

	public int getDanTocId() {
		return danTocId;
	}

	public void setDanTocId(int danTocId) {
		this.danTocId = danTocId;
	}

	public int getTonGiaoId() {
		return tonGiaoId;
	}

	public void setTonGiaoId(int tonGiaoId) {
		this.tonGiaoId = tonGiaoId;
	}
	
	public String getHoTenBo() {
		return hoTenBo;
	}

	public void setHoTenBo(String hoTenBo) {
		this.hoTenBo = hoTenBo;
	}

	public String getNgheNghiepBo() {
		return ngheNghiepBo;
	}

	public void setNgheNghiepBo(String ngheNghiepBo) {
		this.ngheNghiepBo = ngheNghiepBo;
	}

	public String getHoTenMe() {
		return hoTenMe;
	}

	public void setHoTenMe(String hoTenMe) {
		this.hoTenMe = hoTenMe;
	}

	public String getNgheNghiepMe() {
		return ngheNghiepMe;
	}

	public void setNgheNghiepMe(String ngheNghiepMe) {
		this.ngheNghiepMe = ngheNghiepMe;
	}

	public int getLopId() {
		return lopId;
	}

	public void setLopId(int lopId) {
		this.lopId = lopId;
	}

	public int getKhoaHocId() {
		return khoaHocId;
	}

	public void setKhoaHocId(int khoaHocId) {
		this.khoaHocId = khoaHocId;
	}

	public Date getNgayNhapHoc() {
		return ngayNhapHoc;
	}

	public void setNgayNhapHoc(Date ngayNhapHoc) {
		this.ngayNhapHoc = ngayNhapHoc;
	}

	public float getDiemDauVao1() {
		return diemDauVao1;
	}
	
	public void setDiemDauVao1(float diemDauVao1) {
		this.diemDauVao1 = diemDauVao1;
	}

	public float getDiemDauVao2() {
		return diemDauVao2;
	}

	public void setDiemDauVao2(float diemDauVao2) {
		this.diemDauVao2 = diemDauVao2;
	}

	public float getDiemDauVao3() {
		return diemDauVao3;
	}

	public void setDiemDauVao3(float diemDauVao3) {
		this.diemDauVao3 = diemDauVao3;
	}

	public String getTenLopHoc() {
		return tenLopHoc;
	}

	public void setTenLopHoc(String tenLopHoc) {
		this.tenLopHoc = tenLopHoc;
	}

	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}

}
