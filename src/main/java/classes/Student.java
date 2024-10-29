package classes;

public class Student {
	public Student(String name, String email, String date, String password,String gender) {
		super();
		this.name = name;
		this.email = email;
		this.date = date;
		this.password = password;
		this.gender = gender;
	}
	private String name ;
	private String email ;
	private String date ;
	private String password ;
	private String gender ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
