package com.sunway.service.impl;

import com.sunway.dao.TaxShjgDictDao;
import com.sunway.entity.TaxShjgDict;
import com.sunway.service.TaxShjgDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaxShjgDictServiceImpl implements TaxShjgDictService {

    @Autowired
    private TaxShjgDictDao taxShjgDictDao;

    @Override
    public List<TaxShjgDict> getAllData() {
        return taxShjgDictDao.getAllData();
    }
}
