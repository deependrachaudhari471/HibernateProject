package in.com.prestige.test;


import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.prestige.dto.BooksDTO;
import in.com.prestige.dto.LibraryDTO;

public class TestLibrary {
	//Add Redords
	public static void addRecords() throws Exception{
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try{
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			
			LibraryDTO lib = new LibraryDTO();
			lib.setLibraryCode(1122);
			lib.setLibraryName("Central");
			
			BooksDTO b = new BooksDTO();
			b.setBookId(204);
			b.setBookName("PHP");
			b.setAuthorName("ABC");
			b.setPrice(700.0);
			//b.setLibId(lib);
			
			BooksDTO b1 = new BooksDTO();
			b1.setBookId(205);
			b1.setBookName("JAVA");
			b1.setAuthorName("ABC2");
			b1.setPrice(800.0);
			//b1.setLibId(lib);
			
			BooksDTO b3 = new BooksDTO();
			b3.setBookId(206);
			b3.setBookName("NET");
			b3.setAuthorName("ABC9");
			b3.setPrice(900.0);
			//b3.setLibId(lib);
			//many to one
			/*session.save(b);
			session.save(b1);
			session.save(b3);*/
			
			//One To Many
			Set s = new HashSet();
			s.add(b);
			s.add(b1);
			s.add(b3);
			
			lib.setBooksID(s);
			session.save(lib);
			
			txn.commit();
			System.out.println("Saved successfully");
		}catch(HibernateException e){
			if(txn!=null){
				txn.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	 //Delete records
	public static void deleteRecords()throws Exception{
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try{
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			//BooksDTO b = (BooksDTO)session.get(BooksDTO.class, 204);
			LibraryDTO b = (LibraryDTO)session.get(LibraryDTO.class, 1122);
			session.delete(b);
			txn.commit();
			System.out.println("Deleted");
	}catch(HibernateException e){
		if(txn!=null){
			txn.rollback();
		}
		e.printStackTrace();
	}finally{
		session.close();
	}
	}
	
	//Main Method
	public static void main(String[] args)throws Exception {
      //addRecords();
		deleteRecords();
	}
}
