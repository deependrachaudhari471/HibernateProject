package in.com.prestige.test;

import java.util.Iterator;
import java.util.List;

import in.com.prestige.dto.StudentDTO;
import in.com.prestige.model.StudentModel;

public class TestStudent {
	// Add Records
	public static void addRecords() throws Exception {
		try {
			StudentDTO dto = new StudentDTO();
			dto.setStudentName("Saurbah Khare");
			dto.setAddress("Bhopal");
			dto.setConatanctNo("21547896");
			StudentModel model = new StudentModel();
			String res = model.addRecords(dto);
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Getting Results
	public static void getResults() throws Exception {
		try {
			StudentModel model = new StudentModel();
			List<StudentDTO> list = model.getListResults();
			Iterator<StudentDTO> it = list.iterator();
			while (it.hasNext()) {
				StudentDTO dto = it.next();
				System.out.println(dto.getStudentID() + "..." + dto.getStudentName() + "...." + dto.getAddress() + "..."
						+ dto.getConatanctNo());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Update Records
	public static void updateRecord()throws Exception{
		try{
			StudentModel model = new StudentModel();
			StudentDTO dto = new StudentDTO();
			dto.setStudentID(1);
			dto.setStudentName("Rahul Atherner");
			dto.setAddress("Nagpur");
			String res = model.updateStudents(dto);
			System.out.println(res);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	// MainMethod
	public static void main(String[] args) throws Exception {
		//addRecords();
	   // getResults();
		//updateRecord();
	}
}
