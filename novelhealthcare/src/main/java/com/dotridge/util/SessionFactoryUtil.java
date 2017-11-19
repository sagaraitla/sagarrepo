package com.dotridge.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {

	private static SessionFactory sessionFactory = null;

	private SessionFactoryUtil() {
		// no operation
	}

	public static SessionFactory getInstance() {

		if(sessionFactory==null){
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		}
		
		
		/*if (sessionFactory == null) {
			synchronized (SessionFactoryUtil.class) {
				if (sessionFactory == null) {
					Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
					sessionFactory = configuration.buildSessionFactory();
				}

			}

		}*/

		return sessionFactory;

	}
}
