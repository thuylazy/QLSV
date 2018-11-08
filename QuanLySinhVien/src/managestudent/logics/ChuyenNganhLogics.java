
package managestudent.logics;

import java.util.List;

import managestudent.entities.ChuyenNganh;

public interface ChuyenNganhLogics {

	List<ChuyenNganh> getAllChuyenNganh(ChuyenNganh chuyenNganh, int offset, int limit, int sortColumn, String sortType);

	ChuyenNganh getChuyenNganhByMaCN(String maChuyenNganh);

	List<ChuyenNganh> getChuyenNganhByNganhId(int nganhId, ChuyenNganh chuyenNganh, int offset, int limit, int sortColumn, String sortType);

	boolean addChuyenNganh(ChuyenNganh cn);

	boolean updateChuyenNganhByMaChuyenNganh(ChuyenNganh cn);

	boolean updateChuyenNganhById(int chuyenNganhId, ChuyenNganh cn);

	boolean deleteChuyenNganhByMaChuyenNganh(String maChuyenNganh);

	boolean deleteChuyenNganhById(int idChuyenNganh);

	List<String> getAllColumnName();

	ChuyenNganh getChuyenNganhById(int chuyenNganhId);

	int getTotalRecords(ChuyenNganh chuyenNganh);
}
