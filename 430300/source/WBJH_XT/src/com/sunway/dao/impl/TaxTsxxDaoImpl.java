package com.sunway.dao.impl;

import com.sunway.dao.TaxTsxxDao;
import com.sunway.entity.tax.TaxTsxx;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class TaxTsxxDaoImpl implements TaxTsxxDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public TaxTsxx getDataById(TaxTsxx bean) {
        TaxTsxx rtnBean = null;
        Session session = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            rtnBean = session.get(TaxTsxx.class, bean.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rtnBean;
    }

    @Override
    public List<TaxTsxx> getAllData(TaxTsxx bean, int pageIndex, int pageSize) {
        List<TaxTsxx> resultList = null;
        Session session = null;
        CriteriaQuery<TaxTsxx> createQuery = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            String hql = "from TaxTsxx where to_char(tssj, 'yyyy-MM-dd') = to_char(:pTssj, 'yyyy-MM-dd')";
            Query query = session.createQuery(hql);
            query.setParameter("pTssj", bean.getTssj());
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
    public boolean execDelete(TaxTsxx bean) {
        boolean rtnBool = false;
        Session session = null;
        Transaction tran = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            tran = session.getTransaction();
            tran.begin();
            session.delete(bean);
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
    public boolean execInsert(TaxTsxx bean) {
        boolean rtnBool = false;
        Session session = null;
        Transaction tran = null;
        try {
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
    public boolean execUpdate(TaxTsxx bean) {
        boolean rtnBool = false;
        Session session = null;
        Transaction tran = null;
        try {
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
