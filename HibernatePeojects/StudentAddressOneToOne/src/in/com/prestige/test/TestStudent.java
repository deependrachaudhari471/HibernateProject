package in.com.prestige.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.prestige.dto.AddressDTO;
import in.com.prestige.dto.StudentDTO;

public class TestStudent {
	public static SessionFactory factory = new Configuration().configure().buildSessionFactory();

	// add records
	public static void addRecords() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			StudentDTO s = new StudentDTO();
			s.setStudentId(1010);
			s.setStudentName("Deependra");
			StudentDTO s1 = new StudentDTO();
			s1.setStudentId(1020);
			s1.setStudentName("Saurabh");
			

			AddressDTO ad = new AddressDTO();
			ad.setAddressId(2010);
			ad.setCity("Satna");
			ad.setState("MP");
			ad.setStd(s);
			AddressDTO ad1 = new AddressDTO();
			
			ad1.setCity("Indore");
			ad1.setState("MP");
			ad1.setStd(s1);

			session.save(ad);
			session.save(ad1);
			txn.commit();
			System.out.println("Saved Record Succeefully");

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	//Get Result
	public static void getResult() throws Exception{
		Session session = null;
	   try{
		   session = factory.openSession();
		   Criteria crit = session.createCriteria(AddressDTO.class);
		   List list = crit.list();
		   Iterator it = list.iterator();
		   while(it.hasNext()){
			AddressDTO ad = (AddressDTO)it.next();
		   System.out.println(ad.getAddressId());
		   System.out.println(ad.getCity());
		   System.out.println(ad.getState());
		   StudentDTO st = (StudentDTO)ad.getStd();
		   System.out.println(st.getStudentId());
		   System.out.println(st.getStudentName());
		   }
	   }catch (Exception e) {
		   e.printStackTrace();
		} finally {
			session.close();
		}
	   }
	//Delete Records
	public static void deleteRecordsByID() throws Exception{
		Session session = null;
		Transaction txn = null;
		try{
			session = factory.openSession();
			txn = session.beginTransaction();
			//StudentDTO std = (StudentDTO)session.get(StudentDTO.class, 103);
			AddressDTO std = (AddressDTO)session.get(AddressDTO.class, 104);
			session.delete(std);
			txn.commit();
			System.out.println("Record Deleted");
			
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	//Update Records
	public static void updateRecords() throws Exception{
		Session session = null;
		Transaction txn = null;
		try{
			session = factory.openSession();
			txn = session.beginTransaction();
			StudentDTO std = (StudentDTO)session.get(StudentDTO.class, 101);
			AddressDTO ad = (AddressDTO)session.get(AddressDTO.class, std.getStudentId());
			
			std.setStudentName("Rahul");
			ad.setCity("bhopal");
			ad.setStd(std);
            session.update(ad);		
			//session.delete(std);
			txn.commit();
			System.out.println("Record Deleted");
			
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	public static void main(String[] args) throws Exception {
	   addRecords();
		//getResult();
		//deleteRecordsByID();
		//updateRecords();
 	}
}
