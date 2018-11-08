
package managestudent.dao;

import java.util.List;

import managestudent.entities.Diem;

public interface DiemDao extends BaseDao {

	List<Diem> getDiemBySinhVienId(int sinhVienId, int hocKyId);

	int addDiem(Diem diem);

	boolean updateDiemById(int diemId, Diem diem);

	boolean deleteDiemById(int diemId);
}
