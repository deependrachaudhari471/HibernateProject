package in.com.prestige.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.prestige.dto.VehicleDTO;
import in.com.prestige.dto.UserDTO;

public class TestUser {
	// Add Records
	public static void addRecords() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();

			UserDTO user = new UserDTO();
			user.setUserId(102);
			user.setUserName("Saurabh");
			user.setPhone("45327898");
			user.setUserAddress("Indore");

			VehicleDTO v1 = new VehicleDTO();
			v1.setVehicleId(505);
			v1.setVehicleName("TATA");
			v1.setUserid(user);

			VehicleDTO v2 = new VehicleDTO();
			v2.setVehicleId(506);
			v2.setVehicleName("Mahindra kuv");
			v2.setUserid(user);

			session.save(v1);
			session.save(v2);

			txn.commit();
			System.out.println("Saved Succefully");

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
	public static void updateRecord() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			UserDTO user = (UserDTO) session.get(UserDTO.class, 101);
			user.setUserName("Rishabh");
			session.update(user);
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
		// addRecords();
		updateRecord();
	}
}
