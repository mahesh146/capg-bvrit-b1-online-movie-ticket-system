package com.capg.mms.user.register.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.mms.user.register.model.User;

public interface IUserRepo extends JpaRepository<User, Integer> {

	@Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM User c WHERE c.userName = :userName")
	public boolean existsByUserName(String userName);
}
