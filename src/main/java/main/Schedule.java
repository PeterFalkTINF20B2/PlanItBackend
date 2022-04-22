package main;

import java.sql.Date;
import java.time.LocalDate;

import builder.*;

public class Schedule {
	Persistence persitence;
	Appointment[] appointments;
	UIView view;

	public Appointment createAppointement(String title, Category category, LocalDate start, LocalDate end, String description,
			String place) {
		return new AppointmentBuilder().title(title).category(category).start(start).end(end).description(description)
				.place(place).build();
	}

	public Exam createExam(String module, int workload, Date start, Date end, String place) {
		return new ExamBuilder().module(module).workloadInHours(workload).start(start).end(end).place(place).build();
	}

	public Lecture createLecture(String module, Date start, Date end, String place, boolean weekly) {
		return new LectureBuilder().module(module).start(start).end(end).place(place).weekly(weekly).build();
	}

	void refactorAppointment(int app_ID, String description, Category category, int priority, Color color,
			Date startDate, Date endDate) {
		//
	}

	Appointment[] loadAppointments() {
		//
		return null;
	}

	// ---------------- getter and setter section ---------------

	Persistence getPersistence() {
		return persitence;
	}

	void setPersistence(Persistence persistence) {
		this.persitence = persistence;
	}

	UIView getView() {
		return view;
	}

	void setView(UIView view) {
		this.view = view;
	}

	Appointment[] getAppointments() {
		return appointments;
	}
}
