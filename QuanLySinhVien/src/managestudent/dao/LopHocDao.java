
package managestudent.dao;

import java.util.List;

import managestudent.entities.LopHoc;

public interface LopHocDao extends BaseDao {

	List<LopHoc> getAllLopHoc(LopHoc lopHoc, int offset, int limit, int sortColumn, String sortType);

	LopHoc getLopHocById(int lopHocId);

	boolean addLopHoc(LopHoc lopHoc);

	boolean updateLopHocById(int lopHocId, LopHoc lopHoc);

	boolean deleteLopHocById(int lopHocId);

	int getTotalRecords(LopHoc lopHoc);
}
