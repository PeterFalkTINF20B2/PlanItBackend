package de.dhbw.planit;

import java.sql.Date;

public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        
        FilePersistence fp = new FilePersistence();

        Date d1 = new Date(1, 1, 1);
        Date d2 = new Date(2,2,2);
        Appointment a1 = new Appointment(1, "test", Category.STUDY, 1, Color.BLUE, d1, d2);
        Appointment a2 = new Appointment(2, "test2", Category.STUDY, 1, Color.BLUE, d2, d1);

        fp.saveAppointment(a1);
        fp.saveAppointment(a2);
        Appointment[] test = fp.loadAppointments();
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i].getDescription());
        }

        fp.deleteAppointment(1);
        Appointment[] test2 = fp.loadAppointments();
        for (int i = 0; i < test2.length; i++) {
            System.out.println(test2[i].getDescription());
        }
    }
}
