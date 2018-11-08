
package managestudent.logics;

import java.util.List;

import managestudent.entities.Diem;

public interface DiemLogics {

	List<Diem> getDiemBySinhVienId(int sinhVienId, int hocKyId);

	int addDiem(Diem diem);

	boolean updateDiemById(int diemId, Diem diem);

	boolean deleteDiemById(int diemId);

	List<String> getAllColumnName();

	int getTotalRecords();
}
