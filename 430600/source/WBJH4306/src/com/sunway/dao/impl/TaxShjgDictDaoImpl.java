package com.sunway.dao.impl;

import com.sunway.dao.TaxShjgDictDao;
import com.sunway.entity.TaxShjgDict;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaxShjgDictDaoImpl extends BaseDaoImpl<TaxShjgDict> implements TaxShjgDictDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TaxShjgDict> getAllData() {
        List<TaxShjgDict> resultList = null;
        Session session = null;
        try {
            // 创建session对象
            session = getSessionFactory().getCurrentSession();
            String hql = "from TaxShjgDict";
            Query query = session.createQuery(hql);
            // 返回查询结果集
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //session.close();
        }
        return resultList;
    }
}
