package delegacy.dao;

import java.util.List;

import delegacy.model.Car;

public interface CarDao {
	
	void save(Car car);
	
	void update(Car car);
	
	void remove (Car car);
	
	List<Car> getCars();
	
	List<Car> getActiveCars();
	
}
