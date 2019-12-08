package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00306fDAO;
import com.sunway.service.IPgt00306fService;
import com.sunway.vo.Pgt00306f;
import com.sunway.vo.Pgv00306f;

/**
 * 楼房信息图片 
 * @author Light
 *
 */
public class Pgt00306fService implements IPgt00306fService{

	private IPgt00306fDAO t00306fDao;

	@Override
	public ArrayList<Pgv00306f> LoadAll(Pgv00306f v00306f) throws Exception {
		return t00306fDao.LoadAll(v00306f);
	}
	
	@Override
	public ArrayList<Pgv00306f> LoadAllByDz(Pgv00306f v00306f) throws Exception {
		return t00306fDao.LoadAllByDz(v00306f);
	}
	
	
	
	@Override
	public Boolean GetInsertCommand(Pgt00306f t00306f) throws Exception {
		return t00306fDao.GetInsertCommand(t00306f);
	}



	@Override
	public Pgt00306f LoadByPrimaryKey(Pgt00306f t00306f) throws Exception {
		return t00306fDao.LoadByPrimaryKey(t00306f);
	}



	@Override
	public Boolean GetDeleteCommand(Pgt00306f t00306f) throws Exception {
		return t00306fDao.GetDeleteCommand(t00306f);
	}



	@Override
	public Boolean DelPhotoByLF(Pgt00306f t00306f) throws Exception {
		return t00306fDao.DelPhotoByLF(t00306f);
	}



	/*********************************   set  &&  get   **********************************/
	public IPgt00306fDAO getT00306fDao() {
		return t00306fDao;
	}

	public void setT00306fDao(IPgt00306fDAO t00306fDao) {
		this.t00306fDao = t00306fDao;
	}

	
	
}
