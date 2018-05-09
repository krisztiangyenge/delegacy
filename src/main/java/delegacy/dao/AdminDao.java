package delegacy.dao;

import delegacy.model.Admin;

public interface AdminDao {

	void save(Admin admin);
	
	Admin Login(String name, String password) throws Exception;
}
