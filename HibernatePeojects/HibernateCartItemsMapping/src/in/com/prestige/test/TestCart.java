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

import in.com.prestige.dto.CartDTO;
import in.com.prestige.dto.ItemsDTO;

public class TestCart {
	// Add Record
	public static void addRecord() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			CartDTO cart = new CartDTO();
			cart.setCartID(101);
			cart.setCategory("Mobile");

			ItemsDTO item1 = new ItemsDTO();
			item1.setItemId(501);
			item1.setPrice(6000.0);
			item1.setQuantity(2);
			item1.setName("Oppo");

			ItemsDTO item2 = new ItemsDTO();
			item2.setItemId(502);
			item2.setPrice(8000.0);
			item2.setQuantity(2);
			item2.setName("Vivo");

			ItemsDTO item3 = new ItemsDTO();
			item3.setItemId(503);
			item3.setPrice(9000.0);
			item3.setQuantity(2);
			item3.setName("Samsung");

			Set s = new HashSet();
			s.add(item1);
			s.add(item2);
			s.add(item3);

			cart.setChildren(s);
			session.save(cart);
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
	public static void deletRecords(int cart) throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			CartDTO dto = (CartDTO) session.get(CartDTO.class, cart);
			session.delete(dto);
			txn.commit();
			System.out.println("Deleted Sucessfully");
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
				e.printStackTrace();
			}
		} finally {
			session.close();
		}
	}

	// GetRecords
	public static void getRecords() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			Criteria crit = session.createCriteria(CartDTO.class);
			List list = crit.list();
			Iterator it = list.iterator();
			while(it.hasNext()){
				CartDTO cart = (CartDTO)it.next();
				System.out.print("  CartId : "+cart.getCartID());
				System.out.println("  Category : "+cart.getCategory());
				Set item = cart.getChildren();
				Iterator it2 = item.iterator();
				while(it2.hasNext()){
					ItemsDTO dto = (ItemsDTO)it2.next();
					System.out.print("  ItemID : "+dto.getItemId());
					System.out.print("  Name : "+dto.getName());
					System.out.print("  Price : "+dto.getPrice());
					System.out.print("  Quantity : "+dto.getQuantity());
					System.out.println("  Cart_ID : "+dto.getCartId());
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
