package com.capg.mms.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.actuate.autoconfigure.health.HealthProperties.Show;

public class Screen {
private int screenId;
private int theatreId;
private String screenName;
private List<Show> showList;
private LocalDate movieEndDate;
private int rows;
private int columns;
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
public String getScreenName() {
	return screenName;
}
public void setScreenName(String screenName) {
	this.screenName = screenName;
}
public List<Show> getShowList() {
	return showList;
}
public void setShowList(List<Show> showList) {
	this.showList = showList;
}
public LocalDate getMovieEndDate() {
	return movieEndDate;
}
public void setMovieEndDate(LocalDate movieEndDate) {
	this.movieEndDate = movieEndDate;
}
public int getRows() {
	return rows;
}
public void setRows(int rows) {
	this.rows = rows;
}
public int getColumns() {
	return columns;
}
public void setColumns(int columns) {
	this.columns = columns;
}
@Override
public String toString() {
	return "Screen [screenId=" + screenId + ", theatreId=" + theatreId + ", screenName=" + screenName + ", showList="
			+ showList + ", movieEndDate=" + movieEndDate + ", rows=" + rows + ", columns=" + columns + "]";
}


}
