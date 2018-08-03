package in.com.prestige.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.prestigeonetomanybidirectional.PassengerDTO;
import in.com.prestigeonetomanybidirectional.TrainDTO;

public class TestTrain {
	public static SessionFactory factory = new Configuration().configure().buildSessionFactory();

	// Add Train Records
	public static void addRecords() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			TrainDTO t = new TrainDTO();
			t.setTainNo(102);
			t.setTrainName("Kota-indore");

			PassengerDTO p1 = new PassengerDTO();
			p1.setPassengerId(203);
			p1.setPassengerName("Rahul");
			PassengerDTO p2 = new PassengerDTO();
			p2.setPassengerId(204);
			p2.setPassengerName("Naman");

			Set s = new HashSet();
			s.add(p2);
			s.add(p1);

			t.setPassengers(s);
			session.save(t);
			txn.commit();
			System.out.println("Saved Record Succefully");

		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// update Records
	public static void updateRecords()throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
            TrainDTO dto = (TrainDTO)session.get(TrainDTO.class, 101);
            PassengerDTO p1 = (PassengerDTO)session.get(PassengerDTO.class, 201);
            PassengerDTO p2 = (PassengerDTO)session.get(PassengerDTO.class, 202);
            dto.setTrainName("Shipra Express");
            p1.setPassengerName("Prabhat");
            p2.setPassengerName("Luvkush");
            Set s = new HashSet();
            s.add(p1);
            s.add(p2);
            dto.setPassengers(s);
            session.update(dto);
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

	public static void main(String[] args) {
		try {
			//addRecords();
			updateRecords();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
