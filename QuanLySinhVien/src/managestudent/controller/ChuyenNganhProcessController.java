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
import managestudent.entities.Nganh;
import managestudent.logics.impl.ChuyenNganhLogicsImpl;
import managestudent.logics.impl.NganhLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;
import managestudent.validates.ValidateInfor;

/**
 * Servlet implementation class ChuyenNganhProcessController
 */
public class ChuyenNganhProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChuyenNganhProcessController() {
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
			if(request.getSession().getAttribute("chuyennganh") != null) {
				request.setAttribute("chuyennganh", request.getSession().getAttribute("chuyennganh"));
				template = Constant.CHUYENNGANHPROCESS;
			}
			if(request.getParameter("lsMessage") != null) {
				lsMessage.add(request.getParameter("lsMessage"));
				template = Constant.CHUYENNGANHPROCESS;
			}
			if(request.getParameter("ref") != null) {
				request.setAttribute("ref", request.getParameter("ref"));
				template = Constant.CHUYENNGANHPROCESS;
			}
			if(request.getParameter("id") != null) {
				request.setAttribute("id", request.getParameter("id"));
				template = Constant.CHUYENNGANHPROCESS;
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
			if(request.getParameter("submit") != null) {
				ChuyenNganh cn = setDefaultData(request, response);

				if(request.getAttribute("lsMessage") != null) {
					request.setAttribute("chuyennganh", cn);
					RequestDispatcher req = request.getRequestDispatcher(Constant.CHUYENNGANHPROCESS);
					req.forward(request, response);
					return;
				}

				if (request.getParameter("ref") != null) {
					if("add".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateChuyenNganhInfor(cn, true);
					} else if("update".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateChuyenNganhInfor(cn, false);
					}
				}

				if (lsMessage.size() > 0) {
					request.setAttribute("lsMessage", lsMessage);
					request.setAttribute("chuyennganh", cn);
					if (request.getParameter("ref") != null) {
						request.setAttribute("ref", request.getParameter("ref"));
					}
					if(request.getParameter("id") != null) {
						request.setAttribute("id", request.getParameter("id"));
					}
					template = Constant.CHUYENNGANHPROCESS;
				} else {
					request.getSession().setAttribute("chuyennganh", cn);
					if (request.getParameter("ref") != null) {
						String ref = request.getParameter("ref");

						if ("add".equals(ref)) {
							boolean rs = processData(-1, cn, true);

							if (rs) {
								//lsMessage.add(MessageProperties.getMessage("msg_001"));
								request.getSession().removeAttribute("chuyennganh");
								response.sendRedirect("Result.do?add=success");
								return;
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else if ("update".equals(ref)) {
							if (request.getParameter("id") != null) {
								try {
									ChuyenNganhLogicsImpl chuyenNganhLogics = new ChuyenNganhLogicsImpl();
									ChuyenNganh cnTemp = chuyenNganhLogics.getChuyenNganhById(Integer.parseInt(request.getParameter("id")));

									if(cnTemp != null) {
										boolean rs = processData(Integer.parseInt(request.getParameter("id")), cn, false);

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
									template = Constant.CHUYENNGANHPROCESS;
								}
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else if("delete".equals(ref)) {
							try {
								if(request.getParameter("id") != null) {
									ChuyenNganhLogicsImpl chuyenNganhLogics = new ChuyenNganhLogicsImpl();
									ChuyenNganh cnTemp = chuyenNganhLogics.getChuyenNganhById(Integer.parseInt(request.getParameter("id")));

									if(cnTemp != null) {
										boolean rs = chuyenNganhLogics.deleteChuyenNganhById(cnTemp.getChuyenNganhId());

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
								template = Constant.CHUYENNGANHPROCESS;
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
	 * Gán dữ liệu vào đối tượng chuyên ngành
	 *
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ChuyenNganh đối tượng chuyên ngành
	 */
	protected ChuyenNganh setDefaultData(HttpServletRequest request, HttpServletResponse response) {
		ChuyenNganh cn = new ChuyenNganh();
		List<String> lsMessage = new ArrayList<String>();

		try {
			if(request.getParameter("machuyennganh") != null) {
				cn.setMaChuyenNganh(request.getParameter("machuyennganh"));
			}
			if(request.getParameter("tenchuyennganh") != null) {
				cn.setTenChuyenNganh(request.getParameter("tenchuyennganh"));
			}
			if(request.getParameter("id") != null) {
				cn.setNganhId(Integer.parseInt(request.getParameter("id")));
			}
			if(request.getParameter("nganhid") != null) {
				cn.setNganhId(Integer.parseInt(request.getParameter("nganhid")));
			}
		} catch (NumberFormatException e) {
			System.out.println("An error occur: " + e.getMessage());
			lsMessage.add(MessageErrorProperties.getMessage("error_024"));
			request.setAttribute("lsMessage", lsMessage);
		}

		return cn;
	}

	/**
	 * Gán dữ liệu cho các control
	 *
	 * @param request
	 * @param response
	 */
	protected void loadData(HttpServletRequest request, HttpServletResponse response) {
		NganhLogicsImpl nganhLogics = new NganhLogicsImpl();

		request.setAttribute("lsNganh", nganhLogics.getAllNganh(new Nganh(), 0, nganhLogics.getTotalRecords(new Nganh()), 1, "ASC"));
	}

	/**
	 * Xử lý dữ liệu vào tầng logics
	 *
	 * @param isAdd true: action add / false: action update
	 * @return true: thành công / false: thất bại
	 */
	protected boolean processData(int chuyenNganhId, ChuyenNganh cn, boolean isAdd) {
		boolean rs = false;

		ChuyenNganhLogicsImpl chuyenNganhLogics = new ChuyenNganhLogicsImpl();
		if(isAdd) {
			rs = chuyenNganhLogics.addChuyenNganh(cn);
		} else {
			rs = chuyenNganhLogics.updateChuyenNganhById(chuyenNganhId, cn);
		}

		return rs;
	}
}
