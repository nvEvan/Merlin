package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Sets up our session factory for transactions with our database.
 * @author Alex
 */
public class HibernateUtil {

	/**
	 * Grabs configuration file and create our session factory.
	 */
	@SuppressWarnings("deprecation")
	private static SessionFactory sessionFactory =
			new Configuration().configure().
			buildSessionFactory();

	/**@return a session to communicate with the DB*/
	public static Session getSession(){
		return sessionFactory.openSession();
	}
}