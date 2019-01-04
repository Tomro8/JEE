package jee.modelTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import jee.model.Employee;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author romainbeaussart
 */
public class EmployeeTest {
    
    private static Employee e,em;
    private static String name, firstName, telHome, telMob, telPro, address, PC, city, email;
    private static int id;
    
    public EmployeeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        name = "Dupont";
        firstName = "Bob";
        telHome = new String("0123456789");
        telMob = "0612345678";
        telPro = "0987654321";
        address = "23 Rue des pommiers";
        PC = "75000";
        city = "Paris";
        email = "email@email.net";
        id = 0;
        e = new Employee(name, firstName, telHome, telMob, telPro, address, PC, city, email, id);
        em = new Employee(name, firstName, telHome, telMob, telPro, address, PC, city, email, id);
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /* --- Tests --- */
    
    @Test
    public final void testGetId(){
	assertTrue(e.getId() == id);
    }
    
    @Test
    public final void testSetId(){
        int idM = 1;
        em.setId(idM);
        assertTrue(em.getId() == idM);
        
    }
    
    @Test
    public final void testGetName(){
        assertTrue(e.getName().equals(name));
    }
    
    @Test
    public final void testSetName(){
        String string = "Test";
        em.setName(string);
        assertTrue(em.getName().equals(string));

    }
    
    @Test
    public final void testGetFirstName(){
        assertTrue(e.getFirstName().equals(firstName));
    }
    
    @Test
    public final void testSetFirstName(){
        String string = "Test";
        em.setFirstName(string);
        assertTrue(em.getFirstName().equals(string));
    }
    
    @Test
    public final void testGetTelephone(){
        assertTrue(e.getTelephone().equals(telHome));
    }
    
    @Test
    public final void testSetTelephone(){
        String string = "Test";
        em.setTelephone(string);
        assertTrue(em.getTelephone().equals(string));
    }
    
    @Test
    public final void testGetTelMob(){
        assertTrue(e.getTelMob() == telMob);
    }
    
    @Test
    public final void testSetTelMob(){
        String string = "Test";
        em.setTelMob(string);
        assertTrue(em.getTelMob().equals(string));
    }
    
    @Test
    public final void testGetTelPro(){
        assertTrue(e.getTelPro().equals(telPro));
    }
    
    @Test
    public final void testSetTelPro(){
        String string = "Test";
        em.setTelPro(string);
        assertTrue(em.getTelPro().equals(string));
    }
    
    @Test
    public final void testGetAddress(){
        assertTrue(e.getAddress().equals(address));
    }
    
    @Test
    public final void testSetAddress(){
        String string = "Test";
        em.setAddress(string);
        assertTrue(em.getAddress().equals(string));
    }
    
    @Test
    public final void testGetPostalCode(){
        assertTrue(e.getPostalCode().equals(PC));
    }
    
    @Test
    public final void testSetPostalCode(){
        String string = "Test";
        em.setPostalCode(string);
        assertTrue(em.getPostalCode().equals(string));
    }
    
    @Test
    public final void testGetCity(){
        assertTrue(e.getCity().equals(city));
    }
    
    @Test
    public final void testSetCity(){
        String string = "Test";
        em.setCity(string);
        assertTrue(em.getCity().equals(string));
    }
    
    @Test
    public final void testGetEmail(){
        assertTrue(e.getEmail().equals(email));
    }
    
    @Test
    public final void testSetEmail(){
        String string = "Test";
        em.setEmail(string);
        assertTrue(em.getEmail().equals(string));
    }
}
