package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.ICzArcgisDAO;
import com.sunway.service.ICzArcgisService;
import com.sunway.vo.CzArcgis;

/**
 * @author Lee
 *
 */
public class CzArcgisService implements ICzArcgisService {

	private ICzArcgisDAO arcgisDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.ICzArcgisService#ExecCommandCZ00062(com.sunway.vo.CzArcgis)
	 */
	@Override
	public CzArcgis ExecCommandCZ00062(CzArcgis arcgis) throws Exception {
		return arcgisDao.ExecCommandCZ00062(arcgis);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ICzArcgisService#ExecCommandCZ00061(com.sunway.vo.CzArcgis)
	 */
	@Override
	public ArrayList<CzArcgis> ExecCommandCZ00061(CzArcgis arcgis)
			throws Exception {
		return arcgisDao.ExecCommandCZ00061(arcgis);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ICzArcgisService#ExecCommandCZ00063(com.sunway.vo.CzArcgis)
	 */
	@Override
	public CzArcgis ExecCommandCZ00063(CzArcgis arcgis) throws Exception {
		return arcgisDao.ExecCommandCZ00063(arcgis);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.ICzArcgisService#ExecCommandCZ00064(com.sunway.vo.CzArcgis)
	 */
	@Override
	public ArrayList<CzArcgis> ExecCommandCZ00064(CzArcgis arcgis)
			throws Exception {
		return arcgisDao.ExecCommandCZ00064(arcgis);
	}

	/**
	 * @return the arcgisDao
	 */
	public ICzArcgisDAO getArcgisDao() {
		return arcgisDao;
	}

	/**
	 * @param arcgisDao the arcgisDao to set
	 */
	public void setArcgisDao(ICzArcgisDAO arcgisDao) {
		this.arcgisDao = arcgisDao;
	}

}
