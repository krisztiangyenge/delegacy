package delegacy.service;

import java.util.List;

import delegacy.model.Car;
import delegacy.model.Delegacy;
import delegacy.model.Worker;

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
	 *  Visszaad egy kiküldetést id alapján.
	 * @param id A kiküldetés id-ja
	 * @return A kért kiküldetés
	 */
	Delegacy get(int id);
	
	/**
	 * Az összes kiküldetés listázása.
	 * @return A kiküldetések listája
	 */
	List<Delegacy> getAllDelegacy();
	
	/**
	  * A kifizetendő összeget kiszámoló metódus, ami hozzáad egy 9Ft/km amortizációs költséget a benzinköltséghez.
	  * @param distance Az út távolsága
	  * @param consumption Az autó fogyasztása
	  * @param FuelPrice Az üzemanyag ára
	  * @return A kifizetendő összeg
	  */
	Double getActionPay(Double distance, Double consumption, Double FuelPrice);
	
	 /**
	  * A kifizetendő összeget kiszámoló metódus.
	  * @param distance Az út távolsága
	  * @param consumption Az autó fogyasztása
	  * @param FuelPrice Az üzemanyag ára
	  * @return A kifizetendő összeg
	  */
	Double getPay(Double distance, Double consumption, Double FuelPrice);
	
	/**
	 * A validálást végző metódus.
	 * @param delegacy a validálandó objektum
	 * @return A validálás eredménye
	 * @throws IllegalArgumentException Ha nem valid az objektum, kivételt dob
	 */
	boolean validate(Delegacy delegacy) throws IllegalArgumentException;
	
	 /**
	  * 
	  * @param distance A távolság
	  * @param consumption A fogyasztás
	  * @param FuelPrice A benzin ár
	  * @return Számolható-e az összeg
	  * @throws IllegalArgumentException Ha nincs meg minden praméter a számoláshoz hibát dob
	  */
	boolean validatePay(Double distance, Double consumption, Double FuelPrice) throws IllegalArgumentException;
}
