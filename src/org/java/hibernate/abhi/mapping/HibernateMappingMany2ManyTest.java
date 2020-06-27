package org.java.hibernate.abhi.mapping;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMappingMany2ManyTest {


	public static void main(String[] args) {
		
		UserDetailsMany2Many ud = new UserDetailsMany2Many();
		ud.setUserId(1);
		ud.setUserName("mishra");
		
		VehicleMany2Many vehicle = new VehicleMany2Many();
		vehicle.setVehicleName("myCar");
		
		VehicleMany2Many vehicle1 = new VehicleMany2Many();
		vehicle1.setVehicleName("Car");
		
		ud.getVehicle().add(vehicle);
		ud.getVehicle().add(vehicle1);
		vehicle.getUserList().add(ud);
		vehicle1.getUserList().add(ud);
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(ud);
	    session.save(vehicle);
	    session.save(vehicle1);
		session.getTransaction().commit();
		session.close();
	
	}


}
