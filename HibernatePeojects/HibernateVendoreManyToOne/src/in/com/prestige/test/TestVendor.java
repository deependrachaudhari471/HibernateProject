package in.com.prestige.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.prestige.dto.CustomerDTO;
import in.com.prestige.dto.VendorDTO;

public class TestVendor {
	// Add Records
	public static void addRecords() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();

			VendorDTO v = new VendorDTO();
			v.setVendorId(101);
			v.setVendorName("JIO");

			CustomerDTO c1 = new CustomerDTO();
			c1.setCustomerID(201);
			c1.setCustomerName("Deependra");
			c1.setParentObject(v);

			CustomerDTO c2 = new CustomerDTO();
			c2.setCustomerID(202);
			c2.setCustomerName("Rishabh");
			c2.setParentObject(v);

			CustomerDTO c3 = new CustomerDTO();
			c3.setCustomerID(203);
			c3.setCustomerName("Vivek");
			c3.setParentObject(v);

			session.save(c1);
			session.save(c2);
			session.save(c3);

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

	public static void main(String[] args) throws Exception {
		addRecords();
	}
}
