package lab.pai.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.pai.model.Delegation;
import lab.pai.model.Role;
import lab.pai.model.User;
import lab.pai.repository.DelegationRepo;
import lab.pai.repository.RoleRepo;
import lab.pai.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	DelegationRepo delegationRepo;
	UserRepo userRepo;
	RoleRepo roleRepo;
	
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userRepo.findAll();
		return users;
	}

	public void changePassword(long userId, String newPassword) {
		// TODO Auto-generated method stub
		Optional<User> u = userRepo.findById(userId);
		if(u.isPresent()) {
			User user = u.get();
			user.setPassword(newPassword);
		}
		
	}

	public boolean deleteUserById(long userId) {
		// TODO Auto-generated method stub
		Optional<User> u = userRepo.findById(userId);
		if(u.isPresent()) {
			for (Delegation delegation : delegationRepo.findUser(userId)) {
				delegationRepo.delete(delegation);
			}
			userRepo.deleteById(userId);
			return true;
		}
		return false;
	}

	public List<User> getAllUsersByRoleName(String roleName) {
		// TODO Auto-generated method stub
		List<Role> roles = roleRepo.findAll().
				stream().
				filter(x -> x.getRoleName().contains(roleName)).
				collect(Collectors.toList());
		List<User> users = null;
		for(int i=0; i<roles.size(); i++) {
			users = roles.get(i).getUser();
		}
		return users;
	}

	public List<Delegation> getAllDelByUserOrderByDateStartDesc(long userId) {
		// TODO Auto-generated method stub
		Optional<User> u= userRepo.findById(userId);
		if(u.isPresent()) {
			User user = u.get();
			List<Delegation> del = user.getDelegation();
			return del;
		}
		return null;
	}

}
