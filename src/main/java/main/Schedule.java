package PlanIt.PlanItBackend;

import java.sql.Date;

public class Schedule {
    Persistence persitence;
    Appointment[] appointments;
    UIView view;

    void createAppointement(int app_ID, String description, Category category, int priority,
                            Color color, Date startDate, Date endDate) {
        new Appointment(app_ID, description, category, priority, color, startDate, endDate);
    }

    void refactorAppointment(int app_ID, String description, Category category, int priority,
                             Color color, Date startDate, Date endDate) {
         //
    }

    Appointment[] loadAppointments() {
        //
        return null;
    }

    void createExam (int app_ID, String description, Category category, int priority,
                     Color color, Date startDate, Date endDate, String module, int studyWorkload) {
        new Exam(app_ID, description, category, priority, color, startDate, endDate, module, studyWorkload);
    }

    // ---------------- getter and setter section ---------------

    Persistence getPersistence() {
        return persitence;
    }

    void setPersistence(Persistence persistence) {
        this.persitence = persistence;
    }

    UIView getView() {
        return view;
    }

    void setView(UIView view) {
        this.view = view;
    }

    Appointment[] getAppointments() {
        return appointments;
    }
}
