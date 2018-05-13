package delegacy.service;

import java.util.List;

import delegacy.model.Car;
import delegacy.model.Worker;

public interface CarService {
	
	void save(Car car) throws IllegalArgumentException;
			
	void update(Car car) throws IllegalArgumentException;
	
	void remove(Car car) throws IllegalArgumentException;
	
	List<Car> getAllCars();
	
	List<Car> getAvailableCars();
	
	List<Car> getCarByWorker(Worker worker);
}
