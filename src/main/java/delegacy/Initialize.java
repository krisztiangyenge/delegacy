package delegacy;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import delegacy.dao.impl.WorkerDaoImpl;
import delegacy.dao.impl.AdminDaoImpl;
import delegacy.dao.impl.CarDaoImpl;
import delegacy.model.Admin;
import delegacy.model.Car;
import delegacy.model.Worker;

public class Initialize {
	private static final Logger logger = LoggerFactory.getLogger(Initialize.class);

	public static void initializeCar() {
		Car car = new Car();
		try {
			car.setBrand("Volkswagen");
			car.setCarName("Passat");
			car.setPlateNumber("ABC-123");
			car.setAvailable(true);
			car.setConsumption(10.5);
			
			CarDaoImpl dao = new CarDaoImpl();
			dao.save(car);
		} catch(Exception e){
			logger.error(e.getMessage());
		}
	}
	
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
	
	public static void initializeWorker() {
		Worker worker = new Worker();
		try {
			worker.setFirstName("John");
			worker.setLastName("Snow");
			
			WorkerDaoImpl dao = new WorkerDaoImpl();
			
			dao.save(worker);
		} catch(Exception e){
			logger.error(e.getMessage());
		}
	}
	
	
}
