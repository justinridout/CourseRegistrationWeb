package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CourseDetails;

/**
 * Servlet implementation class AddCourseServlet
 */
@WebServlet("/addCourseServlet")
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String courseName = request.getParameter("courseName");
		String courseDescription = request.getParameter("courseDesc");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
					
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		CourseDetails cd = new CourseDetails(courseName, courseDescription, ld);
		
		CourseDetailsHelper cdh = new CourseDetailsHelper();
		cdh.insertCourse(cd);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
