import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public  class saver {
	private static SessionFactory sessionFactory;
	
	
	
	
	
	public SessionFactory returnSessionFactory(){
		try {
		sessionFactory = new Configuration().configure().buildSessionFactory(); 
		//Session session = sessionFactory.openSession();
		return sessionFactory;
		}
		catch(Exception E) {
		E.printStackTrace();	
		}
		//session.save();
		sessionFactory = new Configuration().configure().buildSessionFactory(); 
		//Session session = sessionFactory.openSession();
		return sessionFactory;
		
	}
	
	public void close()
	{
		sessionFactory.close();
	}
	
	

}
