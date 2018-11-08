
package managestudent.dao;

import java.util.List;

import managestudent.entities.TonGiao;

public interface TonGiaoDao extends BaseDao {

	List<TonGiao> getAllTonGiao(TonGiao tonGiao, int offset, int limit, int sortColumn, String sortType);

	TonGiao getTonGiaoById(int tonGiaoId);

	boolean addTonGiao(TonGiao tonGiao);

	boolean updateTonGiaoById(int tonGiaoId, TonGiao tonGiao);

	boolean deleteTonGiaoById(int tonGiaoId);

	int getTotalRecords(TonGiao tonGiao);
}
