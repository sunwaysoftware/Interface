/**
 * 
 */
package com.sunway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunway.dao.BdcJyfjDao;
import com.sunway.entity.BdcJyfj;
import com.sunway.service.BdcJyfjService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author andy.gao
 *
 */
@Service
@Transactional
public class BdcJyfjServiceImpl implements BdcJyfjService {

    @Autowired
    private BdcJyfjDao bdcJyfjDao;

	@Override
	public List<BdcJyfj> getAllData(BdcJyfj bean, int pageIndex, int pageSize) {
		return bdcJyfjDao.getAllData(bean, pageIndex, pageSize);
	}

}
