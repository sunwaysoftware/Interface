/**
 * 
 */
package com.sunway.chart;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Andy.Kou
 *
 */
public class ChartData implements Serializable {

	private static final long serialVersionUID = -9087519483778481590L;
	private String name;
	private BigDecimal y;

	public ChartData(){}	
	
	/**
	 * @param name
	 * @param y
	 */
	public ChartData(String name, BigDecimal y) {
		this.name = name;
		this.y = y;
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
	 * @return the y
	 */
	public BigDecimal getY() {
		return y;
	}
	
	/**
	 * @param y the y to set
	 */
	public void setY(BigDecimal y) {
		this.y = y;
	}

}
