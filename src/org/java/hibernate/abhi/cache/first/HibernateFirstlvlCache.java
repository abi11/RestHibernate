package org.java.hibernate.abhi.cache.first;


import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.java.hibernate.abhi.dto.UserDetails;
import org.java.hibernate.abhi.dto.Vehicle;

public class HibernateFirstlvlCache {

	public static void main(String[] args) {
		
		UserDetails ud = new UserDetails();
		ud.setUserId(1);
		ud.setUserName("mishra");
		ud.setAddress("First User Address");
		ud.setJoinDate(new Date());
		ud.setDescription("User Description of User 1");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("myCar");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");
		ud.getVehicle().add(vehicle);
		ud.getVehicle().add(vehicle1);
		//ud.setVehicle(vehicle);
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(ud);
	 session.save(vehicle);
	 session.save(vehicle1);
		
		
		session.getTransaction().commit();
		session.close();
		
		ud = null;
//		Query query = session.createQuery("from UserDetails user where user.userId =1").setCacheable(true);
//		List users = query.getResultList();
	session = sessionFactory.openSession();
	session.beginTransaction();
	//session.get(UserDetails.class, 1);
		UserDetails user= (UserDetails)(session.get(UserDetails.class,1));
		//user.setUserName("updated userName");
		
		System.out.println("User Name: " + user.getUserName());
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		UserDetails user2= (UserDetails)(session2.get(UserDetails.class,1));
		
//		Query query2 = session2.createQuery("from UserDetails user where user.userId =1").setCacheable(true);
//		users = query2.getResultList();
		session2.getTransaction().commit();
		session2.close();
	}

}
