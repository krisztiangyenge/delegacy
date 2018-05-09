package delegacy.dao;

import java.util.List;

import delegacy.model.Worker;

public interface WorkerDao {
	
	void save(Worker worker);
	
	void update(Worker worker);
	
	void remove (Worker worker);
	
	List<Worker> getAllWorker();
	
	Worker getWorker(int id);
}
