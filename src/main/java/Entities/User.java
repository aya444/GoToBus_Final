package Entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userid;
	private String username;
	private String password;
	private String full_name;
	private String role;
	private static final long serialVersionUID = 1L;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="UserTripN",
			joinColumns=@JoinColumn(name="user_id"),
		    inverseJoinColumns=@JoinColumn(name="tripid"))
	private Set <TripN> trips = new HashSet<TripN>();

	public Set<TripN> getTrips() {
		return trips;
	}
	public void setTrips(Set<TripN> trips) {
		this.trips = trips;
	}
	public User() {
		super();
	}   
	public Integer getId() {
		return this.userid;
	}

	public void setId(Integer uid) {
		this.userid = uid;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getFull_name() {
		return this.full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}   
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public void addusertrip(TripN trip)
	{
		this.trips.add(trip);
	}
   
}
