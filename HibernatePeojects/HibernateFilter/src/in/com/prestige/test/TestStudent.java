package in.com.prestige.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;

import in.com.presstige.dto.StudentDTO;
import in.com.prestige.model.StudentModel;

public class TestStudent {
	// Add Students
	public static void addStudents() throws Exception {
		try {
			StudentDTO dto = new StudentDTO();
			dto.setStudentName("Aman");
			dto.setAddress("Indore");
			dto.setAge(16);
			StudentModel model = new StudentModel();
			String res = model.addStudents(dto);
			System.out.println(res);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	// GetResults
	public static void getStudents(int age) throws Exception {
		try {
			StudentModel model = new StudentModel();
			List<StudentDTO> list = model.getList(age);
			Iterator<StudentDTO> it = list.iterator();
			while (it.hasNext()) {
				StudentDTO st = (StudentDTO) it.next();
				System.out.println(st.getStudentID() + "...." + st.getStudentName() + "..." + st.getAddress() + "..."
						+ st.getAge());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		// addStudents();
		getStudents(20);
	}
}
