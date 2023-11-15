package models;




public class StudentRegistration {
private int id;
private int studentId;
private String name;
private String date;
private String gender;
private String phone;
private String education;
private String attend;
private String photo;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEducation() {
	return education;
}
public void setEducation(String education) {
	this.education = education;
}
public String getAttend() {
	return attend;
}
public void setAttend(String attend) {
	this.attend = attend;
}


public StudentRegistration() {
	super();
}


public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public StudentRegistration(int id, int studentId, String name, String date, String gender, String phone,
		String education, String attend, String photo) {
	super();
	this.id = id;
	this.studentId = studentId;
	this.name = name;
	this.date = date;
	this.gender = gender;
	this.phone = phone;
	this.education = education;
	this.attend = attend;
	this.photo = photo;
}
public StudentRegistration(int studentId, String name, String date, String gender, String phone, String education,
		String attend, String photo) {
	super();
	this.studentId = studentId;
	this.name = name;
	this.date = date;
	this.gender = gender;
	this.phone = phone;
	this.education = education;
	this.attend = attend;
	this.photo = photo;
}
public StudentRegistration(String name, String date, String gender, String phone, String education, String attend,
		String photo) {
	super();
	this.name = name;
	this.date = date;
	this.gender = gender;
	this.phone = phone;
	this.education = education;
	this.attend = attend;
	this.photo = photo;
}
public StudentRegistration(int studentId, String name, String attend) {
	super();
	this.studentId = studentId;
	this.name = name;
	this.attend = attend;
}



}
