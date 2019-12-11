package com.sunway.dao.impl;

import com.sunway.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    private Class clazz;//用于接收运行时的泛型类型

    public BaseDaoImpl() {
        //获得当前类型的带有泛型类型的父类
        ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
        //ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericInterfaces()[0];

        //获得运行期的泛型类型
        this.clazz = (Class) ptClass.getActualTypeArguments()[0];
    }

    @Autowired
    public void appSessionFactory(SessionFactory sessionFactory){
        setSessionFactory(sessionFactory);
    }

    /**
     * 删除操作
     * @param t
     * @return T.成功；F.失败
     */
    public void execDelete(T t) {
        getHibernateTemplate().delete(t);
    }

    /**
     * 插入操作
     * @param t
     * @return T.成功；F.失败
     */
    public void execInsert(T t) {
        getHibernateTemplate().save(t);
    }

    /**
     * 更新操作
     * @param t
     * @return T.成功；F.失败
     */
    public void execUpdate(T t) {
        getHibernateTemplate().update(t);
    }

    /**
     * 根据主键查数据
     * @param id 主键
     * @return 返回实体
     */
    public T getById(Serializable id) {
        return (T)getHibernateTemplate().get(clazz, id);
    }
}
