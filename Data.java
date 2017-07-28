

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.info;

/**
 * Servlet implementation class Data
 */
@WebServlet("/Data")
public class Data extends HttpServlet {
	 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("SubmitButton").equalsIgnoreCase("viewdata"))
		{
			
			//SessionFactory sessionfactory = new  Configuration().configure().buildSessionFactory();
			
			//HttpSession s = request.getSession();
			
			//SessionFactory sf= (SessionFactory)s.getAttribute("sfactory");
			/*
			Session session= sf.openSession();
			Session session = sessionfactory.openSession();
			session.beginTransaction();
			*/
			final saver session = new saver();
		
			Session a =session.returnSessionFactory().openSession();
			a.beginTransaction();
			Query<info> query = a.createQuery("from info");
			List<info> users = (List<info>)query.list();
			request.setAttribute("recordlist", users);
			/*
			for(info u: users){
				System.out.println("MONTH: "+u.getMonth()+" DAY:"+u.getDay()+" YEAR: "+u.getYear()+" HOURS: "+u.getHours());
				}
				*/
			a.close();
			session.close();
			//sessionfactory.close();
			
			//way1
			RequestDispatcher dispatcher = request.getRequestDispatcher("/tabledata.jsp");
			dispatcher.forward(request, response);
			
			//  way2 request.getRequestDispatcher("/tabledata.jsp").forward(request, response);
			// way3 getServletConfig().getServletContext().getRequestDispatcher("/tabledata.jsp").forward(request, response);
			//response.sendRedirect("tabledata.jsp");
			
		}
		else if(request.getParameter("SubmitButton").equalsIgnoreCase("adddata")){
			response.sendRedirect("default.jsp");
		}
			
		else{
			//edit data
			response.sendRedirect("editdata.jsp");
		
			
	}
		
		
	}


	
	
	
}
