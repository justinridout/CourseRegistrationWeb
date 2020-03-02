package model;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "LOCATION_NAME")
	private String locationName;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state;

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "courses_in_location", joinColumns = {
			@JoinColumn(name = "COURSE_ID", referencedColumnName = "COURSE_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ID", referencedColumnName = "ID", unique = true) })
	private List<CourseDetails> listOfCourses;

	public Location() {
		super();
	}

	public Location(int id, String locationName, String city, String state, List<CourseDetails> listOfCourses) {

		this.id = id;
		this.locationName = locationName;
		this.city = city;
		this.state = state;
		this.listOfCourses = listOfCourses;
	}

	public Location(String locationName, String city, String state, List<CourseDetails> listOfCourses) {

		this.locationName = locationName;
		this.city = city;
		this.state = state;
		this.listOfCourses = listOfCourses;
	}

	public Location(String locationName, String city, String state) {

		this.locationName = locationName;
		this.city = city;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<CourseDetails> getListOfCourses() {
		return listOfCourses;
	}

	public void setListOfCourses(List<CourseDetails> listOfCourses) {
		this.listOfCourses = listOfCourses;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", locationName=" + locationName + ", city=" + city + ", state=" + state
				+ ", listOfCourses=" + listOfCourses + ", getId()=" + getId() + ", getLocationName()="
				+ getLocationName() + ", getCity()=" + getCity() + ", getState()=" + getState()
				+ ", getListOfCourses()=" + getListOfCourses() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
