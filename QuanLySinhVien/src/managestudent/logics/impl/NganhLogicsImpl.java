
package managestudent.logics.impl;

import java.util.List;

import managestudent.dao.impl.NganhDaoImpl;
import managestudent.entities.Nganh;
import managestudent.logics.NganhLogics;

public class NganhLogicsImpl implements NganhLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.NganhLogics#addNganh(managestudent.entities.Nganh)
	 */
	@Override
	public boolean addNganh(Nganh nganh) {
		NganhDaoImpl nganhDao = new NganhDaoImpl();
		boolean rs = nganhDao.addNganh(nganh);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.NganhLogics#deleteNganhByMaNganh(java.lang.String)
	 */
	@Override
	public boolean deleteNganhByMaNganh(String maNganh) {
		NganhDaoImpl nganhDao = new NganhDaoImpl();
		boolean rs = nganhDao.deleteNganhByMaNganh(maNganh);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.NganhLogics#getAllNganh()
	 */
	@Override
	public List<Nganh> getAllNganh(Nganh nganh, int offset, int limit, int sortColumn, String sortType) {
		NganhDaoImpl nganhDao = new NganhDaoImpl();
		List<Nganh> lsNganh = nganhDao.getAllNganh(nganh, offset, limit, sortColumn, sortType);

		return lsNganh;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.NganhLogics#getNganhByMaNganh(java.lang.String)
	 */
	@Override
	public Nganh getNganhByMaNganh(String maNganh) {
		NganhDaoImpl nganhDao = new NganhDaoImpl();
		Nganh nganh = nganhDao.getNganhByMaNganh(maNganh);

		return nganh;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.NganhLogics#updateNganhByMaNganh(java.lang.String, managestudent.entities.Nganh)
	 */
	@Override
	public boolean updateNganhByMaNganh(String maNganh, Nganh nganh) {
		NganhDaoImpl nganhDao = new NganhDaoImpl();
		boolean rs = nganhDao.updateNganhByMaNganh(maNganh, nganh);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.NganhLogics#getAllColumnName()
	 */
	@Override
	public List<String> getAllColumnName() {
		NganhDaoImpl nganhDao = new NganhDaoImpl();
		List<String> lsColumn = nganhDao.getAllColumnName("nganh");

		return lsColumn;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.NganhLogics#getTotalRecords()
	 */
	@Override
	public int getTotalRecords(Nganh nganh) {
		NganhDaoImpl nganhDao = new NganhDaoImpl();
		int total = nganhDao.getTotalRecords(nganh);

		return total;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.NganhLogics#updateNganhByID(int, managestudent.entities.Nganh)
	 */
	@Override
	public boolean updateNganhByID(int nganhId, Nganh nganh) {
		NganhDaoImpl nganhDao = new NganhDaoImpl();
		boolean rs = nganhDao.updateNganhByID(nganhId, nganh);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.NganhLogics#getNganhById(int)
	 */
	@Override
	public Nganh getNganhById(int nganhId) {
		NganhDaoImpl nganhDao = new NganhDaoImpl();
		Nganh nganh = nganhDao.getNganhById(nganhId);

		return nganh;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.NganhLogics#deleteNganhById(int)
	 */
	@Override
	public boolean deleteNganhById(int idNganh) {
		NganhDaoImpl nganhDao = new NganhDaoImpl();
		boolean rs = nganhDao.deleteNganhById(idNganh);

		return rs;
	}

}
