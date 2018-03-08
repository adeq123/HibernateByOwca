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
		employee.setLastName("Nowak");
		employee.setSalary(33111.3);
		

		Employee employee1 = new Employee();
		employee1.setFirstName("Marek");
		employee1.setLastName("Czwartek");
		employee1.setSalary(1500.3);
		
		Employee employee2 = new Employee();
		employee2.setFirstName("Anna");
		employee2.setLastName("Kowalska");
		employee2.setSalary(2500);
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(employee1);
		entityManager.persist(employee2);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
    }
}
