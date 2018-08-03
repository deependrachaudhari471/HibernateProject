package in.com.prestige.test;

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
			v.setVendorId(102);
			v.setVendorName("Idea");

			CustomerDTO c1 = new CustomerDTO();
			c1.setCustomerID(201);
			c1.setCustomerName("Deependra");
			//c1.setParentObject(v);

			CustomerDTO c2 = new CustomerDTO();
			c2.setCustomerID(202);
			c2.setCustomerName("Rioshabh");
			// c2.setParentObject(v);

			CustomerDTO c3 = new CustomerDTO();
			c3.setCustomerID(208);
			c3.setCustomerName("Naman");
			// c3.setParentObject(v);
			// Many to One
			/*
			 * session.save(c1); session.save(c2); session.save(c3);
			 */

			// One To Many
			Set s = new HashSet();
			s.add(c1);
			s.add(c2);
			s.add(c3);

			v.setChildren(s);
			session.save(v);

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

	// delete Records
	public static void deleteRecords() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();

			 CustomerDTO cust = (CustomerDTO)session.get(CustomerDTO.class, 208);
			 //VendorDTO vendor = (VendorDTO)session.get(VendorDTO.class, 101);
			//CustomerDTO cust = new CustomerDTO();
			//cust.setCustomerID(202);
			 session.evict(cust);
			session.delete(cust);
			txn.commit();
			System.out.println("Records Deleted");
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// update Record
	public static void updateRecord() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
		    VendorDTO vendor = (VendorDTO)session.get(VendorDTO.class, 102);
		    vendor.setVendorName("VODAFONE");
		    session.update(vendor);
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
//getListRecord
	public static void getList()throws Exception{
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			Criteria crit = session.createCriteria(VendorDTO.class);
			
			VendorDTO vendor = new VendorDTO();
			List list = crit.list();
			Iterator it = list.iterator();
			while(it.hasNext()){
				VendorDTO v = (VendorDTO)it.next();
				System.out.print("VendorId : "+v.getVendorId());
				System.out.println("  VendorName : "+v.getVendorName());
				 Set s = v.getChildren();
				 Iterator it2 = s.iterator();
				 while(it2.hasNext()){
					 CustomerDTO c = (CustomerDTO)it2.next();
					 System.out.print("  CustomerId :"+c.getCustomerID());
					 System.out.println("  Name : "+c.getCustomerName());
				
				 }
				 
			}
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	public static void main(String[] args) throws Exception {
		addRecords();
		//deleteRecords();
		//updateRecord();
		//getList();
	}
}
