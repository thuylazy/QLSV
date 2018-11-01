package com.managestudent.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.managestudent.beans.InforBean;
import com.managestudent.dao.InforDao;
@WebServlet("/AddInfor")
public class AddInfor extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Infor Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navuser.html").include(request, response);
		
		out.println("<div class='container'>");
		String gender = request.getParameter("gender");
		String addr = request.getParameter("addr");
		String bday1 = request.getParameter("bday1");
		try {
			java.util.Date bday = new SimpleDateFormat("yyyy-MM-dd").parse(bday1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InforBean bean=new InforBean();
		int i = InforDao.save(bean);
		if(i>0){
			out.println("<h3>Add information successfully</h3>");
		}
		request.getRequestDispatcher("addinforform.html").include(request, response);
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
