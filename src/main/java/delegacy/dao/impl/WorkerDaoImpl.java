package delegacy.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import delegacy.dao.WorkerDao;
import delegacy.datasource.ConnectionHandler;
import delegacy.model.Car;
import delegacy.model.Worker;

/**
 * A WorkerDao interfészt implementáló osztály.
 * @author Krisztian
 *
 */
public class WorkerDaoImpl implements WorkerDao {
	private EntityManagerFactory emf = ConnectionHandler.getEntityManagerFactory();
	
	private Logger logger = LoggerFactory.getLogger(WorkerDaoImpl.class);

	/* (non-Javadoc)
	 * @see delegacy.dao.WorkerDao#save(delegacy.model.Worker)
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see delegacy.dao.WorkerDao#update(delegacy.model.Worker)
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see delegacy.dao.WorkerDao#remove(delegacy.model.Worker)
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see storage.dao.ProductDao#get(int)
	 */
	@Override
	public Worker get(int id) {
		EntityManager em = emf.createEntityManager();
		Worker worker = null;
		try{
			worker = em.find(Worker.class, id);
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			em.close();
		}
		return worker;
	}
	
	/* (non-Javadoc)
	 * @see delegacy.dao.WorkerDao#getAllWorker(delegacy.model.Worker)
	 */
	@Override
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
}
