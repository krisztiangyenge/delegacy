package delegacy;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import delegacy.dao.impl.AdminDaoImpl;
import delegacy.model.Admin;
import delegacy.model.Car;
import delegacy.model.Delegacy;
import delegacy.model.Worker;
import delegacy.service.impl.CarServiceImpl;
import delegacy.service.impl.DelegacyServiceImpl;
import delegacy.service.impl.WorkerServiceImpl;

/**
 * Az alkalmazást inicializáló osztály.
 * @author Krisztian
 *
 */
public class Initialize {
	private static final Logger logger = LoggerFactory.getLogger(Initialize.class);

	/**
	 * Feltöltjük az adatbázist kezdő értékekkel.
	 */
	public static void initializeWorker() {
		Worker worker = new Worker();
		try {
			worker.setFirstName("John");
			worker.setLastName("Snow");
			worker.setTraveled(500);
			
			WorkerServiceImpl ws = new WorkerServiceImpl();
			
			ws.save(worker);
		} catch(Exception e){
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * Feltöltjük az adatbázist kezdő értékekkel.
	 */
	public static void initializeCar() {
		Car car = new Car();
		try {
			car.setBrand("Volkswagen");
			car.setCarName("Passat");
			car.setPlateNumber("ABC-123");
			car.setConsumption(10.5);
			
			WorkerServiceImpl ws = new WorkerServiceImpl();
			List<Worker> wl = ws.getAllWorker();
			
			car.setOwner(wl.get(0));
			
			CarServiceImpl cs = new CarServiceImpl();
			cs.save(car);
		} catch(Exception e){
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * Feltöltjük az adatbázist kezdő értékekkel.
	 */
	public static void initializeAdmin() {
		Admin admin = new Admin();
		try {
			admin.setName("admin");
			admin.setPassword(DigestUtils.sha1Hex("admin"));
			
			AdminDaoImpl dao = new AdminDaoImpl();
			dao.save(admin);
		
		} catch(Exception e){
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * Feltöltjük az adatbázist kezdő értékekkel.
	 */
	public static void InitializeDelegacy() {
		Delegacy delegacy = new Delegacy();
		CarServiceImpl cs = new CarServiceImpl();
		WorkerServiceImpl us = new WorkerServiceImpl();
		
		List<Car> cl = cs.getAllCars();
		List<Worker> wl = us.getAllWorker();
		try {
			delegacy.setCarId(cl.get(0));
			delegacy.setWorkerId(wl.get(0));
			delegacy.setStartAddress("Debrecen");
			delegacy.setEndAddress("Sopron");
			delegacy.setDistance(500);
			delegacy.setFuelPrice(350);
			delegacy.setPay(18375.0);
			DelegacyServiceImpl ds = new DelegacyServiceImpl();
			ds.save(delegacy);
		} catch(Exception e){
			logger.error(e.getMessage());
		}

	}
	
	
}
