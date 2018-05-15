package delegacy.service.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import delegacy.dao.impl.CarDaoImpl;
import delegacy.datasource.ConnectionHandler;
import delegacy.model.Car;
import delegacy.model.Worker;

public class CarServiceTest {
	
	private CarServiceImpl carService;
	
	private CarDaoImpl carDao;
	
	@Before
	public void settins() {
		carService = new CarServiceImpl();
		
		carDao = Mockito.mock(CarDaoImpl.class);
	
		Car car = new Car("aaa-11", "cbr", "honda", 10);
		Worker worker = new Worker("Nagy", "Sándor");
		car.setOwner(worker);
		
		Mockito.when(carDao.get(1)).thenReturn(car);
	}
	
	@Test
	public void testValidation() {
		Assert.assertTrue(carService.validate(carDao.get(1)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void plateNumberError() {
		carService.validate(new Car("", "tipus", "márka", 8));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nameError() {
		carService.validate(new Car("rendszám", "", "márka", 6));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void brandError() {
		carService.validate(new Car("rendszám", "tipus", "", 6));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void consumptiondError() {
		carService.validate(new Car("rendszám", "tipus", "márka", 0));
	}
	
	@After
	public void closeConnection(){
		ConnectionHandler.closeConnection();
	}
}
