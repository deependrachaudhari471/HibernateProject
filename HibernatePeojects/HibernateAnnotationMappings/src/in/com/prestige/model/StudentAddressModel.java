package in.com.prestige.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.com.prestige.dto.AddressDTO;
import in.com.prestige.dto.StudentDTO;
import in.com.prestige.uitl.HibernateUtil;

public class StudentAddressModel {
    //getting Session Object
	public static Session getSession() throws Exception{
		SessionFactory factory = null;
		Session session = null;
		try{
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return session;
	}
	
	//Adding Records Into the table
	public String addRecords(AddressDTO dto) throws Exception{
	    Session session = null;
	    Transaction txn = null;
	    String res = null;
	    try{
	    	session = getSession();
	    	txn = session.beginTransaction();
	    	session.save(dto);
	    	txn.commit();
	    	res = "Record Saved Successfully";
	    }catch(HibernateException e){
	    	if(txn!=null){
	    		txn.rollback();
	    	}
	    	e.printStackTrace();
	    	
	    }finally{
	    	session.close();
	    }
	    return res;
	}
	
	//Getting result in List
	public List getList(AddressDTO dto) throws Exception{
		Session session = null;
		List list = null;
		try{
			session = getSession();
			Criteria crit = session.createCriteria(dto.getClass());
			list = crit.list();
		}catch(HibernateException e){
	    	e.printStackTrace();
	    	
	    }finally{
	    	session.close();
	    }
		return list;
	}
	
	//update records
	public String updateRecords(Integer addressId,Integer studentId)throws Exception{
		String res = null;
		Session session = null;
		Transaction txn = null;
		try{
			session = getSession();
			txn = session.beginTransaction();
			AddressDTO dto = (AddressDTO)session.get(AddressDTO.class,addressId);
			dto.setCity("Satna");
			StudentDTO sdto = (StudentDTO)session.get(StudentDTO.class, studentId);
			sdto.setStudentName("Pankaj");
			session.update(dto);
			txn.commit();
			res = "Record Updated";
		}catch(HibernateException e){
	    	if(txn!=null){
	    		txn.rollback();
	    	}
	    	e.printStackTrace();
	    	
	    }finally{
	    	session.close();
	    }
		return res;
	}
	
	//For Deleting records
	public String deleteRecords(Integer addressId)throws Exception{
		String res = null;
		Session session = null;
		Transaction txn = null;
		try{
			session = getSession();
			txn = session.beginTransaction();
			AddressDTO dto = (AddressDTO)session.get(AddressDTO.class, addressId);
			session.delete(dto);
			txn.commit();
			res = "Record DeletedS";
		}catch(HibernateException e){
	    	if(txn!=null){
	    		txn.rollback();
	    	}
	    	e.printStackTrace();
	    	
	    }finally{
	    	session.close();
	    }
		return res;
	}
}
