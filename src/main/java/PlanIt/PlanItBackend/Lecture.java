package PlanIt.PlanItBackend;

import java.util.Date;

public class Lecture extends Appointment {
      String module;
      int preperationWorkload;

      public Lecture(int app_ID, String description, Category category, int priority, Color color, Date startDate,
                  Date endDate, String module, int preperationWorkload) {
            super(app_ID, description, category, priority, color, startDate, endDate);
            this.module = module;
            this.preperationWorkload = preperationWorkload;
      }

      // ---------------- getter and setter section ---------------    

      String getModule() {
            return module;
      }

      void setModule(String module) {
            this.module = module;
      }

      int getPreperationWorkload() {
            return preperationWorkload;
      }

      void setPreperationWorkload(int preperationWorkload) {
            this.preperationWorkload = preperationWorkload;
      }
}   
