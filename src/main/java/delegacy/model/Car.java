package delegacy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Az autókat reprezentáló osztály.
 * @author Krisztian
 *
 */
@Entity
@XmlRootElement(name="car")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carId;
	
	/**
	 * Az autó id-ját visszaadó metódus.
	 * @return Az autó id-ja
	 */
	public int getCarId() {
		return carId;
	}

	/**
	  * Az autó id-ját beállító metódus.
	  * @param carId Az autó id-ja
	  */
	public void setCarId(int carId) {
		this.carId = carId;
	}

	private String plateNumber;
	
	private String carName;
	
	private String brand;
	
	private double consumption;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="workerId")
	private Worker owner;

	/**
	  * Az autó tulaját beállító metódus.
	  * @param owner Az autó tulaja
	  */
	public void setOwner(Worker owner) {
		this.owner = owner;
	}
	
	/**
	 * Az autó tulaját visszaadó metódus.
	 * @return Az autó tulaja
	 */
	public Worker getOwner() {
		return owner;
	}
	
	/**
	 * Az autó rendszámát visszaadó metódus.
	 * @return Az autó rendszáma
	 */
	public String getPlateNumber() {
		return plateNumber;
	}

	/**
	  * Az autó rendszámát beállító metódus.
	  * @param plateNumber Az autó rendszáma
	  */
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	/**
	 * Az autó tipusát visszaadó metódus.
	 * @return Az autó tipusa
	 */
	public String getCarName() {
		return carName;
	}

	/**
	  * Az autó tipusát beállító metódus.
	  * @param carName Az autó tipusa
	  */
	public void setCarName(String carName) {
		this.carName = carName;
	}

	/**
	 * Az autó márkáját visszaadó metódus.
	 * @return Az autó márkája
	 */
	public String getBrand() {
		return brand;
	}

	/**
	  * Az autó márkáját beállító metódus.
	  * @param brand Az autó márkája
	  */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Az autó fogyasztását visszaadó metódus.
	 * @return Az autó fogasztása
	 */
	public double getConsumption() {
		return consumption;
	}
	
	/**
	  * Az autó fogyasztását beállító metódus.
	  * @param consumption Az autó fogyasztása
	  */
	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.brand + " " + this.carName + " (" + this.plateNumber + ")";
	}
	
}
