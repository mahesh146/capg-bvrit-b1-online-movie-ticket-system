package com.capg.mms.register.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.mms.register.model.Customer;

public interface IRegisterCustomerRepo extends JpaRepository<Customer, String> {

}
