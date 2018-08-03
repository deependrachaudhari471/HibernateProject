package in.com.prestige.test;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.prestige.dto.DepartmentDTO;
import in.com.prestige.dto.EmployeeDTO;



public class TestEmployee {
    //Add Record
	public static void addRecord() throws Exception{
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try{
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		txn = session.beginTransaction();
		DepartmentDTO depart = new DepartmentDTO();
		depart.setDepartmentId(102);
		depart.setDeptName("Management");
		
		EmployeeDTO emp1 = new EmployeeDTO();
		emp1.setEmployeeId(504);
		emp1.setFirsName("Pankaj");
		emp1.setLastName("Arya");
		emp1.setBirthDate(new Date());
		
		EmployeeDTO emp2 = new EmployeeDTO();
		emp2.setEmployeeId(505);
		emp2.setFirsName("Vijay");
		emp2.setLastName("Verma");
		emp2.setBirthDate(new Date());
		
		EmployeeDTO emp3 = new EmployeeDTO();
		emp3.setEmployeeId(506);
		emp3.setFirsName("Vivek");
		emp3.setLastName("Verma");
		emp3.setBirthDate(new Date());
		
		Set s = new HashSet();
		s.add(emp1);
		s.add(emp2);
		s.add(emp3);
		
		depart.setChildren(s);
		
		session.save(depart);
		txn.commit();
		System.out.println("Saved Succefully");
		
		}catch(HibernateException e){
			if(txn!= null){
				txn.rollback();
				e.printStackTrace();
			}
		}finally {
			session.close();
		}
	}
	
	//Main MEthod
	public static void main(String[] args) throws Exception {
		addRecord();
	}
}
