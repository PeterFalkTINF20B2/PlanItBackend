package test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import builder.*;
import main.*;

public class TestBuilder {
	@Test
	public void testAppointmentBuilderAllFieldsEntered() {
		Appointment a1 = new AppointmentBuilder().title("Dentist").category(Category.Doctor).start(new Date(1))
				.end(new Date(2)).description("Brushing teeth").place("Goethe Platz 12, 85256 Vierkirchen").build();
		assertEquals(
				"Appointment: Dentist, Doctor, Thu Jan 01 01:00:00 CET 1970, Thu Jan 01 01:00:00 CET 1970, Brushing teeth, Goethe Platz 12, 85256 Vierkirchen",
				a1.toString());
	}

	@Test
	public void testExamBuilderAllFieldsEntered() {
		Exam e1 = new ExamBuilder().module("Theoretische Informatik 3").workloadInHours(10).start(new Date(1))
				.end(new Date(2)).place("A263").build();
		assertEquals(
				"Exam: Theoretische Informatik 3, 10, Thu Jan 01 01:00:00 CET 1970, Thu Jan 01 01:00:00 CET 1970, A263",
				e1.toString());
	}

	@Test
	public void testLectureBuilderAllFieldsEntered() {
		Lecture l1 = new LectureBuilder().module("SE 1").start(new Date(1)).end(new Date(2)).place("A263").weekly(false)
				.build();
		assertEquals("Lecture: SE 1, Thu Jan 01 01:00:00 CET 1970, Thu Jan 01 01:00:00 CET 1970, A263, false",
				l1.toString());
	}

	@Test
	public void testAppointmentBuilderFieldMissing() {
		Appointment a = new AppointmentBuilder().title("Dentist").start(new Date(1)).end(new Date(2))
				.place("Geothe-Platz 12, 85256 Vierkirchen").build();
		assertEquals(
				"Appointment: Dentist, null, Thu Jan 01 01:00:00 CET 1970, Thu Jan 01 01:00:00 CET 1970, null, Geothe-Platz 12, 85256 Vierkirchen",
				a.toString());
	}
}
