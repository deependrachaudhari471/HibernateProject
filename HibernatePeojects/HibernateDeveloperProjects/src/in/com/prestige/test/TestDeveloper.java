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

import in.com.prestige.dto.DeveloperDTO;
import in.com.prestige.dto.ProjectsDTO;

public class TestDeveloper {
	// Add Record
	public static void addRecord() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			DeveloperDTO dto = new DeveloperDTO();
			dto.setDeveloperId(101);
			dto.setDeveloperName("Deependra");

			ProjectsDTO p1 = new ProjectsDTO();
			p1.setProjectId(201);
			p1.setProjectName("Spencer");

			ProjectsDTO p2 = new ProjectsDTO();
			p2.setProjectId(202);
			p2.setProjectName("Spencer123");

			ProjectsDTO p3 = new ProjectsDTO();
			p3.setProjectId(203);
			p3.setProjectName("Spencer123456");

			Set s = new HashSet();
			s.add(p1);
			s.add(p2);
			s.add(p3);

			dto.setProjectId(s);
			session.save(dto);
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
			Criteria crit = session.createCriteria(DeveloperDTO.class);
			List list = crit.list();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				DeveloperDTO dto = (DeveloperDTO) it.next();
				System.out.print("DeveloperID : " + dto.getDeveloperId());
				System.out.println("  DeveloperName : " + dto.getDeveloperName());
				Set bids = dto.getProjectId();
				Iterator it2 = bids.iterator();
				while (it2.hasNext()) {
					ProjectsDTO pro = (ProjectsDTO) it2.next();
					System.out.print("  ProjectId : " + pro.getProjectId());
					System.out.print(" ProjectName : " + pro.getProjectName());
					System.out.println("  ProjectID : " + pro.getProjectId());
					
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
