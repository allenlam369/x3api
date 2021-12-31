package allen.wqplis.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "river_latest_results", schema = "public")
public class RiverLatest implements Serializable {
	private static final long serialVersionUID = -3299034019047458608L;

	@Column(name = "river", nullable = true)
	private String river;

	@Id
	@Column(name = "station", nullable = false)
	private String station;

	@Column(name = "mdate", nullable = false)
	private Date mdate;

	@Column(name = "do_", nullable = false)
	private Double do_;

	@Column(name = "bod5", nullable = false)
	private Double bod5;

	@Column(name = "nh4", nullable = false)
	private Double nh4;

	@Column(name = "wqi_pt", nullable = false)
	private Double wqi_pt;

	@Column(name = "wqi_grade", nullable = false)
	private String wqi_grade;

	@Column(name = "ec", nullable = false)
	private Integer ec;

	@Column(name = "ec_level", nullable = false)
	private String ec_level;

	public RiverLatest() {

	}

	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	public Double getDo_() {
		return do_;
	}

	public void setDo_(Double do_) {
		this.do_ = do_;
	}

	public Double getBod5() {
		return bod5;
	}

	public void setBod5(Double bod5) {
		this.bod5 = bod5;
	}

	public Double getNh4() {
		return nh4;
	}

	public void setNh4(Double nh4) {
		this.nh4 = nh4;
	}

	public Double getWqi_pt() {
		return wqi_pt;
	}

	public void setWqi_pt(Double wqi_pt) {
		this.wqi_pt = wqi_pt;
	}

	public String getWqi_grade() {
		return wqi_grade;
	}

	public void setWqi_grade(String wqi_grade) {
		this.wqi_grade = wqi_grade;
	}

	public Integer getEc() {
		return ec;
	}

	public void setEc(Integer ec) {
		this.ec = ec;
	}

	public String getEc_level() {
		return ec_level;
	}

	public void setEc_level(String ec_level) {
		this.ec_level = ec_level;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((station == null) ? 0 : station.hashCode());
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
		RiverLatest other = (RiverLatest) obj;
		if (station == null) {
			if (other.station != null)
				return false;
		} else if (!station.equals(other.station))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RiverLatest [river=" + river + ", station=" + station + ", mdate=" + mdate + ", do_=" + do_ + ", bod5="
				+ bod5 + ", nh4=" + nh4 + ", wqi_pt=" + wqi_pt + ", wqi_grade=" + wqi_grade + ", ec=" + ec
				+ ", ec_level=" + ec_level + "]";
	}

}
