package in.com.prestige.test;

import java.util.Iterator;
import java.util.List;

import in.com.prestige.dto.AddressDTO;
import in.com.prestige.dto.StudentDTO;
import in.com.prestige.model.StudentAddressModel;

public class TestStudentAddress {
	// For Adding Records In table
	public static void addRecords() throws Exception {
		StudentDTO s = new StudentDTO();
		s.setStudentId(112);
		s.setStudentName("Rahul");
		s.setContactNO("8965322154");

		AddressDTO add = new AddressDTO();
		add.setAddressId(102);
		add.setCity("Bhopal");
		add.setState("MP");
		add.setStudentId(s);

		StudentAddressModel model = new StudentAddressModel();
		String res = model.addRecords(add);
		System.out.println(res);
	}

	// Getting results
	public static void getList() throws Exception {
		StudentAddressModel model = new StudentAddressModel();
		List list = model.getList(new AddressDTO());
		Iterator it = list.iterator();
		while (it.hasNext()) {
			AddressDTO ad = (AddressDTO) it.next();
			System.out.println(ad.getAddressId() + "..." + ad.getCity() + "...." + ad.getState());
			StudentDTO dto = (StudentDTO) ad.getStudentId();
			System.out.println(dto.getStudentId() + "..." + dto.getStudentName() + "..." + dto.getContactNO());
		}
	}

	// Update Records
	public static void updateRecords() throws Exception {
		StudentAddressModel model = new StudentAddressModel();
		String res = model.updateRecords(new Integer(101), new Integer(111));
		System.out.println(res);
	}

	// Delete records
	public static void deleterecords() throws Exception {

		StudentAddressModel model = new StudentAddressModel();
		String res = model.deleteRecords(new Integer(102));
		System.out.println(res);

	}

	// Main Method
	public static void main(String[] args) throws Exception {
		addRecords();
		// getList();
		// updateRecords();
		// deleterecords();
	}
}
