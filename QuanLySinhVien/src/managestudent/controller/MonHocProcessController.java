package managestudent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managestudent.entities.ChuyenNganh;
import managestudent.entities.MonHoc;
import managestudent.logics.impl.ChuyenNganhLogicsImpl;
import managestudent.logics.impl.MonHocLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;
import managestudent.validates.ValidateInfor;

/**
 * Servlet implementation class MonHocProcessController
 */
public class MonHocProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonHocProcessController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		List<String> lsMessage = new ArrayList<String>();
		loadData(request, response);

		if(Common.checkLogin(request.getSession())) {
			template = Constant.SYSTEM_ERR;
			if(request.getSession().getAttribute("monhoc") != null) {
				request.setAttribute("monhoc", request.getSession().getAttribute("monhoc"));
				template = Constant.MONHOCPROCESS;
			}
			if(request.getParameter("lsMessage") != null) {
				lsMessage.add(request.getParameter("lsMessage"));
				template = Constant.MONHOCPROCESS;
			}
			if(request.getParameter("ref") != null) {
				request.setAttribute("ref", request.getParameter("ref"));
				template = Constant.MONHOCPROCESS;
			}
			if(request.getParameter("id") != null) {
				request.setAttribute("id", request.getParameter("id"));
				template = Constant.MONHOCPROCESS;
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
		loadData(request, response);

		if(Common.checkLogin(request.getSession())) {
			if(request.getParameter("submit") != null && request.getParameter("submit").length() > 0) {
				MonHoc monHoc = setDefaultData(request, response);

				if(request.getAttribute("lsMessage") != null) {
					request.setAttribute("monhoc", monHoc);
					RequestDispatcher req = request.getRequestDispatcher(Constant.MONHOCPROCESS);
					req.forward(request, response);
					return;
				}

				if (request.getParameter("ref") != null) {
					if("add".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateMonHocInfor(monHoc, true);
					} else if("update".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateMonHocInfor(monHoc, false);
					}
				}

				if (lsMessage.size() > 0) {
					request.setAttribute("lsMessage", lsMessage);
					request.setAttribute("monhoc", monHoc);
					if (request.getParameter("ref") != null) {
						request.setAttribute("ref", request.getParameter("ref"));
					}
					if(request.getParameter("id") != null) {
						request.setAttribute("id", request.getParameter("id"));
					}
					template = Constant.MONHOCPROCESS;
				} else {
					request.getSession().setAttribute("monhoc", monHoc);
					if (request.getParameter("ref") != null) {
						String ref = request.getParameter("ref");

						if ("add".equals(ref)) {
							boolean rs = processData(-1, monHoc, true);

							if (rs) {
								//lsMessage.add(MessageProperties.getMessage("msg_001"));
								request.getSession().removeAttribute("monhoc");
								response.sendRedirect("Result.do?add=success");
								return;
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else if ("update".equals(ref)) {
							try {
								if (request.getParameter("id") != null) {
									try {
										MonHocLogicsImpl monHocLogics = new MonHocLogicsImpl();
										MonHoc monHocTemp = monHocLogics.getMonHocById(Integer.parseInt(request.getParameter("id")));

										if(monHocTemp != null) {
											boolean rs = processData(Integer.parseInt(request.getParameter("id")), monHoc, false);

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
									} catch (Exception e) {
										System.out.println("An error occur: " + e.getMessage());
										lsMessage.add(MessageErrorProperties.getMessage("error_024"));
										template = Constant.MONHOCPROCESS;
									}
								} else {
									template = Constant.SYSTEM_ERR;
								}
							} catch (NumberFormatException e) {
								System.out.println("An error occur: " + e.getMessage());
								lsMessage.add(MessageErrorProperties.getMessage("error_024"));
								template = Constant.MONHOCPROCESS;
							}
						} else if("delete".equals(ref)) {
							try {
								if(request.getParameter("id") != null) {
									MonHocLogicsImpl monHocLogics = new MonHocLogicsImpl();
									MonHoc monHocTemp = monHocLogics.getMonHocById(Integer.parseInt(request.getParameter("id")));

									if(monHocTemp != null) {
										boolean rs = monHocLogics.deleteMonHocById(monHocTemp.getMonHocId());

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
								template = Constant.MONHOCPROCESS;
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
	 * Gán dữ liệu cho các control
	 *
	 * @param request
	 * @param response
	 */
	protected void loadData(HttpServletRequest request, HttpServletResponse response) {
		ChuyenNganhLogicsImpl chuyenNganhLogics = new ChuyenNganhLogicsImpl();

		request.setAttribute("lsChuyenNganh", chuyenNganhLogics.getAllChuyenNganh(new ChuyenNganh(), 0,
				chuyenNganhLogics.getTotalRecords(new ChuyenNganh()), 1, "ASC"));
	}

	/**
	 * Gán dữ liệu vào đối tượng môn học
	 *
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return MonHoc đối tượng môn học
	 */
	protected MonHoc setDefaultData(HttpServletRequest request, HttpServletResponse response) {
		MonHoc monHoc = new MonHoc();
		List<String> lsMessage = new ArrayList<String>();

		try {
			if(request.getParameter("id") != null) {
				monHoc.setMonHocId(Integer.parseInt(request.getParameter("id")));
			}
			if(request.getParameter("tenmonhoc") != null && request.getParameter("tenmonhoc").length() > 0) {
				monHoc.setTenMonHoc(request.getParameter("tenmonhoc"));
			}
			if(request.getParameter("sotrinh") != null && request.getParameter("sotrinh").length() > 0) {
				monHoc.setSoTrinh(request.getParameter("sotrinh"));
			}
			if(request.getParameter("hesochuyencan") != null && request.getParameter("hesochuyencan").length() > 0) {
				monHoc.setHeSoChuyenCan(Float.parseFloat(request.getParameter("hesochuyencan")));
			}
			if(request.getParameter("hesogiuaky") != null && request.getParameter("hesogiuaky").length() > 0) {
				monHoc.setHeSoGiuaKy(Float.parseFloat(request.getParameter("hesogiuaky")));
			}
			if(request.getParameter("hesohocky") != null && request.getParameter("hesohocky").length() > 0) {
				monHoc.setHeSoHocKy(Float.parseFloat(request.getParameter("hesohocky")));
			}
			if(request.getParameter("chuyennganhid") != null && request.getParameter("chuyennganhid").length() > 0) {
				monHoc.setChuyenNganhId(Integer.parseInt(request.getParameter("chuyennganhid")));
			}
		} catch (NumberFormatException e) {
			System.out.println("An error occur: " + e.getMessage());
			lsMessage.add(MessageErrorProperties.getMessage("error_024"));
			request.setAttribute("lsMessage", lsMessage);
		}

		return monHoc;
	}

	/**
	 * Xử lý dữ liệu vào tầng logics
	 *
	 * @param nganhId int id ngành
	 * @param nganh Nganh đối tượng ngành
	 * @param isAdd true: action add / false: action update
	 * @return true: thành công / false: thất bại
	 */
	protected boolean processData(int monHocId, MonHoc monHoc, boolean isAdd) {
		boolean rs = false;
		MonHocLogicsImpl monHocLogics = new MonHocLogicsImpl();

		if(isAdd) {
			rs = monHocLogics.addMonHoc(monHoc);
		} else {
			rs = monHocLogics.updateMonHocById(monHocId, monHoc);
		}

		return rs;
	}
}
