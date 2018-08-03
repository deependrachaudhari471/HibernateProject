package in.com.prestige.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.w3c.dom.ls.LSInput;

import in.com.prestige.dto.AccountHolderDTO;
import in.com.prestige.dto.BankDTO;


public class TestBank {
	// Add Records
	public static void addRecords() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();

			BankDTO bank = new BankDTO();
			bank.setBankId(101);
			bank.setBankName("SBI");
			bank.setAddress("SANKET INDORE");
			
			AccountHolderDTO ac1 = new AccountHolderDTO();
			ac1.setAcHolderId(201);
			ac1.setAcHolderName("Deependra");
			ac1.setAcNumber("8798655421332");
			ac1.setBankId(bank);
			AccountHolderDTO ac2 = new AccountHolderDTO();
			ac2.setAcHolderId(202);
			ac2.setAcHolderName("Vivek");
			ac2.setAcNumber("dfsdf5421332");
			ac2.setBankId(bank);
			
			session.save(ac1);
			session.save(ac2);
			
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
	
	//update Records
	public static void updateRecord()throws Exception{
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			BankDTO bank = (BankDTO)session.get(BankDTO.class, 101);
            Criteria crit = session.createCriteria(AccountHolderDTO.class);
            crit.add(Restrictions.eq("bankId",bank));
            List list = crit.list();
            Iterator it = list.iterator();
            while(it.hasNext()){
            	AccountHolderDTO ac1 = (AccountHolderDTO)it.next();
            	AccountHolderDTO ac = (AccountHolderDTO)session.get(AccountHolderDTO.class,ac1.getAcHolderId());
            	if(ac1.getAcHolderId() == 201){
                ac.setAcHolderName("Rishabh");
                session.update(ac);
            	}
                System.out.println("Updated");
            }
			txn.commit();
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
		//addRecords();
		updateRecord();
	}
}
