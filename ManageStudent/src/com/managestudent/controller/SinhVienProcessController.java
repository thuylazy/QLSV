package com.managestudent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managestudent.entities.DanToc;
import managestudent.entities.DmSinhVien;
import managestudent.entities.HeDaoTao;
import managestudent.entities.KhoaHoc;
import managestudent.entities.LopHoc;
import managestudent.entities.QuocTich;
import managestudent.entities.TonGiao;
import managestudent.logics.impl.DanTocLogicsImpl;
import managestudent.logics.impl.DmSinhVienLogicsImpl;
import managestudent.logics.impl.HeDaoTaoLogicsImpl;
import managestudent.logics.impl.KhoaHocLogicsImpl;
import managestudent.logics.impl.LopHocLogicsImpl;
import managestudent.logics.impl.QuocTichLogicsImpl;
import managestudent.logics.impl.TonGIaoLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.Global;
import managestudent.utils.MessageErrorProperties;
import managestudent.validates.ValidateInfor;


public class SinhVienProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public SinhVienProcessController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkLogin(request.getSession())) {
			template = Constant.SYSTEM_ERR;
			loadData(request, response);
			if(request.getSession().getAttribute("sinhvien") != null) {
				request.setAttribute("sinhvien", request.getSession().getAttribute("sinhvien"));
				template = Constant.SINHVIENPROCESS;
			}
			if(request.getParameter("lsMessage") != null) {
				lsMessage.add(request.getParameter("lsMessage"));
				template = Constant.SINHVIENPROCESS;
			}
			if(request.getParameter("ref") != null) {
				request.setAttribute("ref", request.getParameter("ref"));
				template = Constant.SINHVIENPROCESS;
			}
			if(request.getParameter("id") != null) {
				request.setAttribute("id", request.getParameter("id"));
				template = Constant.SINHVIENPROCESS;
			}

		} else {
			template = Constant.LOGIN;
			lsMessage.add(MessageErrorProperties.getMessage("error_023"));
		}

		request.setAttribute("lsMessage", lsMessage);
		RequestDispatcher req = request.getRequestDispatcher(template);
		req.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkLogin(request.getSession())) {
			loadData(request, response);
			if(request.getParameter("submit") != null) {
				DmSinhVien sinhVien = setDefaultData(request, response);

				if(request.getAttribute("lsMessage") != null) {
					request.setAttribute("sinhvien", sinhVien);
					RequestDispatcher req = request.getRequestDispatcher(Constant.SINHVIENPROCESS);
					req.forward(request, response);
					return;
				}

				if (request.getParameter("ref") != null) {
					if("add".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateSinhVienInfor(sinhVien, true);
					} else if("update".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateSinhVienInfor(sinhVien, false);
					}
				}

				if (lsMessage.size() > 0) {
					request.setAttribute("lsMessage", lsMessage);
					request.setAttribute("sinhvien", sinhVien);
					if (request.getParameter("ref") != null) {
						request.setAttribute("ref", request.getParameter("ref"));
					}
					if(request.getParameter("id") != null) {
						request.setAttribute("id", request.getParameter("id"));
					}
					template = Constant.SINHVIENPROCESS;
				} else {
					request.getSession().setAttribute("sinhvien", sinhVien);
					if (request.getParameter("ref") != null) {
						String ref = request.getParameter("ref");

						if ("add".equals(ref)) {
							boolean rs = processData(-1, sinhVien, true);

							if (rs) {
								//lsMessage.add(MessageProperties.getMessage("msg_001"));
								request.getSession().removeAttribute("sinhvien");
								response.sendRedirect("Result.do?add=success");
								return;
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else if ("update".equals(ref)) {
							if (request.getParameter("id") != null) {
								DmSinhVienLogicsImpl sinhVienLogics = new DmSinhVienLogicsImpl();
								try {
									DmSinhVien sinhVienTemp = sinhVienLogics.getSinhVienById(Integer.parseInt(request.getParameter("id")));

									if(sinhVienTemp != null) {
										boolean rs = processData(Integer.parseInt(request.getParameter("id")), sinhVien, false);

										if (rs) {
											//lsMessage.add(MessageProperties.getMessage("msg_002"));
											response.sendRedirect("Result.do?update=success");
											return;
										} else {
											template = Constant.SYSTEM_ERR;
										}
									} else {
										template = Constant.SYSTEM_ERR;
									}
								} catch (NumberFormatException e) {
									System.out.println("An error occur: " + e.getMessage());
									lsMessage.add(MessageErrorProperties.getMessage("error_024"));
									template = Constant.SINHVIENPROCESS;
								}
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else if("delete".equals(ref)) {
							try {
								if(request.getParameter("id") != null) {
									DmSinhVienLogicsImpl sinhVienLogics = new DmSinhVienLogicsImpl();
									DmSinhVien sinhVienTemp = sinhVienLogics.getSinhVienById(Integer.parseInt(request.getParameter("id")));

									if(sinhVienTemp != null) {
										boolean rs = sinhVienLogics.deleteSinhVienById(sinhVienTemp.getSinhVienId());

										if(rs) {
											response.sendRedirect("Result.do?delete=success");
											return;
										} else {
											template = Constant.SYSTEM_ERR;
										}
									} else {
										template = Constant.SYSTEM_ERR;
									}
								} else {
									template = Constant.SYSTEM_ERR;
								}
							} catch (NumberFormatException e) {
								System.out.println("An error occur: " + e.getMessage());
								lsMessage.add(MessageErrorProperties.getMessage("error_024"));
								template = Constant.SINHVIENPROCESS;
							}
						} else {
							template = Constant.SYSTEM_ERR;
						}
					} else {
						template = Constant.SYSTEM_ERR;
					}
				}
			} else {
				doGet(request, response);
				return;
			}
		} else {
			template = Constant.LOGIN;
			lsMessage.add(MessageErrorProperties.getMessage("error_023"));
		}

		request.setAttribute("lsMessage", lsMessage);
		RequestDispatcher req = request.getRequestDispatcher(template);
		req.forward(request, response);
	}


	protected void loadData(HttpServletRequest request, HttpServletResponse response) {
		DanTocLogicsImpl danTocLogics = new DanTocLogicsImpl();
		TonGIaoLogicsImpl tonGiaoLogics = new TonGIaoLogicsImpl();
		QuocTichLogicsImpl quocTichLogics = new QuocTichLogicsImpl();
		HeDaoTaoLogicsImpl hdtLogics = new HeDaoTaoLogicsImpl();
		LopHocLogicsImpl lopHocLogics = new LopHocLogicsImpl();
		KhoaHocLogicsImpl khoaHocLogics = new KhoaHocLogicsImpl();

		request.setAttribute("lsDanToc", danTocLogics.getAllDanToc(new DanToc(), 0, danTocLogics.getTotalRecords(new DanToc()), 1, "ASC"));
		request.setAttribute("lsTonGiao", tonGiaoLogics.getAllTonGiao(new TonGiao(), 0, tonGiaoLogics.getTotalRecords(new TonGiao()), 1, "ASC"));
		request.setAttribute("lsQuocTich", quocTichLogics.getAllQuocTich(new QuocTich(), 0, quocTichLogics.getTotalRecords(new QuocTich()), 1, "ASC"));
		request.setAttribute("lsHdt", hdtLogics.getAllHeDaoTao(new HeDaoTao(), 0, hdtLogics.getTotalRecords(new HeDaoTao()), 1, "ASC"));
		request.setAttribute("lsLop", lopHocLogics.getAllLopHoc(new LopHoc(), 0, lopHocLogics.getTotalRecords(new LopHoc()), 1, "ASC"));
		request.setAttribute("lsKhoaHoc", khoaHocLogics.getAllKhoaHoc(new KhoaHoc(), 0, khoaHocLogics.getTotalRecords(new KhoaHoc()), 1, "ASC"));
	}


	protected DmSinhVien setDefaultData(HttpServletRequest request, HttpServletResponse response) {
		DmSinhVien sinhVien = new DmSinhVien();
		List<String> lsMessage = new ArrayList<String>();

		try {
			if(request.getParameter("id") != null) {
				sinhVien.setSinhVienId(Integer.parseInt(request.getParameter("id")));
			}
			if(request.getParameter("masinhvien") != null && request.getParameter("masinhvien").length() > 0) {
				sinhVien.setMaSinhVien(request.getParameter("masinhvien"));
			}
			if(request.getParameter("hodem") != null && request.getParameter("hodem").length() > 0) {
				sinhVien.setHoDem(request.getParameter("hodem"));
			}
			if(request.getParameter("ten") != null && request.getParameter("ten").length() > 0) {
				sinhVien.setTen(request.getParameter("ten"));
			}
			if(request.getParameter("ngaysinh") != null && request.getParameter("ngaysinh").length() > 0) {
				sinhVien.setNgaySinh(Global.ngaySinh);
				Global.ngaySinh = new Date();
				//sinhVien.setNgaySinh(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngaysinh")));
			}
			if(request.getParameter("gioitinh") != null && request.getParameter("gioitinh").length() > 0) {
				sinhVien.setGioiTinh(Integer.parseInt(request.getParameter("gioitinh")));
			}
			if(request.getParameter("cmtnd") != null && request.getParameter("cmtnd").length() > 0) {
				sinhVien.setCmtnd(request.getParameter("cmtnd"));
			}
			if(request.getParameter("sodienthoai") != null && request.getParameter("sodienthoai").length() > 0) {
				sinhVien.setSoDienThoai(request.getParameter("sodienthoai"));
			}
			if(request.getParameter("noisinh") != null && request.getParameter("noisinh").length() > 0) {
				sinhVien.setNoiSinh(request.getParameter("noisinh"));
			}
			if(request.getParameter("quequan") != null && request.getParameter("quequan").length() > 0) {
				sinhVien.setQueQuan(request.getParameter("quequan"));
			}
			if(request.getParameter("hokhauthuongtru") != null && request.getParameter("hokhauthuongtru").length() > 0) {
				sinhVien.setHoKhauThuongTru(request.getParameter("hokhauthuongtru"));
			}
			if(request.getParameter("noiohientai") != null && request.getParameter("noiohientai").length() > 0) {
				sinhVien.setNoiOHienTai(request.getParameter("noiohientai"));
			}
			if(request.getParameter("chedouudai") != null && request.getParameter("chedouudai").length() > 0) {
				sinhVien.setCheDoUuDai(request.getParameter("chedouudai"));
			}
			if(request.getParameter("dantoc") != null && request.getParameter("dantoc").length() > 0) {
				sinhVien.setDanTocId(Integer.parseInt(request.getParameter("dantoc")));
			}
			if(request.getParameter("tongiao") != null && request.getParameter("tongiao").length() > 0) {
				sinhVien.setTonGiaoId(Integer.parseInt(request.getParameter("tongiao")));
			}
			if(request.getParameter("quoctich") != null && request.getParameter("quoctich").length() > 0) {
				sinhVien.setQuocTichId(Integer.parseInt(request.getParameter("quoctich")));
			}
			if(request.getParameter("hotenbo") != null && request.getParameter("hotenbo").length() > 0) {
				sinhVien.setHoTenBo(request.getParameter("hotenbo"));
			}
			if(request.getParameter("nghenghiepbo") != null && request.getParameter("nghenghiepbo").length() > 0) {
				sinhVien.setNgheNghiepBo(request.getParameter("nghenghiepbo"));
			}
			if(request.getParameter("hotenme") != null && request.getParameter("hotenme").length() > 0) {
				sinhVien.setHoTenMe(request.getParameter("hotenme"));
			}
			if(request.getParameter("nghenghiepme") != null && request.getParameter("nghenghiepme").length() > 0) {
				sinhVien.setNgheNghiepMe(request.getParameter("nghenghiepme"));
			}
			if(request.getParameter("hedaotao") != null && request.getParameter("hedaotao").length() > 0) {
				sinhVien.setHeDtId(Integer.parseInt(request.getParameter("hedaotao")));
			}
			if(request.getParameter("lophoc") != null && request.getParameter("lophoc").length() > 0) {
				sinhVien.setLopId(Integer.parseInt(request.getParameter("lophoc")));
			}
			if(request.getParameter("khoahoc") != null && request.getParameter("khoahoc").length() > 0) {
				sinhVien.setKhoaHocId(Integer.parseInt(request.getParameter("khoahoc")));
			}
			if(request.getParameter("ngaynhaphoc") != null && request.getParameter("ngaynhaphoc").length() > 0) {
				sinhVien.setNgayNhapHoc(Global.ngayNhapHoc);
				Global.ngayNhapHoc = new Date();
				//sinhVien.setNgayNhapHoc(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngaynhaphoc")));
			}
			if(request.getParameter("diemdauvao1") != null && request.getParameter("diemdauvao1").length() > 0) {
				sinhVien.setDiemDauVao1(Float.parseFloat(request.getParameter("diemdauvao1")));
			}
			if(request.getParameter("diemdauvao2") != null && request.getParameter("diemdauvao2").length() > 0) {
				sinhVien.setDiemDauVao2(Float.parseFloat(request.getParameter("diemdauvao2")));
			}
			if(request.getParameter("diemdauvao3") != null && request.getParameter("diemdauvao3").length() > 0) {
				sinhVien.setDiemDauVao3(Float.parseFloat(request.getParameter("diemdauvao3")));
			}
			if(request.getParameter("anhsinhvien") != null && request.getParameter("anhsinhvien").length() > 0) {
				sinhVien.setAnhSinhVien(request.getParameter("anhsinhvien"));
			}
		} catch (NumberFormatException e) {
			System.out.println("An error occur: " + e.getMessage());
			lsMessage.add(MessageErrorProperties.getMessage("error_024"));
			request.setAttribute("lsMessage", lsMessage);
		}

		return sinhVien;
	}

	protected boolean processData(int sinhVienId, DmSinhVien sinhVien, boolean isAdd) {
		boolean rs = false;
		DmSinhVienLogicsImpl sinhVienLogics = new DmSinhVienLogicsImpl();

		if(isAdd) {
			rs = sinhVienLogics.addSinhVien(sinhVien);
		} else {
			rs = sinhVienLogics.updateSinhVienById(sinhVienId, sinhVien);
		}

		return rs;
	}
}
