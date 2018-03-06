package info.adro.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import info.adro.jpa.domain.Employee;

public class MainHibernate {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main( String[] args ) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();

		addEmployees();
		/*Query query = entityManager.createQuery("select avg(e.salary), min(e.salary), max(e.salary), sum(e.salary), count(e) from Employee e");
		
		Object[] result = (Object[]) query.getSingleResult();
		System.out.println("Œrednia: " + result [0]);
		System.out.println("Najnizsza: " + result [1]);
		System.out.println("Najwyzsza: " + result [2]);
		System.out.println("Suma: " + result [3]);
		System.out.println("Pracownikow: " + result [4]);
*/
		
		Query query = entityManager.createQuery("select substring(e.firstName, 1, 3), trim(e.lastName), lower(e.firstName), upper(e.firstName), length(e.firstName) from Employee e where e.firstName = 'Karol'");
		Object[] result = (Object[]) query.getSingleResult();
		System.out.println("Pierwsze trzy litery imienia " + result[0]);
		System.out.println("Nazwisko: | " + result[1]);
		System.out.println("Imie ma³ymi l. | " + result[2]);
		System.out.println("Imie wielkimi l. | " + result[3]);
		System.out.println("Dlugosc imienia l. | " + result[4]);
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
