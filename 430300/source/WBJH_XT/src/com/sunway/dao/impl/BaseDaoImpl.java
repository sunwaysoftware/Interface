package com.sunway.dao.impl;

import com.sunway.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDaoImpl implements BaseDao {
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 删除操作
     * @param bean
     * @return T.成功；F.失败
     */
    public boolean execDelete(Object bean) {
        boolean rtnBool = false;
        Session session = null;
        Transaction tran = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            tran = session.getTransaction();
            tran.begin();
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

    /**
     * 插入操作
     * @param bean
     * @return T.成功；F.失败
     */
    public boolean execInsert(Object bean) {
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

    /**
     * 更新操作
     * @param bean
     * @return T.成功；F.失败
     */
    public boolean execUpdate(Object bean) {
        boolean rtnBool = false;
        Session session = null;
        Transaction tran = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            tran = session.getTransaction();
            tran.begin();
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

    /**
     * 根据主键查数据
     * @param pClass 实体类
     * @param id 主键
     * @return 返回实体
     */
    public Object getDataById(Class pClass ,String id) {
        Object rtnBean = null;
        Session session = null;
        try {
            // 创建session对象
            session = sessionFactory.openSession();
            rtnBean = session.get(pClass, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rtnBean;
    }
}
