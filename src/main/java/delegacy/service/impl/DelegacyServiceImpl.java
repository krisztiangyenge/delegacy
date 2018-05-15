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
		if(this.validate(delegacy)) {
			delegacyDao.save(delegacy);
		}
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.DelegacyrService#update(delegacy.model.Delegacy)
	 */
	@Override
	public void update(Delegacy delegacy) throws IllegalArgumentException{
		if(this.validate(delegacy)) {
			delegacyDao.update(delegacy);
		}
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.DelegacyrService#remove(delegacy.model.Delegacy)
	 */
	@Override
	public void remove(Delegacy delegacy) throws IllegalArgumentException{
		delegacyDao.remove(delegacy);
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.CarService#get(delegacy.model.Delegacy)
	 */
	@Override
	public Delegacy get(int id) {
		return delegacyDao.get(id);
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
		if(this.validatePay(distance, consumption, FuelPrice)) {
			double pay = (distance/100) * consumption * FuelPrice;
			
			return pay;
		}
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.DelegacyService#validate(delegacy.model.Delegacy)
	 */
	@Override
	public boolean validate(Delegacy delegacy){
		if(delegacy.getStartAddress() == null || delegacy.getStartAddress().trim().isEmpty()) {
			throw new IllegalArgumentException("Nem adott meg induló címet.");
		}
		
		if(delegacy.getEndAddress() == null || delegacy.getEndAddress().trim().isEmpty()) {
			throw new IllegalArgumentException("Nem adott meg vég címet.");
		}
		
		if(delegacy.getDistance() < 0 || delegacy.getDistance() == 0) {
			throw new IllegalArgumentException("Nem adott meg érvényes távolságot.");
		}
		
		if(delegacy.getFuelPrice() < 0 || delegacy.getFuelPrice() == 0) {
			throw new IllegalArgumentException("Nem adott meg érvényes benzin árat.");
		}
		
		if(delegacy.getWorkerId() == null) {
			throw new IllegalArgumentException("Nem adott meg dolgozót.");
		}
		
		if(delegacy.getCarId() == null) {
			throw new IllegalArgumentException("Nem adott meg autót.");
		}
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see delegacy.service.DelegacyService#validate(delegacy.model.Delegacy)
	 */
	@Override
	public boolean validatePay(Double distance, Double consumption, Double FuelPrice) {
		if(distance < 0 || consumption < 0 || FuelPrice < 0) {
			throw new IllegalArgumentException("Nem megfelelő adatok a számításhoz.");
		}
		
		return true;
	}
}
