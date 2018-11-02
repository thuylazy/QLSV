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
import managestudent.entities.Nganh;
import managestudent.logics.impl.ChuyenNganhLogicsImpl;
import managestudent.logics.impl.NganhLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;

/**
 * Servlet implementation class ChuyenNganhDetailController
 */
public class ChuyenNganhDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChuyenNganhDetailController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkLogin(request.getSession())) {
			if(request.getParameter("id") != null && request.getParameter("id").length() > 0) {
				try {
					int chuyenNganhId = Integer.parseInt(request.getParameter("id"));
					ChuyenNganhLogicsImpl chuyenNganhLogics = new ChuyenNganhLogicsImpl();
					NganhLogicsImpl nganhLogics = new NganhLogicsImpl();
					ChuyenNganh cn = null;

					if((cn = chuyenNganhLogics.getChuyenNganhById(chuyenNganhId)) != null) {
						request.getSession().setAttribute("chuyennganh", cn);
						request.setAttribute("id", request.getParameter("id"));
						request.setAttribute("ref", request.getParameter("ref"));
						request.setAttribute("lsNganh", nganhLogics.getAllNganh(new Nganh(), 0, nganhLogics.getTotalRecords(new Nganh()), 1, "ASC"));
						template = Constant.CHUYENNGANHDETAIL;
					} else {
						template = Constant.SYSTEM_ERR;
					}
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
					template = Constant.SYSTEM_ERR;
				}
			} else {
				template = Constant.SYSTEM_ERR;
			}
		} else {
			template = Constant.LOGIN;
			lsMessage.add(MessageErrorProperties.getMessage("error_023"));
		}

		request.setAttribute("lsMessage", lsMessage);
		RequestDispatcher req = request.getRequestDispatcher(template);
		req.forward(request, response);
	}

}
