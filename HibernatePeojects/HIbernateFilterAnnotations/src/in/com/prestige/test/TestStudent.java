package in.com.prestige.test;

import java.util.Iterator;
import java.util.List;

import in.com.prestige.dto.StudentDTO;
import in.com.prestige.model.StudentModel;

public class TestStudent {
	public static void addRecords() throws Exception {
		StudentDTO dto = new StudentDTO();
		StudentModel model = new StudentModel();

		dto.setStudentName("Aman");
		dto.setAddress("78 Indore");
		dto.setAge(15);
		String res = model.addRecords(dto);
		System.out.println(res);
	}
    
	//Getting Results
	public static void getList(int age) throws Exception{
		StudentModel model = new StudentModel();
		List<StudentDTO> list = model.getList(age);
		Iterator<StudentDTO> it = list.iterator();
		while(it.hasNext()){
			StudentDTO dto = it.next();
			System.out.println(dto.getStudentName());
		}
	}
	// main Method
	public static void main(String[] args) throws Exception {
		//addRecords();
		getList(10);
	}
}
