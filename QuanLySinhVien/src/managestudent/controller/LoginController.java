/**
 * Copyright(C) K16SE 2014
 *
 * LoginController.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managestudent.utils.Constant;
import managestudent.validates.ValidateUsers;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher req = request.getRequestDispatcher(Constant.LOGIN);
		req.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        List<String> lsErrMessage = new ArrayList<String>();
        String template = "";

        String loginId = request.getParameter("loginId").toString();
        String password = request.getParameter("password").toString();

        // set data into session
        session.setAttribute("loginId", loginId);
        session.setAttribute("password", password);

        // validate
        try {
			lsErrMessage = ValidateUsers.validateLogin(loginId, password);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

        if (lsErrMessage.size() > 0) { // go to page login case error
            template = Constant.LOGIN;
        } else {
        	response.sendRedirect("DashBoard.do");
        	return;
        }
        // Set lsErrMessage to request
        request.setAttribute("lsMessage", lsErrMessage);

        RequestDispatcher req = request.getRequestDispatcher(template);
        req.forward(request, response);
	}

}
