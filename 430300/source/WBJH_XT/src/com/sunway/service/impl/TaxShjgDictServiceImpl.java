package com.sunway.service.impl;

import com.sunway.dao.TaxShjgDictDao;
import com.sunway.entity.tax.TaxShjgDict;
import com.sunway.service.TaxShjgDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxShjgDictServiceImpl implements TaxShjgDictService {

    @Autowired
    private TaxShjgDictDao taxShjgDictDao;

    @Override
    public List<TaxShjgDict> getAllData() {
        return taxShjgDictDao.getAllData();
    }
}
