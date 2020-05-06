package com.capg.mms.theatre.service;

import java.util.List;

import com.capg.mms.theatre.exception.TheatreException;
import com.capg.mms.theatre.model.Screen;



public interface IScreenService {
	Screen addScreen (Screen screen)throws TheatreException;
	Screen updateScreenById(Screen screen) throws TheatreException;
	boolean deleteScreenById(int screenId) throws TheatreException;
	List<Screen> findAllScreens() throws TheatreException;
	Screen getScreenById(int screenId);
	boolean validateScreenId(int screenId,int theatreId)throws TheatreException;
	
}
