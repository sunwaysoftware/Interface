/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;
import com.sunway.vo.BF00001;

/**
 * 
 * 正常评估查询
 * @author Lee
 *
 */
public interface IBB00001Service {

	/**
	 * 正常评估查询
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BF00001> LoadAll(BF00001 bean) throws Exception;
	
}