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

import managestudent.entities.DanToc;
import managestudent.logics.impl.DanTocLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;
import managestudent.utils.MessageProperties;

/**
 * Servlet implementation class DanTocController
 */
public class DanTocController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanTocController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> lsMessage = new ArrayList<String>();
		String template = "";

		if(Common.checkLogin(request.getSession())) {
			HttpSession session = request.getSession();
			DanTocLogicsImpl danTocLogics = new DanTocLogicsImpl();
			List<DanToc> lsDanToc = new ArrayList<DanToc>();int limit = Integer.parseInt(MessageProperties.getMessage("limit"));
			int range = Integer.parseInt(MessageProperties.getMessage("range"));
			List<Integer> lsPage = new ArrayList<Integer>();
			int page = 0;
			int totalPage = 0;
			int totalRecords = 0;
			DanToc danToc = new DanToc();
			int offset = 0;
			int sortColumn = 1;
			String sortType = "";

			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}

			if(page == 0) {
				page = 1;
			}

			if(request.getParameter("dantocid") != null) {
				try {
					danToc.setDanTocId(Integer.parseInt(request.getParameter("dantocid")));
					session.setAttribute("dantocid", danToc.getDanTocId());
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			} else if(session.getAttribute("dantocid") != null) {
				try {
					danToc.setDanTocId(Integer.parseInt(session.getAttribute("dantocid").toString()));
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			}
			if(request.getParameter("tendantoc") != null) {
				danToc.setTenDanToc(request.getParameter("tendantoc"));
				session.setAttribute("tendantoc", danToc.getTenDanToc());
			} else if(session.getAttribute("tendantoc") != null) {
				danToc.setTenDanToc(session.getAttribute("tendantoc").toString());
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

			totalRecords = danTocLogics.getTotalRecords(danToc);
			offset = (page > 0) ? limit * ((int) page - 1) : 0;

			lsDanToc = danTocLogics.getAllDanToc(danToc, offset, limit, sortColumn, sortType);
			lsPage = Common.getListPaging(totalRecords, limit, page);
			totalPage = Common.getTotalPage(totalRecords, limit);

			request.setAttribute("page", page);
	        request.setAttribute("lsPage", lsPage);
	        request.setAttribute("range", range);
	        request.setAttribute("totalPage", totalPage);

			if (lsDanToc == null) {
				lsMessage.add(MessageErrorProperties.getMessage("error_022"));
				request.setAttribute("showTable", false);
			} else if (lsDanToc.size() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_001_table"));
				request.setAttribute("showTable", false);
			} else {
				request.setAttribute("lsData", lsDanToc);
			}

			template = Constant.DANTOC;
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
