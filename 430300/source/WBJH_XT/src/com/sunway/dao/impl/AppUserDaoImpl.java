package com.sunway.dao.impl;

import com.sunway.dao.AppUserDao;
import com.sunway.entity.tax.AppUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class AppUserDaoImpl implements AppUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public AppUser getDataById(AppUser bean) {
        AppUser rtnBean = null;
        Session session = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            rtnBean = session.get(AppUser.class, bean.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rtnBean;
    }

    @Override
    public List<AppUser> getAllData(AppUser bean, int pageIndex, int pageSize) {
        List<AppUser> resultList = null;
        Session session = null;
        CriteriaQuery<AppUser> createQuery = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            String hql = "from AppUser where username like :pName";
            Query query = session.createQuery(hql);
            if(null==bean.getUsername()) bean.setUsername("");
            query.setParameter("pName", "%"+bean.getUsername()+"%");
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

    @Override
    public boolean execDelete(AppUser bean) {
        boolean rtnBool = false;
        Session session = null;
        Transaction tran = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            tran = session.getTransaction();
            tran.begin();
            session.createQuery("delete AppAuthority where username = :nm").setParameter("nm", bean.getUsername()).executeUpdate();
            session.delete(bean);
            tran.commit();
            rtnBool = true;
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
        } finally {
            session.close();
        }
        return rtnBool;
    }

    @Override
    public boolean execInsert(AppUser bean) {
        boolean rtnBool = false;
        Session session = null;
        Transaction tran = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            tran = session.getTransaction();
            tran.begin();
            session.save(bean);
            tran.commit();
            rtnBool = true;
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
        } finally {
            session.close();
        }
        return rtnBool;
    }

    @Override
    public boolean execUpdate(AppUser bean) {
        boolean rtnBool = false;
        Session session = null;
        Transaction tran = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            tran = session.getTransaction();
            tran.begin();
            session.createQuery("delete AppAuthority where username = :nm").setParameter("nm", bean.getUsername()).executeUpdate();
            session.update(bean);
            tran.commit();
            rtnBool = true;
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
        } finally {
            session.close();
        }
        return rtnBool;
    }
}
