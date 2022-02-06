package com.customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customerLogin")
public class Customer {
	@Id
private String userName;
private String password;
private String email;
private String address;
public Customer(String username, String password, String email, String address) {
	super();
	this.userName = username;
	this.password = password;
	this.email = email;
	this.address = address;
}

public String getUsername() {
	return userName;
}

public void setUsername(String username) {
	this.userName = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

@Override
public String toString() {
	return "Customer [username=" + userName + ", password=" + password + ", email=" + email + ", address=" + address
			+ "]";
}



}
