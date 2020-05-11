package com.capg.mms.user.register.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.mms.user.register.model.User;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {

	@Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM User c WHERE c.userName = :userName")
	public boolean existsByUserName(String userName);
	
//	@Query(value = "from User where userName=:userName")
//	public User getUserByUserName(String userName);
	
	public User getUserByUserName(String userName);
}
