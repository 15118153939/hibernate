package com.lv.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;
	
	static {
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        //�����Ự��������
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
      
	}
/**
 * ��ȡSessionFactory
 * @return
 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * ��ȡSession
	 * @return
	 */
	public static Session getSession() {
		  //�Ự����
        session = sessionFactory.openSession();
		return session;
	}

	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}
}