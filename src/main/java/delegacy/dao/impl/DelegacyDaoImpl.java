package delegacy.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import delegacy.dao.DelegacyDao;
import delegacy.datasource.ConnectionHandler;
import delegacy.model.Delegacy;

/**
 * A DelegacyDao interfészt implementáló osztály.
 * @author Krisztian
 *
 */
public class DelegacyDaoImpl implements DelegacyDao {
	private EntityManagerFactory emf = ConnectionHandler.getEntityManagerFactory();
	
	private Logger logger = LoggerFactory.getLogger(DelegacyDaoImpl.class);

	/* (non-Javadoc)
	 * @see delegacy.dao.DelegacyDao#save(delegacy.model.Delegacy)
	 */
	@Override
	public void save(Delegacy delegacy){
		EntityManager em = emf.createEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(delegacy);
			em.getTransaction().commit();
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			em.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see delegacy.dao.DelegacyDao#update(delegacy.model.Delegacy)
	 */
	@Override
	public void update(Delegacy delegacy){
		EntityManager em = emf.createEntityManager();
		try{
			em.getTransaction().begin();
			em.merge(delegacy);
			em.getTransaction().commit();
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			em.close();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see delegacy.dao.DelegacyDao#remove(delegacy.model.Delegacy)
	 */
	@Override
	public void remove(Delegacy delegacy){
		EntityManager em = emf.createEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(delegacy);
			em.getTransaction().commit();
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			em.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see delegacy.dao.DelegacyDao#getAllDelegacy(delegacy.model.Delegacy)
	 */
	@Override
	public List<Delegacy> getAllDelegacy(){
		EntityManager em = emf.createEntityManager();
		
		List<Delegacy> delegacyList =null;
		try {
			delegacyList = em.createQuery("SELECT d FROM Delegacy d", Delegacy.class).getResultList();
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			em.close();
		}
		
		return delegacyList;
	}
}
