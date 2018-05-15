package delegacy.service.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import delegacy.dao.impl.WorkerDaoImpl;
import delegacy.datasource.ConnectionHandler;
import delegacy.model.Worker;

public class WorkerServiceTest {
	
	private WorkerServiceImpl workerService;
	
	private WorkerDaoImpl workerDao;
	
	@Before
	public void setUp() {
		workerService = new WorkerServiceImpl();
		
		workerDao = Mockito.mock(WorkerDaoImpl.class);
	
		Worker worker = new Worker("Sheldon", "Cooper");
		
		Mockito.when(workerDao.get(1)).thenReturn(worker);
	}
	
	@Test
	public void testValidation() {
		Assert.assertTrue(workerService.validate(workerDao.get(1)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void firstNameError() {
		workerService.validate(new Worker("", "Géza"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void lastNameError() {
		workerService.validate(new Worker("Nagy", ""));
	}
	
	@After
	public void closeConnection(){
		ConnectionHandler.closeConnection();
	}

}
