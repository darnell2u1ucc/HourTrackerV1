

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.info;



@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	/*
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	/*	String test = request.getParameter("month");
		PrintWriter writer = response.getWriter();
		writer.println(test);
		*/
		//ServletContext context = request.getServletContext();
		
		String input = request.getParameter("submitbutton");
		//if(input.equalsIgnoreCase("main"))
		if(request.getParameter("submitbutton").equals("main"))
		{
		response.sendRedirect("option.jsp");	
		}
		else
		{	
		if(!(request.getParameter("month").equals(""))){
		info newrecord = new info();
		newrecord.setrecord(request.getParameter("month"), request.getParameter("day"), request.getParameter("year"), request.getParameter("hours"));
		
		//HttpSession s = request.getSession();
		
		//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		//Session session = sessionFactory.openSession();
		final saver s = new saver();
		Session session = s.returnSessionFactory().openSession();
		
		session.beginTransaction();
		session.save(newrecord);
		session.getTransaction().commit();
		session.close();
		s.close();
		//sessionFactory.close();
		response.sendRedirect("default.jsp");
		}
		
			
		
		
		}
	}

}
