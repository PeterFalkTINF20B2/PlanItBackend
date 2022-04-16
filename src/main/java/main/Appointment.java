package main;

import java.util.Date;

public class Appointment {
	private String id; // generated
	private String title; // required
	private Category category; // required
	private Date start; // required
	private Date end; // required
	private String description; // optional
	private String place; // optional

	public Appointment(String id, String title, Category category, Date start, Date end, String description,
			String place) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.start = start;
		this.end = end;
		this.description = description;
		this.place = place;
	}

	public Appointment() {
		super();
	}

	@Override
	public String toString() {
		return "Appointment: " + this.title + ", " + this.category + ", " + this.start + ", " + this.end + ", "
				+ this.description + ", " + this.place;
	}

	public String getId() {
		return id;
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

	public String getPlace() {
		return place;
	}
}