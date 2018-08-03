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

import in.com.prestige.dto.AddressDTO;
import in.com.prestige.dto.StudentDTO;

public class TestStudent {
	// Add Records
	public static void addRecords() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();

			StudentDTO std = new StudentDTO();
			std.setsId(101);
			std.setsName("Deependra");

			AddressDTO p1 = new AddressDTO();
			p1.setAddressId(201);
			p1.setAddresType("Local Address");
			p1.setCity("Indore");
			p1.setState("MP");

			AddressDTO p2 = new AddressDTO();
			p2.setAddressId(202);
			p2.setAddresType("Permanent Address");
			p2.setCity("Satna");
			p2.setState("MP");

			/*
			 * session.save(p1); session.save(p2);
			 */
			Set s = new HashSet();
			s.add(p1);
			s.add(p2);

			std.setAddressId(s);
			session.save(std);

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
	/*
	 * public static void deleteRecords() throws Exception { SessionFactory
	 * factory = null; Session session = null; Transaction txn = null; try {
	 * factory = new Configuration().configure().buildSessionFactory(); session
	 * = factory.openSession(); txn = session.beginTransaction();
	 * 
	 * PassengersDTO cust = (PassengersDTO)session.get(PassengersDTO.class,
	 * 208); //VendorDTO vendor = (VendorDTO)session.get(VendorDTO.class, 101);
	 * //CustomerDTO cust = new CustomerDTO(); //cust.setCustomerID(202);
	 * session.evict(cust); session.delete(cust); txn.commit();
	 * System.out.println("Records Deleted"); } catch (HibernateException e) {
	 * if (txn != null) { txn.rollback(); } e.printStackTrace(); } finally {
	 * session.close(); } }
	 * 
	 * // update Record public static void updateRecord() throws Exception {
	 * SessionFactory factory = null; Session session = null; Transaction txn =
	 * null; try { factory = new
	 * Configuration().configure().buildSessionFactory(); session =
	 * factory.openSession(); txn = session.beginTransaction(); TrainDTO vendor
	 * = (TrainDTO)session.get(TrainDTO.class, 102);
	 * vendor.setVendorName("VODAFONE"); session.update(vendor); txn.commit();
	 * System.out.println("Updated"); } catch (HibernateException e) { if (txn
	 * != null) { txn.rollback(); } e.printStackTrace(); } finally {
	 * session.close(); } } //getListRecord public static void getList()throws
	 * Exception{ SessionFactory factory = null; Session session = null; try {
	 * factory = new Configuration().configure().buildSessionFactory(); session
	 * = factory.openSession(); Criteria crit =
	 * session.createCriteria(TrainDTO.class);
	 * 
	 * TrainDTO vendor = new TrainDTO(); List list = crit.list(); Iterator it =
	 * list.iterator(); while(it.hasNext()){ TrainDTO v = (TrainDTO)it.next();
	 * System.out.print("VendorId : "+v.getVendorId());
	 * System.out.println("  VendorName : "+v.getVendorName()); Set s =
	 * v.getChildren(); Iterator it2 = s.iterator(); while(it2.hasNext()){
	 * PassengersDTO c = (PassengersDTO)it2.next();
	 * System.out.print("  CustomerId :"+c.getCustomerID());
	 * System.out.println("  Name : "+c.getCustomerName());
	 * 
	 * }
	 * 
	 * }
	 * 
	 * } catch (HibernateException e) {
	 * 
	 * e.printStackTrace(); } finally { session.close(); } }
	 */
	public static void main(String[] args) throws Exception {
		addRecords();
		// deleteRecords();
		// updateRecord();
		// getList();
	}
}
