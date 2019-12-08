/**
 * 
 */
package com.sunway.chart;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Andy.Kou
 *
 */
public class ChartSeries implements Serializable {

	private static final long serialVersionUID = 5495797596537736396L;
	private String name;
	private ArrayList<ChartData> data;
	
	public ChartSeries() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param name
	 * @param data
	 */
	public ChartSeries(String name, ArrayList<ChartData> data) {
		this.name = name;
		this.data = data;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the data
	 */
	public ArrayList<ChartData> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(ArrayList<ChartData> data) {
		this.data = data;
	}
	
}
