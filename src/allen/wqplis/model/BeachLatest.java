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
	private String beach_code;

	@Column(name = "sample_date", nullable = false)
	private Date sample_date;

	@Column(name = "grade", nullable = true)
	private Integer grade;

	@Column(name = "g_mean", nullable = true)
	private Integer g_mean;

	@Column(name = "r_g_mean", nullable = true)
	private Integer r_g_mean;

	public BeachLatest() {

	}

	public String getBeach_code() {
		return beach_code;
	}

	public void setBeach_code(String beach_code) {
		this.beach_code = beach_code;
	}

	public Date getSample_date() {
		return sample_date;
	}

	public void setSample_date(Date sample_date) {
		this.sample_date = sample_date;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getG_mean() {
		return g_mean;
	}

	public void setG_mean(Integer g_mean) {
		this.g_mean = g_mean;
	}

	public Integer getR_g_mean() {
		return r_g_mean;
	}

	public void setR_g_mean(Integer r_g_mean) {
		this.r_g_mean = r_g_mean;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beach_code == null) ? 0 : beach_code.hashCode());
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
		if (beach_code == null) {
			if (other.beach_code != null)
				return false;
		} else if (!beach_code.equals(other.beach_code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BeachLatest [beach_code=" + beach_code + ", sample_date=" + sample_date + ", grade=" + grade
				+ ", g_mean=" + g_mean + ", r_g_mean=" + r_g_mean + "]";
	}

}
