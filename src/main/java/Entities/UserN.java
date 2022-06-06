//package Entities;
//
//import java.io.Serializable;
//import java.lang.Integer;
//import java.lang.String;
//import java.util.Set;
//import javax.persistence.*;
//
///**
// * Entity implementation class for Entity: UserN
// *
// */
//@Entity
//
//public class UserN implements Serializable {
//
//	   
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Integer id;
//	private String username;
//	private String password;
//	private String full_name;
//	private String role;
//	private Set userTrips;
//	private static final long serialVersionUID = 1L;
//
//	public UserN() {
//		super();
//	}   
//	public Integer getId() {
//		return this.id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}   
//	public String getUsername() {
//		return this.username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}   
//	public String getPassword() {
//		return this.password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}   
//	public String getFull_name() {
//		return this.full_name;
//	}
//
//	public void setFull_name(String full_name) {
//		this.full_name = full_name;
//	}   
//	public String getRole() {
//		return this.role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}   
//	public Set getUserTrips() {
//		return this.userTrips;
//	}
//
//	public void setUserTrips(Set userTrips) {
//		this.userTrips = userTrips;
//	}
//   
//}
