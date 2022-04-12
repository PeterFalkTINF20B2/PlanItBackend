package test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.*;

import com.fasterxml.jackson.core.JsonProcessingException;

import builder.AppointmentBuilder;
import main.*;

public class TestFilePersistence {
	@Test
	public void testconvertAppointmentToJSON() throws JsonProcessingException {
		Appointment a1 = new AppointmentBuilder().title("Dentist").category(Category.Doctor).start(new Date(1))
				.end(new Date(2)).description("Brushing teeth").place("Goethe Platz 12, 85256 Vierkirchen").build();
		assertEquals("[ {\r\n" + "  \"title\" : \"Dentist\",\r\n" + "  \"category\" : \"Doctor\",\r\n"
				+ "  \"start\" : 1,\r\n" + "  \"end\" : 2,\r\n" + "  \"description\" : \"Brushing teeth\"\r\n" + "} ]",
				new FilePersistence().convertAppointmentToJSON(a1));
	}
}
