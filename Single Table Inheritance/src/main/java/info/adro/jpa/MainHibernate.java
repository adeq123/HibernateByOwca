package info.adro.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import info.adro.jpa.domain.Professor;
import info.adro.jpa.domain.Student;

public class MainHibernate 
{
    public static void main( String[] args )
    {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Professor professor = new Professor();
		professor.setFirstName("Jan");
		professor.setLastName("Nowak");
		professor.setSalary(2000.0);
		
		Student student = new Student();
		student.setFirstName("Zbyszek");
		student.setLastName("Kowalski");
		student.setAverageGrade(4.90);
		
		entityManager.getTransaction().begin();
		entityManager.persist(professor);
		entityManager.persist(student);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
    }
}
