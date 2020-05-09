package com.capg.mms.register.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.mms.register.model.Admin;

public interface IRegisterAdminRepo extends JpaRepository<Admin, String> {

}
