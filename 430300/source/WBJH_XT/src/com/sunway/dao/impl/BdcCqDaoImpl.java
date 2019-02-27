package com.sunway.dao.impl;

import com.sunway.dao.BdcCqDao;
import com.sunway.entity.BdcCq;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.MakeUtil;
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
        String HQL = "select distinct new BdcCq(a.id, a.ywh, a.bdcdyh, a.bdcqzh, a.jyjg, a.fzrq) from BdcCq as a left join BdcQlr as b on a.ywh=b.ywh where 1=1";
        if(null!=bean.getJysj())
            HQL = HQL + " and to_char(a.jysj, 'yyyy-MM-dd') = to_char(:pJysj, 'yyyy-MM-dd')";
        if(null!=bean.getQlr() && !"".equals(bean.getQlr()))
            HQL = HQL + " and b.sname like :pQlr";
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            Query query = session.createQuery(HQL);
            if(null!=bean.getQlr() && !"".equals(bean.getQlr()))
                query.setParameter("pQlr", FormatUtil.toSearchLike(bean.getQlr()));
            if(null!=bean.getJysj())
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
