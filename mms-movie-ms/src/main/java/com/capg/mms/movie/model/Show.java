package com.capg.mms.movie.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Show {
	@Id
	private int showId;
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	private LocalDate showStartTime;
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	private LocalDate showEndTime;
	@ElementCollection
	private List<Integer> seats;
	private String showName;
	private String movieName;
	private int screenId;
	private int theaterId;

	public Show() {
		super();
	}

	public Show(int showId, LocalDate showStartTime, LocalDate showEndTime, List<Integer> seats, String showName,
			String movieName, int screenId, int theaterId) {
		super();
		this.showId = showId;
		this.showStartTime = showStartTime;
		this.showEndTime = showEndTime;
		this.seats = seats;
		this.showName = showName;
		this.movieName = movieName;
		this.screenId = screenId;
		this.theaterId = theaterId;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public LocalDate getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(LocalDate showStartTime) {
		this.showStartTime = showStartTime;
	}

	public LocalDate getShowEndTime() {
		return showEndTime;
	}

	public void setShowEndTime(LocalDate showEndTime) {
		this.showEndTime = showEndTime;
	}

	public List<Integer> getSeats() {
		return seats;
	}

	public void setSeats(List<Integer> seats) {
		this.seats = seats;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getMovieName() {
		return movieName;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", showStartTime=" + showStartTime + ", showEndTime=" + showEndTime
				+ ", seats=" + seats + ", showName=" + showName + ", movieName=" + movieName + ", screenId=" + screenId
				+ ", theaterId=" + theaterId + "]";
	}

}
