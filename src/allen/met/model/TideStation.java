package allen.met.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tide_station database table.
 * 
 */
@Entity
@Table(name = "tide_station")
@NamedQuery(name = "TideStation.findAll", query = "SELECT t FROM TideStation t")
public class TideStation implements Serializable {

	private static final long serialVersionUID = 7605025172634584978L;

	@Id
	private Integer id;

	private String name;

	public TideStation() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}