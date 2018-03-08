package info.adro.jpa.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;

	@ManyToMany
	@JoinTable(
			name = "pracownicy_w_projektach",
			joinColumns = {@javax.persistence.JoinColumn(name = "id_projektu")},
			inverseJoinColumns = {@javax.persistence.JoinColumn(name = "id_pracownika")}
			)
	private List <Employee> employees;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getProjects() {
		return employees;
	}
	public void setProjects(List<Employee> employees) {
		this.employees = employees;
	}

}
