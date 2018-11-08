
package managestudent.dao;

import java.util.List;

import managestudent.entities.ChuyenNganh;

public interface ChuyenNganhDao extends BaseDao {

	List<ChuyenNganh> getAllChuyenNganh(ChuyenNganh chuyenNganh, int offset, int limit, int sortColumn, String sortType);

	ChuyenNganh getChuyenNganhByMaCN(String maChuyenNganh);

	ChuyenNganh getChuyenNganhById(int chuyenNganhId);

	List<ChuyenNganh> getChuyenNganhByNganhId(int nganhId, ChuyenNganh chuyenNganh, int offset, int limit, int sortColumn, String sortType);

	boolean addChuyenNganh(ChuyenNganh cn);

	boolean updateChuyenNganhByMaChuyenNganh(ChuyenNganh cn);

	boolean updateChuyenNganhById(int chuyenNganhId, ChuyenNganh cn);

	boolean deleteChuyenNganhByMaChuyenNganh(String maChuyenNganh);

	boolean deleteChuyenNganhById(int idChuyenNganh);

	int getTotalRecords(ChuyenNganh chuyenNganh);
}
