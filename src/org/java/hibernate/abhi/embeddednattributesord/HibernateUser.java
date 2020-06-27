package org.java.hibernate.abhi.embeddednattributesord;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class HibernateUser {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;	
	private String userName;
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name = "street", column=@Column(name="HOME_STREET_NAME")),
	@AttributeOverride(name = "city", column=@Column(name="HOME_CITY_NAME")),
	@AttributeOverride(name = "pincode", column=@Column(name="HOME_PINCODE_NAME")),
	@AttributeOverride(name = "state", column=@Column(name="HOME_STATE_NAME")),
	})
	private HibernateAddress homeAddress;
	@Embedded
	private HibernateAddress officeAddress;
	
	
	public HibernateAddress getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(HibernateAddress homeAddress) {
		this.homeAddress = homeAddress;
	}
	public HibernateAddress getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(HibernateAddress officeAddress) {
		this.officeAddress = officeAddress;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
