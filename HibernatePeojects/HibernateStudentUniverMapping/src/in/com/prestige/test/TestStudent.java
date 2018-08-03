package in.com.prestige.test;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.prestige.dto.UniversityDTO;
import in.com.prestige.dto.StudentDTO;



public class TestStudent {
    //Add Record
	public static void addRecord() throws Exception{
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try{
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		txn = session.beginTransaction();
	    UniversityDTO udto = new UniversityDTO();
	    udto.setuID(101);
	    udto.setuName("RGPV");
	    udto.setCountry("INDIA");
	    
	    StudentDTO s1 = new StudentDTO();
	    s1.setStudentID(201);
	    s1.setFirstName("Deependra");
	    s1.setLastName("Chauhdari");
	    StudentDTO s2 = new StudentDTO();
	    s2.setStudentID(202);
	    s2.setFirstName("Vicek");
	    s2.setLastName("Verma");
	    
		
		
		Set s = new HashSet();
		s.add(s1);
		s.add(s2);

		
		udto.setStudentID(s);
		
		session.save(udto);
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
