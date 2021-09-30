package allen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the tide_level_datagovhk database table.
 * 
 */
@Entity
@Table(name="tide_level_datagovhk")
@NamedQuery(name="TideLevelDatagovhk.findAll", query="SELECT t FROM TideLevelDatagovhk t")
public class TideLevelDatagovhk implements Serializable {
	private static final long serialVersionUID = 1L;

	private Timestamp datetime;

	private BigDecimal height;

	@Column(name="station_id")
	private Integer stationId;

	@Column(name="station_name")
	private String stationName;

	public TideLevelDatagovhk() {
	}

	public Timestamp getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public BigDecimal getHeight() {
		return this.height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public Integer getStationId() {
		return this.stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return this.stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

}