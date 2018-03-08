package info.adro.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Phone {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

private String type;
private String number;
@ManyToOne
@JoinColumn(name = "owner_id")
private Employee owner;

public Employee getOwner() {
	return owner;
}
public void setOwner(Employee owner) {
	this.owner = owner;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}	
}
