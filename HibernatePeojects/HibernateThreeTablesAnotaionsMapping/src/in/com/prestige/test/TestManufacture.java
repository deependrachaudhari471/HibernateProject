package in.com.prestige.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.com.prestige.dto.CustomerDTO;
import in.com.prestige.dto.ManufacturedDTO;
import in.com.prestige.dto.VendorDTO;
import in.com.prestige.uitl.HibernateUtil;

public class TestManufacture {
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
    
		// AddRecords
		public static void addRecords() throws Exception {
			Session session = null;
			Transaction txn = null;
			try {
				session = getSession();
				txn = session.beginTransaction();
				ManufacturedDTO m = new ManufacturedDTO();
				m.setMId(1);
				m.setCompanyName("PP");
				
				VendorDTO v1 = new VendorDTO();
				v1.setVendorId(11);
				v1.setVendorName("JIO");
				VendorDTO v2 = new VendorDTO();
				v2.setVendorId(12);
				v2.setVendorName("IDEA");
				
				CustomerDTO c1 = new CustomerDTO();
				c1.setCustomerId(111);
				c1.setCustomerName("Deependra");
				CustomerDTO c2 = new CustomerDTO();
				c2.setCustomerId(112);
				c2.setCustomerName("Rahul");
				
				Set s = new HashSet();
				s.add(c1);
				s.add(c2);
				
				Set s1 = new HashSet();
				s1.add(v1);
				s1.add(v2);
				
				
				v1.setCustomers(s);
				m.setCustomers(s);
				m.setVendors(s1);
				session.save(m);
				session.save(v1);
				txn.commit();
				System.out.println("SuccessFully Saved");
			} catch (Exception e) {
				if (txn != null) {
					txn.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		//main method
		public static void main(String[] args) throws Exception {
			addRecords();
		}
} 
