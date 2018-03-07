package info.adro.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class DataTime {

	@Id
	private long id;

	private java.sql.Date date;
	private java.sql.Time time;
	private java.sql.Timestamp timestamp;
	
	@Temporal(TemporalType.DATE)
	private java.util.Date utilDate;
	@Temporal(TemporalType.TIME)
	private java.util.Date utilCalendar;
	
	public java.util.Date getUtilDate() {
		return utilDate;
	}

	public void setUtilDate(java.util.Date utilDate) {
		this.utilDate = utilDate;
	}

	public java.util.Date getUtilCalendar() {
		return utilCalendar;
	}

	public void setUtilCalendar(java.util.Date utilCalendar) {
		this.utilCalendar = utilCalendar;
	}

	public java.util.Date getUtilTimeStamp() {
		return utilTimeStamp;
	}

	public void setUtilTimeStamp(java.util.Date utilTimeStamp) {
		this.utilTimeStamp = utilTimeStamp;
	}

	public java.util.Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(java.util.Calendar calendar) {
		this.calendar = calendar;
	}

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date utilTimeStamp;
	
	@Temporal(TemporalType.DATE)
	private java.util.Calendar calendar;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public java.sql.Time getTime() {
		return time;
	}

	public void setTime(java.sql.Time time) {
		this.time = time;
	}

	public java.sql.Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(java.sql.Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
