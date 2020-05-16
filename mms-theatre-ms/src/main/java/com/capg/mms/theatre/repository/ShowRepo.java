package com.capg.mms.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.mms.theatre.model.Show;
@Repository
public interface ShowRepo extends JpaRepository<Show,Integer> {

}
