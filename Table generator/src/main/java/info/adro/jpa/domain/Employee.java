package info.adro.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
public class Employee {
	@Id
	@TableGenerator(name = "mojGenerator",
		table = "tabela_z_identyfikatorami",
		pkColumnName = "nazwa_sekwencji",
		valueColumnName = "wartosc_identyfikatora",
		pkColumnValue = "autoId",
		initialValue = 10,
		allocationSize = 15
			)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "mojGenerator")
	private long id;

	@Column(name = "imie")
	private String firstName;
	@Column(name = "nazwisko")
	private String lastName;
	@Column(name = "pensja")
	private double salary;

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
