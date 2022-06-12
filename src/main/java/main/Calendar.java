package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Calendar {

	public static String getDayOfWeekBefore(String dateString) {
		return LocalDate.parse(dateString).minusDays(7).toString();
	}

	public static String getDayofWeekAfter(String dateString) {
		return LocalDate.parse(dateString).plusDays(7).toString();
	}

	public static List<String> getAktualWeek(String date) {
		List<String> week = new ArrayList<String>();
		FilePersistenceModel fpm = new FilePersistenceModel("", "");
		LocalDate startDate = fpm.getMonday(LocalDate.parse(date));
		week.add(startDate.toString());
		week.add(startDate.plusDays(6).toString());
		return week;
	}
}
