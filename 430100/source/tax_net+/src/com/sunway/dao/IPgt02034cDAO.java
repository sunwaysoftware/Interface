/**
 *
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt02034c;

/**
 * @author Andy.Gao
 *
 */
public interface IPgt02034cDAO {

	public ArrayList<Pgt02034c> LoadAll(Pgt02034c bean) throws Exception;
	
	public ArrayList<Pgt02034c> LoadAll_B(Pgt02034c bean) throws Exception;

}
