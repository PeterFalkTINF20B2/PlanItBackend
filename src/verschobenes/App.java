package controller;

import java.io.IOException;
import java.util.Date;

import builder.AppointmentBuilder;
import main.Appointment;
import main.Category;
import main.FilePersistence;

public final class App {
	public static void main(String[] args) throws IOException {
		FilePersistence fp = new FilePersistence();
//		Appointment a1 = new AppointmentBuilder()
//				.title("General Check")
//				.category(Category.Doctor)
//				.start(new Date(3))
//				.end(new Date(4))
//				.description("Test")
//				.place("Goethe Platz 12, 85256 Vierkirchen")
//				.build();
//		Appointment a1 = new AppointmentBuilder()
//				.title("Dentist")
//				.category(Category.Doctor)
//				.start(new Date(3))
//				.end(new Date(4))
//				.description("Test")
//				.place("Goethe Platz 12, 85256 Vierkirchen")
//				.build();
		
//		fp.addAppointment(a1);
		fp.deleteAppointment("12ac6990-1b54-4157-b628-6bc83d33748e");
	}
}
