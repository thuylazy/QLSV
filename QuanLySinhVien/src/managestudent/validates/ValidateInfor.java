
package managestudent.validates;

import java.util.ArrayList;
import java.util.List;

import managestudent.entities.ChuyenNganh;
import managestudent.entities.DanToc;
import managestudent.entities.DmSinhVien;
import managestudent.entities.HocKy;
import managestudent.entities.KhoaHoc;
import managestudent.entities.LopHoc;
import managestudent.entities.MonHoc;
import managestudent.entities.Nganh;
import managestudent.entities.TonGiao;
//import managestudent.logics.impl.ChuyenNganhLogicsImpl;
//import managestudent.logics.impl.DmSinhVienLogicsImpl;
//import managestudent.logics.impl.HeDaoTaoLogicsImpl;
//import managestudent.logics.impl.NganhLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.MessageErrorProperties;

public class ValidateInfor {

	public static List<String> validateNganhInfor(Nganh nganh, boolean isAdd) {
		List<String> lsMessage = new ArrayList<String>();
//		NganhLogicsImpl nganhLogics = new NganhLogicsImpl();
		String maNganh = nganh.getMaNganh();
		String tenNganh = nganh.getTenNganh();

		if(Common.checkNull(maNganh)) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_manganh"));
		}
//		else {
//			if(isAdd) {
//				if(nganhLogics.getNganhByMaNganh(maNganh) != null) {
//					lsMessage.add(MessageErrorProperties.getMessage("error_003_manganh"));
//				}
//			} else {
//				if(nganhLogics.getNganhByMaNganh(maNganh) == null) {
//					lsMessage.add(MessageErrorProperties.getMessage("error_004_manganh"));
//				}
//			}
//		}
		if(Common.checkNull(tenNganh)) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_tennganh"));
		}

		return lsMessage;
	}

	public static List<String> validateChuyenNganhInfor(ChuyenNganh cn, boolean isAdd) {
		List<String> lsMessage = new ArrayList<String>();
//		ChuyenNganhLogicsImpl chuyenNganhLogics = new ChuyenNganhLogicsImpl();

		if(Common.checkNull(cn.getMaChuyenNganh())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_machuyennganh"));
		}
//		else {
//			if(isAdd) {
//				if(chuyenNganhLogics.getChuyenNganhByMaCN(cn.getMaChuyenNganh()) != null) {
//					lsMessage.add(MessageErrorProperties.getMessage("error_003_machuyennganh"));
//				}
//			} else {
//				if(chuyenNganhLogics.getChuyenNganhByMaCN(cn.getMaChuyenNganh()) == null) {
//					lsMessage.add(MessageErrorProperties.getMessage("error_004_machuyennganh"));
//				}
//			}
//		}
		if(Common.checkNull(cn.getTenChuyenNganh())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_tenchuyennganh"));
		}
		if(cn.getNganhId() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_002_nganh"));
		}

		return lsMessage;
	}

	public static List<String> validateDanTocInfor(DanToc danToc, boolean isAdd) {
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkNull(danToc.getTenDanToc())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_tendantoc"));
		}
		if(!isAdd) {
			if(danToc.getDanTocId() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_004_dantocid"));
			}
		}

		return lsMessage;
	}

	public static List<String> validateHocKyInfor(HocKy hocKy, boolean isAdd) {
		List<String> lsMessage = new ArrayList<String>();

		if(!isAdd) {
			if(hocKy.getHocKyId() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_004_hockyid"));
			}
		}
		if(Common.checkNull(hocKy.getTenHocKy())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_tenhocky"));
		}

		return lsMessage;
	}


	public static List<String> validateKhoaHocInfor(KhoaHoc khoaHoc, boolean isAdd) {
		List<String> lsMessage = new ArrayList<String>();

		if(!isAdd) {
			if(khoaHoc.getKhoaHocId() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_004_khoahocid"));
			}
		}
		if(Common.checkNull(khoaHoc.getTenKhoaHoc())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_tenkhoahoc"));
		}

		return lsMessage;
	}

	public static List<String> validateLopHocInfor(LopHoc lopHoc, boolean isAdd) {
		List<String> lsMessage = new ArrayList<String>();

		if(!isAdd) {
			if(lopHoc.getLopHocId() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_004_lophocid"));
			}
		}
		if(Common.checkNull(lopHoc.getTenLopHoc())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_tenlophoc"));
		}

		return lsMessage;
	}

	public static List<String> validateMonHocInfor(MonHoc monHoc, boolean isAdd) {
		List<String> lsMessage = new ArrayList<String>();

		if(!isAdd) {
			if(monHoc.getMonHocId() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_004_monhocid"));
			}
		}
		if(Common.checkNull(monHoc.getTenMonHoc())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_tenmonhoc"));
		}
		if(Common.checkNull(monHoc.getSoTrinh())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_sotrinh"));
		} else if(!Common.isNumberHalfSize(monHoc.getSoTrinh())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_020_sotrinh"));
		} else if (Integer.parseInt(monHoc.getSoTrinh()) < 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_020_sotrinh"));
		}
		if(monHoc.getHeSoChuyenCan() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_020_hesochuyencan"));
		}
		if(monHoc.getHeSoGiuaKy() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_020_hesogiuaky"));
		}
		if(monHoc.getHeSoHocKy() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_020_hesohocky"));
		}
		if(monHoc.getChuyenNganhId() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_002_chuyennganh"));
		}

		return lsMessage;
	}

	public static List<String> validateSinhVienInfor(DmSinhVien sinhVien, boolean isAdd) {
		List<String> lsMessage = new ArrayList<String>();
//		DmSinhVienLogicsImpl sinhVienLogics = new DmSinhVienLogicsImpl();

		if(!isAdd) {
			if(sinhVien.getSinhVienId() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_004_sinhvienid"));
			}
		}
		if(Common.checkNull(sinhVien.getMaSinhVien())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_masinhvien"));
		}
//		else if(sinhVienLogics.getSinhVienByMaSinhVien(sinhVien.getMaSinhVien()) != null) {
//			if(isAdd) {
//				lsMessage.add(MessageErrorProperties.getMessage("error_003_masinhvien"));
//			}
//		} else if(sinhVienLogics.getSinhVienByMaSinhVien(sinhVien.getMaSinhVien()) != null) {
//			if(!isAdd) {
//				lsMessage.add(MessageErrorProperties.getMessage("error_004_masinhvien"));
//			}
//		}
		if(Common.checkNull(sinhVien.getHoDem())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_hodem"));
		}
		if(Common.checkNull(sinhVien.getTen())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_ten"));
		}
		if(Common.checkNull(sinhVien.getCmtnd())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_cmtnd"));
		}
		if(Common.checkNotValidPhone(sinhVien.getSoDienThoai())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_005_sodienthoai"));
		}
		if(Common.checkNull(sinhVien.getNoiSinh())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_noisinh"));
		}
		if(Common.checkNull(sinhVien.getQueQuan())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_quequan"));
		}
		if(Common.checkNull(sinhVien.getHoKhauThuongTru())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_hokhauthuongtru"));
		}
		if(Common.checkNull(sinhVien.getNoiOHienTai())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_noiohientai"));
		}
		if(Common.checkNull(sinhVien.getCheDoUuDai())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_chedouudai"));
		}
		if(sinhVien.getDanTocId() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_004_dantocid"));
		}
		if(sinhVien.getTonGiaoId() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_004_tongiaoid"));
		}
		if(Common.checkNull(sinhVien.getHoTenBo())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_hotenbo"));
		}
		if(Common.checkNull(sinhVien.getNgheNghiepBo())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_nghenghiepbo"));
		}
		if(Common.checkNull(sinhVien.getHoTenMe())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_hotenme"));
		}
		if(Common.checkNull(sinhVien.getNgheNghiepMe())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_nghenghiepme"));
		}
		if(sinhVien.getLopId() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_004_lophocid"));
		}
		if(sinhVien.getKhoaHocId() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_004_khoahocid"));
		}
		if(sinhVien.getDiemDauVao2() < 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_020_diemdauvao1"));
		}
		if(sinhVien.getDiemDauVao2() < 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_020_diemdauvao2"));
		}
		if(sinhVien.getDiemDauVao3() < 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_020_diemdauvao3"));
		}

		return lsMessage;
	}



	public static List<String> validateTonGiaoInfor(TonGiao tonGiao, boolean isAdd) {
		List<String> lsMessage = new ArrayList<String>();

		if(!isAdd) {
			if(tonGiao.getTonGiaoId() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_004_tongiaoid"));
			}
		}
		if(Common.checkNull(tonGiao.getTenTonGiao())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_tentongiao"));
		}

		return lsMessage;
	}
}
