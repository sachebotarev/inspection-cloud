package ru.mobui.inspection.cloud.odata;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;

public class JPAEntityManagerFactory {
	/**
	 * The JNDI name of the DataSource.
	 */
	public static final String DATA_SOURCE_NAME = "java:comp/env/jdbc/DefaultDB";
	
	/**
	 * The package name which contains all the model classes.
	 */
	public static final String PERSISTENCE_UNIT_NAME = "ru.mobui.inspection.cloud";

	/**
	 * The static {@link EntityManagerFactory}
	 */
	private static EntityManagerFactory entityManagerFactory = null;

	public static synchronized EntityManagerFactory getEntityManagerFactory()
			throws NamingException, SQLException {
		if (entityManagerFactory == null) {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(DATA_SOURCE_NAME);
			Map<String, Object> properties = new HashMap<String, Object>();
			properties.put(PersistenceUnitProperties.NON_JTA_DATASOURCE, ds);
			entityManagerFactory = Persistence.createEntityManagerFactory(
					PERSISTENCE_UNIT_NAME, properties);
		}
		return entityManagerFactory;
	}

}
