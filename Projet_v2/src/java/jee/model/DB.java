/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee.model;

import jee.model.utils.SQLRequest;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Baptiste
 */

public class DB {
    
    private static Connection connexion = null;
    public static void connect() {
        System.out.println("log");
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName("com.mysql.jdbc.Driver");
                        System.out.println("driver OK !");
        } catch ( ClassNotFoundException e ) {
            System.out.println(e.getMessage());
        }
        
        /* Connexion à la base de données */
        try {    
            Properties prop = new Properties();
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            InputStream input = cl.getResourceAsStream("jee/model/utils/db.properties");
            prop.load(input);

            String dbUrl = prop.getProperty("dbUrl");
            String user = prop.getProperty("dbUser");
            String pwd = prop.getProperty("pwd");    

            connexion = DriverManager.getConnection(dbUrl, user, pwd);

        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static boolean login(String login, String password) throws SQLException {

    	PreparedStatement loginS = connexion.prepareStatement(SQLRequest.loginExist); 
    	loginS.setString(1, login);
    	ResultSet result = loginS.executeQuery();
    
        if(result.next()) {
                    System.out.println("exist");

            if(password.compareTo(result.getString("PASSWORD")) == 0) {
                        System.out.println("true");

            	return true;
            }
        }
        return false;
    }
    
    public static Employee getEmployee(int id) throws SQLException {

    	PreparedStatement employeeS = connexion.prepareStatement(SQLRequest.informationEmployee); 
    	employeeS.setInt(1, id);
    	ResultSet result = employeeS.executeQuery();
    	
    
        if(result.next()) {
            return new Employee(result.getString("NAME"),
            		result.getString("FIRSTNAME"),
            		result.getString("TELHOME"),
            		result.getString("TELMOB"),
            		result.getString("TELPRO"),
            		result.getString("ADRESS"),
            		result.getString("POSTALCODE"),
            		result.getString("CITY"),
            		result.getString("EMAIL"),
                        result.getInt("ID"));
        }
        return null;
    }
    
    public static ArrayList<Employee> getListEmployee() throws SQLException {

    	PreparedStatement employeeS = connexion.prepareStatement(SQLRequest.listEmployee); 
    	ResultSet result = employeeS.executeQuery();
    	
    	ArrayList<Employee> employee = new ArrayList<>();
    
        while (result.next()) {
            employee.add(new Employee(result.getString("NAME"),
            		result.getString("FIRSTNAME"),
            		result.getString("TELHOME"),
            		result.getString("TELMOB"),
            		result.getString("TELPRO"),
            		result.getString("ADRESS"),
            		result.getString("POSTALCODE"),
            		result.getString("CITY"),
            		result.getString("EMAIL"),
                        result.getInt("ID")));
        }
        return employee;
    }
    
    public static void removeEmployee(int id) throws SQLException {
    	
    	PreparedStatement employeeS = connexion.prepareStatement(SQLRequest.deleteEmployee); 
        System.out.println("id : " + id);
    	employeeS.setInt(1, id);
    	employeeS.execute();
    	
    }
    
    public static void addEmployee(String name, String firstName, String telehome, String telMob, String telPro, String adress, String postalCode, String city, String email) throws SQLException {
    	
    	PreparedStatement employeeS = connexion.prepareStatement(SQLRequest.addEmployee); 
    	employeeS.setString(1, name);
    	employeeS.setString(2, firstName);
    	employeeS.setString(3, telehome);
    	employeeS.setString(4, telMob);
    	employeeS.setString(5, telPro);
    	employeeS.setString(6, adress);
    	employeeS.setString(7, postalCode);
    	employeeS.setString(8, city);
    	employeeS.setString(9, email);
    	employeeS.execute();
    }
    
    public static void updateEmployee(String name, String firstName, String telehome, String telMob, String telPro, String adress, String postalCode, String city, String email, int id) throws SQLException {
    	
    	PreparedStatement employeeS = connexion.prepareStatement(SQLRequest.updateEmployee); 
    	employeeS.setString(1, name);
    	employeeS.setString(2, firstName);
    	employeeS.setString(3, telehome);
    	employeeS.setString(4, telMob);
    	employeeS.setString(5, telPro);
    	employeeS.setString(6, adress);
    	employeeS.setString(7, postalCode);
    	employeeS.setString(8, city);
    	employeeS.setString(9, email);
    	employeeS.setInt(10, id);
    	employeeS.execute();
    	
    }
    
}

