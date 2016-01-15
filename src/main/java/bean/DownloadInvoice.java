package bean;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ejb.PDFGeneratorEJB;


@Named
@RequestScoped
public class DownloadInvoice implements Serializable {

	final static Logger logger = Logger.getLogger(DownloadInvoice.class);

	private static final long serialVersionUID = -479435522006213706L;

    private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.

		public void downloadInvoice(String userName, String month, Integer year) {
			// Prepare.
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        ExternalContext externalContext = facesContext.getExternalContext();
	        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
	        String jboss = System.getenv("JBOSS_HOME");
	        String filePath = jboss + "/standalone/data/";
	        String fileName = month + "-" + year+ "-" + userName + ".pdf";
	        File file = new File(filePath, fileName);
	        BufferedInputStream input = null;
	        BufferedOutputStream output = null;

	        try {
	            // Open file.
	            input = new BufferedInputStream(new FileInputStream(file), DEFAULT_BUFFER_SIZE);

	            // Init servlet response.
	            response.reset();
	            response.setHeader("Content-Type", "application/pdf");
	            response.setHeader("Content-Length", String.valueOf(file.length()));
	            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

	            output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

	            // Write file contents to response.
	            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
	            int length;
	            while ((length = input.read(buffer)) > 0) {
	                output.write(buffer, 0, length);
	            }

	            // Finalize task.
	            output.flush();
	        } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
                logger.info(e);
			} catch (IOException e) {
				// TODO Auto-generated catch block
                logger.info(e);
			} finally {
	            // close streams.
	            close(output);
	            close(input);
	        }
	        facesContext.responseComplete();
	    }

	    private static void close(Closeable resource) {
	        if (resource != null) {
	            try {
	                resource.close();
	            } catch (IOException e) {
	                logger.info(e);
	            }
	        }
	    }
}
