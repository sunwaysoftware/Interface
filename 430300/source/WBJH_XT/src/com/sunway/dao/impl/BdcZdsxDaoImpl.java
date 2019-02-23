package com.sunway.dao.impl;

import com.sunway.dao.BdcZdsxDao;
import com.sunway.entity.BdcZdsx;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class BdcZdsxDaoImpl implements BdcZdsxDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public BdcZdsx getDataById(BdcZdsx bean) {
        BdcZdsx rtnBean = null;
        Session session = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            rtnBean = session.get(BdcZdsx.class, bean.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rtnBean;
    }

    @Override
    public List<BdcZdsx> getAllData(BdcZdsx bean, int pageIndex, int pageSize) {
        List<BdcZdsx> resultList = null;
        Session session = null;
        CriteriaQuery<BdcZdsx> createQuery = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            String hql = " select new BdcZdsx(id, ywh, zddm, zdmj, zdh, djh) from BdcZdsx where to_char(syqqssj, 'yyyy-MM-dd') >= to_char(:sj1, 'yyyy-MM-dd') and to_char(syqjssj, 'yyyy-MM-dd') <= to_char(:sj2, 'yyyy-MM-dd')";
            Query query = session.createQuery(hql);
            query.setParameter("sj1", bean.getSyqqssj());
            query.setParameter("sj2", bean.getSyqjssj());
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
}
