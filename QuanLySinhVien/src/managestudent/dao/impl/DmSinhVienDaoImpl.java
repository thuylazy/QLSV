
package managestudent.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import managestudent.dao.DmSinhVienDao;
import managestudent.entities.DmSinhVien;

public class DmSinhVienDaoImpl extends BaseDaoImpl implements DmSinhVienDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#getAllSinhVien()
	 */
	@Override
	public List<DmSinhVien> getAllSinhVien(DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType) {
		List<DmSinhVien> lsSinhVien = new ArrayList<DmSinhVien>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				String tmp = "";
				int pos = -1;
				int countChar = 0;
				int conCount = 0;

				sqlCommand.append("SELECT sv.sinhvien_id, sv.masv, sv.hodem, sv.ten, sv.ngaysinh, sv.gioitinh, ");
				sqlCommand.append("sv.lop_id, sv.khoahoc_id, l.tenlop, kh.tenkhoahoc ");
				sqlCommand.append("FROM dmsinhvien sv ");
				sqlCommand.append("INNER JOIN lophoc l ");
				sqlCommand.append("ON sv.lop_id = l.lop_id ");
				sqlCommand.append("INNER JOIN khoahoc kh ");
				sqlCommand.append("ON sv.khoahoc_id = kh.khoahoc_id ");

				if(sinhVien.getMaSinhVien().length() > 0) {
					sqlCommand.append("WHERE sv.masv LIKE ? ");
					conCount++;
				}
				if(sinhVien.getHoDem().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.hodem LIKE ? ");
					conCount++;
				}
				if(sinhVien.getTen().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.ten LIKE ? ");
					conCount++;
				}
				if(sinhVien.getNgaySinh().compareTo(new java.util.Date()) == 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.ngaysinh = ? ");
					conCount++;
				}
				if(sinhVien.getGioiTinh() >= 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.gioitinh = ? ");
					conCount++;
				}
				if(sinhVien.getCmtnd().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.cmtnd LIKE ? ");
					conCount++;
				}
				if(sinhVien.getSoDienThoai().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.sodthoai LIKE ? ");
					conCount++;
				}
				if(sinhVien.getNoiSinh().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.noisinh LIKE ? ");
					conCount++;
				}
				if(sinhVien.getQueQuan().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.quequan LIKE ? ");
					conCount++;
				}
				if(sinhVien.getCheDoUuDai().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.chedouudai LIKE ? ");
					conCount++;
				}
				if(sinhVien.getDanTocId() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.dantoc_id = ? ");
					conCount++;
				}
				if(sinhVien.getTonGiaoId() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.tongiao_id = ? ");
					conCount++;
				}
				
				if(sinhVien.getTenLopHoc().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("l.tenlop LIKE ? ");
					conCount++;
				}
				if(sinhVien.getLopId() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.lop_id = ? ");
					conCount++;
				}
				if(sinhVien.getTenKhoaHoc().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("kh.tenkhoahoc LIKE ? ");
					conCount++;
				}
				if(sinhVien.getKhoaHocId() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.khoahoc_id = ? ");
					conCount++;
				}
				if(conCount > 0) {
					sqlCommand.append("AND ");
				} else {
					sqlCommand.append("WHERE ");
				}

				sqlCommand.append("delete_flg = ? ");
				conCount++;

				sqlCommand.append("ORDER BY ");
				if(sortColumn == 2) {
					sqlCommand.append("sv.hodem ");
				} else if(sortColumn == 3) {
					sqlCommand.append("sv.ten ");
				} else if(sortColumn == 4) {
					sqlCommand.append("sv.ngaysinh ");
				} else if(sortColumn == 5) {
					sqlCommand.append("sv.gioitinh ");
				} else if(sortColumn == 7) {
					sqlCommand.append("l.tenlop ");
				} else if(sortColumn == 8) {
					sqlCommand.append("kh.tenkhoahoc ");
				} else {
					sqlCommand.append("sv.masv ");
				}
				sqlCommand.append(sortType + " ");

				sqlCommand.append("LIMIT " + offset + ", " + limit);

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(sqlCommand.indexOf("sv.masv LIKE ?") > 0) {
					preparedStatement.setString(1, "%" + sinhVien.getMaSinhVien() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.hodem LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getHoDem() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.ten LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getTen() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.ngaysinh = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setDate(countChar + 1, new Date(sinhVien.getNgaySinh().getTime()));
				}
				if((pos = sqlCommand.indexOf("sv.gioitinh = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, sinhVien.getGioiTinh());
				}
				if((pos = sqlCommand.indexOf("sv.cmtnd LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getCmtnd() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.sodthoai LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getSoDienThoai() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.noisinh LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getNoiSinh() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.quequan LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getQueQuan() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.chedouudai LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getCheDoUuDai() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.dantoc_id = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, sinhVien.getDanTocId());
				}
				if((pos = sqlCommand.indexOf("sv.tongiaoid = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, sinhVien.getTonGiaoId());
				}
				
				if((pos = sqlCommand.indexOf("sv.lop_id = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, sinhVien.getLopId());
				}
				if((pos = sqlCommand.indexOf("l.tenlop LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getTenLopHoc() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.khoahoc_id = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, sinhVien.getKhoaHocId());
				}
				if((pos = sqlCommand.indexOf("kh.tenkhoahoc LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getTenKhoaHoc() + "%");
				}
				if((pos = sqlCommand.indexOf("delete_flg = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "0");
				}

				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						DmSinhVien objSinhVien = new DmSinhVien(rs.getInt("sinhvien_id"), rs.getString("masv"), rs.getString("hodem"), rs.getString("ten"),
								rs.getDate("ngaysinh"), rs.getInt("gioitinh"), rs.getInt("lop_id"), rs.getInt("khoahoc_id"));

						lsSinhVien.add(objSinhVien);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsSinhVien = null;
			}
			closeConnect();
		}

		return lsSinhVien;
	}


	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#getListSinhVienByKhoaHocId(int)
	 */
	@Override
	public List<DmSinhVien> getListSinhVienByKhoaHocId(int khoaHocId, DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType) {
		List<DmSinhVien> lsSinhVien = new ArrayList<DmSinhVien>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				String tmp = "";
				int pos = -1;
				int countChar = 0;

				sqlCommand.append("SELECT sv.sinhvien_id, sv.masv, sv.hodem, sv.ten, sv.ngaysinh, sv.gioitinh, ");
				sqlCommand.append("sv.lop_id, sv.khoahoc_id, l.tenlop, kh.tenkhoahoc ");
				sqlCommand.append("FROM dmsinhvien sv ");
				sqlCommand.append("INNER JOIN lophoc l ");
				sqlCommand.append("ON sv.lop_id = l.lop_id ");
				sqlCommand.append("INNER JOIN khoahoc kh ");
				sqlCommand.append("ON sv.khoahoc_id = kh.khoahoc_id ");

				sqlCommand.append("WHERE sv.khoahoc_id = ? ");
				if(sinhVien.getMaSinhVien().length() > 0) {
					sqlCommand.append("AND sv.masv LIKE ? ");
				}
				if(sinhVien.getHoDem().length() > 0) {
					sqlCommand.append("AND sv.hodem LIKE ? ");
				}
				if(sinhVien.getTen().length() > 0) {
					sqlCommand.append("AND sv.ten LIKE ? ");
				}
				if(sinhVien.getTenLopHoc().length() > 0) {
					sqlCommand.append("AND l.tenlop LIKE ? ");
				}
				if(sinhVien.getLopId() > 0) {
					sqlCommand.append("AND sv.lop_id = ? ");
				}
				if(sinhVien.getTenKhoaHoc().length() > 0) {
					sqlCommand.append("AND kh.tenkhoahoc LIKE ? ");
				}
				if(sinhVien.getKhoaHocId() > 0) {
					sqlCommand.append("AND sv.khoahoc_id = ? ");
				}
				sqlCommand.append("AND delete_flg = 0 ");

				sqlCommand.append("ORDER BY ");
				if(sortColumn == 2) {
					sqlCommand.append("sv.hodem ");
				} else if(sortColumn == 3) {
					sqlCommand.append("sv.ten ");
				} else if(sortColumn == 4) {
					sqlCommand.append("sv.ngaysinh ");
				} else if(sortColumn == 5) {
					sqlCommand.append("sv.gioitinh ");
				} else if(sortColumn == 7) {
					sqlCommand.append("l.tenlop ");
				} else if(sortColumn == 8) {
					sqlCommand.append("kh.tenkhoahoc ");
				} else {
					sqlCommand.append("sv.masv ");
				}
				sqlCommand.append(sortType + " ");

				sqlCommand.append("LIMIT " + offset + ", " + limit);

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				preparedStatement.setInt(1, khoaHocId);
				if((pos = sqlCommand.indexOf("sv.masv LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getMaSinhVien() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.hodem LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getHoDem() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.ten LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getTen() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.lop_id = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, sinhVien.getLopId());
				}
				if((pos = sqlCommand.indexOf("l.tenlop LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getTenLopHoc() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.khoahoc_id = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, sinhVien.getKhoaHocId());
				}
				if((pos = sqlCommand.indexOf("kh.tenkhoahoc LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getTenKhoaHoc() + "%");
				}

				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						DmSinhVien objSinhVien = new DmSinhVien(rs.getInt("sinhvien_id"), rs.getString("masv"), rs.getString("hodem"), rs.getString("ten"),
								rs.getDate("ngaysinh"), rs.getInt("gioitinh"), rs.getInt("lop_id"), rs.getInt("khoahoc_id"));

						lsSinhVien.add(objSinhVien);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsSinhVien = null;
			}
			closeConnect();
		}

		return lsSinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#getListSinhVienByLopId(int)
	 */
	@Override
	public List<DmSinhVien> getListSinhVienByLopId(int lopId, DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType) {
		List<DmSinhVien> lsSinhVien = new ArrayList<DmSinhVien>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				String tmp = "";
				int pos = -1;
				int countChar = 0;

				sqlCommand.append("SELECT sv.sinhvien_id, sv.masv, sv.hodem, sv.ten, sv.ngaysinh, sv.gioitinh, ");
				sqlCommand.append(" sv.lop_id, sv.khoahoc_id, l.tenlop, kh.tenkhoahoc ");
				sqlCommand.append("FROM dmsinhvien sv ");
				sqlCommand.append("INNER JOIN lophoc l ");
				sqlCommand.append("ON sv.lop_id = l.lop_id ");
				sqlCommand.append("INNER JOIN khoahoc kh ");
				sqlCommand.append("ON sv.khoahoc_id = kh.khoahoc_id ");

				sqlCommand.append("WHERE sv.lop_id = ? ");
				if(sinhVien.getMaSinhVien().length() > 0) {
					sqlCommand.append("AND sv.masv LIKE ? ");
				}
				if(sinhVien.getHoDem().length() > 0) {
					sqlCommand.append("AND sv.hodem LIKE ? ");
				}
				if(sinhVien.getTen().length() > 0) {
					sqlCommand.append("AND sv.ten LIKE ? ");
				}
				if(sinhVien.getTenLopHoc().length() > 0) {
					sqlCommand.append("AND l.tenlop LIKE ? ");
				}
				if(sinhVien.getLopId() > 0) {
					sqlCommand.append("AND sv.lop_id = ? ");
				}
				if(sinhVien.getTenKhoaHoc().length() > 0) {
					sqlCommand.append("AND kh.tenkhoahoc LIKE ? ");
				}
				if(sinhVien.getKhoaHocId() > 0) {
					sqlCommand.append("AND sv.khoahoc_id = ? ");
				}
				sqlCommand.append("AND delete_flg = 0 ");

				sqlCommand.append("ORDER BY ");
				if(sortColumn == 2) {
					sqlCommand.append("sv.hodem ");
				} else if(sortColumn == 3) {
					sqlCommand.append("sv.ten ");
				} else if(sortColumn == 4) {
					sqlCommand.append("sv.ngaysinh ");
				} else if(sortColumn == 5) {
					sqlCommand.append("sv.gioitinh ");
				} else if(sortColumn == 7) {
					sqlCommand.append("l.tenlop ");
				} else if(sortColumn == 8) {
					sqlCommand.append("kh.tenkhoahoc ");
				} else {
					sqlCommand.append("sv.masv ");
				}
				sqlCommand.append(sortType + " ");

				sqlCommand.append("LIMIT " + offset + ", " + limit);

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				preparedStatement.setInt(1, lopId);
				if((pos = sqlCommand.indexOf("sv.masv LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getMaSinhVien() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.hodem LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getHoDem() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.ten LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getTen() + "%");
				}
				
				if((pos = sqlCommand.indexOf("sv.lop_id = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, sinhVien.getLopId());
				}
				if((pos = sqlCommand.indexOf("l.tenlop LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getTenLopHoc() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.khoahoc_id = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, sinhVien.getKhoaHocId());
				}
				if((pos = sqlCommand.indexOf("kh.tenkhoahoc LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getTenKhoaHoc() + "%");
				}

				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						DmSinhVien objSinhVien = new DmSinhVien(rs.getInt("sinhvien_id"), rs.getString("masv"), rs.getString("hodem"), rs.getString("ten"),
								rs.getDate("ngaysinh"), rs.getInt("gioitinh"), rs.getInt("lop_id"), rs.getInt("khoahoc_id"));

						lsSinhVien.add(objSinhVien);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsSinhVien = null;
			}
			closeConnect();
		}

		return lsSinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#getSinhVienByMaSinhVien(java.lang.String)
	 */
	@Override
	public DmSinhVien getSinhVienByMaSinhVien(String maSinhVien) {
		DmSinhVien sinhVien = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT sinhvien_id, masv, hodem, ten, ngaysinh, gioitinh, cmtnd, ");
				sqlCommand.append("sodthoai, noisinh, quequan, hokhauthuongtru, noiohientai, ");
				sqlCommand.append("chedouudai, dantoc_id, tongiao_id, hotenbo, ");
				sqlCommand.append("nghenghiepbo, hotenme, nghenghiepme, lop_id, khoahoc_id, ");
				sqlCommand.append("ngaynhaphoc, diemdauvao1, diemdauvao2, diemdauvao3, anhsinhvien ");
				sqlCommand.append("FROM dmsinhvien ");
				sqlCommand.append("WHERE masv = ? AND delete_flg = 0 ");
				sqlCommand.append("ORDER BY masv ASC");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, maSinhVien);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						sinhVien = new DmSinhVien(rs.getInt("sinhvienid"), rs.getString("masv"), rs.getString("hodem"), rs.getString("ten"),
								rs.getDate("ngaysinh"), rs.getInt("gioitinh"), rs.getString("cmtnd"), rs.getString("sodthoai"), rs.getString("noisinh"),
								rs.getString("quequan"), rs.getString("hokhauthuongtru"), rs.getString("noiohientai"), rs.getString("chedouudai"),
								rs.getInt("dantoc_id"), rs.getInt("tongiao_id"), rs.getString("hotenbo"), rs.getString("nghenghiepbo"),
								rs.getString("hotenme"), rs.getString("nghenghiepme"), rs.getInt("lop_id"), rs.getInt("khoahoc_id"),
								rs.getDate("ngaynhaphoc"), rs.getFloat("diemdauvao1"), rs.getFloat("diemdauvao2"), rs.getFloat("diemdauvao3"), rs.getString("anhsinhvien"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				sinhVien = null;
			}
			closeConnect();
		}

		return sinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#addSinhVien(managestudent.entities.DmSinhVien)
	 */
	@Override
	public boolean addSinhVien(DmSinhVien sinhVien) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO dmsinhvien ");
				sqlCommand.append("(masv, hodem, ten, ngaysinh, gioitinh, cmtnd, sodthoai, noisinh, ");
				sqlCommand.append("quequan, hokhauthuongtru, noiohientai, chedouudai, dantoc_id, tongiao_id, ");
				sqlCommand.append("hotenbo, nghenghiepbo, hotenme, nghenghiepme, lop_id, khoahoc_id, ngaynhaphoc, ");
				sqlCommand.append("diemdauvao1, diemdauvao2, diemdauvao3, anhsinhvien) ");
				sqlCommand.append("VALUES ");
				sqlCommand.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, sinhVien.getMaSinhVien());
				preparedStatement.setString(2, sinhVien.getHoDem());
				preparedStatement.setString(3, sinhVien.getTen());
				preparedStatement.setDate(4, new Date(sinhVien.getNgaySinh().getTime()));
				preparedStatement.setInt(5, sinhVien.getGioiTinh());
				preparedStatement.setString(6, sinhVien.getCmtnd());
				preparedStatement.setString(7, sinhVien.getSoDienThoai());
				preparedStatement.setString(8, sinhVien.getNoiSinh());
				preparedStatement.setString(9, sinhVien.getQueQuan());
				preparedStatement.setString(10, sinhVien.getHoKhauThuongTru());
				preparedStatement.setString(11, sinhVien.getNoiOHienTai());
				preparedStatement.setString(12, sinhVien.getCheDoUuDai());
				preparedStatement.setInt(13, sinhVien.getDanTocId());
				preparedStatement.setInt(14, sinhVien.getTonGiaoId());
				preparedStatement.setString(16, sinhVien.getHoTenBo());
				preparedStatement.setString(17, sinhVien.getNgheNghiepBo());
				preparedStatement.setString(18, sinhVien.getHoTenMe());
				preparedStatement.setString(19, sinhVien.getNgheNghiepMe());
				preparedStatement.setInt(21, sinhVien.getLopId());
				preparedStatement.setInt(22, sinhVien.getKhoaHocId());
				preparedStatement.setDate(23, new Date(sinhVien.getNgayNhapHoc().getTime()));
				preparedStatement.setFloat(24, sinhVien.getDiemDauVao1());
				preparedStatement.setFloat(25, sinhVien.getDiemDauVao2());
				preparedStatement.setFloat(26, sinhVien.getDiemDauVao3());
				preparedStatement.setString(27, sinhVien.getAnhSinhVien());
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#deleteSinhVienByMaSinhVien(java.lang.String)
	 */
	@Override
	public boolean deleteSinhVienByMaSinhVien(String maSinhVien) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE dmsinhvien ");
				sqlCommand.append("SET delete_flg = 1 ");
				sqlCommand.append("WHERE masv = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, maSinhVien);
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#updateSinhVienByMaSinhVien(managestudent.entities.DmSinhVien)
	 */
	@Override
	public boolean updateSinhVienByMaSinhVien(String maSinhVien, DmSinhVien sinhVien) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE dmsinhvien ");
				sqlCommand.append("SET masv = ?, hodem = ?, ten = ?, ngaysinh = ?, gioitinh = ?, cmtnd = ?, sodthoai = ?, noisinh = ?, ");
				sqlCommand.append("quequan = ?, hokhauthuongtru = ?, noiohientai = ?, chedouudai = ?, dantoc_id = ?, tongiao_id = ?, ");
				sqlCommand.append("hotenbo = ?, nghenghiepbo = ?, hotenme = ?, nghenghiepme = ?, lop_id = ?, ");
				sqlCommand.append("khoahoc_id = ?, ngaynhaphoc = ?, diemdauvao1 = ?, diemdauvao2 = ?, diemdauvao3 = ?, anhsinhvien = ? ");
				sqlCommand.append("WHERE masv = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, sinhVien.getMaSinhVien());
				preparedStatement.setString(2, sinhVien.getHoDem());
				preparedStatement.setString(3, sinhVien.getTen());
				preparedStatement.setDate(4, new Date(sinhVien.getNgaySinh().getTime()));
				preparedStatement.setInt(5, sinhVien.getGioiTinh());
				preparedStatement.setString(6, sinhVien.getCmtnd());
				preparedStatement.setString(7, sinhVien.getSoDienThoai());
				preparedStatement.setString(8, sinhVien.getNoiSinh());
				preparedStatement.setString(9, sinhVien.getQueQuan());
				preparedStatement.setString(10, sinhVien.getHoKhauThuongTru());
				preparedStatement.setString(11, sinhVien.getNoiOHienTai());
				preparedStatement.setString(12, sinhVien.getCheDoUuDai());
				preparedStatement.setInt(13, sinhVien.getDanTocId());
				preparedStatement.setInt(14, sinhVien.getTonGiaoId());
				preparedStatement.setString(16, sinhVien.getHoTenBo());
				preparedStatement.setString(17, sinhVien.getNgheNghiepBo());
				preparedStatement.setString(18, sinhVien.getHoTenMe());
				preparedStatement.setString(19, sinhVien.getNgheNghiepMe());
				preparedStatement.setInt(21, sinhVien.getLopId());
				preparedStatement.setInt(22, sinhVien.getKhoaHocId());
				preparedStatement.setDate(23, new Date(sinhVien.getNgayNhapHoc().getTime()));
				preparedStatement.setFloat(24, sinhVien.getDiemDauVao1());
				preparedStatement.setFloat(25, sinhVien.getDiemDauVao2());
				preparedStatement.setFloat(26, sinhVien.getDiemDauVao3());
				preparedStatement.setString(27, sinhVien.getAnhSinhVien());
				preparedStatement.setString(28, maSinhVien);
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#getTotalRecords(managestudent.entities.DmSinhVien)
	 */
	@Override
	public int getTotalRecords(DmSinhVien sinhVien) {
		int total = 0;
		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				String tmp = "";
				int pos = -1;
				int countChar = 0;
				int conCount = 0;

				sqlCommand.append("SELECT COUNT(*) count ");
				sqlCommand.append("FROM dmsinhvien sv ");
				sqlCommand.append("INNER JOIN lophoc l ");
				sqlCommand.append("ON sv.lop_id = l.lop_id ");
				sqlCommand.append("INNER JOIN khoahoc kh ");
				sqlCommand.append("ON sv.khoahoc_id = kh.khoahoc_id ");

				if(sinhVien.getMaSinhVien().length() > 0) {
					sqlCommand.append("WHERE sv.masv LIKE ? ");
					conCount++;
				}
				if(sinhVien.getHoDem().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.hodem LIKE ? ");
					conCount++;
				}
				if(sinhVien.getTen().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.ten LIKE ? ");
					conCount++;
				}
				if(sinhVien.getNgaySinh().compareTo(new java.util.Date()) == 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.ngaysinh = ? ");
					conCount++;
				}
				if(sinhVien.getGioiTinh() >= 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.gioitinh = ? ");
					conCount++;
				}
				if(sinhVien.getCmtnd().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.cmtnd LIKE ? ");
					conCount++;
				}
				if(sinhVien.getSoDienThoai().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.sodthoai LIKE ? ");
					conCount++;
				}
				if(sinhVien.getNoiSinh().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.noisinh LIKE ? ");
					conCount++;
				}
				if(sinhVien.getQueQuan().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.quequan LIKE ? ");
					conCount++;
				}
				if(sinhVien.getCheDoUuDai().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.chedouudai LIKE ? ");
					conCount++;
				}
				if(sinhVien.getDanTocId() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.dantoc_id = ? ");
					conCount++;
				}
				if(sinhVien.getTonGiaoId() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.tongiao_id = ? ");
					conCount++;
				}
				
				if(sinhVien.getTenLopHoc().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("l.tenlop LIKE ? ");
					conCount++;
				}
				if(sinhVien.getLopId() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.lop_id = ? ");
					conCount++;
				}
				if(sinhVien.getTenKhoaHoc().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("kh.tenkhoahoc LIKE ? ");
					conCount++;
				}
				if(sinhVien.getKhoaHocId() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.khoahoc_id = ? ");
					conCount++;
				}
				if(conCount > 0) {
					sqlCommand.append("AND ");
				} else {
					sqlCommand.append("WHERE ");
				}
				sqlCommand.append("delete_flg = 0 ");
				conCount++;

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(sqlCommand.indexOf("sv.masv LIKE ?") > 0) {
					preparedStatement.setString(1, "%" + sinhVien.getMaSinhVien() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.hodem LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getHoDem() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.ten LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getTen() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.ngaysinh = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setDate(countChar + 1, new Date(sinhVien.getNgaySinh().getTime()));
				}
				if((pos = sqlCommand.indexOf("sv.gioitinh = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, sinhVien.getGioiTinh());
				}
				if((pos = sqlCommand.indexOf("sv.cmtnd LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getCmtnd() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.sodthoai LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getSoDienThoai() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.noisinh LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getNoiSinh() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.quequan LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getQueQuan() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.chedouudai LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getCheDoUuDai() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.dantoc_id = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, sinhVien.getDanTocId());
				}
				if((pos = sqlCommand.indexOf("sv.tongiaoid = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, sinhVien.getTonGiaoId());
				}
				
				if((pos = sqlCommand.indexOf("sv.lop_id = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, sinhVien.getLopId());
				}
				if((pos = sqlCommand.indexOf("l.tenlop LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getTenLopHoc() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.khoahoc_id = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, sinhVien.getKhoaHocId());
				}
				if((pos = sqlCommand.indexOf("kh.tenkhoahoc LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getTenKhoaHoc() + "%");
				}

				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						total = rs.getInt("count");
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				total = 0;
			}
			closeConnect();
		}

		return total;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#getAllSinhVienDetail(managestudent.entities.DmSinhVien, int, int, int, java.lang.String)
	 */
	@Override
	public List<DmSinhVien> getAllSinhVienDetail(DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType) {
		List<DmSinhVien> lsSinhVien = new ArrayList<DmSinhVien>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				String tmp = "";
				int pos = -1;
				int countChar = 0;
				int conCount = 0;

				sqlCommand.append("SELECT sv.sinhvien_id, sv.masv, sv.hodem, sv.ten, sv.ngaysinh, sv.gioitinh, ");
				sqlCommand.append("sv.lop_id, sv.khoahoc_id, l.tenlop, kh.tenkhoahoc, ");
				sqlCommand.append("sv.cmtnd, sv.sodthoai, sv.noisinh, sv.quequan, sv.hokhauthuongtru, sv.noiohientai, ");
				sqlCommand.append("sv.chedouudai. sv.dantoc_id, sv.tongiao_id, sv.hotenbo, sv.nghenghiepbo, ");
				sqlCommand.append("sv.hotenme, sv.nghenghiepme, sv.ngaynhaphoc, sv.diemdauvao1, sv.diemdauvao2, sv.diemdauvao3, ");
				sqlCommand.append("sv.anhsinhvien ");
				sqlCommand.append("FROM dmsinhvien sv ");
				sqlCommand.append("INNER JOIN lophoc l ");
				sqlCommand.append("ON sv.lop_id = l.lop_id ");
				sqlCommand.append("INNER JOIN khoahoc kh ");
				sqlCommand.append("ON sv.khoahoc_id = kh.khoahoc_id ");

				if(sinhVien.getMaSinhVien().length() > 0) {
					sqlCommand.append("WHERE sv.masv LIKE ? ");
					conCount++;
				}
				if(sinhVien.getHoDem().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.hodem LIKE ? ");
					conCount++;
				}
				if(sinhVien.getTen().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.ten LIKE ? ");
					conCount++;
				}
				
				if(sinhVien.getTenLopHoc().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("l.tenlop LIKE ? ");
					conCount++;
				}
				if(sinhVien.getLopId() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.lop_id = ? ");
					conCount++;
				}
				if(sinhVien.getTenKhoaHoc().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("kh.tenkhoahoc LIKE ? ");
					conCount++;
				}
				if(sinhVien.getKhoaHocId() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.khoahoc_id = ? ");
					conCount++;
				}
				if(sinhVien.getCmtnd().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.cmtnd LIKE ? ");
					conCount++;
				}
				if(sinhVien.getSoDienThoai().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.sodthoai LIKE ? ");
					conCount++;
				}
				if(sinhVien.getNoiSinh().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.noisinh LIKE ? ");
					conCount++;
				}
				if(sinhVien.getQueQuan().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.quequan LIKE ? ");
					conCount++;
				}
				if(sinhVien.getHoKhauThuongTru().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.hokhauthuongtru LIKE ? ");
					conCount++;
				}
				if(sinhVien.getNoiOHienTai().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.noiohientai LIKE ? ");
					conCount++;
				}
				if(sinhVien.getCheDoUuDai().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.chedouudai LIKE ? ");
					conCount++;
				}
				if(sinhVien.getDanTocId() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.dantoc_id = ? ");
					conCount++;
				}
				if(sinhVien.getTonGiaoId() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.tongiao_id = ? ");
					conCount++;
				}
				
				if(sinhVien.getHoTenBo().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.hotenbo LIKE ? ");
					conCount++;
				}
				if(sinhVien.getNgheNghiepBo().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.nghenghiepbo LIKE ? ");
					conCount++;
				}
				if(sinhVien.getHoTenMe().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.hotenme LIKE ? ");
					conCount++;
				}
				if(sinhVien.getNgheNghiepMe().length() > 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.nghenghiepme LIKE ? ");
					conCount++;
				}
				if(sinhVien.getNgayNhapHoc().compareTo(new java.util.Date()) != 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.ngaynhaphoc = ? ");
					conCount++;
				}
				if(sinhVien.getDiemDauVao1() >= 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.diemdauvao1 = ? ");
					conCount++;
				}
				if(sinhVien.getDiemDauVao2() >= 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.diemdauvao2 = ? ");
					conCount++;
				}
				if(sinhVien.getDiemDauVao3() >= 0) {
					if(conCount > 0) {
						sqlCommand.append("AND ");
					} else {
						sqlCommand.append("WHERE ");
					}

					sqlCommand.append("sv.diemdauvao3 = ? ");
					conCount++;
				}
				if(conCount > 0) {
					sqlCommand.append("AND ");
				} else {
					sqlCommand.append("WHERE ");
				}

				sqlCommand.append("delete_flg = 0 ");
				conCount++;


				sqlCommand.append("ORDER BY ");
				if(sortColumn == 2) {
					sqlCommand.append("sv.hodem ");
				} else if(sortColumn == 3) {
					sqlCommand.append("sv.ten ");
				} else if(sortColumn == 4) {
					sqlCommand.append("sv.ngaysinh ");
				} else if(sortColumn == 5) {
					sqlCommand.append("sv.gioitinh ");
				} else if(sortColumn == 6) {
					sqlCommand.append("hdt.ten_hedt ");
				} else if(sortColumn == 7) {
					sqlCommand.append("l.tenlop ");
				} else if(sortColumn == 8) {
					sqlCommand.append("kh.tenkhoahoc ");
				} else {
					sqlCommand.append("sv.masv ");
				}
				sqlCommand.append(sortType + " ");

				sqlCommand.append("LIMIT " + offset + ", " + limit);

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				if(sqlCommand.indexOf("sv.masv LIKE ?") > 0) {
					preparedStatement.setString(1, "%" + sinhVien.getMaSinhVien() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.hodem LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getHoDem() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.ten LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getTen() + "%");
				}
				
				if((pos = sqlCommand.indexOf("sv.lop_id = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, sinhVien.getLopId());
				}
				if((pos = sqlCommand.indexOf("l.tenlop LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getTenLopHoc() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.khoahoc_id = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setInt(countChar + 1, sinhVien.getKhoaHocId());
				}
				if((pos = sqlCommand.indexOf("kh.tenkhoahoc LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getTenKhoaHoc() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.cmtnd LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getCmtnd() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.sodthoai LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getSoDienThoai() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.noisinh LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getNoiSinh() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.quequan LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getQueQuan() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.hokhauthuongtru LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getHoKhauThuongTru() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.noiohientai LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getNoiOHienTai() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.chedouudai LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getCheDoUuDai() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.hotenbo LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getHoTenBo() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.nghenghiepbo LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getNgheNghiepBo() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.hotenme LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getHoTenMe() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.nghenghiepme LIKE ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setString(countChar + 1, "%" + sinhVien.getNgheNghiepMe() + "%");
				}
				if((pos = sqlCommand.indexOf("sv.ngaynhaphoc = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setDate(countChar + 1, new Date(sinhVien.getNgayNhapHoc().getTime()));
				}
				if((pos = sqlCommand.indexOf("sv.diemdauvao1 = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setFloat(countChar + 1, sinhVien.getDiemDauVao1());
				}
				if((pos = sqlCommand.indexOf("sv.diemdauvao2 = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setFloat(countChar + 1, sinhVien.getDiemDauVao2());
				}
				if((pos = sqlCommand.indexOf("sv.diemdauvao3 = ?")) > 0) {
					tmp = sqlCommand.substring(0, pos);
					countChar = tmp.length() - tmp.replace("?", "").length();
					preparedStatement.setFloat(countChar + 1, sinhVien.getDiemDauVao3());
				}

				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						DmSinhVien objSinhVien = new DmSinhVien(rs.getInt("sinhvien_id"), rs.getString("masv"), rs.getString("hodem"), rs.getString("ten"),
								rs.getDate("ngaysinh"), rs.getInt("gioitinh"), rs.getInt("lop_id"), rs.getInt("khoahoc_id"));
						objSinhVien.setCmtnd(rs.getString("cmtnd"));
						objSinhVien.setSoDienThoai(rs.getString("sodthoai"));
						objSinhVien.setNoiSinh(rs.getString("noisinh"));
						objSinhVien.setQueQuan(rs.getString("quequan"));
						objSinhVien.setHoKhauThuongTru(rs.getString("hokhauthuongtru"));
						objSinhVien.setNoiOHienTai(rs.getString("noiohientai"));
						objSinhVien.setCheDoUuDai(rs.getString("chedouudai"));
						objSinhVien.setHoTenBo(rs.getString("hotenbo"));
						objSinhVien.setNgheNghiepBo(rs.getString("nghenghiepbo"));
						objSinhVien.setHoTenMe(rs.getString("hotenme"));
						objSinhVien.setNgheNghiepMe(rs.getString("nghenghiepme"));
						objSinhVien.setNgayNhapHoc(rs.getDate("ngaynhaphoc"));
						objSinhVien.setDiemDauVao1(rs.getFloat("diemdauvao1"));
						objSinhVien.setDiemDauVao2(rs.getFloat("diemdauvao2"));
						objSinhVien.setDiemDauVao3(rs.getFloat("diemdauvao3"));

						lsSinhVien.add(objSinhVien);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsSinhVien = null;
			}
			closeConnect();
		}

		return lsSinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#getSinhVienById(int)
	 */
	@Override
	public DmSinhVien getSinhVienById(int sinhVienId) {
		DmSinhVien sinhVien = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT sinhvien_id, masv, hodem, ten, ngaysinh, gioitinh, cmtnd, ");
				sqlCommand.append("sodthoai, noisinh, quequan, hokhauthuongtru, noiohientai, ");
				sqlCommand.append("chedouudai, dantoc_id, tongiao_id, quoctich_id, hotenbo, ");
				sqlCommand.append("nghenghiepbo, hotenme, nghenghiepme, hedt_id, lop_id, khoahoc_id, ");
				sqlCommand.append("ngaynhaphoc, diemdauvao1, diemdauvao2, diemdauvao3, anhsinhvien, chuyennganh_id ");
				sqlCommand.append("FROM dmsinhvien ");
				sqlCommand.append("WHERE sinhvien_id = ? AND delete_flg = 0 ");
				sqlCommand.append("ORDER BY masv ASC");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, sinhVienId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						sinhVien = new DmSinhVien(rs.getInt("sinhvien_id"), rs.getString("masv"), rs.getString("hodem"), rs.getString("ten"),
								rs.getDate("ngaysinh"), rs.getInt("gioitinh"), rs.getString("cmtnd"), rs.getString("sodthoai"), rs.getString("noisinh"),
								rs.getString("quequan"), rs.getString("hokhauthuongtru"), rs.getString("noiohientai"), rs.getString("chedouudai"),
								rs.getInt("dantoc_id"), rs.getInt("tongiao_id"), rs.getString("hotenbo"), rs.getString("nghenghiepbo"),
								rs.getString("hotenme"), rs.getString("nghenghiepme"), rs.getInt("lop_id"), rs.getInt("khoahoc_id"),
								rs.getDate("ngaynhaphoc"), rs.getFloat("diemdauvao1"), rs.getFloat("diemdauvao2"), rs.getFloat("diemdauvao3"), rs.getString("anhsinhvien"));

						sinhVien.setChuyenNganhId(rs.getInt("chuyennganh_id"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				sinhVien = null;
			}
			closeConnect();
		}

		return sinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#updateSinhVienById(int, managestudent.entities.DmSinhVien)
	 */
	@Override
	public boolean updateSinhVienById(int idSinhVien, DmSinhVien sinhVien) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE dmsinhvien ");
				sqlCommand.append("SET masv = ?, hodem = ?, ten = ?, ngaysinh = ?, gioitinh = ?, cmtnd = ?, sodthoai = ?, noisinh = ?, ");
				sqlCommand.append("quequan = ?, hokhauthuongtru = ?, noiohientai = ?, chedouudai = ?, dantoc_id = ?, tongiao_id = ?, ");
				sqlCommand.append(" hotenbo = ?, nghenghiepbo = ?, hotenme = ?, nghenghiepme = ?, lop_id = ?, ");
				sqlCommand.append("khoahoc_id = ?, ngaynhaphoc = ?, diemdauvao1 = ?, diemdauvao2 = ?, diemdauvao3 = ?, anhsinhvien = ?, sinhvien_id = ? ");
				sqlCommand.append("WHERE sinhvien_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, sinhVien.getMaSinhVien());
				preparedStatement.setString(2, sinhVien.getHoDem());
				preparedStatement.setString(3, sinhVien.getTen());
				preparedStatement.setDate(4, new Date(sinhVien.getNgaySinh().getTime()));
				preparedStatement.setInt(5, sinhVien.getGioiTinh());
				preparedStatement.setString(6, sinhVien.getCmtnd());
				preparedStatement.setString(7, sinhVien.getSoDienThoai());
				preparedStatement.setString(8, sinhVien.getNoiSinh());
				preparedStatement.setString(9, sinhVien.getQueQuan());
				preparedStatement.setString(10, sinhVien.getHoKhauThuongTru());
				preparedStatement.setString(11, sinhVien.getNoiOHienTai());
				preparedStatement.setString(12, sinhVien.getCheDoUuDai());
				preparedStatement.setInt(13, sinhVien.getDanTocId());
				preparedStatement.setInt(14, sinhVien.getTonGiaoId());
				preparedStatement.setString(16, sinhVien.getHoTenBo());
				preparedStatement.setString(17, sinhVien.getNgheNghiepBo());
				preparedStatement.setString(18, sinhVien.getHoTenMe());
				preparedStatement.setString(19, sinhVien.getNgheNghiepMe());
				preparedStatement.setInt(21, sinhVien.getLopId());
				preparedStatement.setInt(22, sinhVien.getKhoaHocId());
				preparedStatement.setDate(23, new Date(sinhVien.getNgayNhapHoc().getTime()));
				preparedStatement.setFloat(24, sinhVien.getDiemDauVao1());
				preparedStatement.setFloat(25, sinhVien.getDiemDauVao2());
				preparedStatement.setFloat(26, sinhVien.getDiemDauVao3());
				preparedStatement.setString(27, sinhVien.getAnhSinhVien());
				preparedStatement.setInt(28, sinhVien.getSinhVienId());
				preparedStatement.setInt(29, idSinhVien);

//				int conCount = 0;
//				if(sinhVien.getMaSinhVien() != null && sinhVien.getMaSinhVien().length() > 0) {
//					sqlCommand.append("masv = ? ");
//					conCount++;
//				}
//				if(sinhVien.getHoDem() != null && sinhVien.getHoDem().length() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getTen() != null && sinhVien.getTen().length() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getNgaySinh() != new java.util.Date()) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getGioiTinh() >= 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getCmtnd() != null && sinhVien.getCmtnd().length() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getNoiSinh() != null && sinhVien.getNoiSinh().length() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getQueQuan() != null && sinhVien.getQueQuan().length() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getHoKhauThuongTru() != null && sinhVien.getHoKhauThuongTru().length() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getNoiOHienTai() != null && sinhVien.getNoiOHienTai().length() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getCheDoUuDai() != null && sinhVien.getCheDoUuDai().length() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getDanTocId() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getTonGiaoId() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getQuocTichId() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getHoTenBo() != null && sinhVien.getHoTenBo().length() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getNgheNghiepBo() != null && sinhVien.getNgheNghiepBo().length() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getHoTenMe() != null && sinhVien.getNgheNghiepMe().length() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getHeDtId() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getLopId() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getKhoaHocId() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getNgayNhapHoc() != new java.util.Date()) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getDiemDauVao1() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getDiemDauVao2() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getDiemDauVao3() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				if(sinhVien.getAnhSinhVien() != null && sinhVien.getAnhSinhVien().length() > 0) {
//					if(conCount > 0) {
//						sqlCommand.append(" = ? ");
//					}
//				}
//				sqlCommand.append("WHERE sinhvien_id = ? ");

				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#deleteSinhVienById(int)
	 */
	@Override
	public boolean deleteSinhVienById(int idSinhVien) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE dmsinhvien ");
				sqlCommand.append("SET delete_flg = 1 ");
				sqlCommand.append("WHERE sinhvien_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, idSinhVien);
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#updateChuyenNganhSinhVien(int, int)
	 */
	@Override
	public boolean updateChuyenNganhSinhVien(int sinhVienId, int chuyenNganhId) {
		boolean rs = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("UPDATE dmsinhvien ");
				sqlCommand.append("SET chuyennganh_id = ? ");
				sqlCommand.append("WHERE sinhvien_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, chuyenNganhId);
				preparedStatement.setInt(2, sinhVienId);
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					rs = true;
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
			}
			closeConnect();
		}

		return rs;
	}

}
