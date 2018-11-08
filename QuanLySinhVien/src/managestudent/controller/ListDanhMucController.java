/**
 * Copyright(C) K16SE 2014
 *
 * BaseDaoImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managestudent.utils.Common;
import managestudent.utils.Constant;

/**
 * Servlet implementation class ListDanhMucController
 */
public class ListDanhMucController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListDanhMucController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String template = "";

		if (Common.checkLogin(request.getSession())) {
			if (request.getParameter("name") != null) {
				String danhMuc = request.getParameter("name");

				if (danhMuc.equals("chuyennganh")) {
					response.sendRedirect("ChuyenNganh.do");
					return;
				} else if (danhMuc.equals("dantoc")) {
					response.sendRedirect("DanToc.do");
					return;
				} else if (danhMuc.equals("sinhvien")) {
					response.sendRedirect("SinhVien.do");
					return;
				} else if (danhMuc.equals("hocky")) {
					response.sendRedirect("HocKy.do");
					return;
				} else if (danhMuc.equals("khoahoc")) {
					response.sendRedirect("KhoaHoc.do");
					return;
				} else if (danhMuc.equals("lophoc")) {
					response.sendRedirect("LopHoc.do");
					return;
				} else if (danhMuc.equals("monhoc")) {
					response.sendRedirect("MonHoc.do");
					return;
				} else if (danhMuc.equals("nganh")) {
					response.sendRedirect("Nganh.do");
					return;
				} else if (danhMuc.equals("tongiao")) {
					response.sendRedirect("TonGiao.do");
					return;
				} else if(danhMuc.equals("diem")) {
					response.sendRedirect("Diem.do");
					return;
				} else {
					template = Constant.SYSTEM_ERR;
				}
			} else {
				template = Constant.SYSTEM_ERR;
			}
		} else {
			template = Constant.LOGIN;
		}

		RequestDispatcher req = request.getRequestDispatcher(template);
		req.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
