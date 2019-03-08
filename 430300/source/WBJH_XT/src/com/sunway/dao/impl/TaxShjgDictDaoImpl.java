package com.sunway.dao.impl;

import com.sunway.dao.TaxShjgDictDao;
import com.sunway.entity.tax.TaxShjgDict;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class TaxShjgDictDaoImpl implements TaxShjgDictDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TaxShjgDict> getAllData() {
        List<TaxShjgDict> resultList = null;
        Session session = null;
        CriteriaQuery<TaxShjgDict> createQuery = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            String hql = "from TaxShjgDict";
            Query query = session.createQuery(hql);
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
