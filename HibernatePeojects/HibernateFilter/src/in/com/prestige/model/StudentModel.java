package in.com.prestige.model;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import in.com.presstige.dto.StudentDTO;

public class StudentModel {
	private static SessionFactory factory = null;

	// Getting Session Object
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

	// Addrecords
	public String addStudents(StudentDTO student) throws Exception {
		String res = null;
		Session s = null;
		try {
			s = getSession();
			Transaction txn = s.beginTransaction();
			s.save(student);
			txn.commit();
			res = "Record Inserted";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
          s.close();
		}
		return res;
	}

	// getList Result
	public List<StudentDTO> getList(int age) throws Exception {
		List<StudentDTO> list = null;;
		Session s = null;
		try {
            s = getSession();
            System.out.println("Enabling Age Filter Session");
            Filter filter = s.enableFilter("age_varification");
            s.enableFilter("Student_Name");
            
            filter.setParameter("age_param", age);
            Criteria crit = s.createCriteria(StudentDTO.class);
            crit.addOrder(Order.asc("studentName"));
            list = crit.list();
            s.disableFilter("age_varification");
            s.disableFilter("Student_Name");
            
            //RESULT WITHOUT FILTERING
            Criteria crit2 = s.createCriteria(StudentDTO.class);
            List list2 = crit2.list();
            Iterator it2 = list2.iterator();
            while(it2.hasNext()){
            	StudentDTO st = (StudentDTO)it2.next();
            	System.out.println(st.getStudentID()+"..."+st.getStudentName()+"..."+st.getAge());
            	
            }
            System.out.println("Result After Filtering");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		return list;
	}
}
