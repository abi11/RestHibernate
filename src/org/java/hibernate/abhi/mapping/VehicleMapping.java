package org.java.hibernate.abhi.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class VehicleMapping {
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	//@ManyToOne
	//@JoinColumn(name="USER_ID")
	//@NotFound(action = NotFoundAction.IGNORE)
//	private UserDetailsMapping user;
//	
//	
//	public UserDetailsMapping getUser() {
//		return user;
//	}
//	public void setUser(UserDetailsMapping user) {
//		this.user = user;
//	}
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
