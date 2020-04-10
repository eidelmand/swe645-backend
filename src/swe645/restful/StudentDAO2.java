package swe645.restful;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class StudentDAO2 {

	 private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
	            .createEntityManagerFactory("restful");
	 
	  public void saveInfo(StudentBean student) {
	        // The EntityManager class allows operations such as create, read, update, delete
	        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
	        // Used to issue transactions on the EntityManager
	        EntityTransaction et = null;
	 
	        try {
	            // Get transaction and start
	            et = em.getTransaction();
	            et.begin();
	 
	 
	            // Save the student object
	            em.persist(student);
	            et.commit();
	        } catch (Exception ex) {
	            // If there is an exception rollback changes
	            if (et != null) {
	                et.rollback();
	            }
	            ex.printStackTrace();
	        } finally {
	            // Close EntityManager
	            em.close();
	        }
	        
	        
	    }

	  public StudentBean getStudent(String id) {
	    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
	    	
	    	// the lowercase c refers to the object
	    	// :custID is a parameterized query thats value is set below
	    	String query = "SELECT S FROM StudentBean S WHERE S.id = :studentID";
	    	
	    	// Issue the query and get a matching Customer
	    	TypedQuery<StudentBean> tq = em.createQuery(query, StudentBean.class);
	    	tq.setParameter("studentID", id);
	    	
	    	StudentBean student = null;
	    	try {
	    		// Get matching customer object and output
	    		student = tq.getSingleResult();
	    	}
	    	catch(NoResultException ex) {
	    		ex.printStackTrace();
	    	}
	    	finally {
	    		em.close();
	    	}
	    	return student;
	    }
	  
	  public ArrayList<String> getIDs() {
	    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
	    	
	    	// the lowercase c refers to the object
	    	// :custID is a parameterized query thats value is set below
	    	String strQuery = "SELECT S.id FROM StudentBean S";
	    	
	    	// Issue the query and get a matching Customer
	    	TypedQuery<String> tq = em.createQuery(strQuery, String.class);
	    	List<String> students = new ArrayList<String>();
	    	try {
	    		// Get matching customer object and output
	    		students =  tq.getResultList();
	    	}
	    	catch(NoResultException ex) {
	    		ex.printStackTrace();
	    	}
	    	finally {
	    		em.close();
	    	}
	    	ArrayList<String> ids = new ArrayList<String>();
	    	for(String s: students)
	    		ids.add(s);
	    	return ids;
	    }
}
