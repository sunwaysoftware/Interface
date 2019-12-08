package com.sunway.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.sunway.util.Common;
import com.sunway.vo.JsonPager;
import com.sunway.vo.Pgt00401;

public class Pgt00401DAO extends BaseDAO {

	public void persist(Pgt00401 transientInstance) throws Exception {
		Session session = null;
		logger.debug("persisting Pgt00401 instance");
		try {
			session = super.getSession();
			session.getTransaction().begin();
			session.persist(transientInstance);
			session.getTransaction().commit();
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			session.getTransaction().rollback();
			throw re;
		} finally {
			getFree(null, null, session);
		}
	}
	
	public void attachDirty(Pgt00401 persistentInstance) throws Exception {
		Session session = null;
		logger.debug("attaching dirty Pgt00401 instance");
		try {
			session = super.getSession();
			session.getTransaction().begin();
			session.saveOrUpdate(persistentInstance);
			session.getTransaction().commit();
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			session.getTransaction().rollback();
			throw re;
		} finally {
			getFree(null, null, session);
		}
	}
	
	public void delete(Pgt00401 persistentInstance) throws Exception {
		Session session = null;
		logger.debug("deleting Pgt00401 instance");
		try {
			session = super.getSession();
			session.getTransaction().begin();
			session.delete(persistentInstance);
			session.getTransaction().commit();
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			session.getTransaction().rollback();
			throw re;
		} finally {
			getFree(null, null, session);
		}
	}
	
	public Pgt00401 loadById(String pk) throws Exception {
		Pgt00401 bRtn;
		Session session = null;
		logger.debug("loadById Pgt00401 instance");
		try {
			session = super.getSession();
			bRtn = (Pgt00401) session.get(Pgt00401.class, pk);
			logger.debug("loadById successful");
		} catch (RuntimeException re) {
			logger.error("loadById failed", re);
			throw re;
		} finally {
			getFree(null, null, session);
		}
		return bRtn;
	}
	
	public JsonPager query (Pgt00401 bean, int pageIndex, int pageSize) throws Exception  {
		Session session = null;
		List<?> rtnList = null;
		int rowCount = 0;
		
		try {
			session = super.getSession();
			Criteria criteria = session.createCriteria(Pgt00401.class); 
			// 设置参数 
			if(null!=bean.getQlr()&& !Common.isNullOrEmpty(bean.getQlr())){
				criteria.add(Restrictions.like("qlr", Common.getSearchLike(bean.getQlr())));
			}
			if(null != bean.getGyqk() && !Common.isNullOrEmpty(bean.getGyqk())){
				criteria.add(Restrictions.like("gyqk", Common.getSearchLike(bean.getGyqk())));
			}
			if(null != bean.getCd00001Ssgx() && !Common.isNullOrEmpty(bean.getCd00001Ssgx())){
				criteria.add(Restrictions.eq("cd00001Ssgx", bean.getCd00001Ssgx()));
			}			
	        // 获取根据条件分页查询的总行数  
	        rowCount = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();  
	        criteria.setProjection(null);
	        // 设置每页显示多少个，设置多大结果。  
	        criteria.setMaxResults(pageSize);  
	        // 设置起点  
	        criteria.setFirstResult((pageIndex - 1) * pageSize); 
	        rtnList = criteria.list();
		} catch (Exception e) {
			logger.error(e);
		} finally {
			getFree(null, null, session);
		}
		
		return new JsonPager(pageIndex, pageSize, rowCount, rtnList);
	}
	
	
	
	
	
}
