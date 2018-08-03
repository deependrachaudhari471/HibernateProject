package in.com.prestige.model;

import java.security.CryptoPrimitive;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import in.com.prestige.dto.StudentDTO;
import in.com.prestige.util.HibernateUtil;

public class StudentModel {
   //Getting session object
   public static Session getSession() throws Exception{
	   Session session = null;
	   SessionFactory factory= null;
	   try{
		   factory = HibernateUtil.getSessionFactory();
		   session = factory.openSession();
	   }catch(HibernateException e){
		   e.printStackTrace();
	   }
	   return session;
   }
   
    //Adding Records
    public String addRecords(StudentDTO dto) throws Exception{
    	Session session = null;
    	Transaction txn = null;
    	String res = null;
    	try{
    		session = getSession();
    		txn = session.beginTransaction();
    		session.save(dto);
    		txn.commit();
    		res = "Records Inserted";
    	}catch(HibernateException e){
    		if(txn!=null){
    			txn.rollback();
    		}
    		e.printStackTrace();
    	}finally {
			session.close();
		}
    	return res;
    }
    
    //Getting Result In List
    public List<StudentDTO> getList(int age)throws  Exception{
    	List<StudentDTO> list =  null;
    	Session sesion = null;
    	try{
    		sesion = getSession();
    		System.out.println("Enabling Student Filter");
    		Filter filter = sesion.enableFilter("student_name");
    		filter.setParameter("age_param", age);
    		Criteria crit = sesion.createCriteria(StudentDTO.class);
    		list = crit.list();
    		sesion.disableFilter("student_name");
    	}catch(HibernateException e){
    		e.printStackTrace();
    	}finally {
			sesion.close();
		}
    	return list;
    }
    
    
    
}
