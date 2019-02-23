package com.sunway.dao.impl;

import com.sunway.dao.BdcCqDao;
import com.sunway.entity.BdcCq;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class BdcCqDaoImpl implements BdcCqDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public BdcCq getDataById(BdcCq bean) {
        BdcCq rtnBean = null;
        Session session = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            rtnBean = session.get(BdcCq.class, bean.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rtnBean;
    }

    @Override
    public List<BdcCq> getAllData(BdcCq bean, int pageIndex, int pageSize) {
        List<BdcCq> resultList = null;
        Session session = null;
        CriteriaQuery<BdcCq> createQuery = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            String hql = "select new BdcCq(id, ywh, bdcdyh, bdcqzh, jyjg, fzrq) from BdcCq where to_char(jysj, 'yyyy-MM-dd') = to_char(:pJysj, 'yyyy-MM-dd')";
            Query query = session.createQuery(hql);
            query.setParameter("pJysj", bean.getJysj());
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
