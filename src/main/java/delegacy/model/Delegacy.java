package delegacy.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Az kiküldetésket reprezentáló osztály.
 * @author Krisztian
 *
 */
@Entity
@XmlRootElement(name="delegacy")
public class Delegacy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int delegacyId;
	
	/**
	 * Az osztály lonstruktora.
	 * @param startAddress Indulási cím
	 * @param endAddress Érkezési cím
	 * @param distance távolság
	 * @param fuelPrice benzin ár
	 */
	public Delegacy(String startAddress, String endAddress, Double distance, Double fuelPrice) {
		super();
		this.startAddress = startAddress;
		this.endAddress = endAddress;
		this.distance = distance;
		this.fuelPrice = fuelPrice;
	}

	/**
	 * Az osztály paraméter nélküli konstruktora.
	 */
	public Delegacy() {
	}


	@ManyToOne
	@JoinColumn(referencedColumnName="workerId")
	private Worker worker;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="carId")
	private Car car;
	
	private String startAddress;
	
	private String endAddress;
	
	private Double distance;
	
	private Double pay;
	
	private Double fuelPrice;
	
	/**
	 * Az benzinárat visszaadó metódus.
	 * @return Az benzin ára
	 */
	public Double getFuelPrice() {
		return fuelPrice;
	}
	
	/**
	  * A benzinárat beállító metódus.
	  * @param fuelPrice A benzin ára
	  */
	public void setFuelPrice(double fuelPrice) {
		this.fuelPrice = fuelPrice;
	}
	
	/**
	 * Az kifizetendő összeget visszaadó metódus.
	 * @return Az kifizetendő összeg
	 */
	public Double getPay() {
		return pay;
	}
	
	/**
	  * A kifizetendő összeget beállító metódus.
	  * @param pay A kifizetendő összeg
	  */
	public void setPay(Double pay) {
		this.pay = pay;
	}
	
	/**
	 * A kiküldetés id-ját visszaadó metódus.
	 * @return A kiküldetés id-ja
	 */
	@XmlAttribute
	public int getDelegacyId() {
		return delegacyId;
	}

	/**
	  * A kiküldetés id-ját beállító metódus.
	  * @param delegacyId A kiküldetés id-ja
	  */
	public void setDelegacyId(int delegacyId) {
		this.delegacyId = delegacyId;
	}

	/**
	 * A dolgozót visszaadó metódus.
	 * @return A dolgozó
	 */
	public Worker getWorkerId() {
		return worker;
	}

	/**
	  * A dolgozót beállító metódus.
	  * @param worker A dolgozó
	  */
	public void setWorkerId(Worker worker) {
		this.worker = worker;
	}

	/**
	 * Az autót visszaadó metódus.
	 * @return Az autó
	 */
	public Car getCarId() {
		return car;
	}

	/**
	  * Az autót beállító metódus.
	  * @param carId Az autó
	  */
	public void setCarId(Car carId) {
		this.car = carId;
	}

	/**
	 * Az induló címet visszaadó metódus.
	 * @return Az induló cím
	 */
	public String getStartAddress() {
		return startAddress;
	}

	/**
	  * Az induló címet beállító metódus.
	  * @param startAddress Az induló cím
	  */
	public void setStartAddress(String startAddress) {
		this.startAddress = startAddress;
	}

	/**
	 * A cél cím visszaadó metódus.
	 * @return A cél cím
	 */
	public String getEndAddress() {
		return endAddress;
	}

	/**
	  * A cél címet beállító metódus.
	  * @param endAddress A cél cím
	  */
	public void setEndAddress(String endAddress) {
		this.endAddress = endAddress;
	}
	
	/**
	 * A távolságot visszaadó metódus.
	 * @return A távolság
	 */
	public double getDistance() {
		return distance;
	}

	/**
	  * A távolságot beállító metódus.
	  * @param distance A távolság
	  */
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return worker.getFirstName() + " " + worker.getLastName() + " " + car.getBrand() + " " + car.getCarName();
	}
	
}
