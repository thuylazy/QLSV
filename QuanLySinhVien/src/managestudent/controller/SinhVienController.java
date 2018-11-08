package managestudent.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managestudent.entities.DanToc;
import managestudent.entities.DmSinhVien;
import managestudent.entities.KhoaHoc;
import managestudent.entities.LopHoc;
import managestudent.entities.TonGiao;
import managestudent.logics.impl.DanTocLogicsImpl;
import managestudent.logics.impl.DmSinhVienLogicsImpl;
import managestudent.logics.impl.KhoaHocLogicsImpl;
import managestudent.logics.impl.LopHocLogicsImpl;
import managestudent.logics.impl.TonGIaoLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;
import managestudent.utils.MessageProperties;

/**
 * Servlet implementation class SinhVienController
 */
public class SinhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SinhVienController() {
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
			DmSinhVienLogicsImpl sinhVienLogics = new DmSinhVienLogicsImpl();
			LopHocLogicsImpl lopHocLogics = new LopHocLogicsImpl();
			KhoaHocLogicsImpl khoaHocLogics = new KhoaHocLogicsImpl();
			DanTocLogicsImpl danTocLogics = new DanTocLogicsImpl();
			TonGIaoLogicsImpl tonGiaoLogics = new TonGIaoLogicsImpl();
			int limit = Integer.parseInt(MessageProperties.getMessage("limit"));
			int range = Integer.parseInt(MessageProperties.getMessage("range"));
			List<Integer> lsPage = new ArrayList<Integer>();
			int page = 0;
			int totalPage = 0;
			int totalRecords = 0;
			DmSinhVien sinhVien = new DmSinhVien();
			int offset = 0;
			int sortColumn = 1;
			String sortType = "";

