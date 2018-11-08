package managestudent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managestudent.entities.LopHoc;
import managestudent.logics.impl.LopHocLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;
import managestudent.validates.ValidateInfor;

/**
 * Servlet implementation class LopHocProcessController
 */
public class LopHocProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LopHocProcessController() {
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
			if(request.getSession().getAttribute("lophoc") != null) {
				request.setAttribute("lophoc", request.getSession().getAttribute("lophoc"));
				template = Constant.LOPHOCPROCESS;
			}
			if(request.getParameter("lsMessage") != null) {
				lsMessage.add(request.getParameter("lsMessage"));
				template = Constant.LOPHOCPROCESS;
			}
			if(request.getParameter("ref") != null) {
				request.setAttribute("ref", request.getParameter("ref"));
				template = Constant.LOPHOCPROCESS;
			}
			if(request.getParameter("id") != null) {
				request.setAttribute("id", request.getParameter("id"));
				template = Constant.LOPHOCPROCESS;
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
				LopHoc lopHoc = setDefaultData(request, response);

				if(request.getAttribute("lsMessage") != null) {
					request.setAttribute("lophoc", lopHoc);
					RequestDispatcher req = request.getRequestDispatcher(Constant.LOPHOCPROCESS);
					req.forward(request, response);
					return;
				}

				if (request.getParameter("ref") != null) {
					if("add".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateLopHocInfor(lopHoc, true);
					} else if("update".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateLopHocInfor(lopHoc, false);
					}
				}

				if (lsMessage.size() > 0) {
					request.setAttribute("lsMessage", lsMessage);
					request.setAttribute("lophoc", lopHoc);
					if (request.getParameter("ref") != null) {
						request.setAttribute("ref", request.getParameter("ref"));
					}
					if(request.getParameter("id") != null) {
						request.setAttribute("id", request.getParameter("id"));
					}
					template = Constant.LOPHOCPROCESS;
				} else {
					request.getSession().setAttribute("lophoc", lopHoc);
					if (request.getParameter("ref") != null) {
						String ref = request.getParameter("ref");

						if ("add".equals(ref)) {
							boolean rs = processData(-1, lopHoc, true);

							if (rs) {
								//lsMessage.add(MessageProperties.getMessage("msg_001"));
								request.getSession().removeAttribute("lophoc");
								response.sendRedirect("Result.do?add=success");
								return;
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else if ("update".equals(ref)) {
							if (request.getParameter("id") != null) {
								try {
									LopHocLogicsImpl lopHocLogics = new LopHocLogicsImpl();
									LopHoc lopHocTemp = lopHocLogics.getLopHocById(Integer.parseInt(request.getParameter("id")));

									if(lopHocTemp != null) {
										boolean rs = processData(Integer.parseInt(request.getParameter("id")), lopHoc, false);

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
									template = Constant.LOPHOCPROCESS;
								}
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else if("delete".equals(ref)) {
							try {
								if(request.getParameter("id") != null) {
									LopHocLogicsImpl lopHocLogics = new LopHocLogicsImpl();
									LopHoc lopHocTemp = lopHocLogics.getLopHocById(Integer.parseInt(request.getParameter("id")));

									if(lopHocTemp != null) {
										boolean rs = lopHocLogics.deleteLopHocById(lopHocTemp.getLopHocId());

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
								template = Constant.LOPHOCPROCESS;
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
	 * Gán dữ liệu vào đối tượng lớp học
	 *
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return LopHoc đối tượng lớp học
	 */
	protected LopHoc setDefaultData(HttpServletRequest request, HttpServletResponse response) {
		LopHoc lopHoc = new LopHoc();
		List<String> lsMessage = new ArrayList<String>();

		try {
			if(request.getParameter("id") != null) {
				lopHoc.setLopHocId(Integer.parseInt(request.getParameter("id")));
			}
			if(request.getParameter("tenlophoc") != null) {
				lopHoc.setTenLopHoc(request.getParameter("tenlophoc"));
			}
		} catch (NumberFormatException e) {
			System.out.println("An error occur: " + e.getMessage());
			lsMessage.add(MessageErrorProperties.getMessage("error_024"));
			request.setAttribute("lsMessage", lsMessage);
		}

		return lopHoc;
	}

	/**
	 * Xử lý dữ liệu vào tầng logics
	 *
	 * @param isAdd true: action add / false: action update
	 * @return true: thành công / false: thất bại
	 */
	protected boolean processData(int lopHocId, LopHoc lopHoc, boolean isAdd) {
		boolean rs = false;
		LopHocLogicsImpl lopHocLogics = new LopHocLogicsImpl();

		if(isAdd) {
			rs = lopHocLogics.addLopHoc(lopHoc);
		} else {
			rs = lopHocLogics.updateLopHocById(lopHocId, lopHoc);
		}

		return rs;
	}
}
