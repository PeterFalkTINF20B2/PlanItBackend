package main;

import java.time.LocalDate;
//import java.util.Date;

public class Calendar {
    public Calendar(){
    }

    public static String getDayOfWeekBefore(String dateString){
//        @SuppressWarnings("deprecation")
//		LocalDate oldDate = LocalDate.parse(dateString);
//        LocalDate newDate = oldDate.minusDays(7);
//        return newDate.toString();
    	return LocalDate.parse(dateString).minusDays(7).toString();
    }
    
    public static String getDayofWeekAfter(String dateString) {
    	LocalDate oldDate = LocalDate.parse(dateString);
    	LocalDate newDate = oldDate.plusDays(7);
    	return newDate.toString();
    }
}
