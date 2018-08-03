package in.com.prestige.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.prestige.dto.EmployeeDTO;
import in.com.prestige.dto.DepartmentDTO;

public class TestDepart {
	// Add Records
	public static void addRecords() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
            DepartmentDTO dep = new DepartmentDTO();
            dep.setDepartID(102);
            dep.setDepartName("PHP Technology");
            
            EmployeeDTO e1  = new EmployeeDTO();
            e1.setEmpId(203);
            e1.setEmpName("Rahul");
            e1.setEmpAddress("Saket Indore");
            e1.setDepartID(dep);
            
            EmployeeDTO e2  = new EmployeeDTO();
            e2.setEmpId(204);
            e2.setEmpName("Saurabh");
            e2.setEmpAddress("Palasiya Indore");
            e2.setDepartID(dep);
            
            session.save(e1);
            session.save(e2);
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

	
	//get Records
	public static void getList() throws Exception{
		SessionFactory factory = null;
		Session session = null;
		
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			Criteria crit = session.createCriteria(EmployeeDTO.class);
			List list = crit.list();
			Iterator it = list.iterator();
			while(it.hasNext()){
				EmployeeDTO emp = (EmployeeDTO)it.next();
				System.out.print("EmpId : "+emp.getEmpId());
				System.out.print("  Emp Name :"+emp.getEmpName());
				System.out.println("  EmpAddress :"+emp.getEmpAddress());
				DepartmentDTO dep = (DepartmentDTO)emp.getDepartID();
				System.out.println("  DepartmentName : "+dep.getDepartName());
			}
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
		} finally {
			session.close();
		}
			
	}
	
	
	// delete Records
      public static void deleteRecords() throws Exception {
		SessionFactory factory = null;
		Session session = null;
		Transaction txn = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			txn = session.beginTransaction();
            DepartmentDTO dep = (DepartmentDTO)session.get(DepartmentDTO.class, 101);
			session.delete(dep);
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

	public static void main(String[] args) throws Exception {
		//addRecords();
		//deleteRecords();
		//getList();
	}
}
