package com.capg.mms.model;

import java.sql.Time;
import java.util.List;



public class Show {

private int showId;
private Time showStartTime;
private Time showEndTime;
private List<Seat> seats;
private String showName;
private Movie movieName;
private int screenId;
private int theatreId;
public int getShowId() {
	return showId;
}
public void setShowId(int showId) {
	this.showId = showId;
}
public Time getShowStartTime() {
	return showStartTime;
}
public void setShowStartTime(Time showStartTime) {
	this.showStartTime = showStartTime;
}
public Time getShowEndTime() {
	return showEndTime;
}
public void setShowEndTime(Time showEndTime) {
	this.showEndTime = showEndTime;
}
public List<Seat> getSeats() {
	return seats;
}
public void setSeats(List<Seat> seats) {
	this.seats = seats;
}
public String getShowName() {
	return showName;
}
public void setShowName(String showName) {
	this.showName = showName;
}
public Movie getMovieName() {
	return movieName;
}
public void setMovieName(Movie movieName) {
	this.movieName = movieName;
}
public int getScreenId() {
	return screenId;
}
public void setScreenId(int screenId) {
	this.screenId = screenId;
}
public int getTheatreId() {
	return theatreId;
}
public void setTheatreId(int theatreId) {
	this.theatreId = theatreId;
}
@Override
public String toString() {
	return "Show [showId=" + showId + ", showStartTime=" + showStartTime + ", showEndTime=" + showEndTime + ", seats="
			+ seats + ", showName=" + showName + ", movieName=" + movieName + ", screenId=" + screenId + ", theatreId="
			+ theatreId + "]";
}


}
