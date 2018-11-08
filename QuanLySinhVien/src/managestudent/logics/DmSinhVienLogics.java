
package managestudent.logics;

import java.util.List;

import managestudent.entities.DmSinhVien;

public interface DmSinhVienLogics {

	List<DmSinhVien> getAllSinhVien(DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType);

	List<DmSinhVien> getAllSinhVienDetail(DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType);

	List<DmSinhVien> getListSinhVienByHeDaoTaoId(int heDaoTaoId, DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType);

	List<DmSinhVien> getListSinhVienByLopId(int lopId, DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType);

	List<DmSinhVien> getListSinhVienByKhoaHocId(int khoaHocId, DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType);

	DmSinhVien getSinhVienByMaSinhVien(String maSinhVien);

	DmSinhVien getSinhVienById(int sinhVienId);

	boolean addSinhVien(DmSinhVien sinhVien);

	boolean updateSinhVienByMaSinhVien(String maSinhVien, DmSinhVien sinhVien);

	boolean updateSinhVienById(int idSinhVien, DmSinhVien sinhVien);

	boolean deleteSinhVienByMaSinhVien(String maSinhVien);

	boolean deleteSinhVienById(int idSinhVien);

	List<String> getAllColumnName();

	int getTotalRecords(DmSinhVien sinhVien);

	boolean updateChuyenNganhSinhVien(int sinhVienId, int chuyenNganhId);
}
