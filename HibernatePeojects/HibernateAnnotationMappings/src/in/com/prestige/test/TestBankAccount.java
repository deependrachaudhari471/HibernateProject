package in.com.prestige.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.com.prestige.dto.AccountHoldersDTO;
import in.com.prestige.dto.BankDTO;
import in.com.prestige.uitl.HibernateUtil;

public class TestBankAccount {

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

	// Adding Records
	public static void addRecords() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = getSession();
			txn = session.beginTransaction();
			BankDTO b = new BankDTO();
			b.setBankId(102);
			b.setBankName("UBI");
			b.setAddress("78 Indore");

			AccountHoldersDTO ac1 = new AccountHoldersDTO();
			ac1.setAccountNo(7896);
			ac1.setName("Naman");
			ac1.setPhone("6593212");
			ac1.setBankId(b);

			AccountHoldersDTO ac2 = new AccountHoldersDTO();
			ac2.setAccountNo(7895);
			ac2.setName("Aman");
			ac2.setPhone("6593212");
			ac2.setBankId(b);

			session.save(ac1);
			session.save(ac2);
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

	// Getting results
	public static void getList() throws Exception {
		Session session = null;
		try {
			session = getSession();
			Criteria crit = session.createCriteria(AccountHoldersDTO.class);
			List list = crit.list();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				AccountHoldersDTO ac = (AccountHoldersDTO) it.next();
				System.out.println(ac.getAccountNo() + "..." + ac.getName() + "..." + ac.getPhone());
				BankDTO b = (BankDTO) ac.getBankId();
				System.out.println(b.getBankId() + "..." + b.getBankName() + "..." + b.getAddress());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// Update Records
	public static void updateRecords() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = getSession();
			txn = session.beginTransaction();
			AccountHoldersDTO ac = (AccountHoldersDTO) session.get(AccountHoldersDTO.class, 5478);
			ac.setName("Prabhat");
			BankDTO b = (BankDTO) session.get(BankDTO.class, 101);
			b.setBankName("BOI");
			ac.setBankId(b);
			session.update(ac);
			txn.commit();
			System.out.println("Record Updated");

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
			//AccountHoldersDTO ac = (AccountHoldersDTO)session.get(AccountHoldersDTO.class,5478);
			BankDTO b = (BankDTO)session.get(BankDTO.class, 101);
			session.delete(b);
			txn.commit();
			System.out.println("Record deleted");
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
		// updateRecords();
		deleteRecords();
	}

}
