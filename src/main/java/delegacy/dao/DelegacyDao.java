package delegacy.dao;

import java.util.List;

import delegacy.model.Delegacy;

public interface DelegacyDao {

	void save(Delegacy delegacy);
	
	void update(Delegacy delegacy);
	
	void remove (Delegacy delegacy);
	
	List<Delegacy> getAllDelegacy();
	
}
