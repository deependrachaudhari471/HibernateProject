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

import in.com.prestige.dto.AuctionDTO;
import in.com.prestige.dto.BidDTO;

public class TestAuction {
	// Add Record
	public static void addRecord() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			AuctionDTO auction = new AuctionDTO();
			auction.setItemId(101);
			auction.setDescription("IPL Player - Chris Gayle");

			BidDTO bid1 = new BidDTO();
			bid1.setBidId(501);
			bid1.setAmount(500.0);
			bid1.setTeamName("KIXP");

			BidDTO bid2 = new BidDTO();
			bid2.setBidId(502);
			bid2.setAmount(700.0);
			bid2.setTeamName("RCB");

			BidDTO bid3 = new BidDTO();
			bid3.setBidId(503);
			bid3.setAmount(900.0);
			bid3.setTeamName("KKR");

			Set s = new HashSet();
			s.add(bid1);
			s.add(bid2);
			s.add(bid3);

			auction.setBids(s);
			session.save(auction);
			txn.commit();
			System.out.println("Saved Succefully");

		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
				e.printStackTrace();
			}
		} finally {
			session.close();
		}
	}

	// Delete Records
	/*
	 * public static void deletRecords(int cart) throws Exception {
	 * SessionFactory factory = null; Session session = null; Transaction txn =
	 * null; try { factory = new
	 * Configuration().configure().buildSessionFactory(); session =
	 * factory.openSession(); txn = session.beginTransaction(); CartDTO dto =
	 * (CartDTO) session.get(CartDTO.class, cart); session.delete(dto);
	 * txn.commit(); System.out.println("Deleted Sucessfully"); } catch
	 * (HibernateException e) { if (txn != null) { txn.rollback();
	 * e.printStackTrace(); } } finally { session.close(); } }
	 */
	// GetRecords
	public static void getRecords() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			Criteria crit = session.createCriteria(AuctionDTO.class);
			List list = crit.list();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				AuctionDTO auction = (AuctionDTO) it.next();
				System.out.print("AUCTIONID : " + auction.getItemId());
				System.out.println("  Description : " + auction.getDescription());
				Set bids = auction.getBids();
				Iterator it2 = bids.iterator();
				while (it2.hasNext()) {
					BidDTO dto = (BidDTO) it2.next();
					System.out.print("  ItemID : " + dto.getItemId());
					System.out.print(" Team Name : " + dto.getTeamName());
					System.out.print("  Amount : " + dto.getAmount());
					System.out.println("  BID_ID : " + dto.getBidId());
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// Main MEthod
	public static void main(String[] args) throws Exception {
		//addRecord();
		// deletRecords(101);
		getRecords();
	}
}
