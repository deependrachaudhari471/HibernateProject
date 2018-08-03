package in.com.prestige.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.prestige.dto.AddressDTO;
import in.com.prestige.dto.PersonDTO;

public class TestPerson {
	// Get Records
	public static void getListResults() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
           
			Criteria crit = session.createCriteria(AddressDTO.class);
			List list = crit.list();
			Iterator it = list.iterator();
			while(it.hasNext()){
				AddressDTO address = (AddressDTO)it.next();
				System.out.print("Address Id : "+address.getAddressId());
				System.out.print("  City :"+address.getCity());
				System.out.print("  State :"+address.getState());
				System.out.print("  Zipcode :"+address.getZipcode());
				PersonDTO person = (PersonDTO)address.getPersonID();
				System.out.print("  Person Name : "+person.getfName());
				System.out.println("  PersonId "+person.getPersonID());
			}
             			
			txn.commit();
			

		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	//delete Records;
	public static void updateRecord() throws Exception{
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
           PersonDTO person = (PersonDTO)session.get(PersonDTO.class, 101);
           person.setfName("Vivek");
           person.setlName("Verma");
           session.update(person);
           txn.commit();
           System.out.println("Updated");
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void main(String[] args) throws Exception {
		getListResults();
		//updateRecord();
	}
}
