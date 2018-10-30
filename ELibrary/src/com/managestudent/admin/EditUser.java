package com.managestudent.admin;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.managestudent.beans.UserBean;
import com.managestudent.dao.LibrarianDao;
@WebServlet("/EditLibrarian")
public class EditUser extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String smobile=request.getParameter("mobile");
		long mobile=Long.parseLong(smobile);
		UserBean bean=new UserBean(id,name, email, password, mobile);
		LibrarianDao.update(bean);
		response.sendRedirect("ViewLibrarian");
	}

}
