package delegacy.service;

import java.util.List;

import delegacy.model.Delegacy;

public interface DelegacyService {
	void save(Delegacy delegacy) throws IllegalArgumentException;
	
	void update(Delegacy delegacy) throws IllegalArgumentException;
	
	void remove(Delegacy delegacy) throws IllegalArgumentException;
	
	List<Delegacy> getAllDelegacy();
}
