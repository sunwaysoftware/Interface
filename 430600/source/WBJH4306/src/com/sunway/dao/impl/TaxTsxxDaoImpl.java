package com.sunway.dao.impl;

import com.sunway.dao.BaseDao;
import com.sunway.dao.TaxTsxxDao;
import com.sunway.entity.TaxTsxx;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class TaxTsxxDaoImpl extends BaseDaoImpl<TaxTsxx> implements TaxTsxxDao {

    public List<TaxTsxx> getAllData(TaxTsxx bean, int pageIndex, int pageSize) {
        List<TaxTsxx> resultList = null;
        Session session = null;
        try {
            // 创建session对象
            session = getSessionFactory().getCurrentSession();
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
            //session.close();
        }
        return resultList;
    }

}
