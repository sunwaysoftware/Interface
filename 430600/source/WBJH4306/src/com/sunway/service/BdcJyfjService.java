/**
 * 
 */
package com.sunway.service;

import java.util.List;

import com.sunway.entity.BdcJyfj;

/**
 * @author andy.gao
 *
 */
public interface BdcJyfjService {

    public List<BdcJyfj> getAllData(BdcJyfj bean, int pageIndex, int pageSize);

}
