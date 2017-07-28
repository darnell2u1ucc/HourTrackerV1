

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import com.info;

/**
 * Servlet implementation class edit
 */
@WebServlet("/edit")
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final saver session = new saver();
		Session a = session.returnSessionFactory().openSession();
		a.beginTransaction();
		Query query = a.createQuery("from info where day=? and month=? and year=? and hours=?");
		query.setInteger(0, Integer.parseInt(request.getParameter("day")));
		query.setInteger(1, Integer.parseInt(request.getParameter("month")));
		query.setInteger(2, Integer.parseInt(request.getParameter("year")));
		query.setDouble(3, Double.parseDouble(request.getParameter("hours")));
		query.setMaxResults(1);
		List<info> user = (List<info>)query.list();
		info singleuser = new info();
		
		if (user.size() >= 1) {
		for(info u : user) {
			a.delete(u);
		}
		}
		
		a.getTransaction().commit();
		a.close();
		session.close();
		
		response.sendRedirect("option.jsp");
	}

}
