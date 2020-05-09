package com.capg.mms.theatre.service;

import java.util.List;

import com.capg.mms.theatre.exception.TheatreException;
import com.capg.mms.theatre.model.Theatre;
;

public interface ITheatreService {
	Theatre addTheatre (Theatre theatre)throws TheatreException;
	Theatre updateTheatreById(Theatre theatre) throws TheatreException;
	boolean deleteTheatreById(int theatreId) throws TheatreException;
	List<Theatre> findAllTheatres() throws TheatreException;
	Theatre getTheatreById(int theatreId);
	Theatre getTheatreByName(String theatreName);
	boolean validateTheatreId(int theatreId) throws TheatreException;
}
