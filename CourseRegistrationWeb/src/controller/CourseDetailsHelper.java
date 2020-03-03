package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	
	public void deleteCourse(CourseDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CourseDetails> typedQuery = em.createQuery(
				"SELECT cd FROM CourseDetails cd WHERE cd.courseName = : selectedCourse and cd.courseDescription = : selectedDescription",
				CourseDetails.class);
		
		typedQuery.setParameter("selectedCourse", toDelete.getCourseName());
		typedQuery.setParameter("selectedDescription", toDelete.getCourseDescription());
		
		typedQuery.setMaxResults(1);
		
		CourseDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public CourseDetails searchForCourseById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CourseDetails found = em.find(CourseDetails.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateCourse(CourseDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
