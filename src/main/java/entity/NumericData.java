package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class NumericData implements Serializable {

	private static final long serialVersionUID = -3619557237066421013L;

	@Id
	@GeneratedValue
	private Long id;

	private Date date;
	
	private Boolean value;

	@ManyToOne
	private Numeric numeric;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	public Numeric getNumeric() {
		return numeric;
	}

	public void setNumeric(Numeric numeric) {
		this.numeric = numeric;
	}
	

}
