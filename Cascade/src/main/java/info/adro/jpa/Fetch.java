package info.adro.jpa;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import info.adro.jpa.domain.Employee;
import info.adro.jpa.domain.Phone;

public class Fetch {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
   
	public static void main( String[] args ) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();
		
		Employee empl = entityManager.find(Employee.class, 1L);
		empl.getPhones().forEach(e -> System.out.println(e.getNumber()));
		entityManager.getTransaction().begin();
	
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
    }
	
	private static void addEmployees() {
		addEmployee("Karol", "Mareusiak", 2362);
		addEmployee("Marik", "Bednarek", 3232);
		addEmployee("Jan", "Mateusiak", 542342);
		addEmployee("Anna", "Mateusiak", 2222);
		addEmployee("Daria", "Kowalska", 456462);
		addEmployee("Monika", "Ucinska", 23456);
		addEmployee("Ernest", "Pajak", 6452);
		addEmployee("Artur", "Owczarek", 9999);
		addEmployee("Adrian", "Roguski", 19999);
		
	}
	
	private static void addEmployee(String firstName, String lastName, double salary) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);
		

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}
}
