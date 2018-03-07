package info.adro.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainHibernate {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		//EntityManager entityManager = entityManagerFactory.createEntityManager();
	
		//entityManager.close();
		entityManagerFactory.close();
	}

}
