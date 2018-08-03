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
import org.hibernate.criterion.Restrictions;

import in.com.prestige.dto.CourseDTO;
import in.com.prestige.dto.StudentDTO;

public class TestStudentCourse {
	// Add records
	public static void addRecords() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();

			StudentDTO s1 = new StudentDTO();
			s1.setStudentId(101);
			s1.setStudentName("Deependra");
			s1.setMarks(90);
			StudentDTO s2 = new StudentDTO();
			s2.setStudentId(102);
			s2.setStudentName("Shekhar");
			s2.setMarks(90);

			CourseDTO c1 = new CourseDTO();
			c1.setCourseId(201);
			c1.setCourseName("Java");
			c1.setDuration(7);
			CourseDTO c2 = new CourseDTO();
			c2.setCourseId(202);
			c2.setCourseName("andorid");
			c2.setDuration(3);

			Set s = new HashSet();
			s.add(c1);
			s.add(c2);

			s1.setCourses(s);
			s2.setCourses(s);
			session.save(s1);
			session.save(s2);

			txn.commit();
			System.out.println("Saved record");

		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// Get Records
	public static void getReocrds() throws Exception {
		SessionFactory factory = null;
		Session session = null;

		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			Criteria crit = session.createCriteria(StudentDTO.class);
			//crit.add(Restrictions.eq("studentId", 101));
			List list = crit.list();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				StudentDTO std = (StudentDTO) it.next();
				System.out.print("SID : " + std.getStudentId());
				System.out.print("  SNAME : " + std.getStudentName());
				System.out.println("  SMARKS : " + std.getMarks());
				Set set = std.getCourses();
				Iterator it2 = set.iterator();
				while (it2.hasNext()) {
					CourseDTO c = (CourseDTO) it2.next();
					System.out.print("CID :" + c.getCourseId());
					System.out.print("  CNAME : " + c.getCourseName());
					System.out.println("  CDUARTION : " + c.getDuration());
				}
			}
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	//delete RecordsUsing ThirdTable
	public static void deletRecordsThirdTable()throws Exception{
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			StudentDTO std = (StudentDTO)session.get(StudentDTO.class, 102);
			CourseDTO crs = (CourseDTO)session.get(CourseDTO.class, 201);
			std.getCourses().remove(crs);
			
			session.save(std);
			txn.commit();
			System.out.println("Deleted");
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	//Delete records
	public static void deletRecords()throws Exception{
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			//StudentDTO std = (StudentDTO)session.get(StudentDTO.class, 102);
			CourseDTO std = (CourseDTO)session.get(CourseDTO.class, 201);
			session.delete(std);
			txn.commit();
			System.out.println("Deleted");
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	//Update Records
	public static void updateRecords()throws Exception{
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			StudentDTO std = (StudentDTO)session.get(StudentDTO.class, 102);
			//System.out.println(std.getCourses());
			std.setStudentName("Manan");
			session.update(std);
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
	public static void updateRecordsChildByParent()throws Exception{
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
			StudentDTO std = (StudentDTO)session.get(StudentDTO.class, 101);
			//System.out.println(std.getCourses());
			std.setStudentName("Aman");
			CourseDTO c1 = (CourseDTO)session.get(CourseDTO.class,201);
			CourseDTO c2 = (CourseDTO)session.get(CourseDTO.class, 202);
			
			c1.setCourseName("Histrory");
			c2.setCourseName("Managenmnbt");
			Set s = new HashSet();
			s.add(c1);
			s.add(c2);
			
			std.setCourses(s);
			session.update(std);
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
	public static void main(String[] args) throws Exception {
		//addRecords();
		getReocrds();
	    //deletRecordsThirdTable();
		//deletRecords();
		//updateRecords();
		//updateRecordsChildByParent();
	}
}
