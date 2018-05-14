package delegacy.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import delegacy.dao.AdminDao;
import delegacy.datasource.ConnectionHandler;
import delegacy.model.Admin;

/**
 * A {@link delegacy.dao.AdminDao} intérfészt implementáló osztály.
 * @author Krisztian
 *
 */
public class AdminDaoImpl implements AdminDao{
	
	private EntityManagerFactory emf = ConnectionHandler.getEntityManagerFactory();
	
	private Logger logger = LoggerFactory.getLogger(AdminDaoImpl.class);

	/* (non-Javadoc)
	 * @see delegacy.dao.AdminDao#save(delegacy.model.Admin)
	 */
	@Override
	public void save(Admin admin){
		EntityManager em = emf.createEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(admin);
			em.getTransaction().commit();
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			em.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see delegacy.dao.AdminDao#Login(delegacy.model.Admin)
	 */
	@Override
	public Admin Login(String name, String password) throws Exception {
		EntityManager em = emf.createEntityManager();
		Admin admin = null;
		try{
			admin = em.createQuery("SELECT a FROM Admin a WHERE a.name = :Name and a.password = :Pass", Admin.class)
						.setParameter("Name", name)
						.setParameter("Pass", DigestUtils.sha1Hex(password))
						.getSingleResult();
		}catch(NoResultException ex){
			throw new Exception("Hibás adat");
		}finally {
			em.close();
		}
		
		return admin;
	}
}
