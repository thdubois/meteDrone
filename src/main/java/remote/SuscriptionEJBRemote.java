package remote;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import entity.Suscription;

@Local
public interface SuscriptionEJBRemote {
	public List<Suscription> findSuscriptionById(Long id);
	public List<Suscription> findSuscriptions();
	public void createSuscription(Date begin, Long idUser, Long idSensor);

}
