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

public class Employee {
	private String name, firstName, telephone, telMob, telPro, address, postalCode, city, email;
        int id;

        public Employee() {
            id = 0;
        }
        
	public Employee(String p_name, String p_firstName, String p_telehome, String p_telMob, String p_telPro, String p_adress, String p_postalCode, String p_city, String p_email, int id) {
		 this.id = id;
		 this.name = p_name;
		 this.firstName = p_firstName;
		 this.telephone = p_telehome;
		 this.telMob = p_telMob;
		 this.telPro = p_telPro;
		 this.address = p_adress;
		 this.postalCode = p_postalCode;
		 this.city = p_city;
		 this.email = p_email;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telehome) {
		this.telephone = telehome;
	}

	public String getTelMob() {
		return telMob;
	}

	public void setTelMob(String telMob) {
		this.telMob = telMob;
	}

	public String getTelPro() {
		return telPro;
	}

	public void setTelPro(String telPro) {
		this.telPro = telPro;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
