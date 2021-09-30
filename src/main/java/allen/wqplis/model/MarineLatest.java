package allen.wqplis.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
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
	private String dCode;

	@Column(name = "do_", nullable = true)
	private Double do_;

	@Column(name = "do_sat", nullable = true)
	private Double doSat;

	@Column(name = "ecoli", nullable = true)
	private Double ecoli;

	@Column(name = "sal", nullable = true)
	private Double sal;

	@Column(name = "temper", nullable = true)
	private Double temper;

	@Column(name = "turb_sc", nullable = true)
	private Double turbSc;

	@Column(name = "ss", nullable = true)
	private Double ss;

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

	public String getdCode() {
		return dCode;
	}

	public void setdCode(String dCode) {
		this.dCode = dCode;
	}

	public Double getDo_() {
		return do_;
	}

	public void setDo_(Double do_) {
		this.do_ = do_;
	}

	public Double getDoSat() {
		return doSat;
	}

	public void setDoSat(Double doSat) {
		this.doSat = doSat;
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

	public Double getTurbSc() {
		return turbSc;
	}

	public void setTurbSc(Double turbSc) {
		this.turbSc = turbSc;
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
		result = prime * result + ((mdate == null) ? 0 : mdate.hashCode());
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
		if (mdate == null) {
			if (other.mdate != null)
				return false;
		} else if (!mdate.equals(other.mdate))
			return false;
		if (station == null) {
			if (other.station != null)
				return false;
		} else if (!station.equals(other.station))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MarineLatest [station=" + station + ", mdate=" + mdate + ", dCode=" + dCode + ", do_=" + do_
				+ ", doSat=" + doSat + ", ecoli=" + ecoli + ", sal=" + sal + ", temper=" + temper + ", turbSc=" + turbSc
				+ ", ss=" + ss + "]";
	}

}
