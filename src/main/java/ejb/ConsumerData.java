package ejb;

import java.util.Date;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.log4j.Logger;

import remote.AnalogicDataEJBRemote;
import remote.NumericDataEJBRemote;


@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName =
				"destinationType", propertyValue = "javax.jms.Queue"),
				@ActivationConfigProperty(propertyName =
				"destination", propertyValue = "queue/testQueue"),
				@ActivationConfigProperty(propertyName =
				"acknowledgeMode", propertyValue = "Auto-acknowledge"),
				@ActivationConfigProperty(propertyName = "user",
				propertyValue = "quickstartUser"),
				@ActivationConfigProperty(propertyName = "password",
				propertyValue = "quickstartPwd1!") })

public class ConsumerData implements MessageListener {
	final static Logger logger = Logger.getLogger(ConsumerData.class);
	
	@EJB
	private AnalogicDataEJBRemote analogicDataEJBRemote;
	
	@EJB
	private NumericDataEJBRemote numericDataEJBRemote;
	
	public void onMessage(Message message) {
		ObjectMessage objectMessage = null;
		if(message instanceof ObjectMessage) {
			objectMessage = (ObjectMessage) message;
			try {
				if(objectMessage.getLongProperty("type")==0){//analogic
					Long id = objectMessage.getLongProperty("id");
					logger.info("ID de consumer DATA:"+ id);
					Double value = objectMessage.getDoubleProperty("value");
					logger.info("VALUE de consumer DATA:"+ value);
					analogicDataEJBRemote.createAnalogicData(new Date(),value, id);
				}
				else if(objectMessage.getLongProperty("type")==1){
					Long idCapteur = objectMessage.getLongProperty("id");
					logger.info("ID de consumer DATA:"+ idCapteur);
					Boolean value = objectMessage.getBooleanProperty("value");
					logger.info("VALUE de consumer DATA:"+ value);
					numericDataEJBRemote.createNumericData(new Date(), value, idCapteur);
				}
			}
			catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
