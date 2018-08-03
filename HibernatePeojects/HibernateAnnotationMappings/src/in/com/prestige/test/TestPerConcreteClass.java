package in.com.prestige.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.com.prestige.tableperconcrete.ChequeDTO;
import in.com.prestige.tableperconcrete.CreditCardDTO;
import in.com.prestige.uitl.HibernateUtil;

public class TestPerConcreteClass {
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
	public static void addRecords() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = getSession();
			txn = session.beginTransaction();

			CreditCardDTO credit = new CreditCardDTO();
			credit.setPaymentId(101);
			credit.setAmount(300.0);
			credit.setCreditCardType("Master");

			ChequeDTO chek = new ChequeDTO();
			chek.setAmount(600.0);
			chek.setPaymentId(102);
			chek.setChequeType("SBI");

			session.save(chek);
			session.save(credit);
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

	// MainMethod
	public static void main(String[] args) throws Exception {
		addRecords();
	}
}
