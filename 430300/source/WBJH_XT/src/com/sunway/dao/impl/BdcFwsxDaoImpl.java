package com.sunway.dao.impl;

import com.sunway.dao.BdcFwsxDao;
import com.sunway.entity.BdcFwsx;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;

import java.util.List;

@Repository
public class BdcFwsxDaoImpl implements BdcFwsxDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public BdcFwsx getDataById(BdcFwsx bean) {
        BdcFwsx rtnBean = null;
        Session session = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            rtnBean = session.get(BdcFwsx.class, bean.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rtnBean;
    }

    @Override
    public List<BdcFwsx> getDataByYwh(BdcFwsx bean) {
        List<BdcFwsx> resultList = null;
        Session session = null;
        CriteriaQuery<BdcFwsx> createQuery = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            String hql = "from BdcFwsx where ywh = :pYwh";
            Query query = session.createQuery(hql);
            query.setParameter("pYwh", bean.getYwh());
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
    public List<BdcFwsx> getAllData(BdcFwsx bean, int pageIndex, int pageSize) {
        List<BdcFwsx> resultList = null;
        Session session = null;
        CriteriaQuery<BdcFwsx> createQuery = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            String hql = "select new BdcFwsx(id, ywh, bsit, barea, bdcdyh, bdcqzh) from BdcFwsx where to_char(cssj, 'yyyy-MM-dd') = to_char(:pCssj, 'yyyy-MM-dd')";
            Query query = session.createQuery(hql);
            query.setParameter("pCssj", bean.getCssj());
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
    public List<Double> getCountGroupMonthByYear(Integer year) {
        List<Double> resultList = null;
        Session session = null;
        CriteriaQuery<BdcFwsx> createQuery = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            String hql = "select count(id) from BdcFwsx where year(cssj) = :pYear group by month(cssj) order by month(cssj)";
            Query query = session.createQuery(hql);
            query.setParameter("pYear", year);
            // 返回查询结果集
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return resultList;
    }
}
