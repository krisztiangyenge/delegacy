package delegacy.service;

import java.util.List;

import delegacy.model.Delegacy;

/**
 * A kiküldetés controller interfésze. Ide kerülnek a felületről hívott metódusok.
 * @author Krisztian
 *
 */
public interface DelegacyService {
	
	/**
	 * Egy új kiküldetés mentése az adatbázisba.
	 * @param delegacy Az új {@link delegacy.model.Delegacy} objektuma
	 * @throws IllegalArgumentException Ha nem menthető az objektum, hibaüzenetet dob
	 */
	void save(Delegacy delegacy) throws IllegalArgumentException;
	
	/**
	 * Kiküldetés adatait modosítja.
	 * @param delegacy {@link delegacy.model.Delegacy} objektum
	 * @throws IllegalArgumentException Ha nem menthető az objektum, hibaüzenetet dob
	 */
	void update(Delegacy delegacy) throws IllegalArgumentException;
	
	/**
	 * Kiküldetés törlése.
	 * @param delegacy {@link delegacy.model.Delegacy} objektum
	 * @throws IllegalArgumentException Ha nem törölhető az objektum, hibaüzenetet dob
	 */
	void remove(Delegacy delegacy) throws IllegalArgumentException;
	
	/**
	 * Az összes kiküldetés listázása.
	 * @return A kiküldetések listája
	 */
	List<Delegacy> getAllDelegacy();
	 /**
	  * A kifizetendő összeget kiszámoló metódus.
	  * @param distance Az út távolsága
	  * @param consumption Az autó fogyasztása
	  * @param FuelPrice Az üzemanyag ára
	  * @return A kifizetendő összeg
	  */
	Double getPay(Double distance, Double consumption, Double FuelPrice);
}
