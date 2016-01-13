package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AnalogicData implements Serializable {

	private static final long serialVersionUID = 3771436731002475501L;

	@Id
	@GeneratedValue
	private Long id;

	private Date date;

	private Double value;

	@ManyToOne
	private Analogic analogic;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Analogic getAnalogic() {
		return analogic;
	}

	public void setAnalogic(Analogic analogic) {
		this.analogic = analogic;
	}
}