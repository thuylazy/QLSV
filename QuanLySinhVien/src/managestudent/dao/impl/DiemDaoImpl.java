
package managestudent.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import managestudent.dao.DiemDao;
import managestudent.entities.Diem;
import managestudent.entities.MonHoc;

public class DiemDaoImpl extends BaseDaoImpl implements DiemDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.DiemDao#addDiem(managestudent.entities.Diem)
	 */
	@Override
	public int addDiem(Diem diem) {
		int result = -1;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO diem ");
				sqlCommand.append("(monhoc_id, lanthi, diemthi, diemchuyencan, diemgiuaky, ");
				sqlCommand.append("hocky_id, sinhvien_id) ");
				sqlCommand.append("VALUES");
				sqlCommand.append("(?, ?, ?, ?, ?, ?, ?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString(), Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(1, diem.getMonHocId());
				preparedStatement.setString(2, diem.getLanThi());
				preparedStatement.setFloat(3, diem.getDiemThi());
				preparedStatement.setFloat(4, diem.getDiemChuyenCan());
				preparedStatement.setFloat(5, diem.getDiemGiuaKy());
				preparedStatement.setInt(6, diem.getHocKyId());
				preparedStatement.setInt(7, diem.getSinhVienId());
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					rs =  preparedStatement.getGeneratedKeys();
					if(rs != null) {
						while(rs.next()) {
							result = rs.getInt(1);
						}
					}
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				result = -1;
			}
			closeConnect();
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DiemDao#getDiemBySinhVienId(int)
	 */
	@Override
	public List<Diem> getDiemBySinhVienId(int sinhVienId, int hocKyId) {
		List<Diem> lsDiem = new ArrayList<Diem>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT diem.diem_id, monhoc.monhoc_id, monhoc.tenmonhoc, diem.diemthi, diem.diemchuyencan, diem.diemgiuaky, ");
				sqlCommand.append("monhoc.hesoChuyenCan, monhoc.hesoGiuaKy, monhoc.hesoHocKy ");
				sqlCommand.append("FROM diem ");
				sqlCommand.append("INNER JOIN dmsinhvien ON dmsinhvien.sinhvien_id = diem.sinhvien_id ");
				sqlCommand.append("INNER JOIN monhoc ON diem.monhoc_id = monhoc.monhoc_id ");
				sqlCommand.append("INNER JOIN hocky ON hocky.hocky_id = diem.hocky_id ");
				sqlCommand.append("WHERE dmsinhvien.sinhvien_id = ? ");
				sqlCommand.append("AND dmsinhvien.delete_flg = 0 ");
				if(hocKyId > 0) {
					sqlCommand.append("AND hocky.hocky_id = ? ");
				}
				sqlCommand.append("ORDER BY monhoc.monhoc_id ASC");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, sinhVienId);
				if(hocKyId > 0) {
					preparedStatement.setInt(2, hocKyId);
				}
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						Diem diem = new Diem();
						MonHoc monHoc = new MonHoc();

						diem.setDiemId(rs.getInt("diem_id"));
						diem.setMonHocId(rs.getInt("monhoc_id"));
						monHoc.setMonHocId(rs.getInt("monhoc_id"));
						monHoc.setTenMonHoc(rs.getString("tenmonhoc"));
						diem.setDiemThi(rs.getFloat("diemthi"));
						diem.setDiemChuyenCan(rs.getFloat("diemchuyencan"));
						diem.setDiemGiuaKy(rs.getFloat("diemgiuaky"));
						monHoc.setHeSoChuyenCan(rs.getFloat("hesoChuyenCan"));
						monHoc.setHeSoGiuaKy(rs.getFloat("hesoGiuaKy"));
						monHoc.setHeSoHocKy(rs.getFloat("hesoHocKy"));
						diem.setMonHoc(monHoc);

						lsDiem.add(diem);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				lsDiem = null;
			}
			closeConnect();
		}

		return lsDiem;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DiemDao#deleteDiemById(int)
	 */
	@Override
	public boolean deleteDiemById(int diemId) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM diem ");
				sqlCommand.append("WHERE diem_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, diemId);
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DiemDao#updateDiemById(int, managestudent.entities.Diem)
	 */
	@Override
	public boolean updateDiemById(int diemId, Diem diem) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE diem ");
				sqlCommand.append("SET monhoc_id = ?, lanthi = ?, diemthi = ?, diemchuyencan = ?, diemgiuaky = ?, hocky_id = ?, sinhvien_id = ? ");
				sqlCommand.append("WHERE diem_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, diem.getMonHocId());
				preparedStatement.setString(2, diem.getLanThi());
				preparedStatement.setFloat(3, diem.getDiemThi());
				preparedStatement.setFloat(4, diem.getDiemChuyenCan());
				preparedStatement.setFloat(5, diem.getDiemGiuaKy());
				preparedStatement.setFloat(6, diem.getHocKyId());
				preparedStatement.setFloat(7, diem.getSinhVienId());
				preparedStatement.setInt(8, diem.getDiemId());
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

}
