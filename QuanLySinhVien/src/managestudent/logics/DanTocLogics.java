
package managestudent.logics;

import java.util.List;

import managestudent.entities.DanToc;

public interface DanTocLogics {

	List<DanToc> getAllDanToc(DanToc danToc, int offset, int limit, int sortColumn, String sortType);

	DanToc getDanTocById(int danTocId);

	boolean addDanToc(DanToc dt);

	boolean updateDanTocById(int danTocId, DanToc dt);

	boolean deleteDanTocById(int danTocId);

	List<String> getAllColumnName();

	int getTotalRecords(DanToc danToc);
}
