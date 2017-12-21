package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Sets up our session factory for transactions with our database.
 * 
 * @author Alex
 */
public class HibernateUtil {

	/**
	 * Grabs configuration file and create our session factory.
	 */
	private static SessionFactory sessionFactory;

	// Initialize SessionFactory
	static {
		initSessionFactory();
	}

	/**
	 * @return a session to communicate with the DB
	 */
	public static Session getSession() {
		return sessionFactory.openSession();
	}

	///
	// PRIVATE METHODS
	///

	@SuppressWarnings("deprecation")
	private static void initSessionFactory() {
		// Get basic hibernate config data
		String merlinDBProp = System.getenv("MerlinDBProp");
		String[] databaseProps = merlinDBProp.split(";");
		Configuration config = new Configuration().configure();

		// Set local config properties
		config.setProperty("hibernate.connection.url", databaseProps[0]);
		config.setProperty("hibernate.connection.username", databaseProps[1]);
		config.setProperty("hibernate.connection.password", databaseProps[2]);
		config.setProperty("hibernate.connection.pool_size", databaseProps[3]);
		config.setProperty("show_swl", databaseProps[4]);
		config.setProperty("hibernate.hbm2ddl.auto", databaseProps[5]);

		// create SessionFactory
		sessionFactory = config.buildSessionFactory();
	}
}
