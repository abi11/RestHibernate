package org.java.hibernate.abhi.mapping;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
@org.hibernate.annotations.Entity(selectBeforeUpdate =true )
public class UserDetailsMany2Many {
	
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;	
	private String userName;
	@ManyToMany
	@JoinTable(name="USER_MANY2MANY_VEHICLE",joinColumns =@JoinColumn(name="USER_ID"),inverseJoinColumns = @JoinColumn(name="VEHICLE_ID"))
	private Collection<VehicleMany2Many> vehicle= new ArrayList<VehicleMany2Many>();
	
	
	public Collection<VehicleMany2Many> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<VehicleMany2Many> vehicle) {
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
