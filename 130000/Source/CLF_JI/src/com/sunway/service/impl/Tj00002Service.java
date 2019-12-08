/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunway.service.impl;

import com.sunway.dao.ITj00002DAO;
import com.sunway.service.ITj00002Service;
import com.sunway.vo.TJ00002;

/**
 *
 * @author Amani
 */
public class Tj00002Service implements ITj00002Service {

    private ITj00002DAO dao;

    @Override
    public TJ00002 Load(TJ00002 bean) throws Exception {
        return dao.Load(bean);
    }

    public ITj00002DAO getDao() {
        return dao;
    }

    public void setDao(ITj00002DAO dao) {
        this.dao = dao;
    }
}
