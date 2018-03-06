package info.adro.jpa;


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
		//employee.setId(1L);
		employee.setFirstName("Jan");
		employee.setLastName("Nowak");
		employee.setSalary(3333.3);
		
		Employee employee2 = new Employee();
		//employee2.setId(1L);
		employee2.setFirstName("Robert");
		employee2.setLastName("Bednarek");
		employee2.setSalary(4444.4);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(employee2);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
    }
}
