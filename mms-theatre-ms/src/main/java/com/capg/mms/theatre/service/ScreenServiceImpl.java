package com.capg.mms.theatre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mms.theatre.exception.TheatreException;
import com.capg.mms.theatre.model.Screen;
import com.capg.mms.theatre.repository.ITheatreRepo;
import com.capg.mms.theatre.repository.ScreenRepo;

@Service
public class ScreenServiceImpl implements IScreenService {

	@Autowired
	ScreenRepo screenRepo;
	@Autowired 
	ITheatreRepo theatrerepo;
	@Override
	public Screen addScreen(Screen screen) {
		return screenRepo.saveAndFlush(screen);
	}

	@Override
	public Screen updateScreenById(Screen screen) throws TheatreException {
		int screenId = screen.getScreenId();
		if (screenRepo.existsById(screenId)) {
			Screen updateScreen = screenRepo.findById(screenId).get();
			screenRepo.saveAndFlush(updateScreen);
		} else {
			throw new TheatreException("Id not found");
		}
		return screen;
	}

	@Override
	public boolean deleteScreenById(int screenId) throws TheatreException {
		
		if (screenRepo.existsById(screenId)) {
			screenRepo.deleteById(screenId);
		} else {
			throw new TheatreException("Id not found");
		}
		return true;
	}

	@Override
	public List<Screen> findAllScreens() throws TheatreException {

		return screenRepo.findAll();
	}

	@Override
	public Screen getScreenById(int screenId) {
		// TODO Auto-generated method stub
		return screenRepo.getOne(screenId);
	}

	@Override
	public boolean validateScreenId(int screenId, int theatreId) throws TheatreException {
		String theatre=Integer.toString(theatreId);
		String screen=Integer.toString(screenId);
		String screen1 = screen+theatre;
		if(!(screen1.length()>=4))
			throw new TheatreException("ScreenId must be minimum of 4 characters, concatinated with screenId and theatreId");
		return true;
		
	}

}
