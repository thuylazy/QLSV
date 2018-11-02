/**
 * Copyright(C) K16SE 2014
 *
 * DmSinhVienLogicsImpl.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.logics.impl;

import java.util.List;

import managestudent.dao.impl.DmSinhVienDaoImpl;
import managestudent.entities.DmSinhVien;
import managestudent.logics.DmSinhVienLogics;

/**
 *
 * @author HaVH
 *
 */
public class DmSinhVienLogicsImpl implements DmSinhVienLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#addSinhVien(managestudent.entities.DmSinhVien)
	 */
	@Override
	public boolean addSinhVien(DmSinhVien sinhVien) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		boolean rs = sinhVienDao.addSinhVien(sinhVien);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#deleteSinhVienByMaSinhVien(java.lang.String)
	 */
	@Override
	public boolean deleteSinhVienByMaSinhVien(String maSinhVien) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		boolean rs = sinhVienDao.deleteSinhVienByMaSinhVien(maSinhVien);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#getAllSinhVien()
	 */
	@Override
	public List<DmSinhVien> getAllSinhVien(DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		List<DmSinhVien> lsSinhVien = sinhVienDao.getAllSinhVien(sinhVien, offset, limit, sortColumn, sortType);

		return lsSinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#getListSinhVienByHeDaoTaoId(int)
	 */
	@Override
	public List<DmSinhVien> getListSinhVienByHeDaoTaoId(int heDaoTaoId, DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		List<DmSinhVien> lsSinhVien = sinhVienDao.getListSinhVienByHeDaoTaoId(heDaoTaoId, sinhVien, offset, limit, sortColumn, sortType);

		return lsSinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#getListSinhVienByKhoaHocId(int)
	 */
	@Override
	public List<DmSinhVien> getListSinhVienByKhoaHocId(int khoaHocId, DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		List<DmSinhVien> lsSinhVien = sinhVienDao.getListSinhVienByKhoaHocId(khoaHocId, sinhVien, offset, limit, sortColumn, sortType);

		return lsSinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#getListSinhVienByLopId(int)
	 */
	@Override
	public List<DmSinhVien> getListSinhVienByLopId(int lopId, DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		List<DmSinhVien> lsSinhVien = sinhVienDao.getListSinhVienByLopId(lopId, sinhVien, offset, limit, sortColumn, sortType);

		return lsSinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#getSinhVienByMaSinhVien(java.lang.String)
	 */
	@Override
	public DmSinhVien getSinhVienByMaSinhVien(String maSinhVien) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		DmSinhVien sinhVien = sinhVienDao.getSinhVienByMaSinhVien(maSinhVien);

		return sinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#updateSinhVienByMaSinhVien(java.lang.String, managestudent.entities.DmSinhVien)
	 */
	@Override
	public boolean updateSinhVienByMaSinhVien(String maSinhVien,
			DmSinhVien sinhVien) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		boolean rs = sinhVienDao.updateSinhVienByMaSinhVien(maSinhVien, sinhVien);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#getAllColumnName()
	 */
	@Override
	public List<String> getAllColumnName() {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		List<String> lsColumn = sinhVienDao.getAllColumnName("dmsinhvien");

		return lsColumn;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#getTotalRecords()
	 */
	@Override
	public int getTotalRecords(DmSinhVien sinhVien) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		int total = sinhVienDao.getTotalRecords(sinhVien);

		return total;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#getAllSinhVienDetail(managestudent.entities.DmSinhVien, int, int, int, java.lang.String)
	 */
	@Override
	public List<DmSinhVien> getAllSinhVienDetail(DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		List<DmSinhVien> lsSinhVien = sinhVienDao.getAllSinhVienDetail(sinhVien, offset, limit, sortColumn, sortType);

		return lsSinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#getSinhVienById(int)
	 */
	@Override
	public DmSinhVien getSinhVienById(int sinhVienId) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		DmSinhVien sinhVien = sinhVienDao.getSinhVienById(sinhVienId);

		return sinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#updateSinhVienById(int, managestudent.entities.DmSinhVien)
	 */
	@Override
	public boolean updateSinhVienById(int idSinhVien, DmSinhVien sinhVien) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		boolean rs = sinhVienDao.updateSinhVienById(idSinhVien, sinhVien);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#deleteSinhVienById(int)
	 */
	@Override
	public boolean deleteSinhVienById(int idSinhVien) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		boolean rs = sinhVienDao.deleteSinhVienById(idSinhVien);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#updateChuyenNganhSinhVien(int, int)
	 */
	@Override
	public boolean updateChuyenNganhSinhVien(int sinhVienId, int chuyenNganhId) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		boolean rs = sinhVienDao.updateChuyenNganhSinhVien(sinhVienId, chuyenNganhId);

		return rs;
	}

}
