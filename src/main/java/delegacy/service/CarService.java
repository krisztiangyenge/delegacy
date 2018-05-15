package delegacy.service;

import java.util.List;

import delegacy.model.Car;
import delegacy.model.Worker;

/**
 * Az autó controller interfésze. Ide kerülnek a felületről hívott metódusok.
 * @author Krisztian
 *
 */
public interface CarService {
	
	/**
	 * Egy új autó mentése az adatbázisba.
	 * @param car Az új {@link delegacy.model.Car} objektuma
	 * @throws IllegalArgumentException Ha nem menthető az objektum, hibaüzenetet dob
	 */
	void save(Car car) throws IllegalArgumentException;
			
	/**
	 * Egy autó adatait modosítja.
	 * @param car {@link delegacy.model.Car} objektum
	 * @throws IllegalArgumentException Ha nem menthető az objektum, hibaüzenetet dob
	 */
	void update(Car car) throws IllegalArgumentException;
	
	/**
	 * Autó törlése.
	 * @param car {@link delegacy.model.Car} objektum
	 * @throws IllegalArgumentException Ha nem törölhető az objektum, hibaüzenetet dob
	 */
	void remove(Car car) throws IllegalArgumentException;
	
	
	/**
	 *  Visszaad egy autót id alapján.
	 * @param id Az autó id-ja
	 * @return A kért autó
	 */
	Car get(int id);
	
	/**
	 * Az összes autó listázása.
	 * @return Az autók listája
	 */
	List<Car> getAllCars();
	
	/**
	 * Felhasználóhoz tartozó autók listázása.
	 * @param worker {@link delegacy.model.Worker} objektum
	 * @return Az autók listája
	 */
	List<Car> getCarByWorker(Worker worker);
	
	/**
	 * A validálást végző metódus.
	 * @param car a validálandó objektum
	 * @return A validálás eredménye
	 * @throws IllegalArgumentException Ha nem valid az objektum, kivételt dob
	 */
	boolean validate(Car car) throws IllegalArgumentException;
}
