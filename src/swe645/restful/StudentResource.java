package swe645.restful;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


/**
 * Servlet implementation class StudentResource
 */

@WebServlet("/StudentResource")
public class StudentResource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentResource() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO2 dao = new StudentDAO2();
		StudentBean student = new StudentBean();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		
		if(request.getParameter("studentid") == null) {
			ArrayList<String> ids = dao.getIDs();
			String json = new Gson().toJson(ids);
			
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		}
		else if(request.getParameter("username") == null) {
			student = dao.getStudent(request.getParameter("studentid"));
			
			String json = new Gson().toJson(student);
			
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		}
		else {
			student.setId(request.getParameter("studentid"));
			student.setUsername(request.getParameter("username"));
			student.setStreet(request.getParameter("address"));
			student.setCity(request.getParameter("city"));
			student.setState(request.getParameter("state"));
			student.setZip(request.getParameter("zip"));
			student.setPhone(request.getParameter("phone"));
			student.setEmail(request.getParameter("email"));
			student.setDate(request.getParameter("date"));

			dao.saveInfo(student);
		}		
	}

}
