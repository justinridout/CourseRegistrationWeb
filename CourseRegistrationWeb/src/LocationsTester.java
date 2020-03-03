import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.LocationHelper;
import model.CourseDetails;
import model.Location;

public class LocationsTester {

	public static void main(String[] args) {
		
		CourseDetails cd = new CourseDetails("Computer Science", "Learn About Computers", LocalDate.now());
		CourseDetails bio = new CourseDetails("Biology", "Learn About Biology", LocalDate.now());
		
		LocationHelper lh = new LocationHelper();
		
		List<CourseDetails> courseList = new ArrayList<CourseDetails>();
		
		courseList.add(cd);
		courseList.add(bio);
		
		Location ankeny = new Location("DMACC", "Ankeny", "IA");
		
		ankeny.setListOfCourses(courseList);
		
		lh.insertNewLocation(ankeny);
		
		List<Location> allLocations = lh.getLocation();
		
		for (Location l: allLocations) {
			System.out.println(l.toString());
			
		}

	}

}
