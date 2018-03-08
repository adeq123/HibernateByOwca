package info.adro.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Phone {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

private String type;
private String number;

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
