package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class FilePersistence implements Persistence {
	String path;
	File appointmentFile;
	Appointment appointment;

	public FilePersistence() {
		setPath(System.getProperty("user.home") + File.separator + "Documents" + File.separator
				+ "Appointments by PlanIt");
		appointmentFile = new File(path + File.separator + "appointments.txt");
	}

	public String convertAppointmentListToJSON(List<Appointment> appntmnts) throws JsonProcessingException {
		// Create ObjectMapper object
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		// TODO: If file exists, load appointments into List
		// Add new appointment to list

		// Serialize object to JSON
		String json = mapper.writeValueAsString(appntmnts);
		return json;
	}

	public void saveAppointment(String json) {
		BufferedWriter br;
		try {
			br = new BufferedWriter(new FileWriter(appointmentFile));
			br.write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//        Appointment[] aArr;
//        if (appointmentFile.exists()) {
//            ArrayList<Appointment> appointments = new ArrayList<Appointment>();
//			Appointment[] loadedStudents = loadAppointments();
//		
//			for(int i = 0; i < loadedStudents.length; i++) {
//				appointments.add(loadedStudents[i]);
//			}
//			appointments.add(appointment);
//		
//			aArr = new Appointment[appointments.size()];
//			aArr = appointments.toArray(aArr);
//		}
//		else {
//			aArr = new Appointment[1];
//			aArr[0] = appointment;
//		}

//        try {
//			FileOutputStream f = new FileOutputStream(appointmentFile);
//			ObjectOutputStream o = new ObjectOutputStream(f);
//
//			// Write objects to file
//			o.writeObject(aArr);
//			o.close();
//			f.close();
//
//		} catch (FileNotFoundException e) {
//			System.out.println("File not found");
//		} catch (IOException e) {
//			System.out.println("Error initializing stream");
//        }
	}

//    @Override
	public Appointment[] loadAppointments() {
		Appointment[] lApp = null;

		try {
			// Read Student array from file.
			FileInputStream fis = new FileInputStream(appointmentFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			lApp = (Appointment[]) ois.readObject();

			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return lApp;
	}

//    @Override
	public void deleteAppointment(int app_ID) {
		if (appointmentFile.exists()) {
			Appointment[] oldAppArr = loadAppointments();
			ArrayList<Appointment> updatedAppList = new ArrayList<Appointment>();

			for (int i = 0; i < oldAppArr.length; i++) {
				if (oldAppArr[i].getApp_ID() != app_ID) {
					updatedAppList.add(oldAppArr[i]);
				}
			}

			Appointment[] newStudentsArr = new Appointment[updatedAppList.size()];
			newStudentsArr = updatedAppList.toArray(newStudentsArr);

			try {
				FileOutputStream fos = new FileOutputStream(appointmentFile);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(newStudentsArr);
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

//    @Override
	public void updateAppointment(Appointment appointment) {
		// TODO Auto-generated method stub

	}
	// ---------------- getter and setter section ---------------

	String getPath() {
		return path;
	}

	void setPath(String path) {
		this.path = path;
	}

	File getAppointmentFile() {
		return appointmentFile;
	}

	void setStorage(File appointmentFile) {
		this.appointmentFile = appointmentFile;
	}

	Appointment getAppointment() {
		return appointment;
	}

	void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
}
