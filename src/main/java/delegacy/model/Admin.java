package delegacy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Az adminokat reprezentáló osztály.
 * @author Krisztian
 *
 */
@Entity
@XmlRootElement(name="admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String password;
	
	/**
	 * Az admin id-ját visszaadó metódus.
	 * @return Az admin id-ja
	 */
	@XmlAttribute
	public int getId() {
		return id;
	}
	
	/**
	 * Az admin nevét visszaadó metódus.
	 * @return Az admin neve
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Az admin jelszavát visszaadó metódus.
	 * @return az admi jelszava
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Az admin id-ját beállító metódus.
	 * @param id az admin id-ja
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Az admin nevét beállító metódus.
	 * @param name az admin neve
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Az admin jelszavát beállító metódus.
	 * @param password az admin jelszava
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
