package info.adro.jpa;


import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import info.adro.jpa.domain.Address;
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
		Address address = new Address();
		employee.setFirstName("Jan");
		employee.setLastName("Nowak");
		employee.setSalary(33111.3);
		address.setLocality("bb");
		address.setStreet("ss");
		address.setStreetNumber(333);
		address.setZipCode("43-1232");
		employee.setData(address);

		entityManager.getTransaction().begin();
		entityManager.persist(address);
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
    }
}
