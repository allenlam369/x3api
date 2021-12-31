package allen.met.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the tide database table.
 * 
 */
@Entity
@NamedQuery(name = "Tide.findAll", query = "SELECT t FROM Tide t ORDER BY t.datetime DESC")
@NamedQuery(name = "Tide.findByDatetimeStationId", query = "SELECT t FROM Tide t WHERE t.datetime= ?1 AND t.station_id= ?2 ORDER BY t.datetime DESC")
@NamedQuery(name = "Tide.findBetweenDates", query = "SELECT t FROM Tide t WHERE t.datetime BETWEEN ?1 AND ?2 AND t.station_id= ?3 ORDER BY t.datetime DESC")

@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "datetime", "station_id" }) })
public class Tide implements Serializable {
	private static final long serialVersionUID = 5875779212540658612L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private long id;

	@Column(name = "datetime", nullable = false)
	private Timestamp datetime;

	@Column(name = "height", nullable = false)
	private double height;

	@Column(name = "station_id")
	private Integer station_id;

	public Tide() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Integer getStation_id() {
		return station_id;
	}

	public void setStation_id(Integer station_id) {
		this.station_id = station_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Tide other = (Tide) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tide [id=" + id + ", datetime=" + datetime + ", height=" + height + ", station_id=" + station_id + "]";
	}

}