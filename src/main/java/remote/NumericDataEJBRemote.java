package remote;

import java.util.Date;

import javax.ejb.Remote;

@Remote
public interface NumericDataEJBRemote {
	public void createNumericData(Date date, Boolean value, Long numericId);
}
