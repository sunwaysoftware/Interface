package com.sunway.dao.impl;

import com.sunway.dao.BdcQlrDao;
import com.sunway.entity.BdcQlr;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BdcQlrDaoImpl extends BaseDaoImpl<BdcQlr> implements BdcQlrDao {

    @Override
    public List<BdcQlr> getDataByYwh(BdcQlr bean) {
        List<BdcQlr> resultList = null;
        Session session = null;
        String HQL = "from BdcQlr where ywh = :pYwh";
        try {
            // 创建session对象
            session = getSessionFactory().getCurrentSession();
            Query query = session.createQuery(HQL);
            query.setParameter("pYwh", bean.getYwh());
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
