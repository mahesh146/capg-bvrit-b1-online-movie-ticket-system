package com.capg.mms.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.mms.theatre.model.Theatre;

@Repository
public interface ITheatreRepo extends JpaRepository<Theatre, Integer> {

	public Theatre getByTheatreId(Integer theatreId);

	public Theatre getByTheatreName(String theatreName);

}
