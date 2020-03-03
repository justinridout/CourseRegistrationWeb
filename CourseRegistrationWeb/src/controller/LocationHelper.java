package controller;

import java.util.List;

import javax.persistence.*;

import model.Location;

public class LocationHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CourseRegistrationWeb");
	
	public void insertNewLocation(Location l) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Location> getLocation(){
		EntityManager em = emfactory.createEntityManager();
		List<Location> allLocations = em.createQuery("SELECT l  FROM Location l").getResultList();
		return allLocations;
	}
	
	public void deleteLocation(Location toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		/*TypedQuery<Location>*/ Query typedQuery = em.createQuery("DELETE FROM Location lo WHERE lo.locationName = '" + toDelete.getLocationName() + "' and lo.city = '" + toDelete.getCity() + "' and lo.state = '" + toDelete.getState() +"'",
				Location.class);
		
		//typedQuery.setParameter("selectedName", toDelete.getLocationName());
		//typedQuery.setParameter("selectedCity", toDelete.getCity());
		//typedQuery.setParameter("selectedState", toDelete.getState());
		
		
		//typedQuery.setMaxResults(1);
		
		//Location result = typedQuery.getResultList();
		
		//em.remove(result);
		//em.getTransaction().commit();
		System.out.println(typedQuery.executeUpdate());
		em.close();
	}
	
	public Location searchForLocationById(int tempId) {
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		Location found = em.find(Location.class, tempId);
		System.out.println(found);
		em.close();
		return found;
	}
	
	public void updateLocation(Location toUpdate) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toUpdate);
		em.getTransaction().commit();
		em.close();
	}
}
