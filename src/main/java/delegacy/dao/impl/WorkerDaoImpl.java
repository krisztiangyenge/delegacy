package delegacy.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import delegacy.dao.WorkerDao;
import delegacy.datasource.ConnectionHandler;
import delegacy.model.Worker;

public class WorkerDaoImpl implements WorkerDao {
	private EntityManagerFactory emf = ConnectionHandler.getEntityManagerFactory();
	
	private Logger logger = LoggerFactory.getLogger(WorkerDaoImpl.class);

	public void save(Worker worker){
		EntityManager em = emf.createEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(worker);
			em.getTransaction().commit();
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			em.close();
		}
	}
	
	public void update(Worker worker){
		EntityManager em = emf.createEntityManager();
		try{
			em.getTransaction().begin();
			em.merge(worker);
			em.getTransaction().commit();
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			em.close();
		}
		
	}
	
	public void remove(Worker worker){
		EntityManager em = emf.createEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(worker);
			em.getTransaction().commit();
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			em.close();
		}
	}
	
	public List<Worker> getAllWorker(){
		EntityManager em = emf.createEntityManager();
		
		List<Worker> workerList =null;
		try {
			workerList = em.createQuery("SELECT w FROM Worker w", Worker.class).getResultList();
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			em.close();
		}
		
		return workerList;
	}
	
	public Worker getWorker(int id) {
		EntityManager em = emf.createEntityManager();
		Worker worker = null;
		try {
			worker = em.find(Worker.class, id);
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally {
			em.close();
		}
		return worker;
	}
}
