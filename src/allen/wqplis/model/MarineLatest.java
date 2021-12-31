package allen.wqplis.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marine_latest_results", schema = "public")
public class MarineLatest implements Serializable {
	private static final long serialVersionUID = -4895121439875198039L;

	@Id
	@Column(name = "station", nullable = false)
	private String station;

	@Column(name = "mdate", nullable = false)
	private Date mdate;

	@Column(name = "d_code", nullable = true)
	private String d_code;

	@Column(name = "do_", nullable = true)
	private Double do_;

	@Column(name = "do_sat", nullable = true)
	private Double do_sat;

	@Column(name = "ecoli", nullable = true)
	private Double ecoli;

	@Column(name = "sal", nullable = true)
	private Double sal;

	@Column(name = "temper", nullable = true)
	private Double temper;

	@Column(name = "turb_sc", nullable = true)
	private Double turb_sc;

	@Column(name = "ss", nullable = true)
	private Double ss;

	public MarineLatest() {

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

	public String getD_code() {
		return d_code;
	}

	public void setD_code(String d_code) {
		this.d_code = d_code;
	}

	public Double getDo_() {
		return do_;
	}

	public void setDo_(Double do_) {
		this.do_ = do_;
	}

	public Double getDo_sat() {
		return do_sat;
	}

	public void setDo_sat(Double do_sat) {
		this.do_sat = do_sat;
	}

	public Double getEcoli() {
		return ecoli;
	}

	public void setEcoli(Double ecoli) {
		this.ecoli = ecoli;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getTemper() {
		return temper;
	}

	public void setTemper(Double temper) {
		this.temper = temper;
	}

	public Double getTurb_sc() {
		return turb_sc;
	}

	public void setTurb_sc(Double turb_sc) {
		this.turb_sc = turb_sc;
	}

	public Double getSs() {
		return ss;
	}

	public void setSs(Double ss) {
		this.ss = ss;
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
		MarineLatest other = (MarineLatest) obj;
		if (station == null) {
			if (other.station != null)
				return false;
		} else if (!station.equals(other.station))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MarineLatest [station=" + station + ", mdate=" + mdate + ", d_code=" + d_code + ", do_=" + do_
				+ ", do_sat=" + do_sat + ", ecoli=" + ecoli + ", sal=" + sal + ", temper=" + temper + ", turb_sc="
				+ turb_sc + ", ss=" + ss + "]";
	}

}
