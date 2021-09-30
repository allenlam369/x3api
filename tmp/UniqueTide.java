package allen.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class UniqueTide implements Serializable {

	private static final long serialVersionUID = 3L;
	private Timestamp datetime;
	private int stationId;

	public UniqueTide(Timestamp datetime, int stationId) {
		this.datetime = datetime;
		this.stationId = stationId;
	}

	public UniqueTide() {
		// TODO Auto-generated constructor stub
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datetime == null) ? 0 : datetime.hashCode());
		result = prime * result + stationId;
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
		UniqueTide other = (UniqueTide) obj;
		if (datetime == null) {
			if (other.datetime != null)
				return false;
		} else if (!datetime.equals(other.datetime))
			return false;
		if (stationId != other.stationId)
			return false;
		return true;
	}

}
