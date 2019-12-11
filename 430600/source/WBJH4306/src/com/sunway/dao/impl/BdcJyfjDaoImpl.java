/**
 * 
 */
package com.sunway.dao.impl;

import java.util.List;

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
            String hql = "from BdcJyfj where to_char(upfiletime, 'yyyy-MM-dd') = to_char(:pInsTime, 'yyyy-MM-dd')";
            Query query = session.createQuery(hql);
            query.setParameter("pInsTime", bean.getUpfiletime());
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
