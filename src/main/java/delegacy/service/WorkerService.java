package delegacy.service;

import java.util.List;

import delegacy.model.Worker;

public interface WorkerService {
	void save(Worker worker) throws IllegalArgumentException;
	
	void update(Worker worker) throws IllegalArgumentException;
	
	void remove(Worker worker) throws IllegalArgumentException;
	
	List<Worker> getAllWorker();
}
