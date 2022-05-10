package main;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
	private String id; // generated
	private String title; // required
	private Category category; // required
	private LocalDate startDate; // required
	private LocalTime startTime; //required
	private LocalDate endDate; // required
	private LocalTime endTime; //required
	private String description; // optional

	public Appointment(String id, String title, Category category, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime, String description,
			String place) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endDate = endDate;
		this.endTime = endTime;
		this.description = description;
	}

	public Appointment() {
		super();
	}

	@Override
	public String toString() {
		return "Appointment: " + this.title + ", " + this.category + ", " + this.startDate + ", " + this.endDate + ", "
				+ this.description;
	}

	public AppointmentModel toAppointmentModel() {
		return new AppointmentModel(this.id, this.title, this.startDate.toString(), this.startTime.toString(), this.endDate.toString(), this.endTime.toString(),this.category.toString(), this.description);
	}
	
	// ---------------- getter and setter section ---------------
	
	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Category getCategory() {
		return category;
	}

	public LocalDate getStart() {
		return startDate;
	}

	public LocalDate getEnd() {
		return endDate;
	}

	public String getDescription() {
		return description;
	}
}