package com.sunway.dao.impl;

import com.sunway.dao.BdcFwsxDao;
import com.sunway.entity.BdcFwsx;
import com.sunway.util.FormatUtil;
import com.sunway.vo.ChartJsVo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BdcFwsxDaoImpl extends BaseDaoImpl<BdcFwsx> implements BdcFwsxDao {

    @Override
    public List<BdcFwsx> getDataByYwh(BdcFwsx bean) {
        List<BdcFwsx> resultList = null;
        Session session = null;
        try {
            // 创建session对象
            session = getSessionFactory().getCurrentSession();
            String hql = "from BdcFwsx where ywh = :pYwh";
            Query query = session.createQuery(hql);
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
    public List<BdcFwsx> getAllData(BdcFwsx bean, int pageIndex, int pageSize) {
        List<BdcFwsx> resultList = null;
        Session session = null;
        String HQL = "select distinct new BdcFwsx(a.id, a.ywh, a.bsit, a.barea, a.bdcdyh) from BdcFwsx a left join BdcQlr b on a.ywh=b.ywh where 1=1";
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

    @Override
    public List<ChartJsVo> getCountGroupMonthByYear(Integer year) {
        List<ChartJsVo> resultList = null;
        Session session = null;
        try {
            // 创建session对象
            session = getSessionFactory().getCurrentSession();
            String hql = "select new com.sunway.vo.ChartJsVo(month(cssj), count(id)) from BdcFwsx where year(cssj) = :pYear group by month(cssj) order by month(cssj)";
            Query query = session.createQuery(hql);
            query.setParameter("pYear", year);
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
