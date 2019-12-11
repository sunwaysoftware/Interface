package com.sunway.service.impl;

import com.sunway.dao.BdcQlrDao;
import com.sunway.entity.BdcQlr;
import com.sunway.service.BdcQlrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BdcQlrServiceImpl implements BdcQlrService {
    @Autowired
    private BdcQlrDao bdcQlrDao;

    @Override
    public List<BdcQlr> getDataByYwh(BdcQlr bean) {
        return bdcQlrDao.getDataByYwh(bean);
    }
}
