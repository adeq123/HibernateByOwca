package info.adro.jpa;

import java.util.Iterator;
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
		//TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.salary > 3000 order by e.salary", Employee.class);
		//List<Employee> employees = query.getResultList();
		
		Query query = entityManager.createQuery("select concat(e.firstName,' ', e.lastName), e.salary * 0.2 from Employee e");
		Iterator<?> iter = query.getResultList().iterator();
		while(iter.hasNext()) {
			Object[] item = (Object[]) iter.next();
			String name = (String) item[0];
			double tax = (Double) item[1];
			System.out.println(name + " has to pay " + tax);
		}
		
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
