
package managestudent.dao;

import java.util.List;

import managestudent.entities.Nganh;

public interface NganhDao extends BaseDao {

	List<Nganh> getAllNganh(Nganh nganh, int offset, int limit, int sortColumn, String sortType);

	Nganh getNganhByMaNganh(String maNganh);

	Nganh getNganhById(int nganhId);

	boolean addNganh(Nganh nganh);

	boolean updateNganhByMaNganh(String maNganh, Nganh nganh);

	boolean updateNganhByID(int nganhId, Nganh nganh);

	boolean deleteNganhByMaNganh(String maNganh);

	boolean deleteNganhById(int idNganh);

	int getTotalRecords(Nganh nganh);
}
