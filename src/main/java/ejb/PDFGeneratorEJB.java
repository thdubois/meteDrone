package ejb;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

@Stateless
public class PDFGeneratorEJB {
	@Schedule(dayOfMonth="1", hour="5", minute="30")
	public void GeneratePDF() {

	}

	@Schedule(hour="*", minute="*")
	public void generateTest() {
		// Create a document and add a page to it
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage( page );

		// Create a new font object selecting one of the PDF base fonts
		PDFont font = PDType1Font.HELVETICA_BOLD;
		try {
			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			contentStream.beginText();
			contentStream.setFont( font, 12 );
			contentStream.moveTextPositionByAmount( 100, 700 );
			contentStream.drawString( "Hello World" );
			contentStream.endText();
			contentStream.close();
			Date date= new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);
			String monthString = new DateFormatSymbols().getMonths()[month];
			String yearString = String.valueOf(year);
			String name = monthString + "-" + yearString +".pdf";
			document.save("../standalone/data/" + name);
			document.close();
		} catch (Exception e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
