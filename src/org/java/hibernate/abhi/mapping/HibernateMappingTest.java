package org.java.hibernate.abhi.mapping;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMappingTest {


	public static void main(String[] args) {
		
		UserDetailsMapping ud = new UserDetailsMapping();
		ud.setUserId(1);
		ud.setUserName("mishra");
		VehicleMapping vehicle = new VehicleMapping();
		vehicle.setVehicleName("myCar");
		
		VehicleMapping vehicle1 = new VehicleMapping();
		vehicle1.setVehicleName("Car");
		ud.getVehicle().add(vehicle);
		ud.getVehicle().add(vehicle1);
//		vehicle.setUser(ud);
//		vehicle.setUser(ud);
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
