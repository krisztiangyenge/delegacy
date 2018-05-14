package delegacy.dao;

import delegacy.model.Admin;

/**
 * Az adminokat kezelő DAO interfész.
 * @author Krisztian
 *
 */
public interface AdminDao {

	/**
	 * Az adminokat mentő metódus.
	 * @param admin A menteni kívánt {@link delegacy.model.Admin} objektum
	 */
	void save(Admin admin);
	
	/**
	 * Megtalálja a felhasználót a belépéshez.
	 * @param name Az admin felhasználó neve 
	 * @param password Az admin jelszava
	 * @return Visszatér az {@link delegacy.model.Admin} objektummal
	 * @throws Exception Ha nem talál felhasználót
	 */
	Admin Login(String name, String password) throws Exception;
}
