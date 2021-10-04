package allen.wqplis.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "beach_latest_grade", schema = "public")
public class BeachLatest implements Serializable {
	private static final long serialVersionUID = -461111894312690301L;

	@Id
	@Column(name = "beach_code", nullable = false)
	private String beachCode;

	@Column(name = "sample_date", nullable = false)
	private Date sampleDate;

	@Column(name = "grade", nullable = true)
	private Integer grade;

	@Column(name = "g_mean", nullable = true)
	private Integer gMean;

	@Column(name = "r_g_mean", nullable = true)
	private Integer rgMean;

	public BeachLatest() {

	}

	public String getBeachCode() {
		return beachCode;
	}

	public void setBeachCode(String beachCode) {
		this.beachCode = beachCode;
	}

	public Date getSampleDate() {
		return sampleDate;
	}

	public void setSampleDate(Date sampleDate) {
		this.sampleDate = sampleDate;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getgMean() {
		return gMean;
	}

	public void setgMean(Integer gMean) {
		this.gMean = gMean;
	}

	public Integer getRgMean() {
		return rgMean;
	}

	public void setRgMean(Integer rgMean) {
		this.rgMean = rgMean;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beachCode == null) ? 0 : beachCode.hashCode());
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
		BeachLatest other = (BeachLatest) obj;
		if (beachCode == null) {
			if (other.beachCode != null)
				return false;
		} else if (!beachCode.equals(other.beachCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BeachLatest [beachCode=" + beachCode + ", sampleDate=" + sampleDate + ", grade=" + grade + ", gMean="
				+ gMean + ", rgMean=" + rgMean + "]";
	}

}
