package in.com.prestige.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.prestigemanytoone.dto.AddressDTO;
import in.com.prestigemanytoone.dto.StudentDTO;


public class TestStudent {
	public static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	public static void addRecords() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
		    AddressDTO ad = new AddressDTO();
		    ad.setAddressId(201);
		    ad.setCity("Indore");
		    ad.setState("MP");
		   
			StudentDTO s1 = new StudentDTO();
			s1.setStudentId(101);
			s1.setStudentName("Deependra");
			s1.setAddressId(ad);
			StudentDTO s2 = new StudentDTO();
			s2.setStudentId(102);
			s2.setStudentName("Pankaj");
			s2.setAddressId(ad);
			
		    session.save(s1);
		    session.save(s2);
			
			txn.commit();
			System.out.println("Record Saved");

		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	//Update Records
	public static void updateByParent() throws Exception{
		Session session = null;
		Transaction txn = null;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
		    AddressDTO dto = (AddressDTO)session.get(AddressDTO.class, 201);
		    StudentDTO std = (StudentDTO)session.get(StudentDTO.class, 101);
		    
		    std.setStudentName("Naman");
		    std.setAddressId(dto);
            session.update(std);
            txn.commit();
            System.out.println("Record Updated");
		    
			
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	
	//delete Records
	public static void deleteRecords() throws Exception{
		Session session = null;
		Transaction txn = null;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			StudentDTO s = (StudentDTO)session.get(StudentDTO.class, 101);
			session.delete(s);
			txn.commit();
			System.out.println("Record Deleted");
			
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	//main Method
	public static void main(String[] args) throws Exception{
		//addRecords();
		//updateByParent();
		//deleteRecords();
	}
}
