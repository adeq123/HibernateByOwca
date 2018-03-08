package info.adro.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import info.adro.jpa.domain.Employee;

public class MainHibernate {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main( String[] args ) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();

		addEmployees();
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
		Root<Employee> employee = criteriaQuery.from(Employee.class);
		Path<Double> salary = employee.get("salary");
		criteriaQuery.select(employee).where(builder.and( builder.greaterThan(salary, 3000.0), builder.lessThan(salary, 5000.0)));
		TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
		List<Employee> empl = query.getResultList();
		
		empl.forEach(e -> System.out.println(e.toString()));
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
