package delegacy.service.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import delegacy.dao.impl.CarDaoImpl;
import delegacy.dao.impl.DelegacyDaoImpl;
import delegacy.datasource.ConnectionHandler;
import delegacy.model.Car;
import delegacy.model.Delegacy;
import delegacy.model.Worker;

public class DelegacyServiceTest {
	
	private DelegacyServiceImpl delegacyService;
	
	private DelegacyDaoImpl delegacyDao;
	
	@Before
	public void settins() {
		delegacyService = new DelegacyServiceImpl();
		
		delegacyDao = Mockito.mock(DelegacyDaoImpl.class);
	
		Delegacy delegacy = new Delegacy("start", "end", 100.0, 300.0);
		Worker worker = new Worker("Nagy", "Sándor");
		Car car = new Car("rendszám", "tipus", "márka", 10);
		car.setOwner(worker);
		delegacy.setWorkerId(worker);
		delegacy.setCarId(car);
		
		double pay = delegacyService.getPay(delegacy.getDistance(), car.getConsumption(), delegacy.getFuelPrice());
		
		delegacy.setPay(pay);
		
		Mockito.when(delegacyDao.get(1)).thenReturn(delegacy);
	}
	
	@Test
	public void testValidation() {
		Assert.assertTrue(delegacyService.validate(delegacyDao.get(1)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void startError() {
		delegacyService.validate(new Delegacy("", "end", 10.0, 8.0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void endError() {
		delegacyService.validate(new Delegacy("start", "", 10.0, 8.0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void brandError() {
		delegacyService.validate(new Delegacy("start", "end", 0.0, 8.0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void consumptiondError() {
		delegacyService.validate(new Delegacy("start", "end", 10.0, 0.0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void payDistance() {
		delegacyService.validatePay(-10.0, 10.0, 10.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void payConsumption() {
		delegacyService.validatePay(10.0, -10.0, 10.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void payFuelPrice() {
		delegacyService.validatePay(10.0, 10.0, -10.0);
	}
	
	@After
	public void closeConnection(){
		ConnectionHandler.closeConnection();
	}
}
