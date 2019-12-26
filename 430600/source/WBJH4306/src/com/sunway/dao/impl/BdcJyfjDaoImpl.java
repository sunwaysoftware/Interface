/**
 * 
 */
package com.sunway.dao.impl;

import java.util.List;

import com.sunway.util.FormatUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sunway.dao.BdcJyfjDao;
import com.sunway.entity.BdcJyfj;

/**
 * @author andy.gao
 *
 */
@Repository
public class BdcJyfjDaoImpl extends BaseDaoImpl<BdcJyfj> implements BdcJyfjDao {

	@Override
	public List<BdcJyfj> getAllData(BdcJyfj bean, int pageIndex, int pageSize) {
        List<BdcJyfj> resultList = null;
        Session session = null;
        try {
            // 创建session对象
            session = getSessionFactory().getCurrentSession();
            String hql = "from BdcJyfj where caseno like :ywh and slbh like :slbh";
            Query query = session.createQuery(hql);
            query.setParameter("ywh", "%"+bean.getCaseno()+"%");
            query.setParameter("slbh", "%"+bean.getSlbh()+"%");
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
