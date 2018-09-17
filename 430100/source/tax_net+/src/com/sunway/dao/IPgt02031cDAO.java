/**
 *
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt02031c;

/**
 * @author Andy.Gao
 *
 */
public interface IPgt02031cDAO {

	public ArrayList<Pgt02031c> LoadAll(Pgt02031c bean) throws Exception;
	
	public ArrayList<Pgt02031c> LoadAll_B(Pgt02031c bean) throws Exception;

}
