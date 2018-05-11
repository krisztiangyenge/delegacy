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
@Entity
@XmlRootElement(name="delegacy")
public class Delegacy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int delegacyId;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="workerId")
	private Worker worker;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="carId")
	private Car car;
	
	private Date delegacyDate;
	
	private String carBrandName;
	
	private String workerFullName;
	
	private String startAddress;
	
	private String endAddress;
	
	private Double distance;
	
	@XmlAttribute
	public int getDelegacyId() {
		return delegacyId;
	}
	
	public String getCarBrandName() {
		return carBrandName;
	}
	
	public void setCarBrandName(String brand, String carName) {
		this.carBrandName = brand +" "+ carName;
	}
	
	public String getWorkerFullName() {
		return workerFullName;
	}
	
	public void setworkerFullName(String firstName, String lastName) {
		this.workerFullName = firstName +" "+ lastName;
	}

	public void setDelegacyId(int delegacyId) {
		this.delegacyId = delegacyId;
	}

	public Worker getWorkerId() {
		return worker;
	}

	public void setWorkerId(Worker worker) {
		this.worker = worker;
	}

	public Car getCarId() {
		return car;
	}

	public void setCarId(Car carId) {
		this.car = carId;
	}

	public Date getDelegacyDate() {
		return delegacyDate;
	}

	public void setDelegacyDate(Date delegacyDate) {
		this.delegacyDate = delegacyDate;
	}

	public String getStartAddress() {
		return startAddress;
	}

	public void setStartAddress(String startAddress) {
		this.startAddress = startAddress;
	}

	public String getEndAddress() {
		return endAddress;
	}

	public void setEndAddress(String endAddress) {
		this.endAddress = endAddress;
	}
	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public String toString() {
		return worker.getFirstName() + " " + worker.getLastName() + " " + car.getBrand() + " " + car.getCarName();
	}
	
}
