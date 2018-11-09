
package managestudent.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managestudent.entities.ChuyenNganh;
import managestudent.entities.Diem;
import managestudent.entities.DmSinhVien;
import managestudent.entities.HocKy;
import managestudent.entities.MonHoc;
import managestudent.logics.impl.ChuyenNganhLogicsImpl;
import managestudent.logics.impl.DiemLogicsImpl;
import managestudent.logics.impl.DmSinhVienLogicsImpl;
import managestudent.logics.impl.HocKyLogicsImpl;
import managestudent.logics.impl.MonHocLogicsImpl;
import managestudent.logics.impl.NganhLogicsImpl;
import managestudent.utils.Common;

/**
 * Servlet implementation class AddDiemServicesController
 */
public class AddDiemServicesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDiemServicesController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action") != null) {
			String action = request.getParameter("action");
			if("add".equals(action)) {
				doAdd(request, response);
			} else {
				doDelete(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
		if(request.getParameter("diemId") != null && request.getParameter("hockyid") != null && request.getParameter("sinhvienid") != null) {
			try {
				float diemTBHK = 0.0f;
				float diemTK = 0.0f;
				int diemId = Integer.parseInt(request.getParameter("diemId"));
				int hocKyId = Integer.parseInt(request.getParameter("hockyid"));
				int sinhVienId = Integer.parseInt(request.getParameter("sinhvienid"));

				DiemLogicsImpl diemLogics = new DiemLogicsImpl();
				HocKyLogicsImpl hocKyLogics = new HocKyLogicsImpl();

				StringBuilder json = new StringBuilder();
				if(diemLogics.deleteDiemById(diemId)) {
					List<HocKy> lsHocKy = hocKyLogics.getAllHocKy(new HocKy(), 0, hocKyLogics.getTotalRecords(new HocKy()), 1, "ASC");
					List<Diem> lsDiem = new ArrayList<Diem>();

					for (HocKy hocKy : lsHocKy) {
						lsDiem = diemLogics.getDiemBySinhVienId(sinhVienId, hocKy.getHocKyId());
						if(hocKy.getHocKyId() == hocKyId) {
							diemTBHK = Common.getDiemTBHK(lsDiem);
							diemTK += diemTBHK;
						} else {
							diemTK += Common.getDiemTBHK(lsDiem);
						}
					}
					diemTK /= lsHocKy.size();

					json.append("{\"result\": \"success\", \"diemTBHK\": \"");
					json.append(diemTBHK + "\", \"diemTK\": \"");
					json.append(diemTK + "\"}");
				} else {
					json.append("{\"result\": \"fail\"}");
				}

				PrintWriter out = response.getWriter();
				out.println(json);
			} catch (NumberFormatException e) {
				System.out.println("An error occur: " + e.getMessage());
			} catch (IOException e) {
				System.out.println("An error occur: " + e.getMessage());
			}
		}
	}

	protected void doAdd(HttpServletRequest request, HttpServletResponse response) {
		if(request.getParameter("monhocid") != null && request.getParameter("hockyid") != null && request.getParameter("diemchuyencan") != null &&
				request.getParameter("diemgiuaky") != null && request.getParameter("diemthi") != null && request.getParameter("sinhvienid") != null) {
			try {
				String tenChuyenNganh = "";
				String tenNganh = "";
				float diemTBHK = 0;
				float diemTK = 0;
				int insertedDiemId = -1;
				int monHocId = Integer.parseInt(request.getParameter("monhocid"));
				int hocKyId = Integer.parseInt(request.getParameter("hockyid"));
				int sinhVienId = Integer.parseInt(request.getParameter("sinhvienid"));
				float diemChuyenCan = Float.parseFloat(request.getParameter("diemchuyencan"));
				float diemGiuaKy = Float.parseFloat(request.getParameter("diemgiuaky"));
				float diemThi = Float.parseFloat(request.getParameter("diemthi"));
				List<Diem> lsDiem = new ArrayList<Diem>();

				MonHocLogicsImpl monHocLogics = new MonHocLogicsImpl();
				DiemLogicsImpl diemLogics = new DiemLogicsImpl();
				DmSinhVienLogicsImpl sinhVienLogics = new DmSinhVienLogicsImpl();
				ChuyenNganhLogicsImpl chuyenNganhLogics = new ChuyenNganhLogicsImpl();
				NganhLogicsImpl nganhLogics = new NganhLogicsImpl();
				HocKyLogicsImpl hocKyLogics = new HocKyLogicsImpl();

				MonHoc monHoc = monHocLogics.getMonHocById(monHocId);
				ChuyenNganh chuyenNganh = chuyenNganhLogics.getChuyenNganhById(monHocLogics.getMonHocById(monHocId).getChuyenNganhId());
				Diem diem = new Diem();
				diem.setDiemChuyenCan(diemChuyenCan);
				diem.setDiemGiuaKy(diemGiuaKy);
				diem.setDiemThi(diemThi);
				diem.setHocKyId(hocKyId);
				diem.setMonHocId(monHocId);
				diem.setMonHoc(monHocLogics.getMonHocById(diem.getMonHocId()));
				diem.setSinhVienId(sinhVienId);
				diem.setLanThi("1");
				DmSinhVien sinhVien = new DmSinhVien();
				sinhVien.setChuyenNganhId(chuyenNganh.getChuyenNganhId());
				tenChuyenNganh = chuyenNganh.getTenChuyenNganh();
				tenNganh = nganhLogics.getNganhById(chuyenNganh.getNganhId()).getTenNganh();
				if(tenChuyenNganh.length() <= 0 || tenChuyenNganh == null) {
					tenChuyenNganh = "Không";
				}
				if(tenNganh.length() <= 0 || tenNganh == null) {
					tenNganh = "Không";
				}

				List<HocKy> lsHocKy = hocKyLogics.getAllHocKy(new HocKy(), 0, hocKyLogics.getTotalRecords(new HocKy()), 1, "ASC");
				for (HocKy hocKy : lsHocKy) {
					lsDiem = diemLogics.getDiemBySinhVienId(sinhVienId, hocKy.getHocKyId());
					if(hocKy.getHocKyId() == hocKyId) {
						diemTBHK = Common.getDiemTBHK(lsDiem);
						diemTK += diemTBHK;
					} else {
						diemTK += Common.getDiemTBHK(lsDiem);
					}
				}
				diemTK /= lsHocKy.size();

				StringBuilder json = new StringBuilder();
				if ((insertedDiemId = diemLogics.addDiem(diem)) > 0) {
					sinhVienLogics.updateChuyenNganhSinhVien(sinhVienId, diem.getMonHoc().getChuyenNganhId());
					json.append("{\"tenMonHoc\": \"");
					json.append(monHoc.getTenMonHoc() + "\", \"hscc\": \"");
					json.append(monHoc.getHeSoChuyenCan() + "\", \"hsgk\": \"");
					json.append(monHoc.getHeSoGiuaKy() + "\", \"hshk\": \"");
					json.append(monHoc.getHeSoHocKy() + "\", \"tenChuyenNganh\": \"");
					json.append(tenChuyenNganh + "\", \"tenNganh\": \"");
					json.append(tenNganh + "\", \"diemTBHK\": \"");
					json.append(diemTBHK + "\", \"diemTK\": \"");
					json.append(diemTK + "\", \"insertedId\" : \"");
					json.append(insertedDiemId + "\"}");
				}

				PrintWriter out = response.getWriter();
				out.println(json);
			} catch (NumberFormatException e) {
				System.out.println("An error occur: " + e.getMessage());
			} catch (IOException e) {
				System.out.println("An error occur: " + e.getMessage());
			}
		}
	}
}
