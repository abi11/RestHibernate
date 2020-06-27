package org.java.hibernate.abhi.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


//@Entity(name="USER_DETAILS")
@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@NamedQuery(name="UserDetails.byId",query="from UserDetails where userId= ?0" )
@Table(name="USER_DETAILS")
@org.hibernate.annotations.Entity(selectBeforeUpdate =true )
public class UserDetails {
	
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;	
	//@Basic  to save default
	
	
	private String userName;
	private Date joinDate;
	private String address;
	
	private String description;
//	@OneToOne
//	@JoinColumn(name="VEHICLE_ID")
//private Vehicle vehicle;
//	
//	
//	public Vehicle getVehicle() {
//		return vehicle;
//	}
//	public void setVehicle(Vehicle vehicle) {
//		this.vehicle = vehicle;
//	}
	@OneToMany
	@JoinTable(name="USER_VEHICLE", joinColumns = @JoinColumn(name="USER_ID"),inverseJoinColumns = @JoinColumn(name="VEHICLE_ID"))
	private Collection<Vehicle> vehicle= new ArrayList<Vehicle>();
	
	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	@Temporal(TemporalType.DATE)
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	@Transient
	public String getAddress() {
		return address;
	}
	
	
	public void setAddress(String address) {
		this.address = address;
	}
	@Lob
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	//@Id
	@Column(name="USER_ID")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name="USER_NAME")
	public String getUserName() {
		return userName + "from getter";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
