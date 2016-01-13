package ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import remote.SensorEJBRemote;
import entity.Analogic;
import entity.Drone;
import entity.Numeric;
import entity.Sensor;
import local.SensorEJBLocal;

@Stateless
public class SensorEJB implements SensorEJBRemote, SensorEJBLocal {
	
	@PersistenceContext(unitName="primary")
	private EntityManager em;

	@Override
	public List<Sensor> findSensorsById(Long id) {
		TypedQuery<Sensor> query=em.createNamedQuery("findSensorsById",Sensor.class).setParameter("droneId", id);
		return query.getResultList();
	}

	@Override
	public List<Sensor> findSensors() {
		TypedQuery<Sensor> query=em.createNamedQuery("findSensors",Sensor.class);
		return query.getResultList();
	}
	
	@Override
	public List<Sensor> findRemovedSensors() {
		TypedQuery<Sensor> query=em.createNamedQuery("findRemovedSensors",Sensor.class);
		return query.getResultList();
	}
	
	@Override
	public void reaffectSensor(Drone drone, Long sensorId) {
		Sensor sensor = em.find(Sensor.class, sensorId);
		sensor.setDrone(drone);
		em.merge(sensor);
	}
	

	@Override
	public List<Sensor> findDroneSensors(){
		TypedQuery<Sensor> query=em.createNamedQuery("findDroneSensors",Sensor.class);
		return query.getResultList();
	}

	@Override
	public void createSensor(int type, String name, String model, Date inServiceDate, Float price, Drone drone) {
		if(type==0){
			Analogic sensorEntity=new Analogic();
			sensorEntity.setName(name);
			sensorEntity.setModel(model);
			sensorEntity.setInServiceDate(inServiceDate);
			sensorEntity.setPrice(price);
			sensorEntity.setDrone(drone);
			em.persist(sensorEntity);
		}
		else if(type==1){
			Numeric sensorEntity=new Numeric();
			sensorEntity.setName(name);
			sensorEntity.setModel(model);
			sensorEntity.setInServiceDate(inServiceDate);
			sensorEntity.setPrice(price);
			sensorEntity.setDrone(drone);
			em.persist(sensorEntity);
		}
	}
	
	public void deleteSensor(Long sensorId){
		Sensor sensor=em.find(Sensor.class, sensorId);
		sensor.setDrone(null);
		em.merge(sensor);
	}
	
}
