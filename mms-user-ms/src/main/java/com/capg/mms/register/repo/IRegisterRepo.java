package com.capg.mms.register.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.mms.register.model.User;

public interface IRegisterRepo extends JpaRepository<User, Integer> {

}
