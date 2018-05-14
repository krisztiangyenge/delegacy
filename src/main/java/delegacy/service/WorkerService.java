package delegacy.service;

import java.util.List;

import delegacy.model.Worker;

/**
 * A dolgozó controller interfésze. Ide kerülnek a felületről hívott metódusok.
 * @author Krisztian
 *
 */
public interface WorkerService {
	
	/**
	 * Egy új dolgozó mentése az adatbázisba.
	 * @param worker Az új {@link delegacy.model.Worker} objektuma
	 * @throws IllegalArgumentException Ha nem menthető az objektum, hibaüzenetet dob
	 */
	void save(Worker worker) throws IllegalArgumentException;
	
	/**
	 * Dolgozó adatait modosítja.
	 * @param worker {@link delegacy.model.Worker} objektum
	 * @throws IllegalArgumentException Ha nem menthető az objektum, hibaüzenetet dob
	 */
	void update(Worker worker) throws IllegalArgumentException;
	
	/**
	 * Dolgozó törlése.
	 * @param worker {@link delegacy.model.Worker} objektum
	 * @throws IllegalArgumentException Ha nem törölhető az objektum, hibaüzenetet dob
	 */
	void remove(Worker worker) throws IllegalArgumentException;
	
	/**
	 * Az összes dolgozó listázása.
	 * @return A dolgozók listája
	 */
	List<Worker> getAllWorker();
}
