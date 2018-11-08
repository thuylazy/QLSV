
package managestudent.dao;

import java.util.List;

import managestudent.entities.KhoaHoc;

public interface KhoaHocDao extends BaseDao {

	List<KhoaHoc> getAllKhoaHoc(KhoaHoc khoaHoc, int offset, int limit, int sortColumn, String sortType);

	KhoaHoc getKhoaHocById(int khoaHocId);

	boolean addKhoaHoc(KhoaHoc khoaHoc);

	boolean updateKhoaHocById(int khoaHocId, KhoaHoc khoaHoc);

	boolean deleteKhoaHocById(int khoaHocId);

	int getTotalRecords(KhoaHoc khoaHoc);
}
