package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AppointmentModel {
	private String id; // generated
	private String title; // required
	private String category; // required
	private String startdate; // required
	private String starttime;// required
	private String enddate; // required
	private String endtime;
	private Boolean flexible;
	private String description; // optional
//	private String place; // optional

	public AppointmentModel(String id, String title, String category, String startdate, String starttime,
			String enddate, String endtime, String description) {
		super();
		this.id = id;
		this.title = title;
		this.startdate = startdate;
		this.starttime = starttime;
		this.enddate = enddate;
		this.endtime = endtime;
//		this.flexible = flexible;
		this.category = category;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Appointment: " + this.title + ", " + this.category + ", " + this.startdate + ", " + this.starttime
				+ ", " + this.enddate + ", " + this.endtime;
	}

	public Appointment toAppointment() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH-mm-ss");
		return new Appointment(this.id, this.title, Category.valueOf(category), LocalDate.parse(startdate),
				LocalTime.parse(starttime, formatter), LocalDate.parse(enddate), LocalTime.parse(endtime, formatter),
				this.description, null);
	}

	/*
	 * getter setter
	 */

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public AppointmentModel() {
		super();
	}

	public String getId() {
		return id;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Boolean getFlexible() {
		return flexible;
	}

	public void setFlexible(Boolean flexible) {
		this.flexible = flexible;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// public Category getCategory() {
	// return category;
	// }
	// public void setCategory(Category category) {
	// this.category = category;
	// }
	public String getStart() {
		return startdate;
	}

	public void setStart(String start) {
		this.startdate = start;
	}

	public String getEnd() {
		return enddate;
	}

	public void setEnd(String end) {
		this.enddate = end;
	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public String getPlace() {
//		return place;
//	}
//	public void setPlace(String place) {
//		this.place = place;
//	}
}
