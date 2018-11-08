
package managestudent.logics.impl;

import java.util.List;

import managestudent.dao.impl.LopHocDaoImpl;
import managestudent.entities.LopHoc;
import managestudent.logics.LopHocLogics;

public class LopHocLogicsImpl implements LopHocLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.LopHocLogics#addLopHoc(managestudent.entities.LopHoc)
	 */
	@Override
	public boolean addLopHoc(LopHoc lopHoc) {
		LopHocDaoImpl lopHocDao = new LopHocDaoImpl();
		boolean rs = lopHocDao.addLopHoc(lopHoc);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.LopHocLogics#deleteLopHocById(int)
	 */
	@Override
	public boolean deleteLopHocById(int lopHocId) {
		LopHocDaoImpl lopHocDao = new LopHocDaoImpl();
		boolean rs = lopHocDao.deleteLopHocById(lopHocId);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.LopHocLogics#getAllLopHoc()
	 */
	@Override
	public List<LopHoc> getAllLopHoc(LopHoc lopHoc, int offset, int limit, int sortColumn, String sortType) {
		LopHocDaoImpl lopHocDao = new LopHocDaoImpl();
		List<LopHoc> lsLopHoc = lopHocDao.getAllLopHoc(lopHoc, offset, limit, sortColumn, sortType);

		return lsLopHoc;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.LopHocLogics#getLopHocById(int)
	 */
	@Override
	public LopHoc getLopHocById(int lopHocId) {
		LopHocDaoImpl lopHocDao = new LopHocDaoImpl();
		LopHoc lopHoc = lopHocDao.getLopHocById(lopHocId);

		return lopHoc;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.LopHocLogics#updateLopHocById(int, managestudent.entities.LopHoc)
	 */
	@Override
	public boolean updateLopHocById(int lopHocId, LopHoc lopHoc) {
		LopHocDaoImpl lopHocDao = new LopHocDaoImpl();
		boolean rs = lopHocDao.updateLopHocById(lopHocId, lopHoc);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.LopHocLogics#getAllColumnName()
	 */
	@Override
	public List<String> getAllColumnName() {
		LopHocDaoImpl lopHocDao = new LopHocDaoImpl();
		List<String> lsColumn = lopHocDao.getAllColumnName("lophoc");

		return lsColumn;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.LopHocLogics#getTotalRecords()
	 */
	@Override
	public int getTotalRecords(LopHoc lopHoc) {
		LopHocDaoImpl lopHocDao = new LopHocDaoImpl();
		int total = lopHocDao.getTotalRecords(lopHoc);

		return total;
	}

}
