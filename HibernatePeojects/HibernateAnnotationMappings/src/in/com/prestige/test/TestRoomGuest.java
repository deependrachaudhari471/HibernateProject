package in.com.prestige.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.com.prestige.dto.GuestDTO;
import in.com.prestige.dto.RoomDTO;
import in.com.prestige.uitl.HibernateUtil;

public class TestRoomGuest {
	// Getting Session Object
	public static Session getSession() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return session;
	}

	// Adding Records
	public static void addRecords() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {

			// for time
			Date d = new Date();
			long t = d.getTime();
			Timestamp time = new Timestamp(t);

			session = getSession();
			txn = session.beginTransaction();

			RoomDTO r1 = new RoomDTO();
			r1.setRoomNumber(1111);
			r1.setPricePerDay(3000.0);
			r1.setMaxPerson(3);
			r1.setFloor(2);
			RoomDTO r2 = new RoomDTO();
			r2.setRoomNumber(1112);
			r2.setPricePerDay(5000.0);
			r2.setMaxPerson(3);
			r2.setFloor(5);
			RoomDTO r3 = new RoomDTO();
			r3.setRoomNumber(1113);
			r3.setPricePerDay(6000.0);
			r3.setMaxPerson(3);
			r3.setFloor(2);

			GuestDTO g1 = new GuestDTO();
			g1.setGuestId(101);
			g1.setlName("Chaudhari");
			g1.setfName("Deependra");
			g1.setAddress("Indore");
			g1.setDate(new Date());
			g1.setPhone("2154879865");
			g1.setTime(time);
			GuestDTO g2 = new GuestDTO();
			g2.setGuestId(102);
			g2.setlName("Verma");
			g2.setfName("Vivek");
			g2.setAddress("Indore");
			g2.setDate(new Date());
			g2.setPhone("9865322154");
			g2.setTime(time);

			Set s = new HashSet();
			s.add(g1);
			s.add(g2);

			r1.setGuests(s);
			r2.setGuests(s);
			r3.setGuests(s);

			session.save(r1);
			session.save(r2);
			session.save(r3);
			txn.commit();
			System.out.println("Records Saved");

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// Getting Results
	public static void getResults() throws Exception {
		Session session = null;
		try {
			session = getSession();
			Criteria crit = session.createCriteria(RoomDTO.class);
			List list = crit.list();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				RoomDTO room = (RoomDTO) it.next();
				System.out.println(room.getRoomNumber() + "..." + room.getMaxPerson() + "..." + room.getPricePerDay());
				Set s = room.getGuests();
				Iterator it2 = s.iterator();
				while (it2.hasNext()) {
					GuestDTO g = (GuestDTO) it2.next();
					System.out.println(g.getGuestId()+"..."+g.getfName() + "...." + g.getlName() + "..." + g.getTime());
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// Update By parent
	public static void updateRecords() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = getSession();
			txn = session.beginTransaction();
			RoomDTO room = (RoomDTO)session.get(RoomDTO.class,1111);
			GuestDTO g1 = (GuestDTO)session.get(GuestDTO.class, 101);
			GuestDTO g2 = (GuestDTO)session.get(GuestDTO.class, 102);
			
			room.setPricePerDay(48000.0);
			g1.setfName("Rahul");
			g1.setlName("Athnere");
			g2.setfName("Pankaj");
			g2.setlName("Arya");
			
			Set s = new HashSet();
			s.add(g1);
			s.add(g2);
			
			room.setGuests(s);
			session.update(room);
			txn.commit();
			System.out.println("Record Updated");
			
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
 
	
	//Delete Records
	public static void deleteRecords()throws Exception{
		Session session = null;
		Transaction txn = null;
		try {
			session = getSession();
			txn = session.beginTransaction();
		    GuestDTO g = (GuestDTO)session.get(GuestDTO.class, 101);
			//RoomDTO room = (RoomDTO)session.get(RoomDTO.class, 1111);
			session.delete(g);
			txn.commit();
			System.out.println("Deleted Record");
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
		 //addRecords();
		getResults();
		//updateRecords();
		//deleteRecords();
	}
}
