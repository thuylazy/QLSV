package com.managestudent.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.managestudent.beans.InforBean;
import com.managestudent.dao.InforDao;

@WebServlet("/ViewInfor")
public class ViewInfor extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Book</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navuser.html").include(request, response);

		out.println("<div class='container'>");

		List<InforBean> list = InforDao.view();

		out.println("<table class='table table-bordered table-striped'>");
		out.println(
				"<tr><th>Name</th><th>Birthday</th><th>Gender</th><th>Address</th></tr>");
		for (InforBean bean : list) {
			out.println("<tr><td><a href = ''</td><td>" + bean.getBday()
					+ "</td><td>" + bean.getGender() + "</td><td>" + bean.getAddr() + "</td></tr>");
		}
		out.println("</table>");

		out.println("</div>");

		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
}
