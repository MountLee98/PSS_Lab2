package lab.pai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lab.pai.model.Delegation;

public interface DelegationRepo extends JpaRepository<Delegation, Long>{
	List<Delegation> getAllDelegationsByOrderByDateTimeStartDesc();
	
	@Query("SELECT d FROM Delegation d WHERE d.user.userId = :userId")
	List<Delegation> findUser(@Param("userId") long userId);
}
