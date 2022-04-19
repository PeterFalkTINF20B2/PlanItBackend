package builder;

import java.util.Date;
import java.util.UUID;

import main.Appointment;
import main.Category;

public class AppointmentBuilder {
	private String id; // generated
	private String title; // required
	private Category category; // required
	private Date start; // required
	private Date end; // required
	private String description; // optional
	private String place; // optional

	public AppointmentBuilder() {
		id = UUID.randomUUID().toString();
	}
	
	public AppointmentBuilder id(String id) {
		this.id = id;
		return this;
	}
	
	public AppointmentBuilder title(String title) {
		this.title = title;
		return this;
	}

	public AppointmentBuilder category(Category category) {
		this.category = category;
		return this;
	}

	public AppointmentBuilder start(Date start) {
		this.start = start;
		return this;
	}

	public AppointmentBuilder end(Date end) {
		this.end = end;
		return this;
	}

	public AppointmentBuilder description(String description) {
		this.description = description;
		return this;
	}
	
	public AppointmentBuilder place(String place) {
		this.place = place;
		return this;
	}

	public Appointment build() {
		return new Appointment(id, title, category, start, end, description, place);
	}
}