
package managestudent.logics.impl;

import java.util.List;

import managestudent.dao.impl.HocKyDaoImpl;
import managestudent.entities.HocKy;
import managestudent.logics.HocKyLogics;

public class HocKyLogicsImpl implements HocKyLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.HocKyLogics#addHocKy(managestudent.entities.HocKy)
	 */
	@Override
	public boolean addHocKy(HocKy hocKy) {
		HocKyDaoImpl hocKyDao = new HocKyDaoImpl();
		boolean rs = hocKyDao.addHocKy(hocKy);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HocKyLogics#deleteHocKyById(int)
	 */
	@Override
	public boolean deleteHocKyById(int hocKyId) {
		HocKyDaoImpl hocKyDao = new HocKyDaoImpl();
		boolean rs = hocKyDao.deleteHocKyById(hocKyId);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HocKyLogics#getAllHocKy()
	 */
	@Override
	public List<HocKy> getAllHocKy(HocKy hocKy, int offset, int limit, int sortColumn, String sortType) {
		HocKyDaoImpl hocKyDao = new HocKyDaoImpl();
		List<HocKy> lsHocKy = hocKyDao.getAllHocKy(hocKy, offset, limit, sortColumn, sortType);

		return lsHocKy;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HocKyLogics#getHocKyById(int)
	 */
	@Override
	public HocKy getHocKyById(int hocKyId) {
		HocKyDaoImpl hocKyDao = new HocKyDaoImpl();
		HocKy hocKy = hocKyDao.getHocKyById(hocKyId);

		return hocKy;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HocKyLogics#updateHocKyById(int, managestudent.entities.HocKy)
	 */
	@Override
	public boolean updateHocKyById(int hocKyId, HocKy hocKy) {
		HocKyDaoImpl hocKyDao = new HocKyDaoImpl();
		boolean rs = hocKyDao.updateHocKyById(hocKyId, hocKy);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HocKyLogics#getAllColumnName()
	 */
	@Override
	public List<String> getAllColumnName() {
		HocKyDaoImpl hocKyDao = new HocKyDaoImpl();
		List<String> lsColumn = hocKyDao.getAllColumnName("hocky");

		return lsColumn;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HocKyLogics#getTotalRecords()
	 */
	@Override
	public int getTotalRecords(HocKy hocKy) {
		HocKyDaoImpl hocKyDao = new HocKyDaoImpl();
		int total = hocKyDao.getTotalRecords(hocKy);

		return total;
	}

}
