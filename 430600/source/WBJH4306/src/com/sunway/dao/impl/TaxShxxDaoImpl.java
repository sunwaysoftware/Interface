package com.sunway.dao.impl;

import com.sunway.dao.TaxShxxDao;
import com.sunway.entity.TaxShxx;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaxShxxDaoImpl extends BaseDaoImpl<TaxShxx> implements TaxShxxDao {

    @Override
    public List<TaxShxx> getAllData(TaxShxx bean, int pageIndex, int pageSize) {
        List<TaxShxx> resultList = null;
        Session session = null;
        try {
            // 创建session对象
            session = getSessionFactory().getCurrentSession();
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
            //session.close();
        }
        return resultList;
    }

}
