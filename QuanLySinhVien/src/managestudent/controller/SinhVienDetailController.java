package managestudent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import managestudent.utils.Global;
import managestudent.utils.MessageErrorProperties;

public class SinhVienDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SinhVienDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkLogin(request.getSession())) {
			if(request.getParameter("id") != null && request.getParameter("id").length() > 0) {
				try {
					int sinhVienId = Integer.parseInt(request.getParameter("id"));
					DmSinhVienLogicsImpl sinhVienLogics = new DmSinhVienLogicsImpl();
					DanTocLogicsImpl danTocLogics = new DanTocLogicsImpl();
					TonGIaoLogicsImpl tonGiaoLogics = new TonGIaoLogicsImpl();
					LopHocLogicsImpl lopHocLogics = new LopHocLogicsImpl();
					KhoaHocLogicsImpl khoaHocLogics = new KhoaHocLogicsImpl();
					DmSinhVien sinhVien = null;

					if((sinhVien = sinhVienLogics.getSinhVienById(sinhVienId)) != null) {
						Global.ngayNhapHoc = sinhVien.getNgayNhapHoc();
						Global.ngaySinh = sinhVien.getNgaySinh();
						request.getSession().setAttribute("sinhvien", sinhVien);
						request.setAttribute("id", request.getParameter("id"));
						request.setAttribute("ref", request.getParameter("ref"));
						request.setAttribute("lsDanToc", danTocLogics.getAllDanToc(new DanToc(), 0, danTocLogics.getTotalRecords(new DanToc()), 1, "ASC"));
						request.setAttribute("lsTonGiao", tonGiaoLogics.getAllTonGiao(new TonGiao(), 0, tonGiaoLogics.getTotalRecords(new TonGiao()), 1, "ASC"));
						request.setAttribute("lsLop", lopHocLogics.getAllLopHoc(new LopHoc(), 0, lopHocLogics.getTotalRecords(new LopHoc()), 1, "ASC"));
						request.setAttribute("lsKhoaHoc", khoaHocLogics.getAllKhoaHoc(new KhoaHoc(), 0, khoaHocLogics.getTotalRecords(new KhoaHoc()), 1, "ASC"));

						template = Constant.SINHVIENDETAIL;
					} else {
						template = Constant.SYSTEM_ERR;
					}
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
					template = Constant.SYSTEM_ERR;
				}
			} else {
				template = Constant.SYSTEM_ERR;
			}
		} else {
			template = Constant.LOGIN;
			lsMessage.add(MessageErrorProperties.getMessage("error_023"));
		}

		request.setAttribute("lsMessage", lsMessage);
		RequestDispatcher req = request.getRequestDispatcher(template);
		req.forward(request, response);
	}

}
