/**
 * Copyright(C) K16SE 2014
 *
 * DanTocLogicsImpl.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.logics.impl;

import java.util.List;

import managestudent.dao.impl.DanTocDaoImpl;
import managestudent.entities.DanToc;
import managestudent.logics.DanTocLogics;

/**
 *
 * @author HaVH
 *
 */
public class DanTocLogicsImpl implements DanTocLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.DanTocLogics#addDanToc(managestudent.entities.DanToc)
	 */
	@Override
	public boolean addDanToc(DanToc dt) {
		DanTocDaoImpl danTocDao = new DanTocDaoImpl();
		boolean rs = danTocDao.addDanToc(dt);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DanTocLogics#deleteDanTocById(int)
	 */
	@Override
	public boolean deleteDanTocById(int danTocId) {
		DanTocDaoImpl danTocDao = new DanTocDaoImpl();
		boolean rs = danTocDao.deleteDanTocById(danTocId);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DanTocLogics#getAllDanToc()
	 */
	@Override
	public List<DanToc> getAllDanToc(DanToc danToc, int offset, int limit, int sortColumn, String sortType) {
		DanTocDaoImpl danTocDao = new DanTocDaoImpl();
		List<DanToc> lsDanToc = danTocDao.getAllDanToc(danToc, offset, limit, sortColumn, sortType);

		return lsDanToc;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DanTocLogics#getDanTocById(int)
	 */
	@Override
	public DanToc getDanTocById(int danTocId) {
		DanTocDaoImpl danTocDao = new DanTocDaoImpl();
		DanToc dt = danTocDao.getDanTocById(danTocId);

		return dt;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DanTocLogics#updateDanTocById(managestudent.entities.DanToc)
	 */
	@Override
	public boolean updateDanTocById(int danTocId, DanToc dt) {
		DanTocDaoImpl danTocDao = new DanTocDaoImpl();
		boolean rs = danTocDao.updateDanTocById(danTocId, dt);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DanTocLogics#getAllColumnName()
	 */
	@Override
	public List<String> getAllColumnName() {
		DanTocDaoImpl danTocDao = new DanTocDaoImpl();
		List<String> lsColumn = danTocDao.getAllColumnName("dantoc");

		return lsColumn;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DanTocLogics#getTotalRecords()
	 */
	@Override
	public int getTotalRecords(DanToc danToc) {
		DanTocDaoImpl danTocDao = new DanTocDaoImpl();
		int total = danTocDao.getTotalRecords(danToc);

		return total;
	}

}
