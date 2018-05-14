package delegacy.dao;

import java.util.List;

import delegacy.model.Delegacy;

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
	 * A kiküldetéseket listaázó metódus.
	 * @return Az kiküldetések listája
	 */
	List<Delegacy> getAllDelegacy();
	
}
