package org.java.hibernate.abhi.embeddednattributesord;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestEmbedded {

	public static void main(String[] args) {
		HibernateUser ud = new HibernateUser();
		ud.setUserName("mishra");
		
		HibernateAddress addr= new HibernateAddress();
		addr.setStreet("home street name");
		addr.setCity("Home City Address");
		
		
		HibernateAddress offaddr= new HibernateAddress();
		offaddr.setStreet("office street name");
		offaddr.setCity("office City Address");
		ud.setHomeAddress(addr);
		ud.setOfficeAddress(offaddr);
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(ud);
	    
		session.getTransaction().commit();
		session.close();

	}

}
