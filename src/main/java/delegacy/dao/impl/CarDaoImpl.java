package delegacy.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import delegacy.dao.CarDao;
import delegacy.datasource.ConnectionHandler;
import delegacy.model.Car;
import delegacy.model.Worker;

/**
 * A CarDao interfészt implementáló osztály.
 * @author Krisztian
 *
 */
public class CarDaoImpl implements CarDao {
	
	private EntityManagerFactory emf = ConnectionHandler.getEntityManagerFactory();
	
	private Logger logger = LoggerFactory.getLogger(CarDaoImpl.class);

	/* (non-Javadoc)
	 * @see delegacy.dao.CarDao#save(delegacy.model.Car)
	 */
	@Override
	public void save(Car car){
		EntityManager em = emf.createEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(car);
			em.getTransaction().commit();
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			em.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see delegacy.dao.CarDao#update(delegacy.model.Car)
	 */
	@Override
	public void update(Car car){
		EntityManager em = emf.createEntityManager();
		try{
			em.getTransaction().begin();
			em.merge(car);
			em.getTransaction().commit();
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			em.close();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see delegacy.dao.CarDao#remove(delegacy.model.Car)
	 */
	@Override
	public void remove(Car car){
		EntityManager em = emf.createEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(car);
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
	public Car get(int id) {
		EntityManager em = emf.createEntityManager();
		Car car = null;
		try{
			car = em.find(Car.class, id);
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			em.close();
		}
		return car;
	}
	
	/* (non-Javadoc)
	 * @see delegacy.dao.CarDao#getCars(delegacy.model.Car)
	 */
	@Override
	public List<Car> getCars(){
		EntityManager em = emf.createEntityManager();
		List<Car> carList =null;
		try {
			carList = em.createQuery("SELECT c FROM Car c", Car.class).getResultList();
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			em.close();
		}
		
		return carList;
	}
	
	/* (non-Javadoc)
	 * @see delegacy.dao.CarDao#getCarByWorker(delegacy.model.Car)
	 */
	@Override
	public List<Car>getCarByWorker(Worker worker){
		EntityManager em = emf.createEntityManager();
		List<Car> carList =null;
		try {
			TypedQuery<Car> query = em.createQuery("SELECT c FROM Car c WHERE c.owner.workerId = :owner", Car.class);
			carList = query.setParameter("owner", worker.getWorkerId()).getResultList();
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			em.close();
		}
		return carList;
	}
}
