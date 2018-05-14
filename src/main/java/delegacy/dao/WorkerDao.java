package delegacy.dao;

import java.util.List;

import delegacy.model.Worker;

/**
 * A dolgozókat kezelő metódus.
 * @author Krisztian
 *
 */
public interface WorkerDao {
	
	/**
	 * A kiküldetéseket mentő metódus.
	 * @param worker A menteni kívánt {@link delegacy.model.Worker} objektum
	 */
	void save(Worker worker);
	
	/**
	 * A kiküldetéseket frissítő metódus.
	 * @param worker A frissíteni kívánt {@link delegacy.model.Worker} objektum
	 */
	void update(Worker worker);
	
	/**
	 * A kiküldetéseket türlő metódus.
	 * @param worker A tötölni kívánt {@link delegacy.model.Worker} objektum
	 */
	void remove (Worker worker);
	
	/**
	 * A dolgozókat listaázó metódus.
	 * @return Az dolgozók listája
	 */
	List<Worker> getAllWorker();
}
