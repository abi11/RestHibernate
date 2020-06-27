package org.java.hibernate.abhi.mapping;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//@Entity(name="USER_DETAILS")

@Entity
@Table(name="USER_DETAILS")
//@org.hibernate.annotations.Entity(selectBeforeUpdate =true )
public class UserDetailsMapping {
	
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;	
	private String userName;
	
	//@OneToMany(mappedBy = "user")
	
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<VehicleMapping> vehicle= new ArrayList<VehicleMapping>();
	
	
	public Collection<VehicleMapping> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<VehicleMapping> vehicle) {
		this.vehicle = vehicle;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName + "from getter";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
