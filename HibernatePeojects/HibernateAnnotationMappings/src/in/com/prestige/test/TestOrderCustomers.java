package in.com.prestige.test;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.com.prestige.dto.CustomerOrderDTo;
import in.com.prestige.dto.OrderDTO;
import in.com.prestige.dto.VendorDTO;
import in.com.prestige.uitl.HibernateUtil;

public class TestOrderCustomers {
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

	// Add Records
	public static void addRecordsForParent() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = getSession();
			txn = session.beginTransaction();
			CustomerOrderDTo c = new CustomerOrderDTo();
			c.setcId(101);
			c.setName("Deependra");
			session.save(c);
			txn.commit();
			System.out.println("Sucessfully Saved");
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void addRecordsForChild() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = getSession();
			txn = session.beginTransaction();
			CustomerOrderDTo c = (CustomerOrderDTo) session.get(CustomerOrderDTo.class, 101);
			// OrderDTO o = (OrderDTO)session.get(OrderDTO.class, (Serializable)
			// c.getOrders());
			OrderDTO o1 = new OrderDTO();
			o1.setoId(208);
			o1.setProductName("Fridge");
			Set s = new HashSet();
			s.add(o1);
			// s.add(c.getOrders());
			c.setOrders(s);
			// c.setOrders(c.getOrders());
			session.save(c);
			txn.commit();
			System.out.println("Sucessfully Saved");
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// Main Method
	public static void main(String[] args) throws Exception {
		// addRecordsForParent();
		addRecordsForChild();
	}
}
