
package managestudent.logics;

import java.util.List;

import managestudent.entities.MonHoc;

public interface MonHocLogics {

	List<MonHoc> getAllMonHoc(MonHoc monHoc, int offset, int limit, int sortColumn, String sortType);

	MonHoc getMonHocById(int monHocId);

	List<MonHoc> getMonHocByChuyenNganh(int chuyenNganhId, MonHoc monHoc, int offset, int limit, int sortColumn, String sortType);

	boolean addMonHoc(MonHoc monHoc);

	boolean updateMonHocById(int monHocId, MonHoc monHoc);

	boolean deleteMonHocById(int monHocId);

	List<String> getAllColumnName();

	int getTotalRecords(MonHoc monHoc);
}
