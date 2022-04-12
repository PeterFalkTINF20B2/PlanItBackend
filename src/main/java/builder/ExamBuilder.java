package builder;

import java.util.Date;
import java.util.UUID;

import main.Exam;

public class ExamBuilder {
	private String id;
	private String module;
	private int workloadInHours;
	private Date start;
	private Date end;
	private String place;

	public ExamBuilder() {
		this.id = UUID.randomUUID().toString();
	}
	
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
		return new Exam(id, module, workloadInHours, start, end, place);
	}
}
