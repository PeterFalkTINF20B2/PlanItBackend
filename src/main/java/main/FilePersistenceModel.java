package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class FilePersistenceModel {
	private String directoryPath;
	private String appointmentFilePath;
	private File appointmentFile;
	
	public FilePersistenceModel(String directoryPath, String appointmentFilePath) {
		// Setting the PlanIt-path to folder "Appointments by PlanIt" in user's
		// documents
		
//		setDirectoryPath(System.getProperty("user.home") + File.separator + "Documents" + File.separator
//				+ "Appointments by PlanIt");
//		// Setting the appointment.txt file address
//		setAppointmentFilePath(directoryPath + File.separator + "appointments.txt");
		
		this.directoryPath = directoryPath;
		this.appointmentFilePath = directoryPath + appointmentFilePath;
		
		// Declare an appointment file
		setAppointmentFile(new File(this.appointmentFilePath));
		// Call method to create a directory in given path
		createDirectoryIfNotExists(this.directoryPath);
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
	 * delete the local File
	 */
	public boolean deleteFile() {
		return this.appointmentFile.delete();
	}

	/*
	 * An ArrayList of AppointmentModel is converted to JSON-format and returned as
	 * String
	 */
	public String convertAppointmentModelListToJSON(ArrayList<AppointmentModel> appntmnts) throws JsonProcessingException {
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
	public void add(AppointmentModel apMod) throws IOException {
		// List of existing appointments is loaded into list
		List<AppointmentModel> list = load();

		// List is converted to ArrayList for easier expansion
		ArrayList<AppointmentModel> aList = new ArrayList<AppointmentModel>(list);
		// New appointment is added to list
		aList.add(apMod);

		// ArrayList is converted to JSON and returned as String
		String json = convertAppointmentModelListToJSON(aList);
		// JSON-String is written into "appointments.txt"-file
		BufferedWriter writer = new BufferedWriter(new FileWriter(appointmentFile));
		writer.write(json);
		writer.close();
	}
	
	/*
	 * Appointments are loaded from "appointments.txt"-file and returned as a List
	 */
	public List<AppointmentModel> load() throws IOException {
		// Content of "appointments.txt" is written into String
		String content = readAppointemntFile();

		List<AppointmentModel> appointmentList = new ArrayList<AppointmentModel>();
		if (appointmentFile.length() != 0) {
			// Create ObjectMapper for demarshalling
			ObjectMapper mapper = new ObjectMapper();

			try {
				// Loaded JSON-String is converted to an ArrayList of Appointment objects
				appointmentList = Arrays.asList(mapper.readValue(content, AppointmentModel[].class));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return appointmentList;
	}
	
	/*
	 * same as loadAppointmentsInTimespan, but returns AppointmentModel
	 */
	public List<AppointmentModel> loadInTimespan(String start, String end) throws IOException {
		// Content of "appointments.txt" is written into String
		String content = readAppointemntFile();
		
		List<AppointmentModel> appointmentModelList = new ArrayList<AppointmentModel>();
		if (appointmentFile.length() != 0) {
			// Create ObjectMapper for demarshalling
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				// Loaded JSON-String is converted to an ArrayList of Appointment objects
				appointmentModelList = Arrays.asList(mapper.readValue(content, AppointmentModel[].class));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
//			until here, same as loadAppointments()
//			filtered stream from list to list
			LocalDate startDate = LocalDate.parse(start);
			LocalDate endDate = LocalDate.parse(end);
			appointmentModelList = appointmentModelList.stream().filter(appointmentModel -> (startDate.isBefore(LocalDate.parse(appointmentModel.getStart()))))
					.collect(Collectors.toList());
			appointmentModelList = appointmentModelList.stream().filter(appointmentModel -> (endDate.isAfter(LocalDate.parse(appointmentModel.getEnd()))))
					.collect(Collectors.toList());
			return appointmentModelList;
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
	 * Appointment with specific ID is being deleted
	 */
	public void deleteAppointmentModel(String id) throws IOException {
		// List of existing appointments is loaded into list
		List<AppointmentModel> list = load();
		// List is converted to ArrayList for easier expansion
		ArrayList<AppointmentModel> aList = new ArrayList<>(list);

		// Find matching ID and remove appointment from ArrayList
		for (int i = 0; i < aList.size(); i++) {
			if (aList.get(i).getId().equals(id)) {
				aList.remove(i);
			}
		}}
	
		/*
		 * Takes given appointment, searches Id,
		 * then replaces old appointment with same Id
		 */
		public void updateAppointment(AppointmentModel apMod) throws IOException{
			// List of existing appointments is loaded into list
			List<AppointmentModel> list = load();
			// List is converted to ArrayList for easier expansion
			ArrayList<AppointmentModel> aList = new ArrayList<>(list);
			
			// Find matching ID and remove appointment from ArrayList
			for (int i = 0; i < aList.size(); i++) {
				if (aList.get(i).getId().equals(apMod.getId())) {
					aList.remove(i);
					aList.add(i, apMod);
				}
			}
			
			// Convert ArrayList to JSON-Format
			String newContent = convertAppointmentModelListToJSON(aList);
			// Write JSON-String to "appointments.txt"-file
			BufferedWriter writer = new BufferedWriter(new FileWriter(appointmentFile));
			writer.write(newContent);
			writer.close();
		}
	
	/*
	 * Getter- and Setter-Section
	 */
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
	
	/*
	 * Mainmethod for testing
	 */
	public static void main(String[] args) {
		FilePersistenceModel fp = new FilePersistenceModel(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Appointments by PlanIt",
				 File.separator + "appointmentModel_Test.json");
		List<AppointmentModel> listout = new ArrayList<>();
		try {
			fp.add(new AppointmentModel("12", "Friseur", "Other","2022-03-14", "14-00-00", "2022-03-14","15-00-00", ""));
			fp.add(new AppointmentModel("85", "Geburtstag", "Family","2022-03-31","06-00-00", "2022-03-31","14-00-00", ""));
			fp.add(new AppointmentModel("123", "Zahnarzt", "Doctor", "2022-03-01","12-00-00","2022-03-31","14-00-00", ""));
			fp.add(new AppointmentModel("1020", "Abendessen", "Friends", "2022-03-25","21-00-00", "2022-03-26","01-00-00", ""));
			fp.add(new AppointmentModel("45605", "Silvesterfeier", "Family", "2022-12-31","23-00-00", "2023-01-01","01-00-00", ""));
			fp.add(new AppointmentModel("9874", "Urlaub", "Sports", "2022-03-28","06-00-00", "2022-04-15","23-59-59", ""));
			listout = fp.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (AppointmentModel appointmentModel : listout) {
			try {
				fp.deleteAppointmentModel(appointmentModel.getId());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
