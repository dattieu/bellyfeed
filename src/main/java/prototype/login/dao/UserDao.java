package prototype.login.dao;

import prototype.login.model.User;

import java.util.List;

public interface UserDao {
	
	boolean authenticate(String base, String username, String password);
	List<String> getAllUserNames();
	List<User> getAll();
	void create(User user);
	void update(User user);
	void delete(User user);
   
}
