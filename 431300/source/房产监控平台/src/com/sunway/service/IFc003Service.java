/**
 * 
 */
package com.sunway.service;

import java.io.InputStream;

/**
 * @author Amani
 *
 */
public interface IFc003Service {

	public boolean insData(int id, String slid, String ssqy, InputStream image) throws Exception;
	
	public InputStream readData(int id) throws Exception;
	
}
