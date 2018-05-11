package delegacy;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import delegacy.dao.impl.WorkerDaoImpl;
import delegacy.dao.impl.AdminDaoImpl;
import delegacy.dao.impl.CarDaoImpl;
import delegacy.model.Admin;
import delegacy.model.Car;
import delegacy.model.Delegacy;
import delegacy.model.Worker;
import delegacy.service.impl.CarServiceImpl;
import delegacy.service.impl.DelegacyServiceImpl;
import delegacy.service.impl.WorkerServiceImpl;


public class Initialize {
	private static final Logger logger = LoggerFactory.getLogger(Initialize.class);

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
	
	public static void InitializeDelegacy() {
		Delegacy delegacy = new Delegacy();
		CarServiceImpl cs = new CarServiceImpl();
		WorkerServiceImpl us = new WorkerServiceImpl();
		
		List<Car> cl = cs.getAllCars();
		List<Worker> wl = us.getAllWorker();
		
		delegacy.setCarId(cl.get(0));
		delegacy.setWorkerId(wl.get(0));
		delegacy.setStartAddress("Debrecen");
		delegacy.setEndAddress("Sopron");
		delegacy.setDistance(350);
		delegacy.setCarBrandName(cl.get(0).getBrand(), cl.get(0).getCarName());
		delegacy.setworkerFullName(wl.get(0).getFirstName(), wl.get(0).getLastName());
		
		DelegacyServiceImpl ds = new DelegacyServiceImpl();
		ds.save(delegacy);

	}
	
	
}
