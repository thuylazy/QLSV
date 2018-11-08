
package managestudent.dao;

import java.util.List;

import managestudent.entities.DanToc;

public interface DanTocDao extends BaseDao {

	List<DanToc> getAllDanToc(DanToc danToc, int offset, int limit, int sortColumn, String sortType);

	DanToc getDanTocById(int danTocId);

	boolean addDanToc(DanToc dt);

	boolean updateDanTocById(int danTocId, DanToc dt);

	boolean deleteDanTocById(int danTocId);

	int getTotalRecords(DanToc danToc);
}
