/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee.model;

/**
 *
 * @author Baptiste
 */
class SQLRequest {
    public static String loginExist = "SELECT c FROM credentials c WHERE LOGIN = :login";
    public static String listEmployee = "SELECT e FROM employees e";
	
}
