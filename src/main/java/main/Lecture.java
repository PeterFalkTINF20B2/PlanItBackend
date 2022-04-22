package main;

import java.time.LocalDate;

public class Lecture {
	private final String id;
	private final String module;
	private final LocalDate start;
	private final LocalDate end;
	private final String place;
	private final boolean weekly;
	
	public Lecture(String id, String module, LocalDate start2, LocalDate end2, String place, boolean weekly) {
		this.id = id;
		this.module = module;
		this.start = start2;
		this.end = end2;
		this.place = place;
		this.weekly = weekly;
	}
	
	@Override
	public String toString() {
		return "Lecture: " + this.module + ", " + this.start + ", " + this.end + ", " + this.place + ", " + this.weekly;
	}

	public String getModule() {
		return module;
	}

	public LocalDate getStart() {
		return start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public String getPlace() {
		return place;
	}

	public boolean isWeekly() {
		return weekly;
	}
}   
