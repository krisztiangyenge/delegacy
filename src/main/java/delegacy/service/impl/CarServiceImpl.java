package delegacy.service.impl;

import java.util.List;

import delegacy.dao.impl.CarDaoImpl;
import delegacy.model.Car;
import delegacy.model.Worker;
import delegacy.service.CarService;

public class CarServiceImpl implements CarService {
	
	private static final CarDaoImpl carDao = new CarDaoImpl();
	
	public void save(Car car) throws IllegalArgumentException{
		carDao.save(car);
	}
	
	public void update(Car car) throws IllegalArgumentException{
		carDao.update(car);
	}
	
	public void remove(Car car) throws IllegalArgumentException{
		carDao.remove(car);
	}
	
	public List<Car> getAllCars() {
		return carDao.getCars();
	}
	
	public List<Car> getAvailableCars() {
		return carDao.getActiveCars();
	}
	
	public List<Car> getCarByWorker(Worker worker){
		
		return carDao.getCarByWorker(worker);
		
	}
	
}
