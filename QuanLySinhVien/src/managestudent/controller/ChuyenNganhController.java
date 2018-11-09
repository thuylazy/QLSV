
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

import managestudent.entities.ChuyenNganh;
import managestudent.entities.Nganh;
import managestudent.logics.impl.ChuyenNganhLogicsImpl;
import managestudent.logics.impl.NganhLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;
import managestudent.utils.MessageProperties;

/**
 * Servlet implementation class ChuyenNganhController
 */
public class ChuyenNganhController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChuyenNganhController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkLogin(request.getSession())) {
			HttpSession session = request.getSession();
			ChuyenNganhLogicsImpl chuyenNganhLogics = new ChuyenNganhLogicsImpl();
			template = Constant.CHUYENNGANH;
			int limit = Integer.parseInt(MessageProperties.getMessage("limit"));
			int range = Integer.parseInt(MessageProperties.getMessage("range"));
			List<Integer> lsPage = new ArrayList<Integer>();
			NganhLogicsImpl nganhLogics = new NganhLogicsImpl();
			List<ChuyenNganh> lsChuyenNganh = new ArrayList<ChuyenNganh>();
			List<Nganh> lsNganh = new ArrayList<Nganh>();
			int page = 0;
			int totalPage = 0;
			int totalRecords = 0;
			ChuyenNganh chuyenNganh = new ChuyenNganh();
			int offset = 0;
			int sortColumn = 1;
			String sortType = "";

			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}

			if(page == 0) {
				page = 1;
			}

			if(request.getParameter("machuyennganh") != null) {
				chuyenNganh.setMaChuyenNganh(request.getParameter("machuyennganh"));
				session.setAttribute("machuyennganh", chuyenNganh.getMaChuyenNganh());
			} else if(session.getAttribute("machuyennganh") != null) {
				chuyenNganh.setMaChuyenNganh(session.getAttribute("machuyennganh").toString());
			}
			if(request.getParameter("tenchuyennganh") != null) {
				chuyenNganh.setTenChuyenNganh(request.getParameter("tenchuyennganh"));
				session.setAttribute("tenchuyennganh", chuyenNganh.getTenChuyenNganh());
			} else if(session.getAttribute("tenchuyennganh") != null) {
				chuyenNganh.setTenChuyenNganh(session.getAttribute("tenchuyennganh").toString());
			}
			if(request.getParameter("nganhid") != null) {
				try {
					chuyenNganh.setNganhId(Integer.parseInt(request.getParameter("nganhid")));
					session.setAttribute("nganhid", chuyenNganh.getNganhId());
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			} else if(session.getAttribute("nganhid") != null) {
				try {
					chuyenNganh.setNganhId(Integer.parseInt(session.getAttribute("nganhid").toString()));
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			}
			if(request.getParameter("tennganh") != null) {
				chuyenNganh.setTenNganh(request.getParameter("tennganh"));
				session.setAttribute("tennganh", chuyenNganh.getTenNganh());
			} else if(session.getAttribute("tennganh") != null) {
				chuyenNganh.setTenNganh(session.getAttribute("tennganh").toString());
			}

			if(request.getParameter("sortcolumn") != null) {
				if(request.getParameter("sortcolumn").length() > 0) {
					sortColumn = Integer.parseInt(request.getParameter("sortcolumn"));
				}

				request.setAttribute("sortcolumn", sortColumn);
			}
			if(request.getParameter("sorttype") != null) {
				sortType = request.getParameter("sorttype");
				request.setAttribute("sorttype", sortType);
			}

			totalRecords = chuyenNganhLogics.getTotalRecords(chuyenNganh);
			offset = (page > 0) ? limit * ((int) page - 1) : 0;

			lsChuyenNganh = chuyenNganhLogics.getAllChuyenNganh(chuyenNganh, offset, limit, sortColumn, sortType);
			lsNganh = nganhLogics.getAllNganh(new Nganh(), 0, nganhLogics.getTotalRecords(new Nganh()), 1, "ASC");
			lsPage = Common.getListPaging(totalRecords, limit, page);
			totalPage = Common.getTotalPage(totalRecords, limit);

			request.setAttribute("page", page);
	        request.setAttribute("lsPage", lsPage);
	        request.setAttribute("range", range);
	        request.setAttribute("totalPage", totalPage);

			if (lsChuyenNganh == null) {
				lsMessage.add(MessageErrorProperties.getMessage("error_022"));
				request.setAttribute("showTable", false);
			} else if (lsChuyenNganh.size() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_001_table"));
				request.setAttribute("showTable", false);
			} else {
				request.setAttribute("lsData", lsChuyenNganh);
				request.setAttribute("lsNganh", lsNganh);
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
