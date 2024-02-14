package constuction.project.data.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class contractor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String email;
	private String mobile;
	private String username;	
	private String password;
	
	
	public contractor() {
		super();
	}


	public contractor(long id, String email, String mobile, String username, String password) {
		super();
		this.id = id;
		this.email = email;
		this.mobile = mobile;
		this.username = username;
		this.password = password;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "contractor [id=" + id + ", email=" + email + ", mobile=" + mobile + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

	


	
	
	
	

}
