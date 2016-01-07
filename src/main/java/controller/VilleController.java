package controller;

import pojo.Meteo;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Named
@RequestScoped
public class VilleController {
	private String ville;
	private List<Meteo> listMeteo;
	final static Logger logger = Logger.getLogger(VilleController.class);

	public void previsionMeteo() throws JsonProcessingException, IOException{
		listMeteo = new ArrayList<>();
		Meteo meteo = new Meteo();
		ObjectMapper mapper = new ObjectMapper();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(
				DateFormat.MEDIUM,DateFormat.SHORT);
		String url = "http://api.openweathermap.org/data/2.5/forecast?q="+ville+",FR&units=metric&appid=a0750586e2446ca389182e5b95941c14";
		JsonNode root = mapper.readTree(new URL(url));
		JsonNode list = root.path("list");
		for (JsonNode node: list){
			meteo = new Meteo();
			Date date = new Date(node.path("dt").asLong()*1000);
			meteo.setDate(dateFormat.format(date));
			meteo.setTemperature(node.path("main").path("temp").asDouble());
			listMeteo.add(meteo);
		}
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Meteo> getListMeteo() {
		return listMeteo;
	}

	public void setListMeteo(List<Meteo> listMeteo) {
		this.listMeteo = listMeteo;
	}





}
