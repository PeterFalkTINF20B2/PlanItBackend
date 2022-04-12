package controller;

import java.util.Date;

import builder.AppointmentBuilder;
import main.Appointment;
import main.Category;

public final class App {
	public static void main(String[] args) {
		Appointment a1 = new AppointmentBuilder()
				.title("Dentist")
				.category(Category.Doctor)
				.start(new Date(1))
				.end(new Date(2))
				.description("Brushing teeth")
				.place("Goethe Platz 12, 85256 Vierkirchen")
				.build();
		
		System.out.println(a1.toString());
	}
}
