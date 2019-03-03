package com.sunway.dao.impl;

import com.sunway.dao.BdcZdsxDao;
import com.sunway.entity.BdcZdsx;
import com.sunway.util.FormatUtil;
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
        String HQL = " select distinct new BdcZdsx(a.id, a.ywh, a.zddm, a.zdmj, a.zdh, a.djh) from BdcZdsx a left join BdcQlr b on a.ywh=b.ywh where 1=1";
        if(null!=bean.getSyqqssj())
            HQL = HQL + " and to_char(a.syqqssj, 'yyyy-MM-dd') >= to_char(:sj1, 'yyyy-MM-dd')";
        if(null!=bean.getSyqjssj())
            HQL = HQL + " and to_char(a.syqjssj, 'yyyy-MM-dd') <= to_char(:sj2, 'yyyy-MM-dd')";
        if(null!=bean.getQlr() && !"".equals(bean.getQlr()))
            HQL = HQL + " and b.sname like :pQlr";

        try {
            // 创建session对象
            session = sessionFactory.openSession();
            Query query = session.createQuery(HQL);
            if(null!=bean.getQlr() && !"".equals(bean.getQlr()))
                query.setParameter("pQlr", FormatUtil.toSearchLike(bean.getQlr()));
            if(null!=bean.getSyqqssj())
                query.setParameter("sj1", bean.getSyqqssj());
            if(null!=bean.getSyqjssj())
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
