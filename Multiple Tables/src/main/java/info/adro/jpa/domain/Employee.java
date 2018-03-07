package info.adro.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pracownicy")
public class Employee {
	@Id
	@GeneratedValue
	private long id;

	//@Column(name = "imie")
	private String firstName;
	//@Column(name = "nazwisko")
	private String lastName;
	@Embedded
	public Address getData() {
		return data;
	}
	public void setData(Address data) {
		this.data = data;
	}
	@Column(name = "pensja")
	private double salary;

	private Address data = new Address();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}


}
