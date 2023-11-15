package models;

public class UserRegistration {
private int id;
private String name;	
private String email;
private String password;
private String role;

public UserRegistration(String name, String email, String password, String role) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
	this.role = role;
}

public UserRegistration(int id, String name, String email, String password, String role) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.role = role;
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

public UserRegistration(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}


public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

public UserRegistration() {
	super();
}

}
