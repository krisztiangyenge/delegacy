package delegacy.service.impl;

import java.util.List;

import delegacy.dao.impl.DelegacyDaoImpl;
import delegacy.model.Delegacy;
import delegacy.service.DelegacyService;

/**
 * Az {@link delegacy.service.DelegacyService} interfészt implementáló osztály.
 * @author Krisztian
 *
 */
public class DelegacyServiceImpl implements DelegacyService {
	private static final DelegacyDaoImpl delegacyDao = new DelegacyDaoImpl();
	
	/* (non-Javadoc)
	 * @see delegacy.service.DelegacyrService#save(delegacy.model.Delegacy)
	 */
	@Override
	public void save(Delegacy delegacy) throws IllegalArgumentException{
		delegacyDao.save(delegacy);
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.DelegacyrService#update(delegacy.model.Delegacy)
	 */
	@Override
	public void update(Delegacy delegacy) throws IllegalArgumentException{
		delegacyDao.update(delegacy);
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.DelegacyrService#remove(delegacy.model.Delegacy)
	 */
	@Override
	public void remove(Delegacy delegacy) throws IllegalArgumentException{
		delegacyDao.remove(delegacy);
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.DelegacyrService#getAllDelegacy(delegacy.model.Delegacy)
	 */
	@Override
	public List<Delegacy> getAllDelegacy(){
		return delegacyDao.getAllDelegacy();
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.DelegacyrService#getPay(delegacy.model.Delegacy)
	 */
	@Override
	public Double getPay(Double distance, Double consumption, Double FuelPrice) {
		
		double pay = (distance/100) * consumption * FuelPrice;
		
		return pay;
	}
}
