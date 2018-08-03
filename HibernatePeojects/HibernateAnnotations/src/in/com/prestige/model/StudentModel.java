package in.com.prestige.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.sql.ordering.antlr.Factory;

import in.com.prestige.dto.StudentDTO;

public class StudentModel {
	/*
	 * public static SessionFactory factory = null; // SessionFactoryObject
	 * public static SessionFactory getSessionFactory() throws Exception {
	 * Configuration cfg = new Configuration();
	 * cfg.configure("hibernate.cfg.xml"); ServiceRegistry registry = new
	 * ServiceRegistryBuilder().applySettings(cfg.getProperties())
	 * .buildServiceRegistry(); factory = cfg.buildSessionFactory(registry);
	 * return factory; }
	 */

	// Getting Session Object
	public static Session getSession() throws Exception {
		Session session = null;
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(cfg.getProperties())
				.buildServiceRegistry();
		SessionFactory factory = cfg.buildSessionFactory(registry);

		try {
			session = factory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}

	// Adding Records
	public String addRecords(StudentDTO dto) throws Exception {
		String res = null;
		Session session = null;
		Transaction txn = null;
		try {
			session = getSession();
			txn = session.beginTransaction();
			session.save(dto);
			txn.commit();
			res = "Records Inserted Succesfully";
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}

	// getting Results
	public List<StudentDTO> getListResults() throws Exception {
		List<StudentDTO> list = null;
		Session session = null;
		try {
			session = getSession();
			Criteria crit = session.createCriteria(StudentDTO.class);
			list = crit.list();
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	// update Students
	public String updateStudents(StudentDTO dto) throws Exception {
		String res = null;
		Session session = null;
		Transaction txn = null;
		try {
			session = getSession();
			txn = session.beginTransaction();
			StudentDTO std = (StudentDTO) session.get(StudentDTO.class, dto.getStudentID());
			std.setStudentName(dto.getStudentName());
			std.setAddress(dto.getAddress());
			session.update(std);
			txn.commit();
			res  = "Record Updated";
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return res;
	}
}
