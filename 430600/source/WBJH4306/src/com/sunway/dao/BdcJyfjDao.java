/**
 * 
 */
package com.sunway.dao;

import java.util.List;

import com.sunway.entity.BdcJyfj;
import com.sunway.entity.TaxShxx;

public interface BdcJyfjDao extends BaseDao<BdcJyfj> {

	public List<BdcJyfj> getAllData(BdcJyfj bean, int pageIndex, int pageSize);
	
}
