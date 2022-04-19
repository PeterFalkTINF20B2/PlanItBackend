package main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class FilePersistence implements Persistence {
	private String directoryPath;
	private String appointmentFilePath;
	private File appointmentFile;

	public FilePersistence() {
		// Setting the PlanIt-path to folder "Appointments by PlanIt" in user's
		// documents
		setDirectoryPath(System.getProperty("user.home") + File.separator + "Documents" + File.separator
				+ "Appointments by PlanIt");
		// Setting the appointment.txt file address
		setAppointmentFilePath(directoryPath + File.separator + "appointments.txt");
		// Declare an appointment file
		setAppointmentFile(new File(appointmentFilePath));
		// Call method to create a directory in given path
		createDirectoryIfNotExists(directoryPath);
		// Call method to create "appointments.txt"-file
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
		ArrayList<Appointment> aList = new ArrayList<Appointment>(list);
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return appointmentList;
	}

	public List<Appointment> loadAppointmentsInTimespan(String start, String end) throws IOException {
		// Content of "appointments.txt" is written into String
		String content = readAppointemntFile();

		List<Appointment> appointmentList = new ArrayList<Appointment>();
		if (appointmentFile.length() != 0) {
			// Create ObjectMapper for demarshalling
			ObjectMapper mapper = new ObjectMapper();

			try {
				// Loaded JSON-String is converted to an ArrayList of Appointment objects
				appointmentList = Arrays.asList(mapper.readValue(content, Appointment[].class));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			until here, same as loadAppointments()
//			filtered stream from list to list
			Date startDate = new Date(start);
			Date endDate = new Date(end);
			appointmentList = appointmentList.stream().filter(appointment -> (startDate.before(appointment.getStart())))
					.toList();
			appointmentList = appointmentList.stream().filter(appointment -> (endDate.after(appointment.getStart())))
					.toList();

			return appointmentList;
		}
		return null;
	}

	/*
	 * Read "appointments.txt"-file into String
	 */
	private String readAppointemntFile() throws IOException {
		return Files.readString(Paths.get(appointmentFilePath));
	}

	/*
	 * Appointment with specific ID is being deleted TODO: when having two
	 * appointments in storage, both are being deleted
	 */
	public void deleteAppointment(String id) throws IOException {
		// List of existing appointments is loaded into list
		List<Appointment> list = loadAppointments();
		// List is converted to ArrayList for easier expansion
		ArrayList<Appointment> aList = new ArrayList<Appointment>(list);

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

	public String getDirectoryPath() {
		return directoryPath;
	}

	public void setDirectoryPath(String directoryPath) {
		this.directoryPath = directoryPath;
	}

	public String getAppointmentFilePath() {
		return appointmentFilePath;
	}

	public void setAppointmentFilePath(String appointmentFilePath) {
		this.appointmentFilePath = appointmentFilePath;
	}

	public File getAppointmentFile() {
		return appointmentFile;
	}

	public void setAppointmentFile(File appointmentFile) {
		this.appointmentFile = appointmentFile;
	}
}
