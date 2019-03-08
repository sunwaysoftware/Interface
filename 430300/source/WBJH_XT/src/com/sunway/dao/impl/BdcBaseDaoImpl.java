package com.sunway.dao.impl;

import com.sunway.dao.BdcBaseDao;
import com.sunway.entity.tax.TaxWsxx;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BdcBaseDaoImpl implements BdcBaseDao {

    @Autowired
    private SessionFactory sessionFactoryBDC;

    @Override
    public boolean execInsert_wsxx(TaxWsxx bean) {
        boolean rtnBool = false;
        Session session = null;
        Transaction tran = null;
        try {
            // 创建session对象
            session = sessionFactoryBDC.openSession();
            tran = session.getTransaction();
            tran.begin();
            session.save(bean);
            tran.commit();
            rtnBool = true;
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
        } finally {
            session.close();
        }
        return rtnBool;
    }

    @Override
    public boolean execDelete_wsxx(TaxWsxx bean) {
        boolean rtnBool = false;
        Session session = null;
        Transaction tran = null;
        try {
            // 创建session对象
            session = sessionFactoryBDC.openSession();
            tran = session.getTransaction();
            tran.begin();
            Query query = session.createQuery("delete TaxWsxx where ywh=:pYwh");
            query.setParameter("pYwh", bean.getYwh());
            query.executeUpdate();
            tran.commit();
            rtnBool = true;
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
        } finally {
            session.close();
        }
        return rtnBool;
    }
}
