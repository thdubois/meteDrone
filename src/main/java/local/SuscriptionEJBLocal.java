package local;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import entity.Suscription;

@Local
public interface SuscriptionEJBLocal {
	public List<Suscription> findSuscriptions();
	public List<Suscription> findSuscriptionsUserById(String email);
	public void createSuscription(Date begin, Long idUser, Long idSensor);
	public void deleteSuscription(Long suscriptId);
}
