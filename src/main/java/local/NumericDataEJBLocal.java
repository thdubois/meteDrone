package local;

import java.util.Date;

import javax.ejb.Local;

@Local
public interface NumericDataEJBLocal {
	public void createNumericData(Date date, Boolean value, Long numericId);
}
