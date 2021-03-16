package lab.pai.service;

import java.util.List;

import lab.pai.model.Delegation;

public interface DelegationService {
	
	void addDelegation(long userId, Delegation delegation);
	boolean removeDelegation(long userId, long delegationId);
	void changeDelegation(long DelegationId, Delegation delegation);
	List<Delegation> getAllDelegations();
	List<Delegation> getAllDelegationsByOrderByDateTimeStartDesc();
	
}
