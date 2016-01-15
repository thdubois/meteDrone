package controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.annotation.PostConstruct;

import remote.AnalogicDataEJBRemote;

import entity.AnalogicData;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@Named
@RequestScoped
public class AnalogicDataController implements Serializable{

	private static final long serialVersionUID = 8294710654309833073L;
	private LineChartModel lineModel1;

	@EJB
	AnalogicDataEJBRemote analogicData;

	public List<AnalogicData> findAnalogicData(Long sensorId){
		return analogicData.findAnalogicData(sensorId);
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

	public LineChartModel genChart(Long sensorId){
		LineChartModel model = new LineChartModel();
		LineChartSeries series1 = new LineChartSeries();


		List<AnalogicData> data = findAnalogicData(sensorId);

		series1.setLabel("Data");
		
		Integer size = data.size();
		
		if(size > 30){
			for(int i=size-30; i < size; i++) {
				series1.set(i, data.get(i).getValue() );
			}
		}
		else{
			for(int i=0; i < size; i++) {
				series1.set(i, data.get(i).getValue() );
			}
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
	
	public Number getLastValue(Long sensorId){
		List<AnalogicData> data = findAnalogicData(sensorId);
		Integer size = data.size();
		
		return data.get(size-1).getValue()*6;
		
	}
}
