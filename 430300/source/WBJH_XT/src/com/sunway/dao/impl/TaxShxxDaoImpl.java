package com.sunway.dao.impl;

import com.sunway.dao.TaxShxxDao;
import com.sunway.entity.tax.TaxShxx;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class TaxShxxDaoImpl implements TaxShxxDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TaxShxx> getAllData(TaxShxx bean, int pageIndex, int pageSize) {
        List<TaxShxx> resultList = null;
        Session session = null;
        CriteriaQuery<TaxShxx> createQuery = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            String hql = "from TaxShxx where to_char(shsj, 'yyyy-MM-dd') = to_char(:pShsj, 'yyyy-MM-dd')";
            Query query = session.createQuery(hql);
            query.setParameter("pShsj", bean.getShsj());
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
