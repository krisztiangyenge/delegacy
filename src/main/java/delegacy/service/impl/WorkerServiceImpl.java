package delegacy.service.impl;

import java.util.List;

import delegacy.dao.impl.WorkerDaoImpl;
import delegacy.model.Worker;
import delegacy.service.WorkerService;

public class WorkerServiceImpl implements WorkerService {
	private static final WorkerDaoImpl workerDao = new WorkerDaoImpl();
	
	public void save(Worker worker) throws IllegalArgumentException{
		workerDao.save(worker);
	}
	
	public void update(Worker worker) throws IllegalArgumentException{
		workerDao.update(worker);
	}
	
	public void remove(Worker worker) throws IllegalArgumentException{
		workerDao.remove(worker);
	}
	
	public List<Worker> getAllWorker(){
		return workerDao.getAllWorker();
	}
}
