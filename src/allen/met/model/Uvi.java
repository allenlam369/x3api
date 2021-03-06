package allen.met.model;

import java.io.Serializable;
//import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the uvi database table.
 * 
 */
@Entity
@NamedQuery(name = "Uvi.findAll", query = "SELECT u FROM Uvi u")
@NamedQuery(name = "Uvi.findOnDate", query = "SELECT u FROM Uvi u WHERE u.datetime = ?1 ORDER BY u.datetime")
@NamedQuery(name = "Uvi.findByDatetime", query = "SELECT u FROM Uvi u WHERE u.datetime= ?1")
@NamedQuery(name = "Uvi.findBetween", query = "SELECT u FROM Uvi u WHERE u.datetime BETWEEN ?1 AND ?2 ORDER BY u.datetime")

// ORDER BY u.datetime
@Table
public class Uvi implements Serializable {
	private static final long serialVersionUID = 906244212949513361L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private long id;

	@Column(name = "datetime", nullable = false)
	private Timestamp datetime;

	@Column(name = "uvi", nullable = false)
	private Float uvi;

	public Uvi() {
	}

	public Uvi(long id, Timestamp datetime, Float uvi) {
		this.id = id;
		this.datetime = datetime;
		this.uvi = uvi;
	}

	public Uvi(Timestamp datetime, Float uvi) {
		this.datetime = datetime;
		this.uvi = uvi;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public Float getUvi() {
		return this.uvi;
	}

	public void setUvi(Float uvi) {
		this.uvi = uvi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datetime == null) ? 0 : datetime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Uvi other = (Uvi) obj;
		if (datetime == null) {
			if (other.datetime != null)
				return false;
		} else if (!datetime.equals(other.datetime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Uvi [id=" + id + ", datetime=" + datetime + ", uvi=" + uvi + "]";
	}

}