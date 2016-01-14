package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import entity.NumericData;
import remote.NumericDataEJBRemote;

@Named
@RequestScoped
public class NumericDataController implements Serializable{

	private static final long serialVersionUID = 8294710654309833073L;
	private LineChartModel lineModel1;

	@EJB
	NumericDataEJBRemote numericData;

	public List<NumericData> findNumericData(Long sensorId){
		return numericData.findNumericData(sensorId);
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
		List<NumericData> data = findNumericData(sensorId);
		series1.setLabel("Data");
		for(int i=0; i < data.size(); i++) {
			int myInt = data.get(i).getValue() ? 1 : 0;
			series1.set(i, myInt );
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
