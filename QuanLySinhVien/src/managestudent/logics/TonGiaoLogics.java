
package managestudent.logics;

import java.util.List;

import managestudent.entities.TonGiao;

public interface TonGiaoLogics {

	List<TonGiao> getAllTonGiao(TonGiao tonGiao, int offset, int limit, int sortColumn, String sortType);

	TonGiao getTonGiaoById(int tonGiaoId);

	boolean addTonGiao(TonGiao tonGiao);

	boolean updateTonGiaoById(int tonGiaoId, TonGiao tonGiao);

	boolean deleteTonGiaoById(int tonGiaoId);

	List<String> getAllColumnName();

	int getTotalRecords(TonGiao tonGiao);
}
