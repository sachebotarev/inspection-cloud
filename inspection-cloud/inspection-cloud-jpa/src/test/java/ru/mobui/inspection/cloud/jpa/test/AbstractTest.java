package ru.mobui.inspection.cloud.jpa.test;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class AbstractTest {
	public static final String PERSISTENCE_UNIT = "ru.mobui.inspection.cloud";
	private static boolean inMemory = true;
	public static final String TEST_JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String TEST_JDBC_URL_IN_MEMORY = "jdbc:derby:memory:DemoDB;create=true";
	public static final String TEST_JDBC_URL = "jdbc:derby:DemoDB;create=true";
	public static final String TEST_JDBC_USER = "demo";
	public static final String TEST_JDBC_PASSWORD = "demo";
	public static final String TEST_TARGET_DATABASE = "Derby";
	public static final String TEST_JPA_LOG_LEVEL = "INFO";
	
	protected static EntityManagerFactory emf;

	@BeforeClass
	public static void setup() {
	    emf = Persistence.createEntityManagerFactory(
				PERSISTENCE_UNIT, getDefaultTestProperties());
	}

	@AfterClass
	public static void shutdown() {
		emf.close();
	}
	
	private static Map<String, String> getDefaultTestProperties() {
		Map<String, String> defaultProperties = null;
		if (defaultProperties == null) {
			defaultProperties = new HashMap<String, String>();
			defaultProperties.put(PersistenceUnitProperties.JDBC_DRIVER,
					TEST_JDBC_DRIVER);
			if (inMemory) {
				defaultProperties.put(PersistenceUnitProperties.JDBC_URL,
						TEST_JDBC_URL_IN_MEMORY);
			} else {
				defaultProperties.put(PersistenceUnitProperties.JDBC_URL,
						TEST_JDBC_URL);
			}
			defaultProperties.put(PersistenceUnitProperties.JDBC_USER,
					TEST_JDBC_USER);
			defaultProperties.put(PersistenceUnitProperties.JDBC_PASSWORD,
					TEST_JDBC_PASSWORD);
			defaultProperties.put(PersistenceUnitProperties.TARGET_DATABASE,
					TEST_TARGET_DATABASE);
			defaultProperties.put(PersistenceUnitProperties.LOGGING_LEVEL,
					TEST_JPA_LOG_LEVEL);
			defaultProperties.put(PersistenceUnitProperties.DDL_GENERATION,
					PersistenceUnitProperties.DROP_AND_CREATE);
		}
		return defaultProperties;
	}
}
