/**
 * Copyright(C) K16SE 2014
 *
 * HeDaoTaoLogicsImpl.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.logics.impl;

import java.util.List;

import managestudent.dao.impl.HeDaoTaoDaoImpl;
import managestudent.entities.HeDaoTao;
import managestudent.logics.HeDaoTaoLogics;

/**
 *
 * @author HaVH
 *
 */
public class HeDaoTaoLogicsImpl implements HeDaoTaoLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.HeDaoTaoLogics#addHeDaoTao(managestudent.entities.HeDaoTao)
	 */
	@Override
	public boolean addHeDaoTao(HeDaoTao hdt) {
		HeDaoTaoDaoImpl hdtDao = new HeDaoTaoDaoImpl();
		boolean rs = hdtDao.addHeDaoTao(hdt);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HeDaoTaoLogics#deleteHeDaoTaoByMaHe(java.lang.String)
	 */
	@Override
	public boolean deleteHeDaoTaoByMaHe(String maHeDaoTao) {
		HeDaoTaoDaoImpl hdtDao = new HeDaoTaoDaoImpl();
		boolean rs = hdtDao.deleteHeDaoTaoByMaHe(maHeDaoTao);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HeDaoTaoLogics#getAllHeDaoTao()
	 */
	@Override
	public List<HeDaoTao> getAllHeDaoTao(HeDaoTao hdt, int offset, int limit, int sortColumn, String sortType) {
		HeDaoTaoDaoImpl hdtDao = new HeDaoTaoDaoImpl();
		List<HeDaoTao> lsHdt = hdtDao.getAllHeDaoTao(hdt, offset, limit, sortColumn, sortType);

		return lsHdt;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HeDaoTaoLogics#getHeDaoTaoByMaHe(java.lang.String)
	 */
	@Override
	public HeDaoTao getHeDaoTaoByMaHe(String maHeDaoTao) {
		HeDaoTaoDaoImpl hdtDao = new HeDaoTaoDaoImpl();
		HeDaoTao hdt = hdtDao.getHeDaoTaoByMaHe(maHeDaoTao);

		return hdt;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HeDaoTaoLogics#updateHeDaoTaoByMaHe(java.lang.String, managestudent.entities.HeDaoTao)
	 */
	@Override
	public boolean updateHeDaoTaoByMaHe(String maHeDaoTao, HeDaoTao hdt) {
		HeDaoTaoDaoImpl hdtDao = new HeDaoTaoDaoImpl();
		boolean rs = hdtDao.updateHeDaoTaoByMaHe(maHeDaoTao, hdt);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HeDaoTaoLogics#getAllColumnName()
	 */
	@Override
	public List<String> getAllColumnName() {
		HeDaoTaoDaoImpl hdtDao = new HeDaoTaoDaoImpl();
		List<String> lsColumn = hdtDao.getAllColumnName("hedaotao");

		return lsColumn;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HeDaoTaoLogics#getTotalRecords()
	 */
	@Override
	public int getTotalRecords(HeDaoTao hdt) {
		HeDaoTaoDaoImpl hdtDao = new HeDaoTaoDaoImpl();
		int total = hdtDao.getTotalRecords(hdt);

		return total;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HeDaoTaoLogics#updateHeDaoTaoById(int, managestudent.entities.HeDaoTao)
	 */
	@Override
	public boolean updateHeDaoTaoById(int hdtId, HeDaoTao hdt) {
		HeDaoTaoDaoImpl hdtDao = new HeDaoTaoDaoImpl();
		boolean rs = hdtDao.updateHeDaoTaoById(hdtId, hdt);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HeDaoTaoLogics#getHeDaoTaoById(int)
	 */
	@Override
	public HeDaoTao getHeDaoTaoById(int hdtId) {
		HeDaoTaoDaoImpl hdtDao = new HeDaoTaoDaoImpl();
		HeDaoTao hdt = hdtDao.getHeDaoTaoById(hdtId);

		return hdt;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HeDaoTaoLogics#deleteHeDaoTaoById(int)
	 */
	@Override
	public boolean deleteHeDaoTaoById(int idHeDaoTao) {
		HeDaoTaoDaoImpl hdtDao = new HeDaoTaoDaoImpl();
		boolean rs = hdtDao.deleteHeDaoTaoById(idHeDaoTao);

		return rs;
	}

}
