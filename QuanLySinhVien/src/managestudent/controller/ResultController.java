package managestudent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;
import managestudent.utils.MessageProperties;

/**
 * Servlet implementation class ResultController
 */
public class ResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		List<String> lsMessage = new ArrayList<String>();
		String action = "";

		if(Common.checkLogin(request.getSession())) {
			template = Constant.RESULT;

			if(request.getParameter("add") != null) {
				action = request.getParameter("add");

				if("success".equals(action)) {
					lsMessage.add(MessageProperties.getMessage("msg_001"));
				} else {
					template = Constant.SYSTEM_ERR;
				}
			}
			if(request.getParameter("update") != null) {
				action = request.getParameter("update");

				if("success".equals(action)) {
					lsMessage.add(MessageProperties.getMessage("msg_002"));
				} else {
					template = Constant.SYSTEM_ERR;
				}
			}
			if(request.getParameter("delete") != null) {
				action = request.getParameter("delete");

				if("success".equals(action)) {
					lsMessage.add(MessageProperties.getMessage("msg_003"));
				} else {
					template = Constant.SYSTEM_ERR;
				}
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
