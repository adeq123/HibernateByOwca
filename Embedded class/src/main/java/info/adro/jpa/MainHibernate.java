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
		
		Employee employee = new Employee();
		employee.setFirstName("Jan");
		employee.setLastName("Nowak");
		employee.setSalary(3333.3);
		employee.setLocality("Warszawa");
		employee.setZipCode("43-330");
		employee.setStreet("Koszykowa");
		employee.setStreetNumber(111);

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
    }
}
