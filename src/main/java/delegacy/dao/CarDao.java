package delegacy.dao;

import java.util.List;

import delegacy.model.Car;
import delegacy.model.Worker;

/**
 * Az autókat kezelő DAO interfész.
 * @author Krisztian
 *
 */
public interface CarDao {
	
	/**
	 * Az autókat mentő metódus.
	 * @param car A menteni kívánt {@link delegacy.model.Car} objektum
	 */
	void save(Car car);
	
	/**
	 * Az autókat frissítő metódus.
	 * @param car A frissíteni kívánt {@link delegacy.model.Car} objektum
	 */
	void update(Car car);
	
	/**
	 * Az autókat törlő metódus.
	 * @param car A törölni kívánt {@link delegacy.model.Car} objektum
	 */
	void remove (Car car);
	
	/**
	 * Visszaad egy autót id alapján.
	 * @param id az autó idja
	 * @return {@link delegacy.model.Car} objektum
	 */
	Car get (int id);
	
	/**
	 * Az autókat listázó metódus.
	 * @return Az autók listája
	 */
	List<Car> getCars();
	
	/**
	 * A tulajok autóit listázó metódus.
	 * @param worker A következő {@link delegacy.model.Worker} objektumhoz keressük az autókat
	 * @return Autók listája
	 */
	List<Car> getCarByWorker(Worker worker);
	
}
