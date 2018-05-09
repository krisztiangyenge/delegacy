package delegacy.datasource;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionHandler {

	private static final String persistenceUnitName = "carDelegacy";
	
	private static EntityManagerFactory entityManagerFactory;
	
	private static ConnectionHandler instance = new ConnectionHandler(); 
	
	private ConnectionHandler() {
	}
	
	public static ConnectionHandler getInstance() {
		return instance;
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		}
		return entityManagerFactory;
	}
	
	public static void closeConnection() {
		if (entityManagerFactory.isOpen())
			entityManagerFactory.close();
	}
	
}
