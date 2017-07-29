package prototype.login.service;

import prototype.login.model.User;

public interface UserService {

	boolean login(User user);
	void register(User user);
	
}
