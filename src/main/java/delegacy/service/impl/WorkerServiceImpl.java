package delegacy.service.impl;

import java.util.List;

import delegacy.dao.impl.WorkerDaoImpl;
import delegacy.model.Worker;
import delegacy.service.WorkerService;

/**
 * Az {@link delegacy.service.WorkerService} interfészt implementáló osztály.
 * @author Krisztian
 *
 */
public class WorkerServiceImpl implements WorkerService {
	private static final WorkerDaoImpl workerDao = new WorkerDaoImpl();
	
	/* (non-Javadoc)
	 * @see delegacy.service.WorkerService#save(delegacy.model.Worker)
	 */
	@Override
	public void save(Worker worker) throws IllegalArgumentException{
		workerDao.save(worker);
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.WorkerService#update(delegacy.model.Worker)
	 */
	@Override
	public void update(Worker worker) throws IllegalArgumentException{
		workerDao.update(worker);
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.WorkerService#remove(delegacy.model.Worker)
	 */
	@Override
	public void remove(Worker worker) throws IllegalArgumentException{
		workerDao.remove(worker);
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.WorkerService#getAllWorker(delegacy.model.Worker)
	 */
	@Override
	public List<Worker> getAllWorker(){
		return workerDao.getAllWorker();
	}
}
