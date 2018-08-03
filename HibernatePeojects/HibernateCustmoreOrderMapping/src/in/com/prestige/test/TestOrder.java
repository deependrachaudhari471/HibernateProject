package in.com.prestige.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.prestige.dto.CustomerDTO;
import in.com.prestige.dto.OrderDTO;

public class TestOrder {
	// Add Record
	public static void addRecord() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			CustomerDTO cust = new CustomerDTO();
			cust.setCustomerID(101);
			cust.setCustomerName("Deependra");

			OrderDTO o1 = new OrderDTO();
			o1.setOrderId(501);
			o1.setProductName("Mobile");
			o1.setAmount(5000.0);
			o1.setOrderDate(new Date());

			OrderDTO o2 = new OrderDTO();
			o2.setOrderId(502);
			o2.setProductName("Tshirt");
			o2.setAmount(500.0);
			o2.setOrderDate(new Date());

			OrderDTO o3 = new OrderDTO();
			o3.setOrderId(503);
			o3.setProductName("TV");
			o3.setAmount(50000.0);
			o3.setOrderDate(new Date());

			Set s = new HashSet();
			s.add(o1);
			s.add(o2);
			s.add(o3);
			
			cust.setOrders(s);
			session.save(cust);
			txn.commit();
			System.out.println("Saved Succefully");

		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
				e.printStackTrace();
			}
		} finally {
			session.close();
		}
	}

	// Main MEthod
	public static void main(String[] args) throws Exception {
		addRecord();
	}
}
