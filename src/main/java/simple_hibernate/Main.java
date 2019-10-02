package simple_hibernate;


import javax.persistence.RollbackException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import simple_hibernate.domain.SimpleEntity;

public class Main {
	 
	 public static void main(String[] args) throws HibernateException{
		 
		Transaction transaction = null; 
		Session session = null; 
		SessionFactory sessionFactory = null;
		
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			SimpleEntity entity = new SimpleEntity("first_property", 14, true);
			int entityId = (Integer)session.save(entity);
			SimpleEntity entityFromDb = session.get(SimpleEntity.class, entityId);
			transaction.commit();
			System.out.println(entityFromDb.getPropertyOne());
		}
		catch (HibernateException | RollbackException | IllegalStateException e){
			 if (transaction != null) {
				 transaction.rollback();
			 }
		}
		finally{
			HibernateException exception = new HibernateException("Unable to close resources");
			
			if(session != null) {
				try {
					session.close();
				}catch(HibernateException e) {
					exception.addSuppressed(e);
				}	
			}
			
			if(sessionFactory != null) {
				try {
					sessionFactory.close();
				}catch(HibernateException e) {
					exception.addSuppressed(e);
				}	
			}
			
			if (exception.getSuppressed().length > 0) {
				throw exception;
			}
		} 
	 } 
}
