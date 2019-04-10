package com.sunway.dao.impl;

import com.sunway.dao.BdcBaseDao;
import com.sunway.dao.TaxWsxxDao;
import com.sunway.entity.tax.TaxWsxx;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class TaxWsxxDaoImpl implements TaxWsxxDao {
    @Autowired
    private BdcBaseDao bdcBaseDao;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public TaxWsxx getDataById(TaxWsxx bean) {
        TaxWsxx rtnBean = null;
        Session session = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            rtnBean = session.get(TaxWsxx.class, bean.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rtnBean;
    }

    @Override
    public List<TaxWsxx> getAllData(TaxWsxx bean, int pageIndex, int pageSize) {
        List<TaxWsxx> resultList = null;
        Session session = null;
        CriteriaQuery<TaxWsxx> createQuery = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            String hql = "from TaxWsxx where to_char(wsrq, 'yyyy-MM-dd') = to_char(:pWsrq, 'yyyy-MM-dd')";
            Query query = session.createQuery(hql);
            query.setParameter("pWsrq", bean.getWsrq());
            query.setFirstResult((pageIndex - 1) * pageSize);
            query.setMaxResults(pageSize);
            // 返回查询结果集
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return resultList;
    }

    @Override
    public boolean execDelete(TaxWsxx bean) {
        boolean rtnBool = false;
        Session session = null;
        Transaction tran = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            tran = session.getTransaction();
            TaxWsxx wsBean = session.get(TaxWsxx.class, bean.getId());
            tran.begin();
            session.delete(wsBean);
            tran.commit();
            rtnBool = true;
            bdcBaseDao.execDelete_wsxx(wsBean);
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
        } finally {
            session.close();
        }
        return rtnBool;
    }

    @Override
    public boolean execInsert(TaxWsxx bean) {
        boolean rtnBool = false;
        Session session = null;
        Transaction tran = null;
        try {
            // 国土同步操作
            if(!bdcBaseDao.execInsert_wsxx(bean))
                bean.setFlagSyn(0);
            else
                bean.setFlagSyn(1);
            // 创建session对象
            session = sessionFactory.openSession();
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
    public boolean execUpdate(TaxWsxx bean) {
        boolean rtnBool = false;
        Session session = null;
        Transaction tran = null;
        try {
            // 国土同步操作
            String pk = bean.getId();
            bdcBaseDao.execDelete_wsxx(bean);
            if(!bdcBaseDao.execInsert_wsxx(bean))
                bean.setFlagSyn(0);
            else
                bean.setFlagSyn(1);
            bean.setId(pk);
            // 创建session对象
            session = sessionFactory.openSession();
            tran = session.getTransaction();
            tran.begin();
            session.update(bean);
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