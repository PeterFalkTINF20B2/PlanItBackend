package builder;

import java.util.Date;

import main.Lecture;

public class LectureBuilder {
	private String module;
	private Date start;
	private Date end;
	private String place;
	private boolean weekly;

	public LectureBuilder module(String module) {
		this.module = module;
		return this;
	}

	public LectureBuilder start(Date start) {
		this.start = start;
		return this;
	}

	public LectureBuilder end(Date end) {
		this.end = end;
		return this;
	}

	public LectureBuilder place(String place) {
		this.place = place;
		return this;
	}

	public LectureBuilder weekly(boolean weekly) {
		this.weekly = weekly;
		return this;
	}

	public Lecture build() {
		return new Lecture(module, start, end, place, weekly);
	}
}
