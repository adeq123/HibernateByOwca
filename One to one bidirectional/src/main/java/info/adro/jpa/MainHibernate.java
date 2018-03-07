package info.adro.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import info.adro.jpa.domain.Cat;
import info.adro.jpa.domain.Owner;

public class MainHibernate {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main( String[] args ) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();
		
		Owner owner = new Owner();
		Cat cat = new Cat();
		owner.setFirstName("Jan");
		owner.setLastName("Nowak");
		owner.setCat(cat);
		cat.setName("kotek");
		
		entityManager.getTransaction().begin();
		entityManager.persist(owner);
		entityManager.persist(cat);
		entityManager.getTransaction().commit();
		entityManager.refresh(cat);
		entityManager.close();
		entityManagerFactory.close();
	}

	
}
