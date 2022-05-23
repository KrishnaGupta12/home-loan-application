

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegHomelone
 */
@WebServlet("/RegHomelone")
public class RegHomelone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegHomelone() {
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
		String Locality = request.getParameter("Locality");
		String House_condition = request.getParameter("House_condition");
		String Salary = request.getParameter("Salary");
		String Months = request.getParameter("Months");
		
		Member member = new Member(Locality,House_condition , Salary, Months);
		
		HomeLoneRegrDao rDao = new HomeLoneRegrDao();
		String result = rDao.insert(member);
		response.getWriter().print(result);
	}

}
