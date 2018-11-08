
package managestudent.logics.impl;

import java.util.List;

import managestudent.dao.impl.TonGiaoDaoImpl;
import managestudent.entities.TonGiao;
import managestudent.logics.TonGiaoLogics;

public class TonGIaoLogicsImpl implements TonGiaoLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.TonGiaoLogics#addTonGiao(managestudent.entities.TonGiao)
	 */
	@Override
	public boolean addTonGiao(TonGiao tonGiao) {
		TonGiaoDaoImpl tonGiaoDao = new TonGiaoDaoImpl();
		boolean rs = tonGiaoDao.addTonGiao(tonGiao);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.TonGiaoLogics#deleteTonGiaoById(int)
	 */
	@Override
	public boolean deleteTonGiaoById(int tonGiaoId) {
		TonGiaoDaoImpl tonGiaoDao = new TonGiaoDaoImpl();
		boolean rs = tonGiaoDao.deleteTonGiaoById(tonGiaoId);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.TonGiaoLogics#getAllTonGiao()
	 */
	@Override
	public List<TonGiao> getAllTonGiao(TonGiao tonGiao, int offset, int limit, int sortColumn, String sortType) {
		TonGiaoDaoImpl tonGiaoDao = new TonGiaoDaoImpl();
		List<TonGiao> lsTonGiao = tonGiaoDao.getAllTonGiao(tonGiao, offset, limit, sortColumn, sortType);

		return lsTonGiao;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.TonGiaoLogics#getTonGiaoById(int)
	 */
	@Override
	public TonGiao getTonGiaoById(int tonGiaoId) {
		TonGiaoDaoImpl tonGiaoDao = new TonGiaoDaoImpl();
		TonGiao tonGiao = tonGiaoDao.getTonGiaoById(tonGiaoId);

		return tonGiao;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.TonGiaoLogics#updateTonGiaoById(int, managestudent.entities.TonGiao)
	 */
	@Override
	public boolean updateTonGiaoById(int tonGiaoId, TonGiao tonGiao) {
		TonGiaoDaoImpl tonGiaoDao = new TonGiaoDaoImpl();
		boolean rs = tonGiaoDao.updateTonGiaoById(tonGiaoId, tonGiao);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.TonGiaoLogics#getAllColumnName()
	 */
	@Override
	public List<String> getAllColumnName() {
		TonGiaoDaoImpl tonGiaoDao = new TonGiaoDaoImpl();
		List<String> lsColumn = tonGiaoDao.getAllColumnName("tongiao");

		return lsColumn;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.TonGiaoLogics#getTotalRecords()
	 */
	@Override
	public int getTotalRecords(TonGiao tonGiao) {
		TonGiaoDaoImpl tonGiaoDao = new TonGiaoDaoImpl();
		int total = tonGiaoDao.getTotalRecords(tonGiao);

		return total;
	}

}
