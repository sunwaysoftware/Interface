package com.sunway.dao.impl;

import com.sunway.dao.TaxWsxxDao;
import com.sunway.entity.TaxWsxx;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaxWsxxDaoImpl extends BaseDaoImpl<TaxWsxx> implements TaxWsxxDao {

    @Override
    public List<TaxWsxx> getAllData(TaxWsxx bean, int pageIndex, int pageSize) {
        List<TaxWsxx> resultList = null;
        Session session = null;
        try {
            // 创建session对象
            session = getSessionFactory().getCurrentSession();
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
            //session.close();
        }
        return resultList;
    }

}