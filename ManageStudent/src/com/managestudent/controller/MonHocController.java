package com.managestudent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managestudent.entities.ChuyenNganh;
import managestudent.entities.MonHoc;
import managestudent.logics.impl.ChuyenNganhLogicsImpl;
import managestudent.logics.impl.MonHocLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;
import managestudent.utils.MessageProperties;

/**
 * Servlet implementation class MonHocController
 */
public class MonHocController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonHocController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkLogin(request.getSession())) {
			HttpSession session = request.getSession();
			template = Constant.MONHOC;
			MonHocLogicsImpl monHocLogics = new MonHocLogicsImpl();
			ChuyenNganhLogicsImpl chuyenNganhLogics = new ChuyenNganhLogicsImpl();
			List<MonHoc> lsMonHoc = new ArrayList<MonHoc>();
			List<ChuyenNganh> lsChuyenNganh = new ArrayList<ChuyenNganh>();
			MonHoc monHoc = new MonHoc();
			int limit = Integer.parseInt(MessageProperties.getMessage("limit"));
			int range = Integer.parseInt(MessageProperties.getMessage("range"));
			List<Integer> lsPage = new ArrayList<Integer>();
			int page = 0;
			int totalPage = 0;
			int totalRecords = 0;
			int offset = 0;
			int sortColumn = 1;
			String sortType = "";

			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}

			if(page == 0) {
				page = 1;
			}

			if(request.getParameter("monhocid") != null && request.getParameter("monhocid").length() > 0) {
				try {
					monHoc.setMonHocId(Integer.parseInt(request.getParameter("monhocid")));
					session.setAttribute("monhocid", monHoc.getMonHocId());
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			} else if(session.getAttribute("monhocid") != null) {
				try {
					monHoc.setMonHocId(Integer.parseInt(session.getAttribute("monhocid").toString()));
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			}
			if(request.getParameter("tenmonhoc") != null) {
				monHoc.setTenMonHoc(request.getParameter("tenmonhoc"));
				session.setAttribute("tenmonhoc", monHoc.getTenMonHoc());
			} else if(session.getAttribute("tenmonhoc") != null) {
				monHoc.setTenMonHoc(session.getAttribute("tenmonhoc").toString());
			}
			if(request.getParameter("chuyennganhid") != null && request.getParameter("chuyennganhid").length() > 0) {
				try {
					monHoc.setChuyenNganhId(Integer.parseInt(request.getParameter("chuyennganhid")));
					session.setAttribute("chuyennganhid", monHoc.getChuyenNganhId());
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			} else if(session.getAttribute("chuyennganhid") != null) {
				try {
					monHoc.setChuyenNganhId(Integer.parseInt(session.getAttribute("chuyennganhid").toString()));
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			}
			if(request.getParameter("tenchuyennganh") != null) {
				monHoc.setTenChuyenNganh(request.getParameter("tenchuyennganh"));
				session.setAttribute("tenchuyennganh", monHoc.getTenChuyenNganh());
			} else if(session.getAttribute("tenchuyennganh") != null) {
				monHoc.setTenChuyenNganh(session.getAttribute("tenchuyennganh").toString());
			}

			if(request.getParameter("sortcolumn") != null) {
				if(request.getParameter("sortcolumn").length() > 0) {
					sortColumn = Integer.parseInt(request.getParameter("sortcolumn"));
				}

				request.setAttribute("sortcolumn", sortColumn);
			}
			if(request.getParameter("sorttype") != null) {
				sortType = request.getParameter("sorttype");
				request.setAttribute("sorttype", sortType);
			}

			totalRecords = monHocLogics.getTotalRecords(monHoc);
			offset = (page > 0) ? limit * ((int) page - 1) : 0;

			lsMonHoc = monHocLogics.getAllMonHoc(monHoc, offset, limit, sortColumn, sortType);
			lsChuyenNganh = chuyenNganhLogics.getAllChuyenNganh(new ChuyenNganh(), 0, chuyenNganhLogics.getTotalRecords(new ChuyenNganh()), 1, "ASC");
			lsPage = Common.getListPaging(totalRecords, limit, page);
			totalPage = Common.getTotalPage(totalRecords, limit);

			request.setAttribute("page", page);
	        request.setAttribute("lsPage", lsPage);
	        request.setAttribute("range", range);
	        request.setAttribute("totalPage", totalPage);

			if (lsMonHoc == null) {
				lsMessage.add(MessageErrorProperties.getMessage("error_022"));
				request.setAttribute("showTable", false);
			} else if (lsMonHoc.size() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_001_table"));
				request.setAttribute("showTable", false);
			} else {
				request.setAttribute("lsData", lsMonHoc);
				request.setAttribute("lsChuyenNganh", lsChuyenNganh);
			}
		} else {
			template = Constant.LOGIN;
			lsMessage.add(MessageErrorProperties.getMessage("error_023"));
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
