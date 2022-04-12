package builder;

import java.util.Date;

import main.Exam;

public class ExamBuilder {
	private String module;
	private int workloadInHours;
	private Date start;
	private Date end;
	private String place;

	public ExamBuilder module(String module) {
		this.module = module;
		return this;
	}

	public ExamBuilder workloadInHours(int hours) {
		this.workloadInHours = hours;
		return this;
	}

	public ExamBuilder start(Date start) {
		this.start = start;
		return this;
	}

	public ExamBuilder end(Date end) {
		this.end = end;
		return this;
	}

	public ExamBuilder place(String place) {
		this.place = place;
		return this;
	}

	public Exam build() {
		return new Exam(module, workloadInHours, start, end, place);
	}
}
