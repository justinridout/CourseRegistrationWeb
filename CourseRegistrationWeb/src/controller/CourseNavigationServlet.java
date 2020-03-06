package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Location;

/**
 * Servlet implementation class CourseNavigationServlet
 */
@WebServlet("/courseNavigationServlet")
public class CourseNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseNavigationServlet() {
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
		CourseDetailsHelper cdh = new CourseDetailsHelper();
		LocationHelper lh = new LocationHelper();
		
		String action = request.getParameter("doThisToLocation");
		String path = "/viewAllLocationsServlet";
		
		if(action.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Location toDelete = lh.searchForLocationById(tempId);
				lh.deleteLocation(toDelete);
			}catch(NumberFormatException e) {
				System.out.println("Please select a location");
			}
			
		}
		
		else if(action.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Location toEdit = lh.searchForLocationById(tempId);
				request.setAttribute("toEdit", toEdit);
				path = "/edit-location.jsp";
				
				request.setAttribute("allCourses", cdh.showAllCourses());
				if(cdh.showAllCourses().isEmpty()) {
					request.setAttribute("allCourses", " ");
				}
			}catch(NumberFormatException e) {
				System.out.println("Please select a location");
			}
		}
		else if (action.equals("add")) {
			path = "/new-location.jsp";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
