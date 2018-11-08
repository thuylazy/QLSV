
package managestudent.dao;

import java.util.List;

import managestudent.entities.MonHoc;

public interface MonHocDao extends BaseDao {

	List<MonHoc> getAllMonHoc(MonHoc monHoc, int offset, int limit, int sortColumn, String sortType);

	MonHoc getMonHocById(int monHocId);

	List<MonHoc> getMonHocByChuyenNganh(int chuyenNganhId, MonHoc monHoc, int offset, int limit, int sortColumn, String sortType);

	boolean addMonHoc(MonHoc monHoc);

	boolean updateMonHocById(int monHocId, MonHoc monHoc);

	boolean deleteMonHocById(int monHocId);

	int getTotalRecords(MonHoc monHoc);
}
