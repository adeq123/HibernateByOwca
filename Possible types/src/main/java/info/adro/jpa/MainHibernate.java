package info.adro.jpa;


import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import info.adro.jpa.domain.Employee;

/**
 * Hello world!
 *
 */
public class MainHibernate 
{
    public static void main( String[] args )
    {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.close();
		entityManagerFactory.close();
    }
}
