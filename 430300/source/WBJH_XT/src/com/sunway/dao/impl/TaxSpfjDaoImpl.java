package com.sunway.dao.impl;

import com.sunway.dao.TaxSpfjDao;
import com.sunway.entity.TaxSpfj;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class TaxSpfjDaoImpl implements TaxSpfjDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TaxSpfj> getAllData(TaxSpfj bean, int pageIndex, int pageSize) {
        List<TaxSpfj> resultList = null;
        Session session = null;
        CriteriaQuery<TaxSpfj> createQuery = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            String hql = "from TaxSpfj where to_char(sprq, 'yyyy-MM-dd') = to_char(:pSprq, 'yyyy-MM-dd')";
            Query query = session.createQuery(hql);
            query.setParameter("pSprq", bean.getSprq());
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
