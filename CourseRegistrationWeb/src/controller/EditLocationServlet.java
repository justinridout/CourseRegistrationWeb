package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CourseDetails;
import model.Location;

/**
 * Servlet implementation class EditLocationServlet
 */
@WebServlet("/editLocationServlet")
public class EditLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLocationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseDetailsHelper cdh = new CourseDetailsHelper();
		LocationHelper lh = new LocationHelper();
		
		String locationName = request.getParameter("locationName");
		String locationCity = request.getParameter("locationCity");
		String locationState = request.getParameter("locationState");
		
		String[] selectedCourses = request.getParameterValues("allCoursesToAdd");
		List<CourseDetails> selectedCoursesInLocation = new ArrayList<CourseDetails>();
		
		if(selectedCourses != null && selectedCourses.length > 0) {
			for (int i = 0; i<selectedCourses.length; i++) {
				System.out.println(selectedCourses[i]);
				CourseDetails c = cdh.searchForCourseById(Integer.parseInt(selectedCourses[i]));
				selectedCoursesInLocation.add(c);
			}
		}
		
		try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			
			Location toUpdate = lh.searchForLocationById(tempId);
			
			
			toUpdate.setLocationName(locationName);
			toUpdate.setCity(locationCity);
			toUpdate.setState(locationState);
			toUpdate.setListOfCourses(selectedCoursesInLocation);
			
			
			lh.updateLocation(toUpdate);
			
		}catch (NumberFormatException e) {
			System.out.println(" IDK ");
		}
		
		getServletContext().getRequestDispatcher("/viewAllLocationsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
