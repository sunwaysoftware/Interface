/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunway.dao;

import com.sunway.vo.TJ00002;

/**
 *
 * @author Amani
 */
public interface ITj00002DAO {
    
	/**
	 * 查询数据
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public TJ00002 Load(TJ00002 bean) throws Exception;
        
}
