package in.com.prestige.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.prestige.dto.StockDTO;
import in.com.prestige.dto.StockDailyRecordDTO;

public class TestStock {
	//add Records
	public static void addRecords(double openPrice,double closePrice)throws Exception{
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			//for timestamp
			Date d = new Date();
			long time = d.getTime();
			Timestamp ts = new Timestamp(time);
			
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			StockDTO stock = new StockDTO();
			stock.setStockID(101);
			stock.setStock_code("4523");
			stock.setStock_name("RELANCE");
			
			StockDailyRecordDTO s1 = new StockDailyRecordDTO();
			s1.setDailyRecordID(501);
			s1.setPriceOpen(openPrice);
			s1.setPriceClose(closePrice);
			s1.setPriceChange((closePrice-openPrice));
			s1.setDate(new Date());
			s1.setTime(ts);
			s1.setStockID(stock);

			session.save(s1);
			txn.commit();
			System.out.println("Saved Succesfully");
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	//GetList
	public static void getList()throws Exception{
		SessionFactory factory = null;
		Session session = null;
		try{
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			Criteria crit = session.createCriteria(StockDailyRecordDTO.class);
			List list = crit.list();
			Iterator it = list.iterator();
			while(it.hasNext()){
				StockDailyRecordDTO st = (StockDailyRecordDTO)it.next();
				System.out.print("DailyRecordID : "+st.getDailyRecordID());
				System.out.print("  PriceOpen : "+st.getPriceOpen());
				System.out.print("  ClosePrice : "+st.getPriceClose());
				System.out.print("  PriceChange : "+st.getPriceChange());
				System.out.print("  Record Date : "+st.getDate());
				System.out.print("  Record Time : "+st.getTime());
				StockDTO stock = (StockDTO)st.getStockID();
				System.out.println("  StockName : "+stock.getStock_name());
			}
			
		}catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
    public static void main(String[] args) throws Exception{
		//addRecords(5000.0, 6000.0);
		getList();
	}
}
