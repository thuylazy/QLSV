/**
 * Copyright(C) K16SE 2014
 *
 * HocKyServicesController.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managestudent.entities.Diem;
import managestudent.entities.HocKy;
import managestudent.logics.impl.DiemLogicsImpl;
import managestudent.logics.impl.HocKyLogicsImpl;

/**
 * Servlet implementation class HocKyServicesController
 */
public class HocKyServicesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HocKyServicesController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hocKyId = -1;
		int sinhVienId = -1;

		if(request.getParameter("hocKyId") != null && request.getParameter("sinhVienId") != null) {
			try {
				hocKyId = Integer.parseInt(request.getParameter("hocKyId"));
				sinhVienId = Integer.parseInt(request.getParameter("sinhVienId"));

				HocKyLogicsImpl hocKyLogics = new HocKyLogicsImpl();
				DiemLogicsImpl diemLogics = new DiemLogicsImpl();

				List<Diem> lsDiem = new ArrayList<Diem>();
				List<HocKy> lsHocKy = hocKyLogics.getAllHocKy(new HocKy(), 0, hocKyLogics.getTotalRecords(new HocKy()), 1, "ASC");
				if(hocKyId <= 0) {
					lsDiem = diemLogics.getDiemBySinhVienId(sinhVienId, lsHocKy.get(0).getHocKyId());
				} else {
					lsDiem = diemLogics.getDiemBySinhVienId(sinhVienId, hocKyId);
				}

				PrintWriter out = response.getWriter();
				StringBuilder json = new StringBuilder();
				json.append("[");
				for (Diem diem : lsDiem) {
					if(json.length() > 1) {
						json.append(",");
					}
					json.append("{\"tenMonHoc\": \"");
					json.append(diem.getMonHoc().getTenMonHoc());
					json.append("\",\"diemChuyenCan\": \"");
					json.append(diem.getDiemChuyenCan());
					json.append("\",\"diemGiuaKy\": \"");
					json.append(diem.getDiemGiuaKy());
					json.append("\",\"diemThi\": \"");
					json.append(diem.getDiemThi());
					json.append("\",\"hscc\": \"");
					json.append(diem.getMonHoc().getHeSoChuyenCan());
					json.append("\",\"hsgk\": \"");
					json.append(diem.getMonHoc().getHeSoGiuaKy());
					json.append("\",\"hshk\": \"");
					json.append(diem.getMonHoc().getHeSoHocKy());
					json.append("\", \"diemId\": \"");
					json.append(diem.getDiemId());
					json.append("\"}");
				}
				json.append("]");

				out.println(json);
			} catch (NumberFormatException e) {
				System.out.println("An error occur: " + e.getMessage());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
