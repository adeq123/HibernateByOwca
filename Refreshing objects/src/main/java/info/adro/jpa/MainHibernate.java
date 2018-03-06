package info.adro.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import info.adro.jpa.domain.Employee;

public class MainHibernate 
{
    public static void main( String[] args )
    {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = new Employee();
		employee.setFirstName("Jan");
		employee.setLastName("Kowalski");
		employee.setSalary(3000);
		

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		System.out.println(employee.toString());
		entityManager.getTransaction().commit();
		
		entityManager.refresh(employee);
		System.out.println(employee.toString());
		
		entityManager.close();
		entityManagerFactory.close();
    }
}
