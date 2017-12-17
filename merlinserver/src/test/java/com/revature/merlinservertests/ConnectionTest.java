package com.revature.merlinservertests;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.junit.Test;

import com.revature.util.HibernateUtil;

/**
 * Determines if Hibernate can get connection from remote database
 * @author Luie
 */
public class ConnectionTest {

	@Test
	public void shouldGetNonNullHibernateSession() {
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();	
		} finally {
			if (session != null)
				session.close();
			
			assertNotNull(session);
		}
	}
}
