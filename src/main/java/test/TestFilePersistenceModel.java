package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.AppointmentModel;
import main.FilePersistenceModel;

public class TestFilePersistenceModel {
	FilePersistenceModel fp;

	@Before
	public void createTestFile() throws IOException {
		fp = new FilePersistenceModel(System.getProperty("user.home") + File.separator + "Documents" + File.separator
				+ "Appointments by PlanIt", File.separator + "appointmentModel_Test.json");
//		generiert Test-Fälle
		try {
			fp.add(new AppointmentModel("12", "Friseur", "2022-03-14", "14-00-00", "2022-03-14", "15-00-00", ""));
			fp.add(new AppointmentModel("85", "Geburtstag", "2022-03-31", "06-00-00", "2022-03-31", "14-00-00", ""));
			fp.add(new AppointmentModel("123", "Zahnarzt", "2022-03-01", "12-00-00", "2022-03-31", "14-00-00", ""));
			fp.add(new AppointmentModel("1020", "Abendessen", "2022-03-25", "21-00-00", "2022-03-26", "01-00-00", ""));
			fp.add(new AppointmentModel("45605", "Silvesterfeier", "2022-12-31", "23-00-00", "2023-01-01", "01-00-00",
					""));
			fp.add(new AppointmentModel("9874", "Urlaub", "2022-03-28", "06-00-00", "2022-04-15", "23-59-59", ""));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@After
	public void deleteTestFile() {
		fp.deleteFile();
	}

	@Test
	public void testLoad() throws IOException {
		// ArrayList from FilePersitence.load()
		List<AppointmentModel> loadedList = fp.load();
		// ArrayList of appointments loaded into storage
		List<AppointmentModel> list = new ArrayList<>();

		list.add(new AppointmentModel("12", "Friseur", "2022-03-14", "14-00-00", "2022-03-14", "15-00-00", ""));
		list.add(new AppointmentModel("85", "Geburtstag", "2022-03-31", "06-00-00", "2022-03-31", "14-00-00", ""));
		list.add(new AppointmentModel("123", "Zahnarzt", "2022-03-01", "12-00-00", "2022-03-31", "14-00-00", ""));
		list.add(new AppointmentModel("1020", "Abendessen", "2022-03-25", "21-00-00", "2022-03-26", "01-00-00", ""));
		list.add(new AppointmentModel("45605", "Silvesterfeier", "2022-12-31", "23-00-00", "2023-01-01", "01-00-00",
				""));
		list.add(new AppointmentModel("9874", "Urlaub", "2022-03-28", "06-00-00", "2022-04-15", "23-59-59", ""));

		// Convert list to array and compare each element by using toString()
		for (int i = 0; i < list.size(); i++) {
			assertEquals(list.toArray()[i].toString(), loadedList.toArray()[i].toString());
		}
	}
}
