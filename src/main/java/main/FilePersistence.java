package main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
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
		createDirectoryIfNotExists(path);
		createAppointmentFileIfNotExists();
	}

	/*
	 * Directory "Appointments by PlanIt" will be created in "Documents"-directory
	 * if not already existing
	 */
	private void createDirectoryIfNotExists(String path) {
		File dir = new File(path);
		if (!dir.exists())
			dir.mkdirs();
	}

	/*
	 * File "appointments.txt" will be created in "Appointments by PlanIt"-directory
	 * if not already existing
	 */
	private void createAppointmentFileIfNotExists() {
		try {
			appointmentFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * An ArrayList of appointments is converted to JSON-format and returned as
	 * String
	 */
	public String convertAppointmentListToJSON(ArrayList<Appointment> appntmnts) throws JsonProcessingException {
		// Create ObjectMapper object
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		// Parse to JSON-String
		String json = mapper.writeValueAsString(appntmnts);
		return json;
	}

	/*
	 * A new appointment is added to the existing appointments and saved locally in
	 * "appointments.txt"
	 */
	public void addAppointment(Appointment appntmnt) throws IOException {
		// List of existing appointments is loaded into list
		List<Appointment> list = loadAppointments();
		
		// List is converted to ArrayList for easier expansion
		ArrayList<Appointment> aList = new ArrayList<Appointment>();
		aList.addAll(list);
		// New appointment is added to list
		aList.add(appntmnt);
		// ArrayList is converted to JSON and returned as String
		String json = convertAppointmentListToJSON(aList);
		// JSON-String is written into "appointments.txt"-file
		BufferedWriter writer = new BufferedWriter(new FileWriter(appointmentFile));
		writer.write(json);
		writer.close();
	}

	/*
	 * Appointments are loaded from "appointments.txt"-file and returned as a List
	 */
	public List<Appointment> loadAppointments() throws IOException {
		// Content of "appointments.txt" is written into String
		String content = readAppointemntFile();

		List<Appointment> appointmentList = new ArrayList<Appointment>();
		if (appointmentFile.length() != 0) {
			// Create ObjectMapper for demarshalling
			ObjectMapper mapper = new ObjectMapper();

			try {
				// Loaded JSON-String is converted to an ArrayList of Appointment objects
				appointmentList = Arrays.asList(mapper.readValue(content, Appointment[].class));
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return appointmentList;
	}

	/*
	 * Read "appointments.txt"-file into String
	 */
	private String readAppointemntFile() throws IOException {
		return Files.readString(Paths.get(path + File.separator + "appointments.txt"));
	}

	/*
	 * Appointment with specific ID is being deleted
	 * TODO: when having two appointments in storage, both are being deleted
	 */
	public void deleteAppointment(String id) throws IOException {
		// List of existing appointments is loaded into list
		List<Appointment> list = loadAppointments();
		// List is converted to ArrayList for easier expansion
		ArrayList<Appointment> aList = new ArrayList<Appointment>();

		// Find matching ID and remove appointment from ArrayList
		for (int i = 0; i < aList.size(); i++) {
			if (aList.get(i).getId().equals(id)) {
				aList.remove(i);
			}
		}

		// Convert ArrayList to JSON-Format
		String newContent = convertAppointmentListToJSON(aList);
		// Write JSON-String to "appointments.txt"-file
		BufferedWriter writer = new BufferedWriter(new FileWriter(appointmentFile));
		writer.write(newContent);
		writer.close();
	}

	// TODO: ähnlich wie bei delete kann mithilfe der ID der zu ändernde Termin
	// gefunden werden
	public void updateAppointment(Appointment appointment) {

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