			List<DmSinhVien> lsSinhVien = new ArrayList<DmSinhVien>();
			List<LopHoc> lsLop = new ArrayList<LopHoc>();
			List<KhoaHoc> lsKhoaHoc = new ArrayList<KhoaHoc>();
			List<DanToc> lsDanToc = new ArrayList<DanToc>();
			List<TonGiao> lsTonGiao = new ArrayList<TonGiao>();

			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}

			if(page == 0) {
				page = 1;
			}

			if((request.getParameter("masv") != null)) {
				sinhVien.setMaSinhVien(request.getParameter("masv"));
				session.setAttribute("masv", sinhVien.getMaSinhVien());
			} else if((session.getAttribute("masv") != null)) {
				sinhVien.setMaSinhVien(session.getAttribute("masv").toString());
			}
			if((request.getParameter("hodem") != null)) {
				sinhVien.setHoDem(request.getParameter("hodem"));
				session.setAttribute("hodem", sinhVien.getHoDem());
			} else if((session.getAttribute("hodem") != null)) {
				sinhVien.setHoDem(session.getAttribute("hodem").toString());
			}
			if((request.getParameter("ten") != null)) {
				sinhVien.setTen(request.getParameter("ten"));
				session.setAttribute("ten", sinhVien.getTen());
			} else if(session.getAttribute("ten") != null) {
				sinhVien.setTen(session.getAttribute("ten").toString());
			}
			if((request.getParameter("ngaysinh") != null)) {
				try {
					sinhVien.setNgaySinh(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngaysinh")));
					session.setAttribute("ngaysinh", sinhVien.getNgaySinh());
				} catch (ParseException e) {
					System.out.println("An error occur: " + e.getMessage());
					sinhVien.setNgaySinh(new Date());
					session.setAttribute("ngaysinh", new Date());
				}
			} else if(session.getAttribute("ngaysinh") != null) {
				try {
					sinhVien.setNgaySinh(new SimpleDateFormat("yyyy-MM-dd").parse(session.getAttribute("ngaysinh").toString()));
				} catch (ParseException e) {
					System.out.println("An error occur: " + e.getMessage());
					sinhVien.setNgaySinh(new Date());
					session.setAttribute("ngaysinh", new Date());
				}
			}
			if((request.getParameter("gioitinh") != null)) {
				try {
					sinhVien.setGioiTinh(Integer.parseInt(request.getParameter("gioitinh")));
					session.setAttribute("gioitinh", sinhVien.getGioiTinh());
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			} else if(session.getAttribute("gioitinh") != null) {
				try {
					sinhVien.setGioiTinh(Integer.parseInt(session.getAttribute("gioitinh").toString()));
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			}
			if((request.getParameter("socmt") != null)) {
				sinhVien.setCmtnd(request.getParameter("socmt"));
				session.setAttribute("socmt", sinhVien.getCmtnd());
			} else if(session.getAttribute("socmt") != null) {
				sinhVien.setCmtnd(session.getAttribute("socmt").toString());
			}
			if((request.getParameter("sodienthoai") != null)) {
				sinhVien.setSoDienThoai(request.getParameter("sodienthoai"));
				session.setAttribute("sodienthoai", sinhVien.getSoDienThoai());
			} else if(session.getAttribute("sodienthoai") != null) {
				sinhVien.setSoDienThoai(session.getAttribute("sodienthoai").toString());
			}
			if((request.getParameter("noisinh") != null)) {
				sinhVien.setNoiSinh(request.getParameter("noisinh"));
				session.setAttribute("noisinh", sinhVien.getNoiSinh());
			} else if(session.getAttribute("noisinh") != null) {
				sinhVien.setNoiSinh(session.getAttribute("noisinh").toString());
			}
			if((request.getParameter("quequan") != null)) {
				sinhVien.setQueQuan(request.getParameter("quequan"));
				session.setAttribute("quequan", sinhVien.getQueQuan());
			} else if(session.getAttribute("quequan") != null) {
				sinhVien.setQueQuan(session.getAttribute("quequan").toString());
			}
			if((request.getParameter("chedo") != null)) {
				sinhVien.setCheDoUuDai(request.getParameter("chedo"));
				session.setAttribute("chedo", sinhVien.getCheDoUuDai());
			} else if(session.getAttribute("chedo") != null) {
				sinhVien.setCheDoUuDai(session.getAttribute("chedo").toString());
			}
			
			if((request.getParameter("dantocid") != null)) {
				try {
					sinhVien.setDanTocId(Integer.parseInt(request.getParameter("dantocid")));
					session.setAttribute("dantocid", sinhVien.getDanTocId());
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			} else if(session.getAttribute("dantocid") != null) {
				try {
					sinhVien.setDanTocId(Integer.parseInt(session.getAttribute("dantocid").toString()));
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			}
			if((request.getParameter("tongiaoid") != null)) {
				try {
					sinhVien.setTonGiaoId(Integer.parseInt(request.getParameter("tongiaoid")));
					session.setAttribute("tongiaoid", sinhVien.getTonGiaoId());
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			} else if(session.getAttribute("tongiaoid") != null) {
				try {
					sinhVien.setTonGiaoId(Integer.parseInt(session.getAttribute("tongiaoid").toString()));
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			}
			if((request.getParameter("lopid") != null)) {
				try {
					sinhVien.setLopId(Integer.parseInt(request.getParameter("lopid")));
					session.setAttribute("lopid", sinhVien.getLopId());
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			} else if(session.getAttribute("lopid") != null) {
				try {
					sinhVien.setLopId(Integer.parseInt(session.getAttribute("lopid").toString()));
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			}
			if((request.getParameter("tenlop") != null)) {
				sinhVien.setTenLopHoc(request.getParameter("tenlop"));
				session.setAttribute("tenlop", sinhVien.getTenLopHoc());
			} else if(session.getAttribute("tenlop") != null) {
				sinhVien.setTenLopHoc(session.getAttribute("tenlop").toString());
			}
			if((request.getParameter("khoahocid") != null)) {
				try {
					sinhVien.setKhoaHocId(Integer.parseInt(request.getParameter("khoahocid")));
					session.setAttribute("khoahocid", sinhVien.getKhoaHocId());
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			} else if(session.getAttribute("khoahocid") != null) {
				try {
					sinhVien.setKhoaHocId(Integer.parseInt(session.getAttribute("khoahocid").toString()));
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			}
			if((request.getParameter("tenkhoahoc") != null)) {
				sinhVien.setTenKhoaHoc(request.getParameter("tenkhoahoc"));
				session.setAttribute("tenkhoahoc", sinhVien.getTenKhoaHoc());
			} else if(session.getAttribute("tenkhoahoc") != null) {
				sinhVien.setTenKhoaHoc(session.getAttribute("tenkhoahoc").toString());
			}

			if(request.getParameter("sortcolumn") != null && request.getParameter("sortcolumn").length() > 0) {
				if(request.getParameter("sortcolumn").length() > 0) {
					sortColumn = Integer.parseInt(request.getParameter("sortcolumn"));
				}

				session.setAttribute("sortcolumn", sortColumn);
			}
			if(request.getParameter("sorttype") != null && request.getParameter("sorttype").length() > 0) {
				sortType = request.getParameter("sorttype");
				session.setAttribute("sorttype", sortType);
			}

			totalRecords = sinhVienLogics.getTotalRecords(sinhVien);
			offset = (page > 0) ? limit * ((int) page - 1) : 0;

			lsSinhVien = sinhVienLogics.getAllSinhVien(sinhVien, offset, limit, sortColumn, sortType);
			lsLop = lopHocLogics.getAllLopHoc(new LopHoc(), 0, lopHocLogics.getTotalRecords(new LopHoc()), 1, "ASC");
			lsKhoaHoc = khoaHocLogics.getAllKhoaHoc(new KhoaHoc(), 0, khoaHocLogics.getTotalRecords(new KhoaHoc()), 1, "ASC");
			lsDanToc = danTocLogics.getAllDanToc(new DanToc(), 0, danTocLogics.getTotalRecords(new DanToc()), 1, "ASC");
			lsTonGiao = tonGiaoLogics.getAllTonGiao(new TonGiao(), 0, tonGiaoLogics.getTotalRecords(new TonGiao()), 1, "ASC");
			lsPage = Common.getListPaging(totalRecords, limit, page);
			totalPage = Common.getTotalPage(totalRecords, limit);

			request.setAttribute("page", page);
	        request.setAttribute("lsPage", lsPage);
	        request.setAttribute("range", range);
	        request.setAttribute("totalPage", totalPage);

			if (lsSinhVien == null) {
				lsMessage.add(MessageErrorProperties.getMessage("error_022"));
				request.setAttribute("showTable", false);
			} else if (lsSinhVien.size() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_001_table"));
				request.setAttribute("showTable", false);
			} else {
				request.setAttribute("lsData", lsSinhVien);
				request.setAttribute("lsLop", lsLop);
				request.setAttribute("lsKhoaHoc", lsKhoaHoc);
				request.setAttribute("lsDanToc", lsDanToc);
				request.setAttribute("lsTonGiao", lsTonGiao);
			}

			template = Constant.SINHVIEN;
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
