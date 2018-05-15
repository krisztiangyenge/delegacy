package delegacy.service.impl;

import java.util.List;

import delegacy.dao.impl.CarDaoImpl;
import delegacy.model.Car;
import delegacy.model.Worker;
import delegacy.service.CarService;

/**
 * Az {@link delegacy.service.CarService} interfészt implementáló osztály.
 * @author Krisztian
 *
 */
public class CarServiceImpl implements CarService {
	
	private static final CarDaoImpl carDao = new CarDaoImpl();
	
	/* (non-Javadoc)
	 * @see delegacy.service.CarService#save(delegacy.model.Car)
	 */
	@Override
	public void save(Car car) throws IllegalArgumentException{
		if(this.validate(car)) {
			carDao.save(car);
		}
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.CarService#update(delegacy.model.Car)
	 */
	@Override
	public void update(Car car) throws IllegalArgumentException{
		if(this.validate(car)) {
			carDao.update(car);
		}
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.CarService#remove(delegacy.model.Car)
	 */
	@Override
	public void remove(Car car) throws IllegalArgumentException{
		carDao.remove(car);
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.CarService#get(delegacy.model.Car)
	 */
	@Override
	public Car get(int id) {
		return carDao.get(id);
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.CarService#getAllCars(delegacy.model.Car)
	 */
	@Override
	public List<Car> getAllCars() {
		return carDao.getCars();
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.CarService#getCarByWorker(delegacy.model.Car)
	 */
	@Override
	public List<Car> getCarByWorker(Worker worker){
		
		return carDao.getCarByWorker(worker);
		
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.CarService#validate(delegacy.model.Car)
	 */
	@Override
	public boolean validate(Car car){
		if(car.getBrand() == null || car.getBrand().trim().isEmpty()) {
			throw new IllegalArgumentException("Nem adott meg márkát.");
		}
		
		if(car.getPlateNumber() == null || car.getPlateNumber().trim().isEmpty()) {
			throw new IllegalArgumentException("Nem adott meg rendszámot.");
		}
		
		if(car.getCarName() == null || car.getCarName().trim().isEmpty()) {
			throw new IllegalArgumentException("Nem adott meg tipust.");
		}
		
		if(car.getConsumption() < 0 || car.getConsumption() == 0) {
			throw new IllegalArgumentException("Nem adott meg fogyasztást.");
		}
		
		if(car.getOwner() == null) {
			throw new IllegalArgumentException("Nem adott meg tulajt.");
		}
		
		return true;
	}
	
}
