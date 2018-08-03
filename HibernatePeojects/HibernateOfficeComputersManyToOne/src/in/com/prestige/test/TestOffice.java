package in.com.prestige.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.prestige.dto.ComputerDTO;
import in.com.prestige.dto.OfficeDTO;

public class TestOffice {
	// Add Records
	public static void addRecords() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();

			OfficeDTO office = new OfficeDTO();
			office.setOfficeId(102);
			office.setOfficeName("Mangement");
			office.setOfficeAddress("Saket Indore");

			ComputerDTO c1 = new ComputerDTO();
			c1.setComputerId(205);
			c1.setComputerBrand("LENOVO");
			c1.setType("LAPTOP");
			c1.setOfficeId(office);

			ComputerDTO c2 = new ComputerDTO();
			c2.setComputerId(206);
			c2.setComputerBrand("LENOVO");
			c2.setType("DESKTOP");
			c2.setOfficeId(office);

			session.save(c1);
			session.save(c2);
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

	// delet Records
	public static void deleteRecords() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
            OfficeDTO o = new OfficeDTO();
            o.setOfficeId(101);
			//OfficeDTO o = (OfficeDTO)session.get(OfficeDTO.class, 101);
            //ComputerDTO c = new ComputerDTO();
            //c.setComputerId(201);
			session.delete(o);
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

	public static void main(String[] args) throws Exception {
		//addRecords();
		//deleteRecords();
	}
}
