package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt00306f;
import com.sunway.vo.Pgv00306f;

/**
 * 楼房信息图片 
 * @author Light
 *
 */
public interface IPgt00306fDAO {

	/**
	 * 获取数据 
	 * @param v00306
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00306f> LoadAll(Pgv00306f v00306f)throws Exception;
	
	/**
	 * 获取数据 
	 * @param v00306
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00306f> LoadAllByDz(Pgv00306f v00306f)throws Exception;
	
	/**
	 * 插入数据
	 * @param t00306f
	 * @return
	 * @throws Exception
	 */
	public Boolean GetInsertCommand(Pgt00306f t00306f)throws Exception;
	
	/**
	 * 根据PK获取数据
	 * @param t00306f
	 * @return
	 * @throws Exception
	 */
	public Pgt00306f LoadByPrimaryKey(Pgt00306f t00306f)throws Exception;
	
	/**
	 * 数据数据
	 * @param t00306f
	 * @return
	 * @throws Exception
	 */
	public Boolean GetDeleteCommand(Pgt00306f t00306f)throws Exception;
	
	/**
	 * 删除该楼房所有图片
	 * @param t00306f
	 * @return
	 * @throws Exception
	 */
	public Boolean DelPhotoByLF(Pgt00306f t00306f)throws Exception;
}
