package controller;

import pojo.Meteo;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Named
@RequestScoped
public class VilleController {
	private String ville;
	private List<Meteo> listMeteo = new List<Meteo>() {
		
		@Override
		public <T> T[] toArray(T[] a) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Meteo> subList(int fromIndex, int toIndex) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Meteo set(int index, Meteo element) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean retainAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean removeAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public Meteo remove(int index) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public ListIterator<Meteo> listIterator(int index) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public ListIterator<Meteo> listIterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int lastIndexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Iterator<Meteo> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public int indexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Meteo get(int index) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean addAll(int index, Collection<? extends Meteo> c) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean addAll(Collection<? extends Meteo> c) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void add(int index, Meteo element) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean add(Meteo e) {
			// TODO Auto-generated method stub
			return false;
		}
	};
	private LineChartModel lineModel1;
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
	
	@PostConstruct
    public void init() {
        createLineModels();
    }
 
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
 
     
    private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel1.setTitle("Linear Chart");
        lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);

    }
     
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
        LineChartSeries series1 = new LineChartSeries();

        series1.setLabel("Series 1");
         
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);

        model.addSeries(series1);

         
        return model;
    }
    
    public LineChartModel genChart(){
    	LineChartModel model = new LineChartModel();
        LineChartSeries series1 = new LineChartSeries();
        

        List<Meteo> data = getListMeteo();
        
        series1.setLabel("Temperature");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        
        for(int i=0; i < data.size(); i++) {
        	series1.set(i, data.get(i).getTemperature());
        }
         

        model.addSeries(series1);
        lineModel1 = initLinearModel();
        lineModel1.setTitle("Linear Chart");
        lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        
     
        
        yAxis.setMin(0);
        yAxis.setMax(50);
        
        return model;
    }





}
