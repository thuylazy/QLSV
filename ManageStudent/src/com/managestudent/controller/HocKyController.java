/**
 * Copyright(C) K16SE 2014
 *
 * HocKyController.java, Aug 26, 2014 HaVH
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
import javax.servlet.http.HttpSession;

import managestudent.entities.HocKy;
import managestudent.logics.impl.HocKyLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;
import managestudent.utils.MessageProperties;

/**
 * Servlet implementation class HocKyController
 */
public class HocKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HocKyController() {
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
			template = Constant.HOCKY;
			HocKyLogicsImpl hocKyLogics = new HocKyLogicsImpl();
			List<HocKy> lsHocKy = new ArrayList<HocKy>();
			HocKy hocKy = new HocKy();
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

			if(request.getParameter("hockyid") != null) {
				try {
					hocKy.setHocKyId(Integer.parseInt(request.getParameter("hockyid")));
					session.setAttribute("hockyid", hocKy.getHocKyId());
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			} else if(session.getAttribute("hockyid") != null) {
				try {
					hocKy.setHocKyId(Integer.parseInt(session.getAttribute("hockyid").toString()));
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			}
			if(request.getParameter("tenhocky") != null) {
				hocKy.setTenHocKy(request.getParameter("tenhocky"));
				request.setAttribute("tenhocky", hocKy.getTenHocKy());
			} else if(session.getAttribute("tenhocky") != null) {
				hocKy.setTenHocKy(session.getAttribute("tenhocky").toString());
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

			totalRecords = hocKyLogics.getTotalRecords(hocKy);
			offset = (page > 0) ? limit * ((int) page - 1) : 0;

			lsHocKy = hocKyLogics.getAllHocKy(hocKy, offset, limit, sortColumn, sortType);
			lsPage = Common.getListPaging(totalRecords, limit, page);
			totalPage = Common.getTotalPage(totalRecords, limit);

			request.setAttribute("page", page);
	        request.setAttribute("lsPage", lsPage);
	        request.setAttribute("range", range);
	        request.setAttribute("totalPage", totalPage);

			if (lsHocKy == null) {
				lsMessage.add(MessageErrorProperties.getMessage("error_022"));
				request.setAttribute("showTable", false);
			} else if (lsHocKy.size() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_001_table"));
				request.setAttribute("showTable", false);
			} else {
				request.setAttribute("lsData", lsHocKy);
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
