package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.CourseDetails;

public class CourseDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CourseRegistrationWeb");
	
	public void insertCourse(CourseDetails cd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(cd);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CourseDetails> showAllCourses(){
		EntityManager em = emfactory.createEntityManager();
		List<CourseDetails> allCourses = em.createQuery("SELECT c FROM CourseDetails c").getResultList();
		return allCourses;
	}
	
	//ADD DELETE
	//ADD SEARCH BY ID
	//ADD UPDATE COURSE
	
	public void cleanUp() {
		emfactory.close();
	}
}
