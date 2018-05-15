package delegacy.dao;

import java.util.List;

import delegacy.model.Car;
import delegacy.model.Delegacy;
import delegacy.model.Worker;

/**
 * A kiküldetéseket DAO interfész.
 * @author Krisztian
 *
 */
public interface DelegacyDao {

	/**
	 * A kiküldetéseket mentő metódus.
	 * @param delegacy A menteni kívánt {@link delegacy.model.Delegacy} objektum
	 */
	void save(Delegacy delegacy);
	
	/**
	 * A kiküldetéseket frissítő metódus.
	 * @param delegacy A frissíteni kívánt {@link delegacy.model.Delegacy} objektum
	 */
	void update(Delegacy delegacy);
	
	/**
	 * A kiküldetéseket törlő metódus.
	 * @param delegacy A törölni kívánt {@link delegacy.model.Delegacy} objektum
	 */
	void remove (Delegacy delegacy);
	
	/**
	 * Visszaad egy kiküldetést id alapján.
	 * @param id a kiküldetés id-ja
	 * @return {@link delegacy.model.Delegacy} objektum
	 */
	Delegacy get (int id);
	
	/**
	 * A kiküldetéseket listaázó metódus.
	 * @return Az kiküldetések listája
	 */
	List<Delegacy> getAllDelegacy();
	
}
