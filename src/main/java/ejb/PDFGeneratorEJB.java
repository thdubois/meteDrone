package ejb;


import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import entity.Company;
import entity.Sensor;
import entity.Suscription;
import entity.User;
import remote.SensorEJBRemote;
import remote.SuscriptionEJBRemote;
import remote.UserEJBRemote;

@Stateless
public class PDFGeneratorEJB {

	@EJB
	private SuscriptionEJBRemote suscription;

	@EJB
	private UserEJBRemote userEJB;
	
	@EJB
	private SensorEJBRemote sensor;
	
	@PersistenceContext(unitName="primary")
	private EntityManager em;


	@Schedule(dayOfMonth="1", hour="5", minute="30")
	public void GeneratePDF() {

	}
	
	public void writeText(PDFont font, PDPageContentStream contentStream, int x, int y, String text){
		try {
			contentStream.beginText();
			contentStream.setFont( font, 12 );
			contentStream.moveTextPositionByAmount(x,y);
			contentStream.drawString(text);
			contentStream.endText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Schedule(hour="*", minute="*")
	public void generateTest() {
		Date date= new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -1);
		int month = cal.get(Calendar.MONTH );
		
		int year = cal.get(Calendar.YEAR);
		String monthString = new DateFormatSymbols().getMonths()[month];
		String yearString = String.valueOf(year);
		
		List<User> users = userEJB.findUsers();
		for(User user: users){
			List<Suscription> suscriptionList = suscription.findSuscriptionsUserById(user.getEmail());
			
			// Create a document and add a page to it
			PDDocument document = new PDDocument();
			PDPage page = new PDPage();
			document.addPage( page );
			// Create a new font object selecting one of the PDF base fonts
			PDFont font = PDType1Font.HELVETICA_BOLD;
			try {	           
				PDPageContentStream contentStream = new PDPageContentStream(document, page);
				int deplacer = 0;
				Double somme = 0.0;
				//title
				int marginTop = 30; 
				int fontSize = 32;
				contentStream.beginText();
				contentStream.setFont(font, fontSize);
				contentStream.moveTextPositionByAmount((page.getMediaBox().getWidth() - 125) / 2, page.getMediaBox().getHeight() - marginTop);
				contentStream.drawString("Invoice");
				contentStream.endText();

				String email = user.getEmail();
				Company company = userEJB.findCompany(email);
				writeText(font, contentStream,100, 600 - deplacer,"Invoice Date: "+ monthString + " " + yearString);
				deplacer = deplacer + 20;
				writeText(font, contentStream,100, 600 - deplacer,"Utilisateur: "+ email);
				deplacer = deplacer + 20;
				writeText(font, contentStream,100, 600 - deplacer,"Company: "+ company.getName());
				deplacer = deplacer + 20;
				for(Suscription suscription : suscriptionList){
					Sensor sensorSus= em.find(Sensor.class, suscription.getSensor().getId());
					writeText(font, contentStream,100, 600 - deplacer,  "Subscrition to model "+ sensorSus.getModel() + " and name "+ sensorSus.getName() + ": " + Float.toString(sensorSus.getPrice()) + " Euros");
					deplacer = deplacer + 20;
					somme = somme + sensorSus.getPrice();
				}
				contentStream.drawLine(100, 600 - deplacer,page.getMediaBox().getWidth() -100, 600 - deplacer);
				deplacer = deplacer + 20;
				writeText(font, contentStream,100, 600 - deplacer, "Somme:"+somme + "Euros");
				deplacer = deplacer + 20;
				contentStream.close();
				String name = monthString + "-" + yearString + "-"+ user.getEmail() +".pdf";
				document.save("../standalone/data/" + name);
				document.close();
			} catch (Exception e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
