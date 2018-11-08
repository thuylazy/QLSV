package managestudent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managestudent.entities.HocKy;
import managestudent.logics.impl.HocKyLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;
import managestudent.validates.ValidateInfor;

/**
 * Servlet implementation class HocKyProcessController
 */
public class HocKyProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HocKyProcessController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkLogin(request.getSession())) {
			template = Constant.SYSTEM_ERR;
			if(request.getSession().getAttribute("hocky") != null) {
				request.setAttribute("hocky", request.getSession().getAttribute("hocky"));
				template = Constant.HOCKYPROCESS;
			}
			if(request.getParameter("lsMessage") != null) {
				lsMessage.add(request.getParameter("lsMessage"));
				template = Constant.HOCKYPROCESS;
			}
			if(request.getParameter("ref") != null) {
				request.setAttribute("ref", request.getParameter("ref"));
				template = Constant.HOCKYPROCESS;
			}
			if(request.getParameter("id") != null) {
				request.setAttribute("id", request.getParameter("id"));
				template = Constant.HOCKYPROCESS;
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
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkLogin(request.getSession())) {
			if(request.getParameter("submit") != null) {
				HocKy hocKy = setDefaultData(request, response);

				if(request.getAttribute("lsMessage") != null) {
					request.setAttribute("hocky", hocKy);
					RequestDispatcher req = request.getRequestDispatcher(Constant.HOCKYPROCESS);
					req.forward(request, response);
					return;
				}

				if (request.getParameter("ref") != null) {
					if("add".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateHocKyInfor(hocKy, true);
					} else if("update".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateHocKyInfor(hocKy, false);
					}
				}

				if (lsMessage.size() > 0) {
					request.setAttribute("lsMessage", lsMessage);
					request.setAttribute("hocky", hocKy);
					if (request.getParameter("ref") != null) {
						request.setAttribute("ref", request.getParameter("ref"));
					}
					if(request.getParameter("id") != null) {
						request.setAttribute("id", request.getParameter("id"));
					}
					template = Constant.HOCKYPROCESS;
				} else {
					request.getSession().setAttribute("hocky", hocKy);
					if (request.getParameter("ref") != null) {
						String ref = request.getParameter("ref");

						if ("add".equals(ref)) {
							boolean rs = processData(-1, hocKy, true);

							if (rs) {
								//lsMessage.add(MessageProperties.getMessage("msg_001"));
								request.getSession().removeAttribute("hocky");
								response.sendRedirect("Result.do?add=success");
								return;
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else if ("update".equals(ref)) {
							if (request.getParameter("id") != null) {
								try {
									HocKyLogicsImpl hocKyLogics = new HocKyLogicsImpl();
									HocKy hocKyTemp = hocKyLogics.getHocKyById(Integer.parseInt(request.getParameter("id")));

									if(hocKyTemp != null) {
										boolean rs = processData(Integer.parseInt(request.getParameter("id")), hocKy, false);

										if (rs) {
											//lsMessage.add(MessageProperties.getMessage("msg_002"));
											response.sendRedirect("Result.do?update=success");
											return;
										} else {
											template = Constant.SYSTEM_ERR;
										}
									} else {
										template = Constant.SYSTEM_ERR;
									}
								} catch (NumberFormatException e) {
									System.out.println("An error occur: " + e.getMessage());
									lsMessage.add(MessageErrorProperties.getMessage("error_024"));
									template = Constant.HOCKYPROCESS;
								}
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else if("delete".equals(ref)) {
							try {
								if(request.getParameter("id") != null) {
									HocKyLogicsImpl hocKyLogics = new HocKyLogicsImpl();
									HocKy hocKyTemp = hocKyLogics.getHocKyById(Integer.parseInt(request.getParameter("id")));

									if(hocKyTemp != null) {
										boolean rs = hocKyLogics.deleteHocKyById(hocKyTemp.getHocKyId());

										if(rs) {
											response.sendRedirect("Result.do?delete=success");
											return;
										} else {
											template = Constant.SYSTEM_ERR;
										}
									} else {
										template = Constant.SYSTEM_ERR;
									}
								} else {
									template = Constant.SYSTEM_ERR;
								}
							} catch (NumberFormatException e) {
								System.out.println("An error occur: " + e.getMessage());
								lsMessage.add(MessageErrorProperties.getMessage("error_024"));
								template = Constant.HOCKYPROCESS;
							}
						} else {
							template = Constant.SYSTEM_ERR;
						}
					} else {
						template = Constant.SYSTEM_ERR;
					}
				}
			} else {
				doGet(request, response);
				return;
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
	 * Gán dữ liệu vào đối tượng học kỳ
	 *
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return HocKy đối tượng học kỳ
	 */
	protected HocKy setDefaultData(HttpServletRequest request, HttpServletResponse response) {
		HocKy hocKy = new HocKy();
		List<String> lsMessage = new ArrayList<String>();

		try {
			if(request.getParameter("id") != null) {
				hocKy.setHocKyId(Integer.parseInt(request.getParameter("id")));
			}
			if(request.getParameter("tenhocky") != null) {
				hocKy.setTenHocKy(request.getParameter("tenhocky"));
			}
		} catch (NumberFormatException e) {
			System.out.println("An error occur: " + e.getMessage());
			lsMessage.add(MessageErrorProperties.getMessage("error_024"));
			request.setAttribute("lsMessage", lsMessage);
		}

		return hocKy;
	}

	/**
	 * Xử lý dữ liệu vào tầng logics
	 *
	 * @param isAdd true: action add / false: action update
	 * @return true: thành công / false: thất bại
	 */
	protected boolean processData(int hocKyId, HocKy hocKy, boolean isAdd) {
		boolean rs = false;
		HocKyLogicsImpl hocKyLogics = new HocKyLogicsImpl();

		if(isAdd) {
			rs = hocKyLogics.addHocKy(hocKy);
		} else {
			rs = hocKyLogics.updateHocKyById(hocKyId, hocKy);
		}

		return rs;
	}
}
