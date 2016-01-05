package ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import remote.SensorEJBRemote;
import remote.SuscriptionEJBRemote;
import entity.Analogic;
import entity.Drone;
import entity.Numeric;
import entity.Sensor;
import entity.Suscription;
import entity.User;
import local.SensorEJBLocal;
import local.SuscriptionEJBLocal;

@Stateless
public class SuscriptionEJB implements SuscriptionEJBRemote, SuscriptionEJBLocal {
	
	@PersistenceContext(unitName="primary")
	private EntityManager em;

	@Override
	public List<Suscription> findSuscriptionById(Long id) {
		TypedQuery<Suscription> query=em.createNamedQuery("findSuscriptionById",Suscription.class).setParameter("idUser", id);
		return query.getResultList();
	}
	
	@Override
	public List<Sensor> findSensorsUserById(String mail) {
		List<Sensor> sensors=null;
		TypedQuery<Suscription> query=em.createNamedQuery("findSuscriptionById",Suscription.class).setParameter("mailUser", mail);
		for (Suscription s:query.getResultList()){
			sensors.add(em.find(Sensor.class, s.getSensor().getId()));
		}
		return sensors;
	}
	@Override
	public List<Suscription> findSuscriptions() {
		TypedQuery<Suscription> query=em.createNamedQuery("findSuscriptions",Suscription.class);
		return query.getResultList();
	}

	@Override
	public void createSuscription(Date begin, Long idUser, Long idSensor){
		Suscription suscriptionEntity=new Suscription();
		suscriptionEntity.setDateBegin(begin);
		User user=em.find(User.class, idUser);
		suscriptionEntity.setUser(user);
		Sensor sensor=em.find(Sensor.class, idSensor);
		suscriptionEntity.setSensor(sensor);
		em.persist(suscriptionEntity);
	}
	
}
