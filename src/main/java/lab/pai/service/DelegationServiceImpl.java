package lab.pai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.pai.model.Delegation;
import lab.pai.model.User;
import lab.pai.repository.DelegationRepo;
import lab.pai.repository.UserRepo;

@Service
public class DelegationServiceImpl implements DelegationService{
	
	@Autowired
	DelegationRepo delegationRepo;
	UserRepo userRepo;

	public void addDelegation(long userId, Delegation delegation) {
		// TODO Auto-generated method stub
		Optional<User> u = userRepo.findById(userId);
		if(u.isPresent()) {
			User user = u.get();
			delegation.setUser(user);
		}
		delegationRepo.save(delegation);
	}

	public boolean removeDelegation(long userId, long delegationId) {
		// TODO Auto-generated method stub
		Optional<Delegation> d = delegationRepo.findById(delegationId);
		if(d.isPresent()) {
			Delegation delegation = d.get();
			Optional<User> u = userRepo.findById(delegation.getUser().getUserId());
			if(u.isPresent()) {
				User user = u.get();
				if(user.getUserId() == userId) {
					delegationRepo.deleteById(delegationId);
					return true;
				}
			}
		}
		return false;
	}

	public void changeDelegation(long delegationId, Delegation delegation) {
		// TODO Auto-generated method stub
        if(delegationRepo.existsById(delegationId)){
            delegationRepo.save(delegation);
        }
	}

	public List<Delegation> getAllDelegations() {
		// TODO Auto-generated method stub
		List<Delegation> delegations = delegationRepo.findAll();
		return delegations;
	}

	@Override
	public List<Delegation> getAllDelegationsByOrderByDateTimeStartDesc() {
		// TODO Auto-generated method stub
		return delegationRepo.getAllDelegationsByOrderByDateTimeStartDesc();
	}

	
}
