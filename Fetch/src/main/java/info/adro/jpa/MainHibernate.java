package info.adro.jpa;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import info.adro.jpa.domain.Employee;
import info.adro.jpa.domain.Phone;

public class MainHibernate {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
   
	public static void main( String[] args ) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();
		
		Employee empl = new Employee ();
		Phone p1 = new Phone();
		Phone p2 = new Phone();
		empl.setFirstName("Jan");
		empl.setLastName("Nowak");
		empl.setSalary(3333.3);
		p1.setType("Mobile");
		p1.setNumber("48646363");
		p2.setType("Home");
		p2.setNumber("503157415");
		List<Phone> phones = new LinkedList<Phone>();
		phones.add(p1);
		phones.add(p2);
		empl.setPhones(phones);
		entityManager.getTransaction().begin();
		//entityManager.persist(p1);
		//entityManager.persist(p2);
		entityManager.persist(empl);
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
