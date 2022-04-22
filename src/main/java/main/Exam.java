package main;

import java.time.LocalDate;

public class Exam {
	private final String id;
	private final String module;
	private final int workloadInHours;
	private final LocalDate start;
	private final LocalDate end;
	private final String place;

	public Exam(String id, String module, int workloadInHours, LocalDate start2, LocalDate end2, String place) {
		this.id = id;
		this.module = module;
		this.workloadInHours = workloadInHours;
		this.start = start2;
		this.end = end2;
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

	public LocalDate getStart() {
		return start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public String getPlace() {
		return place;
	}
}
