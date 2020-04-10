package swe645.restful;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "STUDENTS", catalog="swe645")
public class StudentBean implements Serializable {
	
	@Id
	@Column(name="STUDENTID", unique = true)
	private String id;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="ASTATE")
	private String state;
	
	@Column(name="ZIP")
	private String zip;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ADATE")
	private String date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}