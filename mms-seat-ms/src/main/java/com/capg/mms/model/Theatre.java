package com.capg.mms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Theatre {

private int theatreId;
private String theatreName;
private String theatreCity;
private String movies;
private long listOfScreens;
private String managerName;
private String managerContact;
public int getTheatreId() {
	return theatreId;
}
public void setTheatreId(int theatreId) {
	this.theatreId = theatreId;
}
public String getTheatreName() {
	return theatreName;
}
public void setTheatreName(String theatreName) {
	this.theatreName = theatreName;
}
public String getTheatreCity() {
	return theatreCity;
}
public void setTheatreCity(String theatreCity) {
	this.theatreCity = theatreCity;
}
public String getMovies() {
	return movies;
}
public void setMovies(String movies) {
	this.movies = movies;
}
public long getListOfScreens() {
	return listOfScreens;
}
public void setListOfScreens(long listOfScreens) {
	this.listOfScreens = listOfScreens;
}
public String getManagerName() {
	return managerName;
}
public void setManagerName(String managerName) {
	this.managerName = managerName;
}
public String getManagerContact() {
	return managerContact;
}
public void setManagerContact(String managerContact) {
	this.managerContact = managerContact;
}
@Override
public String toString() {
	return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreCity=" + theatreCity
			+ ", movies=" + movies + ", listOfScreens=" + listOfScreens + ", managerName=" + managerName
			+ ", managerContact=" + managerContact + "]";
}


}
