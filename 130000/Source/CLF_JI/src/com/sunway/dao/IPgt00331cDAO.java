/**
 *
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt00331c;

/**
 * @author Andy.Gao
 *
 */
public interface IPgt00331cDAO {

	public ArrayList<Pgt00331c> LoadAll(Pgt00331c bean) throws Exception;
	
	public ArrayList<Pgt00331c> LoadAll_B(Pgt00331c bean) throws Exception;

}