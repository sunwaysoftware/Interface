/**
 * 
 */
package com.sunway.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author amani
 *
 */
public class HibernateUtils {
	// 声明会话工厂（session(用完后即死亡),connection）
	private static SessionFactory sessionFactory;

	static {
		try {
			// 声明读取配置文件的类，此类在实例化时默认即读取
			Configuration conf = new Configuration();
			// 默认会先去读取classpath下的hibernate.properties,然后读取hibernate.cfg.xml文件,后者会覆盖前者
			conf.configure();
			sessionFactory = conf.buildSessionFactory(); // 创建会话工厂
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * // 返回会话的工厂
	 * 
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * 从工厂打开一个新的Session并返回
	 * 
	 * @return 新的Session
	 */
	public static Session getSession() { //
		return sessionFactory.openSession();
	}

	/***
	 * 关闭传入的数据库Session对象
	 */
	public static void closeSession(Session session) {
		if (session != null && session.isOpen())
			session.close();
	}

	/**
	 * 清理连接池
	 */
	public static void closeSessionFactory(){
		if(sessionFactory !=null && sessionFactory.isOpen())
            sessionFactory.close();
	}
}
