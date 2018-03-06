package info.adro.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import info.adro.jpa.domain.Employee;

public class FindAndModify {
	
	public static void main(String args[]) {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	entityManager.getTransaction().begin();
	Employee empl = entityManager.find(Employee.class, 1L);
	System.out.println("First name: " + empl.getFirstName());
	System.out.println("Last name: " + empl.getLastName());
	System.out.println("Salary: " + empl.getSalary());
	
	empl.setSalary(2000);
	entityManager.getTransaction().commit();
	
	entityManager.close();
	entityManagerFactory.close();
	}
}
