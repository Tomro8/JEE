package jee.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Database {
	
    private static EntityManager em;
    public static void connect() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("credentialsDB") ;
    	em = emf.createEntityManager();
    }

    public static boolean login(String login, String password) throws SQLException {

    	Credentials c = null;
    	Query q = em.createQuery(SQLRequest.loginExist);
    	q.setParameter("login", login);
    	try {
        	c = (Credentials) q.getSingleResult();
        	return c.getLOGIN().compareTo(password) == 0 ? true : false;
    	} catch (NoResultException e) {
    		return false;
    	}
    }
    
    public static Employee getEmployee(int id) throws SQLException {

        return em.find(Employee.class, id);
    }
    
    public static ArrayList<Employee> getListEmployee() throws SQLException {

    	Query q = em.createQuery(SQLRequest.listEmployee);
    	
    	ArrayList<Employee> employee = (ArrayList<Employee>) q.getResultList();
        return employee;
    }
    
    public static void removeEmployee(int id) throws SQLException {
    	
    	  Employee e = em.find(Employee.class, id);
    	  
    	  em.getTransaction().begin();
		  em.remove(e);
		  em.getTransaction().commit();
    	
    }
    
    public static void addEmployee(String name, String firstName, String telehome, String telMob, String telPro, String adress, String postalCode, String city, String email) throws SQLException {
    	
    	em.getTransaction().begin();
    	Employee e = new Employee(name, firstName, telehome, telMob, telPro, adress, postalCode, city, email);
    	em.persist(e);
    	em.getTransaction().commit();
    }
    
    public static void updateEmployee(String name, String firstName, String telhome, String telMob, String telPro, String adress, String postalCode, String city, String email, int id) throws SQLException {
    	
	  	Employee e = em.find(Employee.class, id);
		  
	    em.getTransaction().begin();
	    
	  	e.setName(name);
	   	e.setFirstName(firstName);
	  	e.setTelhome(telhome);
	  	e.setTelMob(telMob);
	  	e.setTelPro(telPro);
	  	e.setAdress(adress);
	  	e.setPostalCode(postalCode);
	  	e.setCity(city);
	  	e.setEmail(email);

		em.getTransaction().commit();
    	
    }
}
