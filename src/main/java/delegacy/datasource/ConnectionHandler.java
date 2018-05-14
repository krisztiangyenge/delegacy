package delegacy.datasource;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Az adatbázis kapcsolatot kezelő osztály.
 * @author Krisztian
 *
 */
public class ConnectionHandler {

	private static final String persistenceUnitName = "carDelegacy";
	
	private static EntityManagerFactory entityManagerFactory;
	
	private static ConnectionHandler instance = new ConnectionHandler(); 
	
	private ConnectionHandler() {
	}
	
	/**
	 * Az alkalmazás aktuális példányát visszaadó metódus.
	 * @return Az alkalmazás aktulális példánya
	 */
	public static ConnectionHandler getInstance() {
		return instance;
	}
	
	/**
	 * Az EntityManagerFactory-t visszaadó metódus.
	 * @return EntityManagerFactory
	 */
	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		}
		return entityManagerFactory;
	}
	
	/**
	 * Ha van nyitott adatbázis kapcsolat, lezárja azt.
	 */
	public static void closeConnection() {
		if (entityManagerFactory.isOpen())
			entityManagerFactory.close();
	}
	
}
