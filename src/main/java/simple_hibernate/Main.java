package simple_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import simple_hibernate.domain.SimpleEntity;

public class Main {
	 
	 public static void main(String[] args) {
		 
		 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		 Session session = sessionFactory.openSession();
		 Transaction transaction = session.beginTransaction();
		 SimpleEntity entity = new SimpleEntity("first_property", 14, true);
		 int entityId = (Integer)session.save(entity);
		 transaction.commit();
		 SimpleEntity entityFromDb = session.get(SimpleEntity.class, entityId);
		 System.out.println(entityFromDb.getPropertyOne());
	 } 
	 
	 
	
}
