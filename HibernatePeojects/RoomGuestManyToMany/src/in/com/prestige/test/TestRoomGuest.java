package in.com.prestige.test;


import java.sql.Time;
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
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import in.com.prestige.dto.RoomDTO;
import in.com.prestige.dto.GuestDTO;

public class TestRoomGuest {
	// Add records
	public static void addRecords() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			//for time stamp
			Date d = new Date();
			long t = d.getTime();
			Timestamp time = new Timestamp(t);
			
			
			GuestDTO g1 = new GuestDTO();
			g1.setGuestId(101);
			g1.setfName("Deependra");
			g1.setlName("Chaudhari");
			g1.setPhone("2154879865");
			g1.setAddress("Indore");
			g1.setDate(new Date());
			g1.setTime(time);
			GuestDTO g2 = new GuestDTO();
			g2.setGuestId(102);
			g2.setfName("Rahul");
			g2.setlName("Athnere");
			g2.setPhone("2154879865");
			g2.setAddress("Bhopal");
			g2.setDate(new Date());
			g2.setTime(time);
			GuestDTO g3 = new GuestDTO();
			g3.setGuestId(103);
			g3.setfName("Saurabh");
			g3.setlName("Khare");
			g3.setPhone("2154879865");
			g3.setAddress("Satna");
			g3.setDate(new Date());
			g3.setTime(time);
			
			//set rooms
			RoomDTO r1 = new RoomDTO();
			r1.setRoomNumber(1111);
			r1.setPricePerDay(6000.0);
			r1.setFloor(2);
			r1.setMaxPerson(3);
			RoomDTO r2 = new RoomDTO();
			r2.setRoomNumber(1112);
			r2.setPricePerDay(6000.0);
			r2.setFloor(2);
			r2.setMaxPerson(6);
			
			Set s = new HashSet();
			s.add(r1);
			s.add(r2);
			Set s1 = new HashSet();
			s1.add(r1);
			
			g1.setRooms(s);
			g2.setRooms(s);
			g3.setRooms(s1);
			
			session.save(g1);
			session.save(g2);
			session.save(g3);

			txn.commit();
			System.out.println("Saved record");

		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// Get Records
	public static void getReocrds() throws Exception {
		SessionFactory factory = null;
		Session session = null;

		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			Criteria crit = session.createCriteria(GuestDTO.class);
			//crit.add(Restrictions.eq("studentId", 101));
			List list = crit.list();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				GuestDTO g = (GuestDTO) it.next();
				System.out.print("GuestID : " + g.getGuestId());
				System.out.print("  F_NAME : " + g.getfName());
				System.out.print("  L_NAME : " + g.getlName());
				System.out.print("  Phone : " + g.getPhone());
				System.out.println("  EntryTime : " + g.getTime());
				Set set = g.getRooms();
				Iterator it2 = set.iterator();
				while (it2.hasNext()) {
					RoomDTO c = (RoomDTO) it2.next();
					System.out.print("RoomId :" + c.getRoomNumber());
					System.out.println("  RoomFloor : " + c.getFloor());
					
				}
			}
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	//delete RecordsUsing ThirdTable
	public static void deletRecordsThirdTable()throws Exception{
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			GuestDTO gst = (GuestDTO)session.get(GuestDTO.class, 101);
			RoomDTO rm = (RoomDTO)session.get(RoomDTO.class, 1111);
			gst.getRooms().remove(rm);
			
			session.save(gst);
			txn.commit();
			System.out.println("Deleted");
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	//Delete records
	/*public static void deletRecords()throws Exception{
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			//StudentDTO std = (StudentDTO)session.get(StudentDTO.class, 102);
			RoomDTO std = (RoomDTO)session.get(RoomDTO.class, 201);
			session.delete(std);
			txn.commit();
			System.out.println("Deleted");
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
	public static void updateRecords()throws Exception{
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			GuestDTO std = (GuestDTO)session.get(GuestDTO.class, 102);
			//System.out.println(std.getCourses());
			std.setStudentName("Manan");
			session.update(std);
			txn.commit();
			System.out.println("Updated");
			
		}catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}*/
	public static void main(String[] args) throws Exception {
		//addRecords();
		getReocrds();
	    //deletRecordsThirdTable();
		//deletRecords();
		//updateRecords();
	}
}
