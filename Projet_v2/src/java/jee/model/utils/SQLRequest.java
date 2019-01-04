/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee.model.utils;

/**
 *
 * @author Baptiste
 */
public class SQLRequest {
    	public static String loginExist = "SELECT * FROM credentials WHERE LOGIN = ?";
	public static String listEmployee = "SELECT * FROM employees";
	public static String informationEmployee = "SELECT * FROM employees WHERE ID = ?";
	public static String addEmployee = "INSERT into employees(NAME, FIRSTNAME, TELHOME, TELMOB, TELPRO, ADRESS, POSTALCODE, CITY, EMAIL) values(?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ? )";
	public static String updateEmployee = "UPDATE employees "
			+ "SET name = ?, "
			+ "firstName = ?, "
			+ "telhome = ?, "
			+ "telMob = ?, "
			+ "telPro = ?, "
			+ "adress = ?, "
			+ "postalCode = ?, "
			+ "city = ?, "
			+ "email = ? "
			+ "WHERE id = ?";
	public static String deleteEmployee = "DELETE FROM employees where ID = ?";
	
}
