package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.*;

import com.fasterxml.jackson.core.JsonProcessingException;

import builder.AppointmentBuilder;
import main.*;

public class TestFilePersistence {
	@Test
	public void testconvertAppointmentToJSON() throws JsonProcessingException {
		Appointment a1 = new AppointmentBuilder().title("Dentist").category(Category.Doctor).start(new Date(1))
				.end(new Date(2)).description("Brushing teeth").place("Goethe Platz 12, 85256 Vierkirchen").build();
		Appointment a2 = new AppointmentBuilder().title("Gym").category(Category.Sports).start(new Date(2))
				.end(new Date(3)).description("Push Day").place("Goethe Platz 13, 85256 Vierkirchen").build();
		List<Appointment> list = new ArrayList<Appointment>();
		list.add(a1);
		list.add(a2);
		assertEquals("[ {\r\n" + "  \"title\" : \"Dentist\",\r\n" + "  \"category\" : \"Doctor\",\r\n"
				+ "  \"start\" : 1,\r\n" + "  \"end\" : 2,\r\n" + "  \"description\" : \"Brushing teeth\"\r\n"
				+ "}, {\r\n" + "  \"title\" : \"Gym\",\r\n" + "  \"category\" : \"Sports\",\r\n"
				+ "  \"start\" : 2,\r\n" + "  \"end\" : 3,\r\n" + "  \"description\" : \"Push Day\"\r\n" + "} ]",
				new FilePersistence().convertAppointmentListToJSON(list));
	}
}
