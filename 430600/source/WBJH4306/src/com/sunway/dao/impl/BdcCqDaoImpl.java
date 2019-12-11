package com.sunway.dao.impl;

import com.sunway.dao.BdcCqDao;
import com.sunway.entity.BdcCq;
import com.sunway.util.FormatUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BdcCqDaoImpl extends BaseDaoImpl<BdcCq> implements BdcCqDao {

    @Override
    public List<BdcCq> getDataByYwh(BdcCq bean) {
        List<BdcCq> resultList = null;
        Session session = null;
        String HQL = "from BdcCq where ywh = :pYwh";
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

    @Override
    public List<BdcCq> getAllData(BdcCq bean, int pageIndex, int pageSize) {
        List<BdcCq> resultList = null;
        Session session = null;
        String HQL = "select distinct new BdcCq(a.id, a.ywh, a.ybdcqzh, a.bdcqzh, a.jyjg, a.fzrq) from BdcCq as a left join BdcQlr as b on a.ywh=b.ywh where 1=1";
        if(null!=bean.getCssj())
            HQL = HQL + " and to_char(a.cssj, 'yyyy-MM-dd') = to_char(:pCssj, 'yyyy-MM-dd')";
        if(null!=bean.getQlr() && !"".equals(bean.getQlr()))
            HQL = HQL + " and b.sname like :pQlr";
        try {
            // 创建session对象
            session = getSessionFactory().getCurrentSession();
            Query query = session.createQuery(HQL);
            if(null!=bean.getQlr() && !"".equals(bean.getQlr()))
                query.setParameter("pQlr", FormatUtil.toSearchLike(bean.getQlr()));
            if(null!=bean.getCssj())
                query.setParameter("pCssj", bean.getCssj());
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
