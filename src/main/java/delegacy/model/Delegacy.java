package delegacy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement(name="delegacy")
public class Delegacy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int delegacyId;
	
	private int workerId;
	
	private String carId;
	
	private Date delegacyDate;
	
	private String startAddress;
	
	private String endAddress;
	
	private Double distance;
	
	@XmlAttribute
	public int getDelegacyId() {
		return delegacyId;
	}

	public void setDelegacyId(int delegacyId) {
		this.delegacyId = delegacyId;
	}

	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
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
	
	
}
