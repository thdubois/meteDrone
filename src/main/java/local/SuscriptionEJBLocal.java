package local;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import entity.Sensor;
import entity.Suscription;

@Local
public interface SuscriptionEJBLocal {
	public List<Suscription> findSuscriptionById(Long id);
	public List<Suscription> findSuscriptions();
	public List<Sensor> findSensorsUserById(Long id);
	public void createSuscription(Date begin, Long idUser, Long idSensor);

}
