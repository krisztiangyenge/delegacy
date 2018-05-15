package delegacy.service.impl;

import java.util.List;

import delegacy.dao.impl.WorkerDaoImpl;
import delegacy.model.Car;
import delegacy.model.Delegacy;
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
		if(this.validate(worker)) {
			workerDao.save(worker);
		}
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.WorkerService#update(delegacy.model.Worker)
	 */
	@Override
	public void update(Worker worker) throws IllegalArgumentException{
		if(this.validate(worker)) {
			workerDao.update(worker);
		}
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.WorkerService#remove(delegacy.model.Worker)
	 */
	@Override
	public void remove(Worker worker) throws IllegalArgumentException{
		workerDao.remove(worker);
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.WorkerService#get(delegacy.model.Worker)
	 */
	@Override
	public Worker get(int id) {
		return workerDao.get(id);
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.WorkerService#getAllWorker(delegacy.model.Worker)
	 */
	@Override
	public List<Worker> getAllWorker(){
		return workerDao.getAllWorker();
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.WorkerService#validate(delegacy.model.Delegacy)
	 */
	@Override
	public boolean validate(Worker worker){
		if(worker.getFirstName() == null || worker.getFirstName().trim().isEmpty()) {
			throw new IllegalArgumentException("Nem adott meg vezeték nevet.");
		}
		
		if(worker.getLastName() == null || worker.getLastName().trim().isEmpty()) {
			throw new IllegalArgumentException("Nem adott meg kereszt nevet.");
		}
		
		return true;
	}
}
