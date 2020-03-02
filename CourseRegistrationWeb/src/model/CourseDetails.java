package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="course_details")
public class CourseDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "COURSE_ID")
	private int id;
	
	@Column(name="COURSE_NAME")
	private String courseName;
	
	@Column(name="COURSE_DESCRIPTION")
	private String courseDescription;
	
	@Column(name="START_DATE")
	private LocalDate startDate;
	
	
	
	
	public CourseDetails() {
		super();
	}
	
	
	public CourseDetails(String courseName, String courseDescription, LocalDate startDate) {
		super();
		this.courseDescription = courseDescription;
		this.courseName = courseName; 
		this.startDate = startDate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getCourseDescription() {
		return courseDescription;
	}


	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	@Override
	public String toString() {
		return "CourseDetails [id=" + id + ", courseName=" + courseName + ", courseDescription=" + courseDescription
				+ ", startDate=" + startDate + "]";
	}
	
}
