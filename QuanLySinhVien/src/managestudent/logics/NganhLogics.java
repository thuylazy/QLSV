
package managestudent.logics;

import java.util.List;

import managestudent.entities.Nganh;

public interface NganhLogics {

	List<Nganh> getAllNganh(Nganh nganh, int offset, int limit, int sortColumn, String sortType);

	Nganh getNganhByMaNganh(String maNganh);

	Nganh getNganhById(int nganhId);

	boolean addNganh(Nganh nganh);

	boolean updateNganhByMaNganh(String maNganh, Nganh nganh);

	boolean deleteNganhByMaNganh(String maNganh);

	boolean deleteNganhById(int idNganh);

	List<String> getAllColumnName();

	int getTotalRecords(Nganh nganh);

	boolean updateNganhByID(int nganhId, Nganh nganh);
}
