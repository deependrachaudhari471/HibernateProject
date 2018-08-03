package in.com.prestige.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.com.prestige.dto.CustomersDTO;
import in.com.prestige.dto.VendorDTO;
import in.com.prestige.uitl.HibernateUtil;

public class TestVendorCustomer {
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

			CustomersDTO c1 = new CustomersDTO();
			c1.setCustomerId(103);
			c1.setCustomerName("Harhsit");
			c1.setAddress("Indore");

			CustomersDTO c2 = new CustomersDTO();
			c2.setCustomerId(104);
			c2.setCustomerName("Pankaj");
			c2.setAddress("Satna");

			VendorDTO v = new VendorDTO();
			v.setVendorId(2);
			v.setVendorName("IDEA");

			Set s = new HashSet();
			s.add(c1);
			s.add(c2);

			v.setCustomers(s);
			session.save(v);
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

	// GetResults
	public static void getList() throws Exception {
		Session session = null;
		try {
			session = getSession();
			Criteria crit = session.createCriteria(VendorDTO.class);
			List list = crit.list();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				VendorDTO v = (VendorDTO) it.next();
				System.out.println(v.getVendorId() + "..." + v.getVendorName());
				Set s = v.getCustomers();
				Iterator it2 = s.iterator();
				while (it2.hasNext()) {
					CustomersDTO c = (CustomersDTO) it2.next();
					System.out.println(c.getCustomerId() + "..." + c.getAddress() + "..." + c.getCustomerName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			session.close();
		}
	}

	// Update By Parent
	public static void updaterecords() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = getSession();
			txn = session.beginTransaction();
			VendorDTO v = (VendorDTO) session.get(VendorDTO.class, 2);
			
			CustomersDTO c1 = (CustomersDTO) session.get(CustomersDTO.class, 103);
			//CustomersDTO c2 = (CustomersDTO) session.get(CustomersDTO.class, 101);
			v.setVendorName("Vodafone");
			c1.setCustomerName("Harhsit");
			//c2.setCustomerName("Ram");
			Set s = new HashSet();
			s = v.getCustomers();
			s.add(c1);
			//s.add(c2);
			v.setCustomers(s);
			session.update(v);
			txn.commit();
			System.out.println("Updatd Succefully");

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// Delete Records
	public static void deleteRecords() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = getSession();
			txn = session.beginTransaction();
			CustomersDTO c = (CustomersDTO)session.get(CustomersDTO.class, 101);
			session.delete(c);
			txn.commit();
			System.out.println("Records Deleted");
			
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
		// addRecords();
		 //getList();
		//updaterecords();
		//deleteRecords();
	}
}
