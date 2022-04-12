package main;

import java.util.Date;

public class Appointment {
	private final String title; // required
	private final Category category; // required
	private final Date start; // required
	private final Date end; // required
	private final String description; // optional
	private final String place; // optional

	public Appointment(String title, Category category, Date start, Date end, String description, String place) {
		this.title = title;
		this.category = category;
		this.start = start;
		this.end = end;
		this.description = description;
		this.place = place;
	}

	@Override
	public String toString() {
		return "Appointment: " + this.title + ", " + this.category + ", " + this.start + ", " + this.end + ", "
				+ this.description + ", " + this.place;
	}

	public String getTitle() {
		return title;
	}

	public Category getCategory() {
		return category;
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}

	public String getDescription() {
		return description;
	}
}