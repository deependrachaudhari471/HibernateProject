package in.com.prestige.test;

import java.util.Date;
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

import in.com.prestigeonetomany.dto.StockDTO;
import in.com.prestigeonetomany.dto.StockDailyRecordsDTO;

public class TestStock {
	public static SessionFactory factory = new Configuration().configure().buildSessionFactory();

	// Add Records
	public static void addRecords() throws Exception {
		Session session = null;
		Transaction txn = null;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			StockDTO stk = new StockDTO();
			stk.setStockId(102);
			stk.setStockName("Wipro");

			StockDailyRecordsDTO s1 = new StockDailyRecordsDTO();
			s1.setStockdailyId(203);
			s1.setPriceOpen(200.0);
			s1.setPriceClose(300.0);
			s1.setDate(new Date());
			StockDailyRecordsDTO s2 = new StockDailyRecordsDTO();
			s2.setStockdailyId(204);
			s2.setPriceOpen(500.0);
			s2.setPriceClose(400.0);
			s2.setDate(new Date());
			

			Set s = new HashSet();
			s.add(s1);
			s.add(s2);

			stk.setDailyRecords(s);
			session.save(stk);
			txn.commit();
			System.out.println("Record Saved");

		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	//get Records
	public static void getListRecords() throws Exception{
		Session session = null;
		try{
			session = factory.openSession();
			Criteria crit = session.createCriteria(StockDTO.class);
			List list = crit.list();
			Iterator it = list.iterator();
			while(it.hasNext()){
				StockDTO stk = (StockDTO)it.next();
				System.out.println(stk.getStockId()+"..."+stk.getStockName());
				Set s = stk.getDailyRecords();
				Iterator it2 = s.iterator();
				while(it2.hasNext()){
					StockDailyRecordsDTO stk2 = (StockDailyRecordsDTO)it2.next();
					System.out.println(stk2.getStock_id()+"..."+stk2.getDate());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	//Update records
	public static void updateRecords() throws Exception{
		Session session = null;
		Transaction txn = null;
		try{
			session = factory.openSession();
			txn = session.beginTransaction();
			StockDTO stk = (StockDTO)session.get(StockDTO.class, 101);
			stk.setStockName("Prestige");
			
			StockDailyRecordsDTO stk2 = (StockDailyRecordsDTO)session.get(StockDailyRecordsDTO.class, 202);
			StockDailyRecordsDTO stk3 = (StockDailyRecordsDTO)session.get(StockDailyRecordsDTO.class, 201);
			stk2.setDate(new Date());
			stk2.setPriceOpen(8000.0);
			stk2.setPriceClose(9000.0);
			stk3.setDate(new Date());
			stk3.setPriceOpen(18000.0);
			stk3.setPriceClose(19000.0);
			
			Set s = new HashSet();
			s.add(stk2);
			s.add(stk3);
			stk.setDailyRecords(s);
			
			session.update(stk);
			txn.commit();
			System.out.println("Updated");
			
		}catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	//delete from parent
	public static void deletByParent() throws Exception{
		Session session = null;
		Transaction txn = null;
		try{
			session = factory.openSession();
			txn = session.beginTransaction();
			StockDTO stk = (StockDTO)session.get(StockDTO.class, 102);
			session.delete(stk);
			txn.commit();
			System.out.println("deletd");
		}catch(Exception e){
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	//Delete By ChildId;
	public static void deletByChild() throws Exception{
		Session session = null;
		Transaction txn = null;
		try{
			session = factory.openSession();
			txn = session.beginTransaction();
			//StockDTO stk = (StockDTO)session.get(StockDTO.class, 102);
			StockDailyRecordsDTO stk = (StockDailyRecordsDTO)session.get(StockDailyRecordsDTO.class, 203);
			
			session.delete(stk);
			txn.commit();
			System.out.println("deletd");
		}catch(Exception e){
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void main(String[] args) throws Exception {
       // addRecords();
		getListRecords();
		//updateRecords();
		//deletByParent();
		//deletByChild();
	}
}
