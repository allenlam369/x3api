package allen.met.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "latest_tide_level", schema = "public")
public class TideLatest implements Serializable {
	private static final long serialVersionUID = -8099607682373626452L;

	@Id
	@Column(name = "id", nullable = false)
	int id;

	@Column(name = "station_id", nullable = false)
	int station_id;

	@Column(name = "datetime", nullable = false)
	Date datetime;

	@Column(name = "height")
	Double height;

	@Column(name = "name")
	String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStation_id() {
		return station_id;
	}

	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		TideLatest other = (TideLatest) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TideLatest [station_id=" + station_id + ", datetime=" + datetime + ", height=" + height + ", name="
				+ name + "]";
	}

}
