package in.com.prestige.model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import in.com.prestige_table_per_class.dto.ChequeDTO;
import in.com.prestige_table_per_class.dto.CreditCardDTO;

public class TablePerClassModel {
	private static SessionFactory factory = null;

	// get Session
	private static Session getSession() throws Exception {
		Session session = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return session;
	}

	// Add Records in paymentTablePerClass
	public static String addRecords(ChequeDTO cheque, CreditCardDTO credit) throws Exception {
		Session s = null;
		Transaction txn = null;
		String res = null;
		try {
			s = getSession();
			txn = s.beginTransaction();
			s.save(cheque);
			s.save(credit);
			txn.commit();
			res = "Record Saved";
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			s.close();
		}
		return res;
	}

	// Add Records in paymentTablePerSubClass
	public  String addRecords(in.com.prestige_table_per_subclass.dto.ChequeDTO cheque,
			in.com.prestige_table_per_subclass.dto.CreditCardDTO credit) throws Exception {
		Session s = null;
		Transaction txn = null;
		String res = null;
		try {
			s = getSession();
			txn = s.beginTransaction();
			s.save(cheque);
			s.save(credit);
			txn.commit();
			res = "Record Saved";
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			s.close();
		}
		return res;
	}
	
	// Add Records in paymentTablePerconcreteClass
		public String addRecordsConcrete(in.com.prestige_table_per_concrete_class.dto.ChequeDTO cheque,
				in.com.prestige_table_per_concrete_class.dto.CreditCardDTO credit) throws Exception {
			Session s = null;
			Transaction txn = null;
			String res = null;
			try {
				s = getSession();
				txn = s.beginTransaction();
				s.save(cheque);
				s.save(credit);
				txn.commit();
				res = "Record Saved";
			} catch (HibernateException e) {
				if (txn != null) {
					txn.rollback();
				}
				e.printStackTrace();
			} finally {
				s.close();
			}
			return res;
		}
	
	//Getting Records in TbalePersubClass
	public List getResultCreditCard()throws Exception{
		Session s = null;
		List list = null;
		try{
			s = getSession();
			Query q = s.createQuery("from CreditCardDTO");
			list = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return list;
	} 

}
