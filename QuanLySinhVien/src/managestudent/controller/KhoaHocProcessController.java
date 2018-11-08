package managestudent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managestudent.entities.KhoaHoc;
import managestudent.logics.impl.KhoaHocLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;
import managestudent.validates.ValidateInfor;

/**
 * Servlet implementation class KhoaHocProcessController
 */
public class KhoaHocProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhoaHocProcessController() {
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
			if(request.getSession().getAttribute("khoahoc") != null) {
				request.setAttribute("khoahoc", request.getSession().getAttribute("khoahoc"));
				template = Constant.KHOAHOCPROCESS;
			}
			if(request.getParameter("lsMessage") != null) {
				lsMessage.add(request.getParameter("lsMessage"));
				template = Constant.KHOAHOCPROCESS;
			}
			if(request.getParameter("ref") != null) {
				request.setAttribute("ref", request.getParameter("ref"));
				template = Constant.KHOAHOCPROCESS;
			}
			if(request.getParameter("id") != null) {
				request.setAttribute("id", request.getParameter("id"));
				template = Constant.KHOAHOCPROCESS;
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
				KhoaHoc khoaHoc = setDefaultData(request, response);

				if(request.getAttribute("lsMessage") != null) {
					request.setAttribute("khoahoc", khoaHoc);
					RequestDispatcher req = request.getRequestDispatcher(Constant.KHOAHOCPROCESS);
					req.forward(request, response);
					return;
				}

				if (request.getParameter("ref") != null) {
					if("add".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateKhoaHocInfor(khoaHoc, true);
					} else if("update".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateKhoaHocInfor(khoaHoc, false);
					}
				}

				if (lsMessage.size() > 0) {
					request.setAttribute("lsMessage", lsMessage);
					request.setAttribute("khoahoc", khoaHoc);
					if (request.getParameter("ref") != null) {
						request.setAttribute("ref", request.getParameter("ref"));
					}
					if(request.getParameter("id") != null) {
						request.setAttribute("id", request.getParameter("id"));
					}
					template = Constant.KHOAHOCPROCESS;
				} else {
					request.getSession().setAttribute("khoahoc", khoaHoc);
					if (request.getParameter("ref") != null) {
						String ref = request.getParameter("ref");

						if ("add".equals(ref)) {
							boolean rs = processData(-1, khoaHoc, true);

							if (rs) {
								//lsMessage.add(MessageProperties.getMessage("msg_001"));
								request.getSession().removeAttribute("khoahoc");
								response.sendRedirect("Result.do?add=success");
								return;
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else if ("update".equals(ref)) {
							if (request.getParameter("id") != null) {
								try {
									KhoaHocLogicsImpl khoaHocLogics = new KhoaHocLogicsImpl();
									KhoaHoc khoaHocTemp = khoaHocLogics.getKhoaHocById(Integer.parseInt(request.getParameter("id")));

									if(khoaHocTemp != null) {
										boolean rs = processData(Integer.parseInt(request.getParameter("id")), khoaHoc, false);

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
									template = Constant.KHOAHOCPROCESS;
								}
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else if("delete".equals(ref)) {
							try {
								if(request.getParameter("id") != null) {
									KhoaHocLogicsImpl khoaHocLogics = new KhoaHocLogicsImpl();
									KhoaHoc khoaHocTemp = khoaHocLogics.getKhoaHocById(Integer.parseInt(request.getParameter("id")));

									if(khoaHocTemp != null) {
										boolean rs = khoaHocLogics.deleteKhoaHocById(khoaHocTemp.getKhoaHocId());

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
								template = Constant.KHOAHOCPROCESS;
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
	 * Gán dữ liệu vào đối tượng khóa học
	 *
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return KhoaHoc đối tượng khóa học
	 */
	protected KhoaHoc setDefaultData(HttpServletRequest request, HttpServletResponse response) {
		KhoaHoc khoaHoc = new KhoaHoc();
		List<String> lsMessage = new ArrayList<String>();

		try {
			if(request.getParameter("id") != null) {
				khoaHoc.setKhoaHocId(Integer.parseInt(request.getParameter("id")));
			}
			if(request.getParameter("tenkhoahoc") != null) {
				khoaHoc.setTenKhoaHoc(request.getParameter("tenkhoahoc"));
			}
		} catch (NumberFormatException e) {
			System.out.println("An error occur: " + e.getMessage());
			lsMessage.add(MessageErrorProperties.getMessage("error_024"));
			request.setAttribute("lsMessage", lsMessage);
		}

		return khoaHoc;
	}

	/**
	 * Xử lý dữ liệu vào tầng logics
	 *
	 * @param isAdd true: action add / false: action update
	 * @return true: thành công / false: thất bại
	 */
	protected boolean processData(int khoaHocId, KhoaHoc khoaHoc, boolean isAdd) {
		boolean rs = false;
		KhoaHocLogicsImpl khoaHocLogics = new KhoaHocLogicsImpl();

		if(isAdd) {
			rs = khoaHocLogics.addKhoaHoc(khoaHoc);
		} else {
			rs = khoaHocLogics.updateKhoaHocById(khoaHocId, khoaHoc);
		}

		return rs;
	}
}
