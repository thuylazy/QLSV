
package managestudent.logics;

import java.util.List;

import managestudent.entities.KhoaHoc;

public interface KhoaHocLogics {

	List<KhoaHoc> getAllKhoaHoc(KhoaHoc khoaHoc, int offset, int limit, int sortColumn, String sortType);

	KhoaHoc getKhoaHocById(int khoaHocId);

	boolean addKhoaHoc(KhoaHoc khoaHoc);

	boolean updateKhoaHocById(int khoaHocId, KhoaHoc khoaHoc);

	boolean deleteKhoaHocById(int khoaHocId);

	List<String> getAllColumnName();

	int getTotalRecords(KhoaHoc khoaHoc);
}
