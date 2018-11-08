package managestudent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managestudent.entities.TonGiao;
import managestudent.logics.impl.TonGIaoLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;
import managestudent.validates.ValidateInfor;

/**
 * Servlet implementation class TonGiaoProcessController
 */
public class TonGiaoProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TonGiaoProcessController() {
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
			if(request.getSession().getAttribute("tongiao") != null) {
				request.setAttribute("tongiao", request.getSession().getAttribute("tongiao"));
				template = Constant.TONGIAOPROCESS;
			}
			if(request.getParameter("lsMessage") != null) {
				lsMessage.add(request.getParameter("lsMessage"));
				template = Constant.TONGIAOPROCESS;
			}
			if(request.getParameter("ref") != null) {
				request.setAttribute("ref", request.getParameter("ref"));
				template = Constant.TONGIAOPROCESS;
			}
			if(request.getParameter("id") != null) {
				request.setAttribute("id", request.getParameter("id"));
				template = Constant.TONGIAOPROCESS;
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
				TonGiao tonGiao = setDefaultData(request, response);

				if(request.getAttribute("lsMessage") != null) {
					request.setAttribute("tongiao", tonGiao);
					RequestDispatcher req = request.getRequestDispatcher(Constant.TONGIAOPROCESS);
					req.forward(request, response);
					return;
				}

				if (request.getParameter("ref") != null) {
					if("add".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateTonGiaoInfor(tonGiao, true);
					} else if("update".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateTonGiaoInfor(tonGiao, false);
					}
				}

				if (lsMessage.size() > 0) {
					request.setAttribute("lsMessage", lsMessage);
					request.setAttribute("tongiao", tonGiao);
					if (request.getParameter("ref") != null) {
						request.setAttribute("ref", request.getParameter("ref"));
					}
					if(request.getParameter("id") != null) {
						request.setAttribute("id", request.getParameter("id"));
					}
					template = Constant.TONGIAOPROCESS;
				} else {
					request.getSession().setAttribute("tongiao", tonGiao);
					if (request.getParameter("ref") != null) {
						String ref = request.getParameter("ref");

						if ("add".equals(ref)) {
							boolean rs = processData(-1, tonGiao, true);

							if (rs) {
								//lsMessage.add(MessageProperties.getMessage("msg_001"));
								request.getSession().removeAttribute("tongiao");
								response.sendRedirect("Result.do?add=success");
								return;
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else if ("update".equals(ref)) {
							if (request.getParameter("id") != null) {
								try {
									TonGIaoLogicsImpl tonGiaoLogics = new TonGIaoLogicsImpl();
									TonGiao tonGiaoTemp = tonGiaoLogics.getTonGiaoById(Integer.parseInt(request.getParameter("id")));

									if(tonGiaoTemp != null) {
										boolean rs = processData(Integer.parseInt(request.getParameter("id")), tonGiao, false);

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
									template = Constant.TONGIAOPROCESS;
								}
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else if("delete".equals(ref)) {
							try {
								if(request.getParameter("id") != null) {
									TonGIaoLogicsImpl tonGiaoLogics = new TonGIaoLogicsImpl();
									TonGiao tonGiaoTemp = tonGiaoLogics.getTonGiaoById(Integer.parseInt(request.getParameter("id")));

									if(tonGiaoTemp != null) {
										boolean rs = tonGiaoLogics.deleteTonGiaoById(tonGiaoTemp.getTonGiaoId());

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
								template = Constant.TONGIAOPROCESS;
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
	 * Gán dữ liệu vào đối tượng tôn giáo
	 *
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return TonGiao đối tượng tôn giáo
	 */
	protected TonGiao setDefaultData(HttpServletRequest request, HttpServletResponse response) {
		TonGiao tonGiao = new TonGiao();
		List<String> lsMessage = new ArrayList<String>();

		try {
			if(request.getParameter("id") != null && request.getParameter("id").length() > 0) {
				tonGiao.setTonGiaoId(Integer.parseInt(request.getParameter("id")));
			}
			if(request.getParameter("tentongiao") != null && request.getParameter("tentongiao").length() > 0) {
				tonGiao.setTenTonGiao(request.getParameter("tentongiao"));
			}
		} catch (NumberFormatException e) {
			System.out.println("An error occur: " + e.getMessage());
			lsMessage.add(MessageErrorProperties.getMessage("error_024"));
			request.setAttribute("lsMessage", lsMessage);
		}

		return tonGiao;
	}

	/**
	 * Xử lý dữ liệu vào tầng logics
	 *
	 * @param isAdd true: action add / false: action update
	 * @return true: thành công / false: thất bại
	 */
	protected boolean processData(int tonGiaoId, TonGiao tonGiao, boolean isAdd) {
		boolean rs = false;
		TonGIaoLogicsImpl tonGiaoLogics = new TonGIaoLogicsImpl();

		if(isAdd) {
			rs = tonGiaoLogics.addTonGiao(tonGiao);
		} else {
			rs = tonGiaoLogics.updateTonGiaoById(tonGiaoId, tonGiao);
		}

		return rs;
	}
}
