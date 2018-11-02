/**
 * Copyright(C) K16SE 2014
 *
 * DashBoardController.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managestudent.utils.Common;
import managestudent.utils.Constant;

/**
 * Servlet implementation class DashBoardController
 */
public class DashBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashBoardController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		String contextPath = request.getContextPath();

		if(Common.checkLogin(request.getSession())) {
			Object loginId = request.getSession().getAttribute("loginId");
			request.getSession().invalidate();

			request.getSession().setAttribute("loginId", loginId);
			template = Constant.DASHBOARD;
		} else {
			response.sendRedirect(contextPath + "/Login.do");
			return;
		}

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
