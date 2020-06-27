package org.java.hibernate.abhi.mapping;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class VehicleMany2Many {
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;

	@ManyToMany(mappedBy = "vehicle")
	private Collection<UserDetailsMany2Many> userList = new ArrayList<UserDetailsMany2Many>();
	
	public Collection<UserDetailsMany2Many> getUserList() {
		return userList;
	}
	public void setUserList(Collection<UserDetailsMany2Many> userList) {
		this.userList = userList;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	

}
