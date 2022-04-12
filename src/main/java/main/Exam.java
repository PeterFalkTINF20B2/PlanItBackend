package main;

import java.util.Date;

public class Exam {
	private final String module;
	private final int workloadInHours;
	private final Date start;
	private final Date end;
	private final String place;

	public Exam(String module, int workloadInHours, Date start, Date end, String place) {
		this.module = module;
		this.workloadInHours = workloadInHours;
		this.start = start;
		this.end = end;
		this.place = place;
	}

	@Override
	public String toString() {
		return "Exam: " + this.module + ", " + this.workloadInHours + ", " + this.start + ", " + this.end + ", "
				+ this.place;
	}

	public String getModule() {
		return module;
	}

	public int getWorkloadInHours() {
		return workloadInHours;
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
}
