package com.capg.mms.theatre.model;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Show {
@Id
private Integer showId;
@DateTimeFormat(pattern = "yyyy-MM-ddThh:mm:ss")
private LocalDateTime showStartTime;
@DateTimeFormat(pattern = "yyyy-MM-ddThh:mm:ss")
private LocalDateTime showEndTime;
@ElementCollection
private List<Integer> seats;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="screenId")
@JsonBackReference
private Screen screen;
private String showName;
private Integer movieId;
private Integer theatreId;
public Show() {
	super();
}

public Show(Integer showId, LocalDateTime showStartTime, LocalDateTime showEndTime, List<Integer> seats, Screen screen,
		String showName, Integer movieId, Integer screenId, Integer theatreId) {
	super();
	this.showId = showId;
	this.showStartTime = showStartTime;
	this.showEndTime = showEndTime;
	this.seats = seats;
	this.screen = screen;
	this.showName = showName;
	this.movieId = movieId;
	//this.screenId = screenId;
	this.theatreId = theatreId;
}

public Integer getShowId() {
	return showId;
}
public void setShowId(Integer showId) {
	this.showId = showId;
}
public LocalDateTime getShowStartTime() {
	return showStartTime;
}
public void setShowStartTime(LocalDateTime showStartTime) {
	this.showStartTime = showStartTime;
}
public LocalDateTime getShowEndTime() {
	return showEndTime;
}
public void setShowEndTime(LocalDateTime showEndTime) {
	this.showEndTime = showEndTime;
}
public List<Integer> getSeats() {
	return seats;
}
public void setSeats(List<Integer> seats) {
	
	this.seats = seats;
}
public Screen getScreen() {
	return screen;
}

public void setScreen(Screen screen) {
	this.screen = screen;
}

public String getShowName() {
	return showName;
}
public void setShowName(String showName) {
	this.showName = showName;
}

public Integer getMovieId() {
	return movieId;
}
public void setMovieId(Integer movieId) {
	this.movieId = movieId;
}

	/*
	 * public int getScreenId() { return screenId; } public void setScreenId(int
	 * screenId) { this.screenId = screenId; }
	 */
public Integer getTheatreId() {
	return theatreId;
}
public void setTheatreId(Integer theatreId) {
	this.theatreId = theatreId;
}
@Override
public String toString() {
	return "Show [showId=" + showId + ", showStartTime=" + showStartTime + ", showEndTime=" + showEndTime + ", seats="
			+ seats + ", showName=" + showName + ", movieId=" + movieId + ", screenId=" + ", theatreId="
			+ theatreId + "]";
}



}
