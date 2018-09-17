/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunway.dao;

import java.io.OutputStream;
import java.util.ArrayList;

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
	public ArrayList<TJ00002> Load(TJ00002 bean) throws Exception;
	
	public OutputStream ExportData(TJ00002 bean) throws Exception;
	
	public ArrayList<TJ00002> Load02(TJ00002 bean) throws Exception;
	
	public OutputStream ExportData02(TJ00002 bean) throws Exception;
        
}
