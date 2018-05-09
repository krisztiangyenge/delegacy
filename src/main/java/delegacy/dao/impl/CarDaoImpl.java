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

public class CarDaoImpl implements CarDao {
	
	private EntityManagerFactory emf = ConnectionHandler.getEntityManagerFactory();
	
	private Logger logger = LoggerFactory.getLogger(CarDaoImpl.class);

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
	
	public List<Car> getActiveCars(){
		EntityManager em = emf.createEntityManager();
		List<Car> carList =null;
		try {
			TypedQuery<Car> query = em.createQuery("SELECT c FROM Car c WHERE c.available = :available", Car.class);
			carList = query.setParameter("available", true).getResultList();
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			em.close();
		}
		
		return carList;
	}
	
	
}
