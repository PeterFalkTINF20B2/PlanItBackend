package de.dhbw.planit;

import java.util.Date;

public class Exam extends Appointment {
      String module;
      int studyWorkload; // in hours

      public Exam(int app_ID, String description, Category category, int priority,
                  Color color, Date startDate, Date endDate, String module, int studyWorkload) {
            super(app_ID, description, category, priority, color, startDate, endDate);
            setModule(module);
            setStudyWorkload(studyWorkload);
      }

      // ---------------- getter and setter section ---------------

      String getModule() {
            return module;
      }

      void setModule(String module) {
            this.module = module;
      }

      int getStudyWorkload() {
            return studyWorkload;
      }

      void setStudyWorkload(int studyWorkload) {
            this.studyWorkload = studyWorkload;
      }
}
