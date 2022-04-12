package main;

import java.util.Date;

public class Lecture {
	private final String module;
	private final Date start;
	private final Date end;
	private final String place;
	private final boolean weekly;
	
	public Lecture(String module, Date start, Date end, String place, boolean weekly) {
		this.module = module;
		this.start = start;
		this.end = end;
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

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}

	public String getPlace() {
		return place;
	}

	public boolean isWeekly() {
		return weekly;
	}
}   
