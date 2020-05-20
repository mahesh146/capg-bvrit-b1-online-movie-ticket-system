package com.capg.mms.theatre.service;

import java.util.List;

import com.capg.mms.theatre.exception.TheatreException;
import com.capg.mms.theatre.model.Screen;



public interface IScreenService {
	Screen addScreen (Screen screen);
	Screen updateScreenById(Screen screen);
	boolean deleteScreenById(int screenId);
	List<Screen> findAllScreens();
	Screen getScreenById(int screenId);
	
	boolean validateScreenId(int screenId);

}
