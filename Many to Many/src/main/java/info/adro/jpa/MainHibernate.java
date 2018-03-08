package info.adro.jpa;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import info.adro.jpa.domain.Employee;
import info.adro.jpa.domain.Project;

public class MainHibernate {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
   
	public static void main( String[] args ) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();
		
		Project project1 = new Project();
		project1.setName("Proj 1");
		Project project2 = new Project();
		project2.setName("Proj 2");
		
		
		Employee empl = new Employee ("Karol", "Mareusiak", 2362);
		Employee emp2 = new Employee ("Marik", "Bednarek", 3232);
		Employee emp3 = new Employee ("Jan", "Mateusiak", 542342);
		Employee emp4 = new Employee ("Anna", "Mateusiak", 2222);
		Employee emp5 = new Employee ("Adrian", "Roguski", 19999);
		ArrayList<Employee> employees1 = new ArrayList<Employee>();
		ArrayList<Employee> employees2 = new ArrayList<Employee>();
		employees1.add(empl);
		employees1.add(emp2);
		employees1.add(emp3);
		employees2.add(emp4);
		employees2.add(emp5);
		
		project1.setProjects(employees1);
		project2.setProjects(employees2);
		
		//empl.setPhones(phones);
		entityManager.getTransaction().begin();

		entityManager.persist(empl);
		entityManager.persist(emp2);
		entityManager.persist(emp3);
		entityManager.persist(emp4);
		entityManager.persist(emp5);
		entityManager.persist(project1);
		entityManager.persist(project2);
		entityManager.getTransaction().commit();
		
		entityManager.refresh(empl);
		//empl.getPhones().forEach(p -> System.out.println(p.getNumber()));
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
