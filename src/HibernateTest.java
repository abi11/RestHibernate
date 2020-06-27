import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.java.hibernate.abhi.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails ud = new UserDetails();
		ud.setUserId(1);
		ud.setUserName("mishra");
		ud.setAddress("First User Address");
		ud.setJoinDate(new Date());
		ud.setDescription("User Description of User 1");
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(ud);
		 //end the transaction
        session.getTransaction().commit();

        //Closing the session
        session.close();
	}

}
