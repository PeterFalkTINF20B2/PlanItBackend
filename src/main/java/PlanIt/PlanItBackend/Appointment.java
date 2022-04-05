package PlanIt.PlanItBackend;

import java.util.Date;
import java.io.Serializable;

public class Appointment implements Serializable {
      int app_ID;
      String description;
      Category category;
      int priority; // data not final
      Color color;
      Date startDate;
      Date endDate;

      public Appointment(int app_ID, String description, Category category, int priority,
            Color color, Date startDate, Date endDate) {
                  setApp_ID(app_ID);
                  setDescription(description);
                  setCategory(category);
                  setPriority(priority);
                  setColor(color);
                  setstartDate(startDate);
                  setendDate(endDate);
            }

      public String toString() {
            return null;            }
      // ---------------- getter and setter section ---------------
      int getApp_ID() {
            return app_ID;
      }

      void setApp_ID(int app_ID) {
            this.app_ID = app_ID;
      }

      public String getDescription() {
            return description;
      }

      void setDescription(String description) {
            this.description = description;
      }

      Category getCategory() {
            return category;
      }
      
      void setCategory(Category category) {
            this.category = category;
      }

      int getPriority() {
            return priority;
      }

      void setPriority(int priority) {
            this.priority = priority;
      }

      Color getColor() {
            return color;
      }

      void setColor(Color color) {
            this.color = color;
      }

      Date getStartDate() {
            return startDate;
      }

      void setstartDate(Date startDate) {
            this.startDate = startDate;
      }

      Date getEndDate() {
            return endDate;
      }

      void setendDate(Date endDate) {
            this.endDate = endDate;
      }
}