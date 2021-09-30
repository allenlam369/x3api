package allen.met.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the tide database table.
 * 
 */
@Entity
@NamedQuery(name = "Tide.findAll", query = "SELECT t FROM Tide t")
@NamedQuery(name = "Tide.findByDatetimeStationId", query = "SELECT t FROM Tide t WHERE t.datetime= ?1 AND t.stationId= ?2")
@NamedQuery(name = "Tide.findBetweenDates", query = "SELECT t FROM Tide t WHERE t.datetime BETWEEN ?1 AND ?2 AND t.stationId= ?3")

@NamedNativeQuery(name = "Tide.twoDays", query = "SELECT * FROM Tide t WHERE t.datetime BETWEEN (current_date - 1) AND (current_date + 1) at time zone 'hkt' AND t.station_id= ?1 ORDER BY t.datetime")
@NamedNativeQuery(name = "Tide.oneWeek", query = "SELECT * FROM Tide t WHERE t.datetime BETWEEN (current_date - 6) AND (current_date + 1) at time zone 'hkt' AND t.station_id= ?1 ORDER BY t.datetime")

@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "datetime", "station_id" }) })

//@IdClass(UniqueTide.class)
public class Tide implements Serializable {
	private static final long serialVersionUID = 5875779212540658612L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private long id;

	@Column(nullable = false)
	private Timestamp datetime;

	@Column(nullable = false)
	private double height;

	@Column(name = "station_id")
	private Integer stationId;

	public Tide() {
	}

	public Timestamp getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public double getHeight() {
		return this.height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getStationId() {
		return this.stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
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
		return "Tide [id=" + id + ", datetime=" + datetime + ", stationId=" + stationId + ", height=" + height + "]";
	}

}