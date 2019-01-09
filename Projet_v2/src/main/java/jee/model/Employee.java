package jee.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "employees")
@Table(name = "employees")
public class Employee {
	
	@Id
	private int ID;
	
	private String name;
	private String telhome; 
	private String firstName; 
	private String telMob;
	private String telPro;
	private String adress;
	private String postalCode;
	private String city;
	
	public int getId() {
		return ID;
	}
	public void setId(int id) {
		this.ID = id;
	}

	private String email;
	
	public Employee() {
		
	}
	public Employee(String p_name, String p_firstName, String p_telehome, String p_telMob, String p_telPro, String p_adress, String p_postalCode, String p_city, String p_email) {
		 
		 this.name = p_name;
		 this.firstName = p_firstName;
		 this.telhome = p_telehome;
		 this.telMob = p_telMob;
		 this.telPro = p_telPro;
		 this.adress = p_adress;
		 this.postalCode = p_postalCode;
		 this.city = p_city;
		 this.email = p_email;

	}



	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelhome() {
		return telhome;
	}
	public void setTelhome(String telhome) {
		this.telhome = telhome;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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
