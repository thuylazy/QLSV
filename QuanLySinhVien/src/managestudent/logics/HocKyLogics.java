
package managestudent.logics;

import java.util.List;

import managestudent.entities.HocKy;

public interface HocKyLogics {

	List<HocKy> getAllHocKy(HocKy hocKy, int offset, int limit, int sortColumn, String sortType);

	HocKy getHocKyById(int hocKyId);

	boolean addHocKy(HocKy hocKy);

	boolean updateHocKyById(int hocKyId, HocKy hocKy);

	boolean deleteHocKyById(int hocKyId);

	List<String> getAllColumnName();

	int getTotalRecords(HocKy hocKy);
}
