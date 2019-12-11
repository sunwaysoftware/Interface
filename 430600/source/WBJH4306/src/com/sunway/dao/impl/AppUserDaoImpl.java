package com.sunway.dao.impl;

import com.sunway.dao.AppUserDao;
import com.sunway.entity.AppUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AppUserDaoImpl extends BaseDaoImpl<AppUser> implements AppUserDao {

    @Override
    public List<AppUser> getAllData(AppUser bean, int pageIndex, int pageSize) {
        List<AppUser> resultList = null;
        Session session = null;
        try {
            // 创建session对象
            session = getSessionFactory().getCurrentSession();
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
            //session.close();
        }
        return resultList;
    }
}
