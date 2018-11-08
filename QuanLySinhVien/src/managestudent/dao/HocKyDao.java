
package managestudent.dao;

import java.util.List;

import managestudent.entities.HocKy;

public interface HocKyDao extends BaseDao {

	List<HocKy> getAllHocKy(HocKy hocKy, int offset, int limit, int sortColumn, String sortType);

	HocKy getHocKyById(int hocKyId);

	boolean addHocKy(HocKy hocKy);

	boolean updateHocKyById(int hocKyId, HocKy hocKy);

	boolean deleteHocKyById(int hocKyId);

	int getTotalRecords(HocKy hocKy);
}
