package lab.pai.service;

import java.util.List;

import lab.pai.model.Delegation;
import lab.pai.model.User;

public interface UserService {
	void registerUser(User user);
	List<User> getAllUsers();
	void changePassword(long userId, String newPassword);
	boolean deleteUserById(long userId);	
	List<User> getAllUsersByRoleName(String roleName);
	List<Delegation> getAllDelByUserOrderByDateStartDesc(long userId);
}
