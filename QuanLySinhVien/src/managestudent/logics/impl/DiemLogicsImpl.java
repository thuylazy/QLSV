
package managestudent.logics.impl;

import java.util.List;

import managestudent.dao.impl.DiemDaoImpl;
import managestudent.entities.Diem;
import managestudent.logics.DiemLogics;

public class DiemLogicsImpl implements DiemLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.DiemLogics#addDiem(managestudent.entities.Diem)
	 */
	@Override
	public int addDiem(Diem diem) {
		DiemDaoImpl diemDao = new DiemDaoImpl();
		int rs = diemDao.addDiem(diem);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DiemLogics#deleteDiemById(int)
	 */
	@Override
	public boolean deleteDiemById(int diemId) {
		DiemDaoImpl diemDao = new DiemDaoImpl();
		boolean rs = diemDao.deleteDiemById(diemId);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DiemLogics#getDiemBySinhVienId(int)
	 */
	@Override
	public List<Diem> getDiemBySinhVienId(int sinhVienId, int hocKyId) {
		DiemDaoImpl diemDao = new DiemDaoImpl();
		List<Diem> lsDiem = diemDao.getDiemBySinhVienId(sinhVienId, hocKyId);

		return lsDiem;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DiemLogics#updateDiemById(int, managestudent.entities.Diem)
	 */
	@Override
	public boolean updateDiemById(int diemId, Diem diem) {
		DiemDaoImpl diemDao = new DiemDaoImpl();
		boolean rs = diemDao.updateDiemById(diemId, diem);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DiemLogics#getAllColumnName()
	 */
	@Override
	public List<String> getAllColumnName() {
		DiemDaoImpl diemDao = new DiemDaoImpl();
		List<String> lsColumn = diemDao.getAllColumnName("diem");

		return lsColumn;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DiemLogics#getTotalRecords()
	 */
	@Override
	public int getTotalRecords() {
		DiemDaoImpl diemDao = new DiemDaoImpl();
		int total = diemDao.getTotalRecords("diem");

		return total;
	}

}
