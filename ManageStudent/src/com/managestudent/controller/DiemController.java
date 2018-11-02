/**
 * Copyright(C) K16SE 2014
 *
 * DiemController.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managestudent.entities.ChuyenNganh;
import managestudent.entities.Diem;
import managestudent.entities.DmSinhVien;
import managestudent.entities.HocKy;
import managestudent.entities.KhoaHoc;
import managestudent.entities.LopHoc;
import managestudent.entities.MonHoc;
import managestudent.entities.Nganh;
import managestudent.logics.impl.ChuyenNganhLogicsImpl;
import managestudent.logics.impl.DiemLogicsImpl;
import managestudent.logics.impl.DmSinhVienLogicsImpl;
import managestudent.logics.impl.HocKyLogicsImpl;
import managestudent.logics.impl.KhoaHocLogicsImpl;
import managestudent.logics.impl.LopHocLogicsImpl;
import managestudent.logics.impl.MonHocLogicsImpl;
import managestudent.logics.impl.NganhLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;

/**
 * Servlet implementation class DiemController
 */
public class DiemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiemController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkLogin(request.getSession())) {
			int sinhVienId = -1;
			int hocKyId = -1;

			if((request.getParameter("svid") != null && request.getParameter("svid").length() > 0)) {
				sinhVienId = Integer.parseInt(request.getParameter("svid"));
				if(request.getParameter("hocky") != null && request.getParameter("hocky").length() > 0) {
					hocKyId = Integer.parseInt(request.getParameter("hocky"));
				}

				if(sinhVienId > 0) {
					DmSinhVienLogicsImpl sinhVienLogics = new DmSinhVienLogicsImpl();
					LopHocLogicsImpl lopLogics = new LopHocLogicsImpl();
					NganhLogicsImpl nganhLogics = new NganhLogicsImpl();
					ChuyenNganhLogicsImpl chuyenNganhLogics = new ChuyenNganhLogicsImpl();
					KhoaHocLogicsImpl khoaLogics = new KhoaHocLogicsImpl();
					HocKyLogicsImpl hocKyLogics = new HocKyLogicsImpl();
					DiemLogicsImpl diemLogics = new DiemLogicsImpl();
					MonHocLogicsImpl monHocLogics = new MonHocLogicsImpl();

					List<LopHoc> lsLopHoc = lopLogics.getAllLopHoc(new LopHoc(), 0, lopLogics.getTotalRecords(new LopHoc()), 1, "ASC");
					List<Nganh> lsNganh = nganhLogics.getAllNganh(new Nganh(), 0, nganhLogics.getTotalRecords(new Nganh()), 1, "ASC");
					List<ChuyenNganh> lsChuyenNganh = chuyenNganhLogics.getAllChuyenNganh(new ChuyenNganh(), 0,
							chuyenNganhLogics.getTotalRecords(new ChuyenNganh()), 1, "ASC");
					List<KhoaHoc> lsKhoaHoc = khoaLogics.getAllKhoaHoc(new KhoaHoc(), 0, khoaLogics.getTotalRecords(new KhoaHoc()), 1, "ASC");
					List<HocKy> lsHocKy = hocKyLogics.getAllHocKy(new HocKy(), 0, hocKyLogics.getTotalRecords(new HocKy()), 1, "ASC");
					List<MonHoc> lsMonHoc = monHocLogics.getAllMonHoc(new MonHoc(), 0, monHocLogics.getTotalRecords(new MonHoc()), 1, "ASC");
					List<Diem> lsDiem = new ArrayList<Diem>();
					if(hocKyId <= 0) {
						lsDiem = diemLogics.getDiemBySinhVienId(sinhVienId, lsHocKy.get(0).getHocKyId());
					} else {
						lsDiem = diemLogics.getDiemBySinhVienId(sinhVienId, hocKyId);
					}
					DmSinhVien sinhVien = sinhVienLogics.getSinhVienById(sinhVienId);

					if(sinhVien != null || lsLopHoc.size() <= 0 || lsNganh.size() <= 0  || lsChuyenNganh.size() <= 0 || lsKhoaHoc.size() <= 0) {
						for (LopHoc lop : lsLopHoc) {
							if(lop.getLopHocId() == sinhVien.getLopId()) {
								request.setAttribute("lop", lop.getTenLopHoc());
							}
						}

						int count = 0;
						int nganhId = -1;
						for (ChuyenNganh chuyenNganh : lsChuyenNganh) {
							if(chuyenNganh.getChuyenNganhId() == sinhVien.getChuyenNganhId()) {
								request.setAttribute("chuyennganh", chuyenNganh.getTenChuyenNganh());
								nganhId = chuyenNganh.getNganhId();
							} else {
								count++;
							}
						}
						if(count == lsChuyenNganh.size()) {
							request.setAttribute("chuyennganh", "Không");
						}

						count = 0;
						for (Nganh nganh : lsNganh) {
							if(nganh.getNganhId() == nganhId) {
								request.setAttribute("nganh", nganh.getTenNganh());
							} else {
								count++;
							}
						}
						if(count == lsNganh.size()) {
							request.setAttribute("nganh", "Không");
						}

						for (KhoaHoc khoaHoc : lsKhoaHoc) {
							if(khoaHoc.getKhoaHocId() == sinhVien.getKhoaHocId()) {
								request.setAttribute("khoahoc", khoaHoc.getTenKhoaHoc());
							}
						}

						float diemTongKet = 0;
						int i = 0;
						List<Diem> lsAllDiem = diemLogics.getDiemBySinhVienId(sinhVienId, -1);
						for (Diem diem : lsAllDiem) {
							int tmp = 0;
							tmp += diem.getDiemChuyenCan() * diem.getMonHoc().getHeSoChuyenCan();
							tmp += diem.getDiemGiuaKy() * diem.getMonHoc().getHeSoGiuaKy();
							tmp += diem.getDiemThi() * diem.getMonHoc().getHeSoHocKy();
							diemTongKet += tmp / (diem.getMonHoc().getHeSoChuyenCan() + diem.getMonHoc().getHeSoGiuaKy() + diem.getMonHoc().getHeSoHocKy());
							i++;
						}
						diemTongKet /= i;

						request.setAttribute("diemtongket", diemTongKet);
						request.setAttribute("lsnganh", lsNganh);
						request.setAttribute("lschuyennganh", lsChuyenNganh);
						request.setAttribute("lsmonhoc", lsMonHoc);
						request.setAttribute("lsdiem", lsDiem);
						request.setAttribute("diemcount", lsDiem.size());
						request.setAttribute("lshocky", lsHocKy);
						request.setAttribute("sinhvien", sinhVien);
						template = Constant.DIEM;
					} else {
						template = Constant.SYSTEM_ERR;
					}
				} else {
					template = Constant.SYSTEM_ERR;
				}
			} else {
				template = Constant.SYSTEM_ERR;
			}
		} else {
			lsMessage.add(MessageErrorProperties.getMessage("error_023"));
			template = Constant.LOGIN;
		}

		request.setAttribute("lsMessage", lsMessage);
		RequestDispatcher req = request.getRequestDispatcher(template);
		req.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
