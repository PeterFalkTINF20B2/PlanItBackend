package main;

import java.io.IOException;
import java.util.List;

public interface Persistence {
      public List<Appointment> loadAppointments() throws IOException;
      public void deleteAppointment(String id) throws IOException;
      public void updateAppointment(Appointment appointment);
}
