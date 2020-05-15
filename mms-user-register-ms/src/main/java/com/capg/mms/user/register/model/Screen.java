package com.capg.mms.user.register.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "screen")
public class Screen {
	@Id
	//@Size(min=4, message = "ScreenId must be minimum of 4 digits")
	//@GeneratedValue
	private Integer screenId;
//private Integer theatreId;
	private String screenName;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "theatreId")
	@JsonBackReference
	//@ManyToOne
	//@JoinColumn(name="theaterid")
	private Theatre theatre;
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	@OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
	//@OneToMany(mappedBy ="screen")
	//@JsonIgnore
	private List<Show> showList;
	@DateTimeFormat(pattern = "yyyy-MM-dd ")
	private LocalDate movieEndDate;
	@Column(name = "rows_details")
	private Integer rows;
	@Column(name = "columns_details")
	private Integer columns;

	public Screen() {
		super();
	}

	public Screen(Integer screenId, Integer theatreId, String screenName, Theatre theatre, List<Show> showList,
			LocalDate movieEndDate, Integer rows, Integer columns) {
		super();
		this.screenId = screenId;
//	this.theatreId = theatreId;
		this.screenName = screenName;
		this.theatre = theatre;
//	this.showList = showList;
		this.movieEndDate = movieEndDate;
		this.rows = rows;
		this.columns = columns;
	}

	public Integer getScreenId() {
		return screenId;
	}

	public void setScreenId(Integer screenId) {
		this.screenId = screenId;
	}

	
	/*
	 * public Integer getTheatreId() { return theatreId; } public void setTheatreId(Integer
	 * theatreId) { this.theatreId = theatreId; }
	 */
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

		
		 for (Show show : showList) { show.setScreen(this); }
		 
		this.showList = showList;
	}

	public LocalDate getMovieEndDate() {
		return movieEndDate;
	}

	public void setMovieEndDate(LocalDate movieEndDate) {
		this.movieEndDate = movieEndDate;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public void setColumns(Integer columns) {
		this.columns = columns;
	}

	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", theatreId=" + ", screenName=" + screenName + ", showList="
				+ ", movieEndDate=" + movieEndDate + ", rows=" + rows + ", columns=" + columns + "]";
	}

}
