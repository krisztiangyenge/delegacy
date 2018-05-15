package delegacy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Az dolgozót reprezentáló osztály.
 * @author Krisztian
 *
 */
@Entity
@XmlRootElement(name="worker")
public class Worker {
	
	/**
	 * Az osztály konstruktora.
	 * @param lastName A dolgozó kereszt neve
	 * @param firstName A dolgozó vezeték neve
	 */
	public Worker(String lastName, String firstName) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	/**
	 * Az osztály paraméter nélküli konstruktora.
	 */
	public Worker() {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int workerId;
	
	private String lastName;
	
	private String firstName;
	
	private Double traveled;
	
	/**
	 * A megtett utat visszaadó metódus.
	 * @return A megtett út
	 */
	public Double getTraveled() {
		return traveled;
	}
	
	 /**
	  * A megtett utat beállító metódus.
	  * @param traveled A megtett út
	  */
	public void setTraveled(double traveled) {
		this.traveled = traveled;
	}
	
	/**
	 * A dolgozó id-ját visszaadó metódus.
	 * @return A dolgozó id-ja
	 */
	@XmlAttribute
	public int getWorkerId() {
		return workerId;
	}

	/**
	  * A dolgozó id-ját beállító metódus.
	  * @param workerId A workerId dolgozó id-ja
	  */
	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	/**
	 * A dolgozó keresztnevét visszaadó metódus.
	 * @return A dolgozó keresztneve
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	  * A dolgozó keresztnevét beállító metódus.
	  * @param lastName A dolgozó keresztneve
	  */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * A dolgozó vezetéknevét visszaadó metódus.
	 * @return A dolgozó vezetékneve
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	  * A dolgozó vezetéknevét beállító metódus.
	  * @param firstName A dolgozó vezetékneve
	  */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getFirstName()+" "+this.getLastName();
	}
}
