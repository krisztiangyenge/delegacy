package delegacy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement(name="car")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carId;
	
	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	private String plateNumber;
	
	private String carName;
	
	private String brand;
	
	private double consumption;
	
	private Boolean available;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="workerId")
	private Worker owner;

	public void setOwner(Worker owner) {
		this.owner = owner;
	}
	
	public Worker getOwner() {
		return owner;
	}
	
	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Boolean isAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	public double getConsumption() {
		return consumption;
	}
	
	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}
	
	@Override
	public String toString() {
		return this.brand + " " + this.carName + " (" + this.plateNumber + ")";
	}
	
}
