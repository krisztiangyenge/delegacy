package delegacy.service.impl;

import java.util.List;

import delegacy.dao.impl.DelegacyDaoImpl;
import delegacy.model.Delegacy;
import delegacy.service.DelegacyService;

public class DelegacyServiceImpl implements DelegacyService {
	private static final DelegacyDaoImpl delegacyDao = new DelegacyDaoImpl();
	
	public void save(Delegacy delegacy) throws IllegalArgumentException{
		delegacyDao.save(delegacy);
	}
	
	public void update(Delegacy delegacy) throws IllegalArgumentException{
		delegacyDao.update(delegacy);
	}
	
	public void remove(Delegacy delegacy) throws IllegalArgumentException{
		delegacyDao.remove(delegacy);
	}
	
	public List<Delegacy> getAllDelegacy(){
		return delegacyDao.getAllDelegacy();
	}
}
